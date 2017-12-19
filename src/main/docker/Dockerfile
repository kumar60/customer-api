FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
RUN apk add --no-cache curl
ADD customer*.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
