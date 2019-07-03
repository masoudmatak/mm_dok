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

import java.util.Date;
import java.util.Random;

public class Mas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mas m = new Mas();
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			//System.out.print(rand.nextInt(10));
			//System.out.print(rand.nextInt(10));
			System.out.println();
			String firsttwo;
			if (rand.nextBoolean()) {
				firsttwo = "20";
			} else {
				firsttwo = "19";
			}
			
			String dagen=rand.nextInt(3) + rand.nextInt(10)+"";
			if(dagen.equalsIgnoreCase("00")) {
				dagen="01";
			}
			String persnr = firsttwo + rand.nextInt(10) + rand.nextInt(10) +"-"+ rand.nextInt(2) + rand.nextInt(10)+"-"
					+ dagen +"-"+ rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10)
					+ rand.nextInt(10);
			System.out.println(persnr);
			if(persnr.length()>12) {
				System.out.println("fel");
			}
		}
		// System.out.println(m.a());
		// m.a();
	}

	private String a() {

		String[] charList = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

		Random rand = new Random();
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < 36; i++) {
			int val = rand.nextInt(charList.length);

			buff.append(charList[val]);

		}
		// System.out.println(buff);

		return buff.toString();

	}

	public static boolean checkStringForAllTheLetters(String input) {
		int index = 0;
		boolean[] visited = new boolean[26];

		for (int id = 0; id < input.length(); id++) {
			if ('a' <= input.charAt(id) && input.charAt(id) <= 'z') {
				index = input.charAt(id) - 'a';
			} else if ('A' <= input.charAt(id) && input.charAt(id) <= 'Z') {
				index = input.charAt(id) - 'A';
			}
			visited[index] = true;
		}

		for (int id = 0; id < 26; id++) {
			if (!visited[id]) {
				return false;
			}
		}
		return true;
	}
}
