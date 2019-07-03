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
package com.mmdok.restclient;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;

/**
 * This example shows how to upload files using POST requests with encryption
 * type "multipart/form-data". For more details please read the full tutorial on
 * https://javatutorial.net/java-file-upload-rest-service
 * 
 * @author javatutorial.net
 */
public class ClientUpoaderMedmetadata {

	public static void main(String[] args) {

		System.out.println("RESTAPI cleint has started..............");
		String dynamiskFilenamn=writeMetaDataFile();

		// the file we want to upload
		File inFile = new File("C:\\Atestdata\\sex.pdf");
		if(inFile.exists()) {
			System.out.println(" the docuemnt file exist..");
		}else {
			System.out.println(" not document file is found");
		}
		File inFile2 = new File(dynamiskFilenamn);
		
		
		if(inFile2.exists()) {
			System.out.println(" metadata file "+dynamiskFilenamn   +"       exist..");
		}else {
			System.out.println(" not document file is found");
		}
		
		FileInputStream fis = null;
		FileInputStream fis2 = null;
		try {
			fis = new FileInputStream(inFile);
			fis2 = new FileInputStream(inFile2);
			DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());

			// server back-end URL
			// HttpPost httppost = new
			//HttpPost httppost = new  HttpPost("http://13.53.172.37:8080/storeFile-1/rest/upload2");
			HttpPost httppost = new  HttpPost("http://127.0.0.1:80/storeFile-1/rest/upload2");
			MultipartEntity entity = new MultipartEntity();

			entity.addPart("file2", new InputStreamBody(fis2, inFile2.getName()));
			// set the file input stream and file name as arguments

			//entity.addPart("file", new InputStreamBody(fis, inFile.getName()));
			
			entity.addPart("file", new InputStreamBody(fis, "Hoho.pdf"));

			entity.addPart("docId", new StringBody("GGAFA001GFARA1881GGBBA"));

			httppost.setEntity(entity);

			// execute the request
			HttpResponse response = httpclient.execute(httppost);

			int statusCode = response.getStatusLine().getStatusCode();
			HttpEntity responseEntity = response.getEntity();
			String responseString = EntityUtils.toString(responseEntity, "UTF-8");

			System.out.println("[" + statusCode + "] " + responseString);

		} catch (ClientProtocolException e) {
			System.err.println("Unable to make connection");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Unable to read file");
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
			}
		}
	}

	private static String writeMetaDataFile() {
		try {
			String str = "<data>\r\n" + " <metadata>\r\n" + "   <personnummer>196612156060</personnummer>\r\n"
					+ "   <skadenummer>FF88888-HS</skadenummer>\r\n"
					+ "   <policy_number>FORS_VILLA_HEM</policy_number>\r\n" + "   <varumarke>FOLKSAM</varumarke>\r\n"
					+ "   <department>SKADOR</department>\r\n" + "   <customerid>CUST-G551190</customerid>\r\n"
					+ "<yta>skadehandling</yta> \r\n" + "<gallringdagar>6000</gallringdagar>\r\n" + "</metadata>\r\n"
					+ "</data>";

			Random rand = new Random();
			int val = rand.nextInt(1000000);
			String metaFilename = "C:\\Atestdata\\AA11AtempMetaDynamik" + val + ".txt";
			File newTextFile = new File(metaFilename);
			FileWriter fw = new FileWriter(newTextFile);
			fw.write(str);
			fw.close();
			return metaFilename;
		} catch (IOException iox) {
			// do stuff with exception
			iox.printStackTrace();
		}
		return null;
	}
}
