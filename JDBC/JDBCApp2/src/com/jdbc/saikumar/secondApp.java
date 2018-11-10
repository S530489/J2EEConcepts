package com.jdbc.saikumar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class secondApp {

	public static void main(String[] args)  throws ClassNotFoundException, SQLException, NumberFormatException, IOException{
	
		Class c = Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "saikumar");
		Statement st= con.createStatement();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.print("enter empID");
			int empNum = Integer.parseInt(br.readLine());
			System.out.print("enter empName");
			String empName =  br.readLine();
			System.out.print("enter Empsal");
			float empSal =  Float.parseFloat(br.readLine());
			System.out.print("enter EmpAddr");
			String empAddr = br.readLine();
			String query = "insert into emp1 values ( "+empNum + ",'"+empName+"',"+empSal+",'"+empAddr+"')";
			st.executeUpdate(query);
			System.out.println("one row is added");
			System.out.println("onemore?");
			if(br.readLine().equals("yes")) {
				continue;
			}else {
				break;
			}
		}
		br.close();
		st.close();
		con.close();

	}

}
