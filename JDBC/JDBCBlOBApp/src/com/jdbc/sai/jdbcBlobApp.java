package com.jdbc.sai;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcBlobApp {

	public static void main(String[] args) throws SQLException, IOException {
		
		Connection con = null;
		PreparedStatement pst = null,pst2 = null;
		FileInputStream fis = null;
		try {
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "saikumar");
			
			pst = con.prepareStatement("insert into emp2 values(?,?)");
			pst.setInt(1, 111);
			File f = new File("C:/Users/S530489/Pictures/Camera Roll/WIN_20171017_08_06_39_Pro.jpg");
			fis = new FileInputStream(f);
			pst.setBinaryStream(2, fis, f.length());
			
			pst.executeUpdate();
			
			System.out.println("Employee inserted");
			
			System.out.println("Image from database");
			pst2 = con.prepareStatement("select * from emp2 where ENO = ?");
			pst2.setInt(1, 111);
			FileOutputStream fout = new FileOutputStream("C:/Users/S530489/Pictures/Camera Roll/Blob_Image.jpg");
			ResultSet rs = pst2.executeQuery();
			rs.next();
			System.out.println("Employee number " + rs.getInt(1));
			
			InputStream is = rs.getBinaryStream(2);
			int val = is.read();
			while(val != -1) {
				fout.write(val);
				val = is.read();
			}
			
			
			System.out.println("Employee retreived back");
			fout.close();
			is.close();
			rs.close();
			
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
		finally {
			pst.close();
			fis.close();
			pst2.close();
			
			
			con.close();
		}

		

	}

}
