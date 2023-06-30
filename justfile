set shell := ["nu", "-c"]

deploy:
    catalina stop
    mvn clean install
    mv ./target/*.war D:\apache-tomcat-10.1.10\webapps -f -u -v
    catalina start