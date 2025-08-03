# Kafka demo(JAVA)


### Setps to build and run this project

- Make sure your env. has maven 3.9+ and Java 17+ 

```
cd kafka-demo-java
```
- Build the project:
```
mvn clean install
```
- Run the java Producer:
```
mvn exec:java -Dexec.mainClass=com.org.demo.Producer
```
- Run the java Consumer:

```
mvn exec:java -Dexec.mainClass=com.org.demo.Consumer
```

Note: Make sure the kafka controller and broker is up and running and the topic "test02" is already created.

