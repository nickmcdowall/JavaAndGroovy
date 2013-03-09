JavaAndGroovy
=============

Summary
-------

This is an example of how a project can be setup to use <code>Groovy</code> and <code>Java</code> interchangeably.
By this I mean that you should be able to use a mixture of <code>Java</code> and <code>Groovy</code> classes and
do things like extend <code>Groovy</code> classes from <code>Java</code> classes (and the other way round). I provide an
example project configuration for both <code>Gradle</code> and <code>Maven</code>.

Using <code>Gradle</code>
------------

Achieving this in <code>Gradle</code> is very simple. Firstly you need to add the <code>Groovy</code> plugin
by including this line in the <code>build.gradle</code> file:

<code>apply plugin: 'groovy'</code>

This plugin extends the <code>Java</code> plugin so by adding this plugin you will be adding tasks for compiling
<code>Java</code> and <code>Groovy</code> source files. Below is the default expected source layout
[which can be reconfigured]. <em>FYI - The <code>Groovy</code> source folders can contain either <code>Java</code> or
<code>Groovy</code> sources but the <code>Java</code> source folders must contain only <code>Java</code> source files.</em>
<pre>
	<code>src/main/java</code>
	<code>src/main/groovy</code>
	<code>src/main/resources</code>
	<code>src/test/java</code>
	<code>src/test/groovy</code>
</pre>
Finally you need to add a compile time <code>Groovy</code> dependency to the project, e.g.
<blockquote><code>compile 'org.codehaus.groovy:groovy-all:2.0.5'</code></blockquote>

That is pretty much it - here is a full <code>build.gradle</code> example which is a slightly cut down version of the
<code>Gradle</code> build config used for this git project:

---
<pre>
<code>
	apply plugin: 'groovy'

	version = '1.0'

	jar {
		manifest {
			attributes 'Title': 'JavaAndGroovy', 'Version': version
		}
	}

	repositories {
		mavenLocal()
		mavenCentral()
	}

	dependencies {
		compile 'org.codehaus.groovy:groovy-all:2.0.5'
	}
</code>
</pre>
---
See the <code>Gradle</code> <code>Groovy</code> plugin documentation for further details <http://www.gradle.org/docs/current/userguide/groovy_plugin.html>

