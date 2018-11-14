package com.jdbc.sai;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class WebrowsetManipulations {

	public static void main(String[] args) {
		WebRowSet webrowset = null;
		FileReader fr = null;
		Connection con =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/saidb", "root", "");
			RowSetFactory factory = RowSetProvider.newFactory();
			webrowset =factory.createWebRowSet();	
			webrowset.setCommand("Select * from emp1");
			con.setAutoCommit(false);
			webrowset.execute(con);
			fr = new FileReader("D:/data.XML");
			webrowset.readXml(fr);
			webrowset.moveToCurrentRow();
			webrowset.acceptChanges();
			System.out.println("changes saved");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				webrowset.close();
				fr.close();
				con.close();
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}

	}

}
