# Software Engineering (CSE 307 & CSE 308)

> **Level-3 Term-I, CSE, BUET**
> A comprehensive repository showcasing practical implementations of software design patterns and object-oriented principles.

## 📖 Overview

This repository contains problem-solving assignments and projects for the Software Engineering courses (CSE 307 & 308). The projects demonstrate the application of various software design patterns and best practices in object-oriented programming (OOP) using Java. Each module includes both the source code and the accompanying class diagrams representing the system architecture.

## 🗂️ Project Structure & Design Patterns

The repository is structured into different "Offline" and "Online" modules, each addressing a specific architectural problem using appropriate software design patterns:

### Offline Assignments
*   **Offline-01: Banking System**
    *   *Focus:* Object-Oriented Principles, Encapsulation, State Management, and System Modeling.
    *   *Description:* Models a typical banking environment with different account types, employee roles (Cashier, Officer, Managing Director), and loan mechanisms.
*   **Offline-02: Order Management System**
    *   *Design Pattern:* **Builder Pattern**
    *   *Description:* A customizable shake-ordering system that separates the construction of complex objects from their representation.
*   **Offline-03: System Integrations & Hierarchies**
    *   *Problem I:* **Adapter Pattern** - Adapting a legacy/imposter system to work cleanly with a spaceship's Crewmate interface.
    *   *Problem II:* **Composite Pattern** - Designing a hierarchical file system structure (Drives, Folders, Files) with uniform component treatment.
*   **Offline-04: Real-time Stock Market**
    *   *Architecture & Pattern:* **Observer Pattern & Client-Server Architecture**
    *   *Description:* A real-time socket-based notification system involving stock price updates, subscribers, multi-threading, and concurrent connections.

### Online Assessments
*   **Online-A1:** Implementation of the **Adapter Pattern** for unified data parsing interfaces.
*   **Online-B1:** Applying creational design structures for robust, scalable ID generation.

## 🚀 Getting Started

### Prerequisites

To compile and run the programs in this repository, ensure your environment handles Java applications:
*   [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/) (JDK 8+ recommended).
*   An IDE of your choice (e.g., IntelliJ IDEA, Eclipse, or VS Code with Java extensions).

### Build and Run Instructions

The modules are standalone Java desktop applications. You can compile and execute each individually:

1.  **Clone the repository:**
    ```bash
    git clone <repository_url>
    cd Software-Engineering
    ```
2.  **Navigate directly to a module's source (e.g., Offline-02):**
    ```bash
    cd "Offline-02/_2005021/src/"
    ```
3.  **Compile the Java files:**
    ```bash
    javac *.java
    ```
4.  **Run the Main Application Entry:**
    ```bash
    java OrderManagementSystem
    ```
    *(Replace `OrderManagementSystem` with the primary driver class of the respective module, e.g., `Main`, `Application`, or `Server` and `Client`).*

## 🛠️ Software Engineering Best Practices

The codebase throughout this repository follows professional software development methodologies:
- **SOLID Principles:** Encouraging single responsibility, open/closed behaviors, and dependency inversion for scalable systems.
- **Design Patterns:** Pragmatic and correct application of GoF (Gang of Four) patterns.
- **Modularity:** Ensuring high cohesion within packages and low coupling between varying system actors.
- **Concurrency control:** Safe multi-threading read-write implementations (e.g., SocketWrappers in Offline-04).

## 📄 Course Info & Integrity

This repository is maintained for educational reference for the CSE 307 & 308 courses at BUET. If you are a current student, please use this as a learning resource and do not copy code directly to avoid academic plagiarism.
