package com.nick;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


public class JavaDeveloperTest {

	private JavaDeveloper javaDeveloper;

	@Mock private PrintStream output;


	@Before public void beforeTest(){
		initMocks(this);
		javaDeveloper = new JavaDeveloper(output);
	}

	@Test
	public void shouldDoJavaStuff() {
		javaDeveloper.doStuff();
		verify(output,times(1)).println("I am developing with Java.");
	}

}
