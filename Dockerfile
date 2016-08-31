FROM tomcat:8-jre8

ADD target/ComptesPerso.war /usr/local/tomcat/webapps/ROOT.war
ADD heroku/database.properties /tmp/database.properties

RUN /bin/rm -rf /usr/local/tomcat/webapps/ROOT

ENV ext.properties.dir=file:/tmp/
ENV JDBC_DATABASE_URL=jdbc:postgresql://database/postgres
ENV JDBC_DATABASE_USERNAME=postgres
ENV JDBC_DATABASE_PASSWORD=
