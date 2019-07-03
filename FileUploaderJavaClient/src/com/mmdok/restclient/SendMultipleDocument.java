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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
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

public class SendMultipleDocument {

	private static int NUMBER_INSERT = 20;

	public static void main(String[] args) {
		SendMultipleDocument multiple = new SendMultipleDocument();
		Random rand = new Random();
		int val;
		String[] bokstav = { "ASAI01", "BCB6751", "I7NCBG0", "S5DK", "9TGE45", "FJ5RA34", "GY", "HD84F", "IM8TF", "KUI",
				"MH7RF", "NC1341", "LPT0", "POG513", "SD8", "G512F", "P2FDAE6", "PIT542", "ZWADA3" };

		long start = System.currentTimeMillis();

		for (int i = 0; i < NUMBER_INSERT; i++) {
			val = rand.nextInt(100000000);
			String namn1 = bokstav[rand.nextInt(bokstav.length)];
			String namn2 = bokstav[rand.nextInt(bokstav.length)];
			String filename = namn1 + namn2 + "_" + val + ".pdf";
			multiple.send(filename, i);
			if (i % 100 == 0) {
				Date date = new Date();
				System.out.println(i + ":........." + date);
			}
		}
		long finish = System.currentTimeMillis();
		long diff = (finish - start) / 1000;
		System.out.println("made in seconds " + diff);
	}

	public void send(String filename, int seqNr) {

		// System.out.println(seqNr+ ":RESTAPI client has
		// started.............."+filename);
		String dynamiskFilenamn = writeMetaDataFile();

		// the file we want to upload
		File inFile = new File("C:\\Atestdata\\change-mysql-temp-dir.pdf");

		File inFile2 = new File(dynamiskFilenamn);

		if (inFile2.exists()) {
			// System.out.println(" metadata file " + dynamiskFilenamn + " exist..");
		} else {
			System.out.println(" not document file is found");
		}

		FileInputStream fis = null;
		FileInputStream fis2 = null;
		try {
			fis = new FileInputStream(inFile);
			fis2 = new FileInputStream(inFile2);
			DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());

			// HttpPost("http://13.53.172.37:8080/storeFile-1/rest/upload2");
			HttpPost httppost = new HttpPost("http://13.53.172.37:8080/storeFile-1/rest/upload2");
			// HttpPost httppost = new
			// HttpPost("http://127.0.0.1/storeFile-1/rest/upload2");
			// HttpPost httppost = new
			// HttpPost("http://127.0.0.1:80/storeFile-1/rest/upload2");
			MultipartEntity entity = new MultipartEntity();

			entity.addPart("file2", new InputStreamBody(fis2, inFile2.getName()));
			// set the file input stream and file name as arguments

			// entity.addPart("file", new InputStreamBody(fis, inFile.getName()));

			entity.addPart("file", new InputStreamBody(fis, filename));

			entity.addPart("docId", new StringBody("GGAFA001GFARA1881GGBBA"));

			httppost.setEntity(entity);

			// execute the request
			HttpResponse response = httpclient.execute(httppost);

			int statusCode = response.getStatusLine().getStatusCode();
			HttpEntity responseEntity = response.getEntity();
			String responseString = EntityUtils.toString(responseEntity, "UTF-8");

			// System.out.println("[" + statusCode + "] " + responseString);

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
			Random rand = new Random();
			int val = rand.nextInt(1000000);
			String skadenummer = "CLA-" + val + "SK";
			val = rand.nextInt(10000000);
			String customerId = "CUS-" + val + "HS";
		/*	String firsttwo;
			if (rand.nextBoolean()) {
				firsttwo = "20";
			} else {
				firsttwo = "19";
			}
			int aret;
			while (true) {
				String fyraForstaNr = firsttwo + rand.nextInt(10) + rand.nextInt(10);
				aret = Integer.parseInt(fyraForstaNr);
				if (aret > 1900 && aret < 2019) {
					break;
				}
			}

			String dagentxt = "";
			while (true) {
				String forstaTxt = rand.nextInt(3) + "";
				String andraTxt = rand.nextInt(10) + "";

				if (!andraTxt.equalsIgnoreCase("0")) {
					dagentxt = forstaTxt + andraTxt;
					break;
				}
			}

			String manaden = "";
			while (true) {
				String forsta = rand.nextInt(2) + "";
				String andra = rand.nextInt(10) + "";
				manaden= forsta + andra;
				int month = Integer.parseInt(manaden);
				if (month > 0 && month < 13) {
					break;
				}
			}*/
			String persnr = genPersonnr();
			String[] kandpersonnr = { "195904111111", "195904112222", "195904113333", "195904114444", "195904115555",
					"195904116666", "195904117777", "195904118888", "195904119999", "195904112819", "19520701111",
					"1952071001", "1952071002", "1952071003", "1952071004", "1952071005", "1952071006", "1952071007",
					"1952071008", "1952071009", "1952071010", "1952071011", "1952071012", "195207103", "195207104",
					"1952071015", "1952071016", "1952071017", "1952071018", "1952071019" };
			int test = rand.nextInt(10000);
			if (test < kandpersonnr.length) {
				persnr = kandpersonnr[test];
			}
			// persnr="201905101314";
			String[] doc_class = { "CLAIM", "CORRESPODENT", "FAKTURA", "FORSAKRING", "HANDLING", "INDIVIDUELL",
					"KOLLEKTIV", "POLICY", "POLISANMALAN", "SKADEANMALAN", "SPARANDE" };
			String[] source_systemid = { "A561", "Q55", "S79", "M40" };
			String source_systemidtxt = source_systemid[rand.nextInt(source_systemid.length)];

			String[] sourcesystem_name = { "Kvalitet kontroll", "Navigation doc", "Customer Care", "Economico" };
			String sourcesystem_nametxt = sourcesystem_name[rand.nextInt(sourcesystem_name.length)];

			String[] which_year = { "2019", "2018", "2017", "2016", "2015" };
			String which_yeartxt = which_year[rand.nextInt(which_year.length)];

			int doc_class_index = rand.nextInt(doc_class.length);
			String doc_classtxt = doc_class[doc_class_index];
			String str = "<data>\r\n" + " <metadata>\r\n" + "   <personnummer>" + persnr + "</personnummer>\r\n"
					+ "<document_class>" + doc_classtxt + "</document_class>\r\n" + "<sourcesystem_name>"
					+ sourcesystem_nametxt + "</sourcesystem_name>\r\n" + "<source_systemid>" + source_systemidtxt
					+ "</source_systemid>\r\n" + "   <skadenummer>" + skadenummer + "</skadenummer>\r\n"
					+ "   <policy_number>FORS_VILLA_HEM</policy_number>\r\n" + "   <varumarke>FOLKSAM</varumarke>\r\n"
					+ "   <department>SKADOR</department>\r\n" + "   <customerid>" + customerId + "</customerid>\r\n"
					+ "<yta>skadehandling</yta> \r\n" + "<gallringdagar>600</gallringdagar>\r\n" + "<which_year>"
					+ which_yeartxt + "</which_year>" + "</metadata>\r\n" + "</data>";

			val = rand.nextInt(1000000);
			// String metaFilename = "C:\\Atestdata\\AA11AtempMetaDynamik" + val + ".txt";
			String metaFilename = "C:\\Atestdata\\AA11fastNamn.txt";
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
	
	
	private static String genPersonnr() {
		Random rand = new Random();
		String firsttwo;
		if (rand.nextBoolean()) {
			firsttwo = "20";
		} else {
			firsttwo = "19";
		}
		int aret;
		while (true) {
			String fyraForstaNr = firsttwo + rand.nextInt(10) + rand.nextInt(10);
			aret = Integer.parseInt(fyraForstaNr);
			if (aret > 1900 && aret < 2019) {
				break;
			}
		}

		String dagentxt = "";
		while (true) {
			String forstaTxt = rand.nextInt(3) + "";
			String andraTxt = rand.nextInt(10) + "";

			if (!andraTxt.equalsIgnoreCase("0")) {
				dagentxt = forstaTxt + andraTxt;
				break;
			}
		}

		String manaden = "";
		while (true) {
			String forsta = rand.nextInt(2) + "";
			String andra = rand.nextInt(10) + "";
			manaden= forsta + andra;
			int month = Integer.parseInt(manaden);
			if (month > 0 && month < 13) {
				break;
			}
		}
		return aret + "" + manaden+dagentxt + rand.nextInt(10)+ rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
	}
}
