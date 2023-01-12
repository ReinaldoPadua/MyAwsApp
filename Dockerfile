FROM gradle

ENV RDS_HOSTNAME=mysql
ENV RDS_PORT=3306
ENV RDS_DB_NAME=testedb
ENV RDS_USERNAME=root
ENV RDS_PASSWORD=root
ENV RDS_DRIVER_DB=com.mysql.cj.jdbc.Driver
ENV DATASOURCE_PROTOCOL=jdbc
ENV DB_TYPE=mysql

RUN mkdir -p /app
WORKDIR /app

COPY . /app

RUN gradle test
RUN gradle build

ENTRYPOINT ["java","-jar","build/libs/myAWSapp-0.0.1-SNAPSHOT.war"]