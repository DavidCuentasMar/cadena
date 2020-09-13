FROM openjdk:11.0.8

COPY /Blockchain/dist /Blockchain/dist
WORKDIR /Blockchain/dist
CMD ["java","-jar", "Blockchain.jar"]

# COPY /Blockchain/src/blockchain /Blockchain/src/blockchain
# WORKDIR /Blockchain/src/blockchain
# RUN javac Blockchain.java
# CMD ["java", "Blockchain.jar"]
