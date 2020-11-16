
FROM tomcat:9.0.39
COPY target/surveywebjpa-RestAPI.war /usr/local/tomcat/webapps/
