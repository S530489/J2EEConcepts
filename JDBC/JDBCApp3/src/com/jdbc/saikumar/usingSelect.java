package com.jdbc.saikumar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class usingSelect {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		Statement st1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		
		try {
			OracleDriver o = new OracleDriver();
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system","saikumar");
			st = con.createStatement();
			st1 = con.createStatement();
			rs = st.executeQuery("select * from emp1");
			System.out.println("empID"+"\t"+"empName"+"\t"+"empSal"+"\t"+"empAddr");
			System.out.println("===================================");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4));
				}
			
			System.out.println("\n\n**************************************************\n\n");
			boolean b = st1.execute("select * from emp1");
			System.out.println(b);
			rs1 = st1.getResultSet();
			System.out.println("empID"+"\t"+"empName"+"\t"+"empSal"+"\t"+"empAddr");
			System.out.println("===================================");
			while(rs1.next()) {
				System.out.println(rs1.getInt(1)+"\t"+rs1.getString(2)+"\t"+rs1.getFloat(3)+"\t"+rs1.getString(4));
				}
			
			System.out.println("\n\n*********************************************************\n\n");
			System.out.println(st1.execute("update emp1 set eSal = eSal+400 where eSal < 7000"));
			System.out.println(st1.getUpdateCount());
			
			
		}
		catch(Exception e) {
			e.printStackTrace();;
		}
		finally {
			try {
			rs.close();
			st.close();
			con.close();
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}

	}

}
