package com.jdbc.saikumar;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class mysqlapp {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("D:\\ADV JAVA\\JDBC\\JDBCMySQLApp04\\src\\db.properties");
		Properties p = new Properties();
		p.load(fis);
		System.out.println(p.keySet());
		Class.forName(p.getProperty("driver_class"));
		try(  Connection con =  DriverManager.getConnection(p.getProperty("driver_URL"), p.getProperty("driver_userName"),p.getProperty("driver_password"));
			  Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = st.executeQuery("select * from emp1");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			) {
				//ResultSetMetaData rsmd = rs.getMetaData();
				System.out.println("In forward direction");
			   System.out.println("ENO\tENAME\tESAL\tEADDR");
			   int count =0 ;
			   while(rs.next()) {
				   System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
				   if(count==1)
					   break;
				   count++;
				   
			   }
			   
			   System.out.println("In Back direction");
			   while(rs.previous()) 
				   System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));

			   
			   System.out.println("Passing the system to make modifications to database");
			   br.readLine();
			   System.out.println("After modifications");
			   while(rs.next()) {
				   rs.refreshRow();
				   System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			   }
			   
			   
			   
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			
		}
	}
}
