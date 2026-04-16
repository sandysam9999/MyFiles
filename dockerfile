FROM tomcat:10.1



COPY dist/MyFiles.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

