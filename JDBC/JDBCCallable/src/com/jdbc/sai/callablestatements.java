package com.jdbc.sai;

import java.awt.Window.Type;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class callablestatements {

	public static void main(String[] args) {
		Connection con = null;
		CallableStatement cst = null;
		CallableStatement cst2 = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "saikumar");
			cst = con.prepareCall("{call getSal(? , ?)}");
			cst.setInt(1, 111);
			cst.registerOutParameter(2, Types.FLOAT);
			cst.execute();
			System.out.println(cst.getFloat(2));
			
			
			cst2 = con.prepareCall("{? = call getAVG(?, ?)}");
			cst2.setInt(2, 111);
			cst2.setInt(3, 222);
			
			cst2.registerOutParameter(1, Types.FLOAT);
			cst2.execute();
			System.out.println(cst2.getFloat(1));
			
			
			
			
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
/*
 create or replace function getAVG(no1 IN number, no2 IN number) return float
 AS
 sal1 float;
 sal2 float;
 BEGIN
 	select esal into sal1 from emp1 where ENO = no1;
 	select esal into sal2 from emp1 where ENO = no2;
 	return (sal1+sal2)/2;
 END getAVG;
 /
 
 
 */





/*

create or replace procedure getSal(no IN number, sal OUT float)
AS
BEGIN
	select ESAL into SAL from emp1 where ENO = no;
END getSal;
/


*/