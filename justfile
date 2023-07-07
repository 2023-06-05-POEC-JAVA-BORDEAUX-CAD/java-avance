set shell := ["nu", "-c"]

deploy:
	catalina stop
	mvn clean install
	mv ./target/*.war D:\apache-tomcat-10.1.10\webapps -f -u -v
	catalina start

startTomee:
	mvn clean install
	mv ./target/*.war D:\apache-tomee-webprofile-9.1.0\webapps\poe-java-av-jdbc-1.0.0-SNAPSHOT.war
	CATALINA_BASE='D:\apache-tomee-webprofile-9.1.0' CATALINA_HOME='D:\apache-tomee-webprofile-9.1.0' CATALINA_TMPDIR='D:\apache-tomee-webprofile-9.1.0\temp' CLASSPATH='D:\apache-tomee-webprofile-9.1.0\bin\bootstrap.jar;D:\apache-tomee-webprofile-9.1.0\bin\tomcat-juli.jar;D:\apache-tomee-webprofile-9.1.0\bin\commons-daemon.jar' D:\apache-tomee-webprofile-9.1.0\bin\startup.bat

stopTomee:
	CATALINA_BASE='D:\apache-tomee-webprofile-9.1.0' CATALINA_HOME='D:\apache-tomee-webprofile-9.1.0' CATALINA_TMPDIR='D:\apache-tomee-webprofile-9.1.0\temp' CLASSPATH='D:\apache-tomee-webprofile-9.1.0\bin\bootstrap.jar;D:\apache-tomee-webprofile-9.1.0\bin\tomcat-juli.jar;D:\apache-tomee-webprofile-9.1.0\bin\commons-daemon.jar' D:\apache-tomee-webprofile-9.1.0\bin\shutdown.bat
	rm D:\apache-tomee-webprofile-9.1.0\webapps\poe-java-av-jdbc-1.0.0-SNAPSHOT -r -f
	rm D:\apache-tomee-webprofile-9.1.0\webapps\poe-java-av-jdbc-1.0.0-SNAPSHOT.war -f