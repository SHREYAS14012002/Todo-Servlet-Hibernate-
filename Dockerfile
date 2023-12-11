FROM tomcat:9.0-jre11
# Remove default Tomcat apps
RUN rm -rf /usr/local/tomcat/webapps/*
# Copy your WAR file to Tomcat's webapps directory
COPY target/todo.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8888
CMD ["catalina.sh", "run"]
