package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateBook {
	private static final String url = "jdbc:mysql:///dxc";
	private static final String user = "root";
	private static final String password = "N#@98wrft45";

		public static void main(String[] args) {

		     Scanner sc = null;
		     int n = 0, bookId = 0, ch =0;
		     String bookName = null;
		     Connection con = null;

		     try {
		        sc = new Scanner(System.in);
		        if(sc != null) {
		            System.out.print("Enter Number of Books you want to update: ");
		            n = sc.nextInt();
		        }
		        con = DriverManager.getConnection(url, user, password);
			    Statement st = con.createStatement();
		        
		        if(sc != null) {
		           for(int i=0; i<n; i++) {
		        	  System.out.println("Enter Book Id or Book Name");
		              System.out.print("bookId: ");
		              bookId = sc.nextInt();
		              System.out.print("bookName: ");
		              bookName = sc.nextLine();
		              bookName+=sc.nextLine();
		              
		    	      String query = "SELECT * FROM bookdetails WHERE bookId = '" + bookId + "' OR bookName = '" + bookName + "'";

		              ResultSet rs = st.executeQuery(query);

		    	      boolean flag = false;
		    	      while (rs.next()) {
		    	         flag = true;
		    	         System.out.println(rs.getInt(1) + " " + rs.getString(2) +  " " + rs.getString(3)+ " " +rs.getString(4));		    	         
		    	      }
		    	      while(flag) {
		    	    	  System.out.println("Enter the choice to update: \n1.Book Id \n2.Book Name "+ "\n3.Author Name \n4.Edition");
		    	    	  String update = "UPDATE bookDetails set ";
		    	    	  ch = sc.nextInt();

		    	    	  switch(ch) {
		    	    	  case 1:
		    	    		  System.out.println("Enter new Book Id: ");
		    	    		  int newBookId= sc.nextInt();
		    	    		  update = update + "bookId = ? WHERE  bookId = " +  bookId;
			    	    	  PreparedStatement ps = con.prepareStatement(update);
		    	    		  ps.setInt(1, newBookId);
		    	    		  
		    	    		  int r = ps.executeUpdate();
		    	    		  if(r>0)
		    	    			  System.out.println("Record updated sucessfully");
		    	    		  break;
		    	    		  
		    	    	  case 2:
		    	    		  System.out.println("Enter new Book Name: ");
		    	    		  String newBookName= sc.nextLine();
		    	    		  newBookName+=sc.nextLine();
		    	    		  update = update + "bookName = ? WHERE  bookId = " +  bookId;
			    	    	  PreparedStatement ps1 = con.prepareStatement(update);
		    	    		  ps1.setString(1, newBookName);
		    	    		  
		    	    		  int r1 = ps1.executeUpdate();
		    	    		  if(r1>0)
		    	    			  System.out.println("Record updated sucessfully");
		    	    		  break;
		    	    		  
		    	    	  case 3:
		    	    		  System.out.println("Enter new Author Name: ");
		    	    		  String newAuthorName= sc.nextLine();
		    	    		  newAuthorName+=sc.nextLine();
		    	    		  update = update + "authorName = ? WHERE  bookId = " +  bookId;
			    	    	  PreparedStatement ps2 = con.prepareStatement(update);
		    	    		  ps2.setString(1, newAuthorName);
		    	    		  
		    	    		  int r2 = ps2.executeUpdate();
		    	    		  if(r2>0)
		    	    			  System.out.println("Record updated sucessfully");
		    	    		  break;
		    	    		  
		    	    	  case 4:
		    	    		  System.out.println("Enter new Edition: ");
		    	    		  String newEdition= sc.nextLine();
		    	    		  newEdition+=sc.nextLine();
		    	    		  update = update + "edition = ? WHERE  bookId = " +  bookId;
			    	    	  PreparedStatement ps3 = con.prepareStatement(update);
		    	    		  ps3.setString(1, newEdition);
		    	    		  
		    	    		  int r3 = ps3.executeUpdate();
		    	    		  if(r3>0)
		    	    			  System.out.println("Record updated sucessfully");
		    	    		  break;
		    	    	  
		    	    	  }
		    	      }
		    	      
		    	      if (flag != true) {
		    	         System.out.println("\nRecord not found");
		    	      } 
		           }
		        }

		     } catch(SQLException se) {
		        se.printStackTrace();
		     } catch(Exception e) {
		        e.printStackTrace();
		     }

		     finally {
		        try {
		           if(con != null) con.close();
		        } catch(SQLException se) {
		           se.printStackTrace();
		        }
		        try {
		           if(sc != null) sc.close();
		        } catch(Exception e) {
		           e.printStackTrace();
		        }
		     } 
		   } 
	}
