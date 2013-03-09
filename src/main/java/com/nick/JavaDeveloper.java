package com.nick;

import java.io.PrintStream;

public class JavaDeveloper implements Developer {

	private PrintStream out;

	public JavaDeveloper(PrintStream out){
		this.out = out;
	}

	public void doStuff(){
		out.println("I am developing with Java.");
	}

}
