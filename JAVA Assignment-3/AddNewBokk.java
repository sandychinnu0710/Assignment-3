package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddNewBokk {

	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");

	      // variables
	      final String url = "jdbc:mysql:///dxc";
	      final String user = "root";
	      final String password = "N#@98wrft45";

	      // establish the connection
	      Connection con = DriverManager.getConnection(url, user, password);
	      // create JDBC statement object
	      Statement st = con.createStatement();

	      // prepare SQL query
	      String query =  "Insert into bookdetails(BookId,BookName,AuthorName,Edition) Values (12, 'introduction java','Daniel liang','9th')" ;
	    		 


	      // send and execute SQL query in Database software
	      //ResultSet rs = st.executeQuery(query);
	     int n=st.executeUpdate(query);

          if (n==1)
        	  System.out.println("\nRecords inserted");
            else 
       System.out.println("Record not inserted") ;
	      // process the ResultSet object
	     /* boolean flag = false;
	      while (rs.next()) {
	         flag = true;
	         System.out.println(rs.getInt(1) + " " + rs.getString(2) + 
	                  " " + rs.getString(3));
	      }

	      if (flag == true) {
	         System.out.println("\nRecords retrieved and displayed");
	      } else {
	         System.out.println("Record not found");
	      }*/
	   // close JDBC objects
	    //  rs.close();
	      st.close();
	      con.close();

	}


}


