package com.require;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Streams {

	public static void main(String[] args) throws IOException {
		FileInputStream fin = new FileInputStream("D:/input.txt");
		int size  = fin.available();
		byte[] b = new byte[size];
		fin.read(b);
		String data = new String(b);
		System.out.println(data);
		fin.close();
		
		FileOutputStream fout = new FileOutputStream("D:/output.txt", true); // deafult false; true means append; false means override
		String s = "Sai Kumar123";
		byte []bout = s.getBytes();
		fout.write(bout);
		fout.close();

	}

}
