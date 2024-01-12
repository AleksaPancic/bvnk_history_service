FROM openjdk:11
ARG JAR_FILE=/build/libs/*.jar
COPY ${JAR_FILE} historyService.jar
EXPOSE 9000 5005
ENV JAVA_TOOL_OPTIONS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5300"
ENTRYPOINT ["java","-jar","/historyService.jar"]