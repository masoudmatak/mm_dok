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

import javax.xml.parsers.*;
import org.xml.sax.InputSource;
import org.w3c.dom.*;
import java.io.*;

public class ParseMetaData {

	public String getTagvalue(String xmlRecords, String tag) {

		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xmlRecords));

			Document doc = db.parse(is);
			NodeList nodes = doc.getElementsByTagName("metadata");

			// iterate the employees
			for (int i = 0; i < nodes.getLength(); i++) {
				Element element = (Element) nodes.item(i);

				NodeList name = element.getElementsByTagName(tag);
				Element line = (Element) name.item(0);
				String val = getCharacterDataFromElement(line);
				if (val != null) {
					return val;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public static void main(String[] args) {

		String xmlRecords = "<data>\r\n" + 
				" <metadata>\r\n" + 
				"   <personnummer>195204112819</personnummer>\r\n" + 
				"   <skadenummer>FF19771711-G</skadenummer>\r\n" + 
				"   <policy_number>FORS_VILLA_HEM</policy_number>\r\n" + 
				"   <varumarke>FOLKSAM</varumarke>\r\n" + 
				"   <department>SKADOR</department>\r\n" + 
				"   <customerid>CUST19199111</customerid>\r\n" + 
				"<yta>skadehandling</yta> \r\n" + 
				"<document_class>Handling</document_class><gallringdagar>3000</gallringdagar>\r\n" + 
				"</metadata>\r\n" + 
				"</data>";
		ParseMetaData test = new ParseMetaData();
		

		System.out.println(xmlRecords);
		System.out.println();
		System.out.println();
		System.out.println(test.getTagvalue(xmlRecords, "personnummer"));
		System.out.println(test.getTagvalue(xmlRecords, "yta"));
		System.out.println(test.getTagvalue(xmlRecords, "gallringdagar"));
		System.out.println(test.getTagvalue(xmlRecords, "document_class"));
	}

	/*************** test metod, anvands inte */
	public void allt() {
		String xmlRecords = "<data>" + " <metadata>" + "   <personnummer>197609131221</personnummer>"
				+ "   <skadenummer>FF1881671</skadenummer>" + "   <policy_number>FORS_VILLA_HEM</policy_number>"
				+ "   <varumarke>FOLKSAM</varumarke>" + "   <department>SKADOR</department>"
				+ "   <customerid>716615416</customerid>" + " </metadata>" + " <metadata>"
				+ "   <personnummer>195904113314</personnummer>" + "   <skadenummer>FF19991111</skadenummer>"
				+ "   <policy_number>FORS_BIL</policy_number>" + "   <varumarke>FOLKSAM</varumarke>"
				+ "   <department>SKADOR</department>" + "   <customerid>661771</customerid>" + " </metadata>"
				+ "</data>";

		System.out.println(xmlRecords);

		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xmlRecords));

			Document doc = db.parse(is);
			NodeList nodes = doc.getElementsByTagName("metadata");

			// iterate the employees
			for (int i = 0; i < nodes.getLength(); i++) {
				Element element = (Element) nodes.item(i);

				NodeList name = element.getElementsByTagName("personnummer");
				Element line = (Element) name.item(0);
				System.out.println("personnummer: " + getCharacterDataFromElement(line));

				NodeList title = element.getElementsByTagName("skadenummer");
				line = (Element) title.item(0);
				System.out.println("skadenummer: " + getCharacterDataFromElement(line));

				NodeList policy = element.getElementsByTagName("policy_number");
				line = (Element) policy.item(0);
				System.out.println("policy_number: " + getCharacterDataFromElement(line));

				NodeList varumarke = element.getElementsByTagName("varumarke");
				line = (Element) varumarke.item(0);
				System.out.println("varumarke: " + getCharacterDataFromElement(line));

				NodeList department = element.getElementsByTagName("department");
				line = (Element) department.item(0);
				System.out.println("department: " + getCharacterDataFromElement(line));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getCharacterDataFromElement(Element e) {
		Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;
			return cd.getData();
		}
		return "?";
	}
}