# 🏢 Dormitory Management System
A robust, console-based Java application designed to streamline and automate daily dormitory operations. Developed with a strict adherence to Object-Oriented Programming (OOP) principles, Clean Architecture, and N-Tier Layering, this project prioritizes maintainability, extensibility, and separation of concerns.

## 🚀 Features
The system supports role-based access control (RBAC) with three primary user types: Students, Personnel, and Authorized Personnel (Admins).

- 🔒 **Secure Authentication & Role Routing:** Dynamic menu rendering based on the logged-in user's role.

- 📝 **Leave Request Management:** Students can submit and postpone leave requests; Admins can verify parental consent and approve/reject them.

- 📋 **Staff Task Assignment:** Admins can assign duties to personnel with specific times and locations; Personnel can view their chronologically sorted daily tasks.

- 🧺 **Laundry Booking:** Conflict-free time slot reservations for dormitory washing machines.

- 📢 **Global Announcements:** Real-time broadcast system for administrators to publish news to all dormitory residents and staff.

- 🍽️ **Dining & Shuttle Schedules:** Centralized viewing of daily meal calories and weekly shuttle departure times.

## 🏗️ Architecture (N-Tier Clean Architecture)
The project is structured into four distinct layers, strictly obeying the Dependency Rule (dependencies only point inward toward the Domain layer).

- **Presentation Layer (UI):** A Command-Line Interface (CLI) that handles user inputs and console outputs. Contains zero business logic.

- **Application Layer (Services & Facade):** The operational brain orchestrating system use cases. It acts as a bridge between the UI and the data repositories.

- **Domain Layer (Core):** Encapsulates enterprise business rules and entities (Student, LeaveRequest, TaskAssignment). Completely isolated from external frameworks.

- **Infrastructure Layer (Persistence):** Manages data storage. Currently utilizes In-Memory Repositories (e.g., TreeSet, HashMap) to ensure fast, O(1) and O(log n) data retrieval and automatic chronological sorting.

## 🧩 Design Patterns Implemented
To ensure a highly decoupled and scalable codebase, 8 Gang of Four (GoF) Design Patterns were actively utilized:

- **Factory Method:** Centralizes the instantiation of different User roles.

- **Builder:** Ensures thread-safe and fluent construction of complex entities like LeaveRequest and TaskAssignment.

- **Singleton:** Guarantees a single, globally accessible instance for in-memory Repositories.

- **Repository:** Abstracts data access logic, allowing for future database migrations without altering the Domain.

- **Facade:** Provides a unified, simplified entry point (DormitoryFacade) for the UI to interact with complex backend services.

- **Observer:** Drives the AnnouncementService, dynamically notifying all registered users when a new broadcast is published.

- **State:** Dynamically alters the application's execution flow based on authentication status (LoggedInState vs. NotLoggedInState), eliminating brittle if-else chains.

- **Template Method:** Defines the standard execution skeleton for all CLI menus in a base abstract class, enforcing a consistent UI lifecycle.

## 💻 Getting Started

### Prerequisites
- Java Development Kit (JDK) 11 or higher.
- Any standard Java IDE (IntelliJ IDEA, Eclipse, VS Code) or terminal.

### Installation and Execution
1. Clone the Repository:

    ```bash
     git clone https://github.com/iremnaz-d/DormitoryManagementSystem.git
    ```
3. Navigate to the project directory and compile the source code.
4. Run the *Main.java* file to launch the Command-Line Interface.

*Note: Because the system uses In-Memory collections, all data is volatile and will reset upon closing the application.*

##  🛣️ Future Scope

- Persistent Database: Migrating from in-memory collections to a relational database (PostgreSQL) by simply writing new Repository implementations.

- Automated Testing: Integrating JUnit 5 for comprehensive unit and integration testing of the Domain and Application layers.

- Evaluation Module: Implementing the UI for the deferred Student Evaluation and Feedback module.

