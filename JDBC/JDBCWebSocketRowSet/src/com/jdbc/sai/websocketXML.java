package com.jdbc.sai;

import java.io.FileWriter;
import java.sql.SQLException;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class websocketXML {

	public static void main(String[] args) {
		
		WebRowSet webrowset = null;
		FileWriter fr = null;
		try {
			RowSetFactory factory = RowSetProvider.newFactory();
			webrowset = factory.createWebRowSet();
			webrowset.setUrl("jdbc:mysql://localhost:3306/saidb");
			webrowset.setUsername("root");
			webrowset.setPassword("");
			webrowset.setCommand("select * from emp1");
			webrowset.execute();
			fr = new FileWriter("D:/ADV JAVA/JDBC/JDBCWebSocketRowSet/data.XML");
			webrowset.writeXml(fr);
			System.out.println("employee data is transffered");
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				webrowset.close();
				fr.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
