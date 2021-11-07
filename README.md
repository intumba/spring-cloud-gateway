# spring-cloud-gateway
This is a sample of spring-cloud-gateway to Active MQ configuration using websockets. The Active MQ is unsecured and spring-cloud-gateway is secured.

## Active MQ 5.16.0

Startup logs.
```
 INFO | Listening for connections at: tcp://SW-Sithabiso:61616?maximumConnections=1000&wireFormat.maxFrameSize=104857600
 INFO | Connector openwire started
 INFO | Listening for connections at: amqp://SW-Sithabiso:5672?maximumConnections=1000&wireFormat.maxFrameSize=104857600
 INFO | Connector amqp started
 INFO | Listening for connections at: stomp://SW-Sithabiso:61613?maximumConnections=1000&wireFormat.maxFrameSize=104857600
 INFO | Connector stomp started
 INFO | Listening for connections at: mqtt://SW-Sithabiso:1883?maximumConnections=1000&wireFormat.maxFrameSize=104857600
 INFO | Connector mqtt started
 INFO | Starting Jetty server
 INFO | Creating Jetty connector
 WARN | ServletContext@o.e.j.s.ServletContextHandler@18705fa{/,null,STARTING} has uncovered http methods for path: /
 INFO | Listening for connections at ws://SW-Sithabiso:61614?maximumConnections=1000&wireFormat.maxFrameSize=104857600
 INFO | Connector ws started
 INFO | Apache ActiveMQ 5.16.0 (localhost, ID:SW-Sithabiso-50621-1636266452609-0:1) started
 INFO | For help or more information please see: http://activemq.apache.org
 INFO | ActiveMQ WebConsole available at http://127.0.0.1:8161/
 INFO | ActiveMQ Jolokia REST API available at http://127.0.0.1:8161/api/jolokia/

```

## spring-cloud-gateway

Simple http client: spring security user password: Test234
```
https://localhost:8443/index.html
```

Discovery service.

```
cd discovery-service
mvn clean install spring-boot:run
```
API Gateway

```
cd gateway-service
mvn clean install spring-boot:run
```
## ** Atlernative to Active MQ **

Custom Java Websocket service. This service mimicks the Active MQ stomp example.

```
cd websocket-service
mvn clean install spring-boot:run
```
