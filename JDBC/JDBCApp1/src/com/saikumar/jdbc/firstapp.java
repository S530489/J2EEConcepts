package com.saikumar.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class firstapp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
		//1. load and register driver class
		Class.forName("oracle.jdbc.OracleDriver");
		
		//2. establish connection 
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "saikumar");
		
		//3.create statement 
		Statement st = con.createStatement();
		
		//create Buffered reader obj
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter table name");
		String tname = br.readLine();
		
		//write SQL Query
		String query = "create table "+tname +"(ENO number(3) primary key, ENAME varchar2(5), ESAL float, EADDR varchar2(10))";
		
		//Execute SQL Query
		st.executeUpdate(query);
		
		System.out.println(tname + " is created ");
		
		//Close connections
		st.close();
		con.close();
		

	}

}
