FROM java
VOLUME /tmp
ADD {JAR_NAME} app.jar
ADD wait-for-it.sh wait-for-it.sh
ADD start.sh start.sh
RUN bash -c 'touch /app.jar'
RUN bash -c 'chmod +x /wait-for-it.sh'
RUN bash -c 'chmod +x /start.sh'
EXPOSE {PORT}
ENTRYPOINT ["/start.sh"]