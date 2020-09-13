FROM openjdk:7
COPY /Blockchain/src/blockchain/ /Blockchain/src/blockchain/
WORKDIR /Blockchain/src/blockchain/
#RUN javac Blockchain.java
#CMD ["java", "Blockchain"]