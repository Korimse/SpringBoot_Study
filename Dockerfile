FROM openjdk:8-jdk-alpine

LABEL maintainer="f.mujeup01@naver.com"

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=build/libs/sb_board-1.0.1-SNAPSHOT-20210729180440.jar

ADD ${JAR_FILE} sb_board-1.0.1-SNAPSHOT-20210729180440.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/sb_board-1.0.1-SNAPSHOT-20210729180440.jar"]
