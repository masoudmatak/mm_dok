/*
Owner and programmer: Masoud Mohammadi 2019
Copywrite is limited and it is only the owner of the program code
can allow the use of it in a system if legal overcoming occurs. 
All rights are reserved for the owner of the code.
This is part of a system design and implementation of this 
Document Management System is based on a particular application area. 
This implementation is based on observation of the use in certain industries. 
In the case of copyright infringement, the owner is entitled to legal 
action and will require legal action through court.
*/

package com.dokapi.admintool;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.xmlpull.v1.XmlPullParserException;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import dbutil.dbutil.ConnectionMgmt;
import io.minio.MinioClient;
import io.minio.errors.MinioException;


@Path("/upload")
public class FileUploadService {

	/** The path to the folder where we want to store the uploaded files */
	private static final String UPLOAD_FOLDER = "/home/ubuntu/dokmentplatsen/";

	public FileUploadService() {
	}

	@Context
	private UriInfo context;

	/**
	 * Returns text response to caller containing current time-stamp
	 * 
	 * @return error response in case of missing parameters an internal exception or
	 *         success response if file has been stored successfully
	 */
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) {

		// check if all form parameters are provided
		if (uploadedInputStream == null || fileDetail == null)
			return Response.status(400).entity("Invalid form data").build();

		// create our destination folder, if it not exists
		try {
			createFolderIfNotExists(UPLOAD_FOLDER);
		} catch (SecurityException se) {
			return Response.status(500).entity("Can not create destination folder on server").build();
		}

		String uploadedFileLocation = UPLOAD_FOLDER + fileDetail.getFileName();
		System.out.println("KKKKKKKKKKKKKKKKKKKKK  getName()..........................." + fileDetail.getName());
		System.out.println("uploadedFileLocation ..........................." + uploadedFileLocation);
		System.out.println(
				"KKKKKKKKKKKKKKKKKKKKK  getCreationDate()..........................." + fileDetail.getCreationDate());
		System.out.println("KKKKKKKKKKKKK getParameters() ..........................." + fileDetail.getParameters());
		System.out.println(
				"andra Meta data getParameters() ..........................." + fileDetail.getParameters().size());

		try {

			insertIntoDB(fileDetail.getFileName(), uploadedFileLocation, "HANDLING", "Q10");
			// funkar saveToFile(uploadedInputStream, uploadedFileLocation);
			saveToMINIO(uploadedInputStream, fileDetail.getFileName());
		} catch (Exception e) {
			return Response.status(500).entity("Can not save file").build();
		}

		return Response.status(200).entity("File saved to " + uploadedFileLocation).build();
	}

	private void insertIntoDB(String dokName, String fileName, String document_class, String source_systemid) {
		try {
			PreparedStatement ps = ConnectionMgmt.getConnection().prepareStatement(
					"insert into mm_document(name,filename,document_class,source_systemid) values(?,?,?,?)");
			ps.setString(1, dokName);
			ps.setString(2, fileName);
			ps.setString(3, document_class);
			ps.setString(4, source_systemid);

			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("File are successfully registered into DB...");
			}
		} catch (Exception e) {
			System.out.println("SQL FEL: " + e);
		}
	}

	private void saveToMINIO(InputStream inStream, String fleName) {
		try {
			String bukett = "miniobukett";

			MinioClient minioClient = new MinioClient("http://13.53.172.37:9000", "admin", "dokmasoud");

			ByteArrayInputStream bais = convertInputStreamToByteArrayInputStream(inStream);
			// Create metadata map
			Map<String, String> headerMap = new HashMap<String, String>();

			// Add custom metadata
			headerMap.put("CustomMeta", "TEST");

			// Add custom content type
			headerMap.put("Content-Type", "application/octet-stream");

			// Add storage class
			headerMap.put("X-Amz-Storage-Class", "REDUCED_REDUNDANCY");

			// Create object 'my-objectname' in 'my-bucketname' with custom metadata in
			// headerMap
			minioClient.putObject(bukett, fleName, bais, bais.available(), headerMap);
			bais.close();
			System.out.println("masoud_minio_object is uploaded successfully");
		} catch (MinioException e) {
			System.out.println("Error MinioException: " + e);
		} catch (XmlPullParserException x) {
			System.out.println("Error XmlPullParserException : " + x);
		} catch (InvalidKeyException i) {
			System.out.println("Error InvalidKeyException: " + i);
		} catch (NoSuchAlgorithmException a) {
			System.out.println("Error NoSuchAlgorithmException: " + a);
		} catch (IOException io) {
			System.out.println("Error IOException: " + io);
		}
	}

	public ByteArrayInputStream convertInputStreamToByteArrayInputStream(InputStream in) {
		try {
			byte[] buff = new byte[8000];

			int bytesRead = 0;

			ByteArrayOutputStream bao = new ByteArrayOutputStream();

			while ((bytesRead = in.read(buff)) != -1) {
				bao.write(buff, 0, bytesRead);
			}

			byte[] data = bao.toByteArray();

			ByteArrayInputStream bin = new ByteArrayInputStream(data);
			System.out.println(bin.available());
			return bin;
		} catch (Exception e) {
			System.out.println("convert fel: " + e);
			return null;
		}

	}

	/**
	 * Utility method to save InputStream data to target location/file
	 * 
	 * @param inStream - InputStream to be saved
	 * @param target   - full path to destination file
	 */
	private void saveToFile(InputStream inStream, String target) throws IOException {
		OutputStream out = null;
		int read = 0;
		byte[] bytes = new byte[1024];

		out = new FileOutputStream(new File(target));
		while ((read = inStream.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		out.flush();
		out.close();
	}

	/**
	 * Creates a folder to desired location if it not already exists
	 * 
	 * @param dirName - full path to the folder
	 * @throws SecurityException - in case you don't have permission to create the
	 *                           folder
	 */
	private void createFolderIfNotExists(String dirName) throws SecurityException {
		File theDir = new File(dirName);
		if (!theDir.exists()) {
			theDir.mkdir();
		}
	}

}
