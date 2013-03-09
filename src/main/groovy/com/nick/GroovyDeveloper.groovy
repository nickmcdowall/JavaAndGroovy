package com.nick
import com.nick.JavaDeveloper;


class GroovyDeveloper extends JavaDeveloper{

	private PrintStream output;

	public GroovyDeveloper(PrintStream output){
		super(output);
		this.output = output;
	}

	@Override
	public void doStuff() {
		super.doStuff()
		output.println "I'm adding some groovy goodness."
	}

}
