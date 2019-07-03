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




public class Alphabets
{
   public static void main(String args[])
   {
      char ch;
 
      for (ch = 'A'; ch <= 'Z'; ch++) {
    	  
         System.out.print("\""+ch+"\",");
      }
      
      
      char ss='B';
      char next=ss++;
      next=next++;
      //System.out.println(next);
   }
}