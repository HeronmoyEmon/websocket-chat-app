# **Simple WebSocket Chat Application**

## **Create a Spring Boot Project**

Use [Spring Initializr](https://start.spring.io/) or your IDE to generate a project with the following dependencies. 

- Spring Web 
- Spring WebSocket
- Spring Boot DevTools (optional)

## **Directory Structure**
```css
src/main/java/com/example/websocket
    ├── WebSocketChatApplication.java

src/main/java/com/example/websocket/chatapp
    ├── config/WebSocketConfig.java
    ├── controller/ChatController.java
    ├── model/ChatMessage.java

src/main/resources/static
    ├── index.html
```

## **Code Files**
[WebSocketChatApplication.java](/src/main/java/com/example/websocket/WebSocketApplication.java)

[WebSocketConfig.java](/src/main/java/com/example/websocket/chatapp/config/WebSocketConfig.java)

[ChatController.java](/src/main/java/com/example/websocket/chatapp/controller/ChatController.java)

[ChatMessage.java](/src/main/java/com/example/websocket/chatapp/model/ChatMessage.java)

[index.html](/src/main/resources/static/index.html)


## **Run the Application**
- Run the `WebSocketChatApplication` class or run this command from terminal : 
```bash
./mvnw spring-boot:run
```
- Open your browser and go to http://localhost:8080
- Open multiple tabs or windows to test the chat functionality

## **Advantages of this Approach**
1. **Scalability**: Uses Spring’s messaging system for message routing.
2. **Decoupled Components**: Separates WebSocket handling from message processing.
3. **Ease of Testing**: With `@MessageMapping` and `@SendTo`, you can easily test the chat logic.