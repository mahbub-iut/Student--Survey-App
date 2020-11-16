
FROM tomcat:9
FROM java:11
COPY target/surveywebjpa-RestAPI.war /usr/local/tomcat/webapps/surveywebjpa-RestAPI.war
