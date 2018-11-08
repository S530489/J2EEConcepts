package com.require;

public class forNameClass {
	static {
		System.out.println("class loading");
	}
	
	public forNameClass() {
		System.out.println("constructor loading");
	}
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class c =  Class.forName("com.require.forNameClass");// fully qualified name is mandatory
		Object obj = c.newInstance();
	}

}
