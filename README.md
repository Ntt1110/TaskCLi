# TaskCLi# Task Tracker CLI 🚀

- **Project URL:** https://github.com/Ntt1110/TaskCLi

The task management application, which runs directly on the command line, is built using pure Java and follows a standard layered architecture.

Please provide the text you would like me to translate.

## 📌 Key Features
* **Add task:** Create a new task with an automatically generated ID, along with a creation timestamp (`createdAt`) and a default status (`TODO`).
* **Display the list:** Show the complete list of existing tasks in a clear and understandable manner on the console screen.
* **Update content:** Modify the content of a task using its ID.
* **Update status (`update-status`):** Modify the progress of a task through different statuses (e.g., `TODO`, `IN_PROGRESS`, `DONE`).
* **Delete task (`delete`):** Remove unnecessary tasks from the system based on their ID.
* **Data Storage:** Automatically reads and writes data to a local file (`Task.json`) using the **Google Gson** library.

Please provide the text you would like me to translate.

## 🏛️ Project Architecture (Layered Architecture)
The project is structured with clearly defined, independent layers to facilitate maintenance and expansion.
* `com.example.Main`: The entry point for the application.
* `com.example.cli`: Command-line interface layer (`CliApp` manages the interactive REPL loop).
* `com.example.controller`: The TaskController receives requests from the CLI and handles input streams.
* `com.example.service`: The `TaskService` handles business logic for adding, modifying, deleting, and status-changing tasks.
* `com.example.repository`: The `TaskRepository` is responsible for reading and writing JSON files.
* `com.example.model`: Defines the `Task` object structure and the `Status` (Enum) data type.

Please provide the text you would like me to translate.

## ⚙️ Technologies Used
* Java SE (JDK 17+)
* **Maven**: Project dependency management
* **Google Gson**: A library for automatic and manual JSON serialization/deserialization

Please provide the text you would like me to translate.

## 📦 Installation and Usage Guide

1. **Clone the repository to your machine:**
```bash
git clone [https://github.com/Ntt1110/TaskCLi.git]
cd TaskCLi
