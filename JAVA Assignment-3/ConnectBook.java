package Jdbc;

import java.sql.DriverManager;

public class ConnectBook {

	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");

	      // variables
	      final String url = "jdbc:mysql:///dxc";
	      final String user = "root";
	      final String password = "N#@98wrft45";

	      // establish the connection
	      java.sql.Connection con = DriverManager.getConnection(url, user, password);

	      // display status message
	      if (con == null) {
	         System.out.println("JDBC connection is not established");
	         return;
	      } else
	         System.out.println("Congratulations," + " Welcome to BMS.\\n");

	      // close JDBC connection
	      con.close();
	}

}
