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

```groovy
apply plugin: 'groovy'
```

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
```groovy
compile 'org.codehaus.groovy:groovy-all:2.0.5'
```

That is pretty much it - here is a full <code>build.gradle</code> example which is a slightly cut down version of the
<code>Gradle</code> build config used for this git project:

```groovy
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
```
See the <code>Gradle</code> <code>Groovy</code> plugin documentation for further details <http://www.gradle.org/docs/current/userguide/groovy_plugin.html>

Using <code>Maven</code>
------------------------
It is slightly trickier to setup the <code>Maven</code> build config. Firstly we need to add a <code>Groovy</code> plugin to
the pom file. Note that although the compiler has <em>eclipse</em> in its name there is no requirement to use eclipse [It is simply
the same compiler that is used by the eclipse <code>Groovy</code> plugin to compile <code>Groovy</code> source files].
```xml
	<plugin>
		<groupId>org.codehaus.groovy</groupId>
		<artifactId>groovy-eclipse-compiler</artifactId>
		<version>2.6.0-01</version>
		<extensions>true</extensions>
	</plugin>
```
By default the project source folder layout is the same for both <code>Maven</code> and <code>Gradle</code>. Next we need
to configure the <code>Maven</code> compiler to use the <code>Groovy</code> compiler plugin as a dependency:
```xml
	<plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-compiler-plugin</artifactId>
		<version>2.4</version>
		<configuration>
			<compilerId>groovy-eclipse-compiler</compilerId>
			<source>1.6</source>
			<target>1.6</target>
		</configuration>
		<dependencies>
			<dependency>
				<groupId>org.codehaus.groovy</groupId>
				<artifactId>groovy-eclipse-compiler</artifactId>
				<version>2.6.0-01</version>
			</dependency>
		</dependencies>
	</plugin>
```
Finally we need to add the compile time project dependency to the pom [This is what determines which <code>Groovy</code>
version gets used]:
```xml
	<dependency>
		<groupId>org.codehaus.groovy</groupId>
		<artifactId>groovy-all</artifactId>
		<version>2.0.5</version>
	</dependency>
```

Here is a full example based on a cut down version of this git project's pom:
```xml
	<?xml version="1.0" encoding="UTF-8"?>
	<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
		<modelVersion>4.0.0</modelVersion>
		<groupId>com</groupId>
		<artifactId>nick</artifactId>
		<version>1.0-SNAPSHOT</version>
		<packaging>jar</packaging>
		<build>
			<plugins>
				<plugin>
					<groupId>org.apache.maven.plugins</groupId>
					<artifactId>maven-compiler-plugin</artifactId>
					<version>2.4</version>
					<configuration>
						<compilerId>groovy-eclipse-compiler</compilerId>
						<source>1.6</source>
						<target>1.6</target>
					</configuration>
					<dependencies>
						<dependency>
							<groupId>org.codehaus.groovy</groupId>
							<artifactId>groovy-eclipse-compiler</artifactId>
							<version>2.6.0-01</version>
						</dependency>
					</dependencies>
				</plugin>
				<plugin>
					<groupId>org.codehaus.groovy</groupId>
					<artifactId>groovy-eclipse-compiler</artifactId>
					<version>2.6.0-01</version>
					<extensions>true</extensions>
				</plugin>
			</plugins>
		</build>
		<dependencies>
			<dependency>
				<groupId>org.codehaus.groovy</groupId>
				<artifactId>groovy-all</artifactId>
				<version>2.0.5</version>
			</dependency>
		</dependencies>
	</project>
```
Not quite as clean as <code>Gradle</code> but it does the same job.

See the project source for a real albeit simplistic example of a project with Java and Groovy classes.