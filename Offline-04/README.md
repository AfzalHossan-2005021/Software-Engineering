# Offline-04: Stock Notification System

Offline-04 is a socket-based Java application that demonstrates a real-time stock subscription workflow. The system separates responsibilities into a server, a console client, and an admin control loop that updates stock data and notifies subscribers.

The implementation is a practical example of clean separation of concerns, event-driven updates, and simple client-server communication using Java object streams.

## System Overview

- The server loads the initial stock list from `init_stocks.txt`.
- Clients connect to the server, subscribe to stock updates, and view their current subscriptions.
- The admin console modifies stock counts and prices, which triggers notifications to interested clients.

## Main Components

- `Server` - starts the socket server, loads the stock inventory, and manages connected clients.
- `Admin` - background console loop for updating stock count and price.
- `Stock` - stores stock state and triggers notifications when values change.
- `NotificationManager` - keeps the subscription registry and dispatches updates.
- `ReadWriteThread` - processes client requests on the server side.
- `Client` - per-user server-side session model that stores subscriptions and pending notifications.
- `SocketWrapper` - shared stream wrapper for client-server communication.
- `Client/Client/src/Client.java` - interactive console client used by end users.

## User Workflows

### Client Commands

After connecting and entering a user name, the client accepts the following commands:

- `S <stockName>` - subscribe to a stock.
- `U <stockName>` - unsubscribe from a stock.
- `V` - view current subscriptions.
- `E` - exit the client.

### Admin Commands

The server-side admin console accepts stock update commands in the form:

- `I <stockName> <value>` - increase the stock price.
- `D <stockName> <value>` - decrease the stock price.
- `C <stockName> <count>` - change the available stock count.

## Behavior Notes

- Subscriptions are maintained per stock so notifications go only to interested clients.
- Each update on a stock immediately publishes a message to all subscribers of that stock.
- A connected client receives the full stock list on login, followed by subscription or notification updates as they occur.
- The system uses a fixed server port of `12345` and the loopback address `127.0.0.1` for the client.

## Build and Run

The project has no external dependencies. Any modern JDK should work.

### Start the Server

From `Offline-04/_2005021/src` in PowerShell:

```powershell
New-Item -ItemType Directory -Force out | Out-Null
javac -d out *.java
java -cp out Server
```

Keep this process running in one terminal. The admin console is part of the same process.

### Start the Client

From `Offline-04/Client/src` in a second terminal:

```powershell
New-Item -ItemType Directory -Force out | Out-Null
javac -d out *.java
java -cp out Client
```

Enter a user name when prompted, then use the client commands listed above.

## Project Layout

- `_2005021/src` - server-side implementation and admin loop
- `Client/src` - console client application
- `_2005021/init_stocks.txt` - initial stock inventory used at server startup
- `CSE308_Behavioural_Design_Pattern.pdf` - assignment brief

## Software Engineering Notes

- The design keeps the network protocol simple and explicit, which makes the system easier to reason about and test.
- Subscription state is centralized on the server, which avoids duplicate client-side state and keeps notifications authoritative.
- The server/client split makes the interaction model realistic while still keeping the codebase compact enough to understand end to end.
