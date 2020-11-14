
FROM tomcat:9
COPY target/surveywebjpa-RestAPI*.war /usr/local/tomcat/webapps/surveywebjpa-RestAPI.war
