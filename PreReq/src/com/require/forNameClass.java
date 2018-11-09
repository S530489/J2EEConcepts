package com.require;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class forNameClass {
	static {
		System.out.println("class loading");
	}
	
	public forNameClass() {
		System.out.println("constructor loading");
	}
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
		Class c =  Class.forName("com.require.forNameClass");// fully qualified name is mandatory
		Object obj = c.newInstance();
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the data: ");
		String data = b.readLine();
		System.out.println("Enter the data: " );
		int i = b.read();
		System.out.println(data);
		System.out.println(i+" "+(char)i);
		
		
	}

}
