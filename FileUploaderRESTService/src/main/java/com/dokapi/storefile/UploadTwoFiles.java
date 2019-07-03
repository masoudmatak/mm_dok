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
package com.dokapi.storefile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

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
import dbutil.dbutil.DBAPI;
import io.minio.MinioClient;
import io.minio.errors.MinioException;

@Path("/upload2")
public class UploadTwoFiles {

	private static int guildLength=36;
	/** The path to the folder where we want to store the uploaded files */
	private String UPLOAD_FOLDER = "/home/ubuntu/dokmentplatsen/";

	public UploadTwoFiles() {

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
			@FormDataParam("file") FormDataContentDisposition fileDetail,
			@FormDataParam("file2") InputStream uploadedInputStream2,
			@FormDataParam("file2") FormDataContentDisposition fileDetail2) {

		if (isWindows()) {
			UPLOAD_FOLDER = "C:/uploadedFiles/";
		}
		// System.out.println("uploadFile startas.............uppload Folder is:" +
		// UPLOAD_FOLDER);
		String personnummer = "";
		String skadenummer = "";
		String policy_number = "";
		String varumarke = "";
		String department = "";
		String customerid = "";
		String yta = "";
		String gallringdagar = "";
		String document_class = "";
		String source_systemid = "";
		String sourcesystem_name = "";
		String which_year = "";
		String errorMessage = null;
		if (fileDetail != null) {
			// System.out.println("FileName 1111111..........................." +
			// fileDetail.getFileName());
		}

		if (fileDetail2 != null) {
			// System.out.println("FileName 222222222222222222..........................." +
			// fileDetail2.getFileName());
		}
		try {
			// System.out.println("kommit till parser..................");
			String metadata = convert2(uploadedInputStream2);
			// System.out.println(metadata);
			ParseMetaData parser = new ParseMetaData();
			personnummer = parser.getTagvalue(metadata, "personnummer");
			skadenummer = parser.getTagvalue(metadata, "skadenummer");
			policy_number = parser.getTagvalue(metadata, "policy_number");
			varumarke = parser.getTagvalue(metadata, "varumarke");
			department = parser.getTagvalue(metadata, "department");
			customerid = parser.getTagvalue(metadata, "customerid");
			yta = parser.getTagvalue(metadata, "yta");
			gallringdagar = parser.getTagvalue(metadata, "gallringdagar");
			document_class = parser.getTagvalue(metadata, "document_class");
			source_systemid = parser.getTagvalue(metadata, "source_systemid");
			sourcesystem_name = parser.getTagvalue(metadata, "sourcesystem_name");
			which_year = parser.getTagvalue(metadata, "which_year");
			

			if (personnummer == null) {
				errorMessage = "personnummer is null, cannot add";
			} else if (skadenummer == null) {
				errorMessage = "skadenummer is null, cannot add";
			} else if (policy_number == null) {
				errorMessage = "policy_nummer is null, cannot add";
			} else if (varumarke == null) {
				errorMessage = "varumarke is null, cannot add";
			} else if (department == null) {
				errorMessage = "department is null, cannot add";
			} else if (customerid == null) {
				errorMessage = "customerid is null, cannot add";
			} else if (yta == null) {
				errorMessage = "yta is null, cannot add";
			} else if (gallringdagar == null) {
				errorMessage = "gallringdagar is null, cannot add";
			} else if (document_class == null) {
				errorMessage = "document_class  is null, cannot add";
			} else if (source_systemid == null) {
				errorMessage = "source_systemid is null, cannot add";
			}

		} catch (Exception ss) {
			System.out.println(ss);
		}
		// check if all form parameters are provided
		if (uploadedInputStream == null || fileDetail == null) {
			return Response.status(400).entity("Invalid form data 1").build();
		}
		if (uploadedInputStream2 == null || fileDetail2 == null) {
			return Response.status(400).entity("Invalid form data2").build();
		}

		// create our destination folder, if it not exists
		try {
			createFolderIfNotExists(UPLOAD_FOLDER);
		} catch (SecurityException se) {
			return Response.status(500).entity("Can not create destination folder on server").build();
		}

		String uploadedFileLocation = UPLOAD_FOLDER + fileDetail.getFileName();
		System.out.println("fil storlek:              "+uploadedInputStream.toString().length());

		try {

			if (errorMessage != null) {
				String messagePage = "<html><body><center><color=red>ERROR: " + errorMessage
						+ "</center></body></html>";
				return Response.status(500).entity(messagePage).build();
			} else {
                     String generatedFileName=getGuid();
				if (saveToMINIO(uploadedInputStream, generatedFileName/*fileDetail.getFileName()*/,document_class.toLowerCase())) {
					DBAPI.insertIntoDB(generatedFileName /* fileDetail.getFileName() */, uploadedFileLocation, document_class,
							source_systemid, personnummer, skadenummer, policy_number, varumarke, department,
							customerid, yta, gallringdagar, sourcesystem_name,which_year);
				}

			}

		} catch (Exception e) {
			System.out.println("fel vid upload " + e);
			return Response.status(500).entity("Can not save file").build();
		}

		return Response.status(200).entity("File saved to " + uploadedFileLocation).build();
	}

	

	private String getGuid() {
	
		String[] charList = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

		Random rand = new Random();
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < guildLength; i++) {
			int val = rand.nextInt(charList.length);
			buff.append(charList[val]);
		}
		return buff.toString();

	}

	private void setGallringYear(int antalYear) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		Date date = new Date();
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date);
		System.out.println(sdf.format(calendar2.getTime()));

		calendar2.set(calendar2.get(Calendar.YEAR) + antalYear, calendar2.get(Calendar.MONTH),
				calendar2.get(Calendar.DATE));
		System.out.println(sdf.format(calendar2.getTime()));
	}

	private boolean saveToMINIO(InputStream inStream, String fleName, String bucketName) {
		try {
			//String bukett = "miniobukett";
			MinioClient minioClient = null;

			if (isWindows()) {
				minioClient = new MinioClient("http://localhost:9000", "admin", "dokmasoud");
				// System.out.println("NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN " +
				// System.getProperty("os.name"));
			} else {
				minioClient = new MinioClient("http://13.53.172.37:9000", "admin", "dokmasoud");
			}

			
			
			 boolean found = minioClient.bucketExists(bucketName);
			  if (found) {
			  //  System.out.println("mybucket already exists");
			  } else {
			    // Create bucket 'my-bucketname'.
			    minioClient.makeBucket(bucketName);
			   // System.out.println("mybucket is created successfully");
			  }
			  
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
			minioClient.putObject(bucketName, fleName, bais, bais.available(), headerMap);
			bais.close();
			return true;
			// System.out.println("masoud_minio_object is uploaded successfully");
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
		return false;
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
			// System.out.println(bin.available());
			return bin;
		} catch (Exception e) {
			System.out.println("convert fel: " + e);
			return null;
		}

	}

	private boolean isWindows() {
		String osname = System.getProperty("os.name");
		if (osname.toUpperCase().startsWith("W")) {
			// System.out.println(" it is windows");
			return true;
		}
		return false;
	}

	private String convert2(InputStream inputStream) throws IOException {
		// System.out.println("starting in conver2");
		final int bufferSize = 1024;
		final char[] buffer = new char[bufferSize];
		final StringBuilder out = new StringBuilder();
		Reader in = new InputStreamReader(inputStream, "UTF-8");
		for (;;) {
			int rsz = in.read(buffer, 0, buffer.length);
			if (rsz < 0)
				break;
			out.append(buffer, 0, rsz);
		}
		// System.out.println("finishing in conver2");
		return out.toString();
	}

	/*
	 * public String convert(InputStream inputStream, Charset charset) throws
	 * IOException { System.out.println("kommit in ........."); StringBuilder
	 * stringBuilder = new StringBuilder(); String line = null;
	 * 
	 * try (BufferedReader bufferedReader = new BufferedReader(new
	 * InputStreamReader(inputStream, charset))) { while ((line =
	 * bufferedReader.readLine()) != null) { stringBuilder.append(line);
	 * System.out.println(line); } } System.out.println("lamnat ........."); return
	 * stringBuilder.toString(); }
	 */
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
