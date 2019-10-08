This is a springboot app/ fileparser microservice

the @SpringBootApplication class for this is FileParseApplication.java

How to run:

-> Import this unzipped project to eclipse/STS as a springboot application
-> right click on FileParseApplication.java and click on run as spring boot app.
-> The application should be up and running.

if you don't have maven setup. goto https://maven.apache.org/download.cgi
download the binary zip archive and unpack it.

goto command prompt and set environment for maven by running below commands

export M2_HOME=/root/apache-maven-3.6.2/
export PATH=/root/apache-maven-3.6.2/bin/:${PATH}

navigate to the directory where you've unzipped this folder.

and run " mvn spring-boot:run ". this should start the application.

after the application is started:

-> you can goto postman or other API testing apps 
-> make a http post call to the uri "http://localhost:8080/file/parse" with request parameter as a file.
-> the file can contain any lines or words you want to count the vowels for.
-> the response will contain the required output.

*I'm attaching the postman screenshots for this service in the email.

*NOTE: I didnt write tests for this code since I've done that for the other maven project


