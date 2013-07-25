package com.nick
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

import static org.mockito.Mockito.times
import static org.mockito.Mockito.verify
import static org.mockito.MockitoAnnotations.initMocks


class GroovyDeveloperTest {

	private Developer groovyDeveloper

	@Mock PrintStream output

	@Before void beforeTest() {
		initMocks(this)
		groovyDeveloper = new GroovyDeveloper(output)
	}

	@Test void shouldDoSomethingGroovy() {
		groovyDeveloper.doStuff()
		verify(output, times(1)).println("I am developing with Java.")
		verify(output, times(1)).println("I'm adding some groovy goodness.")
	}

}
