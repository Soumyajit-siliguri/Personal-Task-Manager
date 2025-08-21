# 📌 DSA-Powered Personal Task Manager (CLI App)
**Subtitle**: *Console-based productivity app built with Java OOP + Collections + DSA algorithms*

## ✅ MVP CHECKLIST (Base Project + All Bonus Features)
### 🔹 PHASE 1 – Project Setup & Structure
- [X] Create Main.java with menu loop
- [X] Define Task class with:
  - [X] ID, Title, Description
  - [X] Due Date (as LocalDate)
  - [X] Priority (Enum: LOW, MEDIUM, HIGH)
  - [X] Tags (Set< String >)
  - [X] Status (Enum: TODO, IN_PROGRESS, DONE)
- [X] Basic CLI input flow using Scanner
- [X]  Directory Structure:
    ```text
    /taskmanager
  ├── Main.java
  ├── model/
  ├── service/
  ├── util/
  └── data/
    ```

### 🔹 PHASE 2 – Task CRUD Operations (Basic Functionality)
- [X] Add New Task
- [X] View All Tasks (sorted by creation time)
- [X] View by Status (filter)
- [ ] Update Task (title, desc, tags, priority, status)
- [ ] Delete Task

DS Used:
* ArrayList, Enum, Scanner, LocalDateTime

### 🔹 PHASE 3 – Productivity & DSA Features
| ✅ Feature                                            | 💡 DS & Algo Concepts                             |
| ---------------------------------------------------- | ------------------------------------------------- |
| \[ ] View Top Priority Tasks                         | `PriorityQueue` with custom Comparator            |
| \[ ] View Upcoming Due Tasks                         | `MinHeap` or simple sort on due date              |
| \[ ] Undo Delete                                     | `Stack` for recently deleted tasks                |
| \[ ] Task History                                    | `Queue` or `Deque` (view recently modified tasks) |
| \[ ] Fast Search by Title/Keyword                    | `HashMap<String, List<Task>>` or simple substring |
| \[ ] Tag-Based Search                                | `Map<String, List<Task>>`                         |
| \[ ] Sort by Custom Logic (date + priority + status) | `Comparator`, `Collections.sort()`                |
| \[ ] Save/Load Tasks from File                       | Java Serialization (`ObjectOutputStream`, etc.)   |
| \[ ] Count Tasks by Status / Tag                     | Use of `Map<String, Integer>`                     |
| \[ ] Split Complex Task into Subtasks (Recursive)    | Use recursion, tree-like design                   |
| \[ ] Time Logs per Task                              | `Map<TaskId, List<TimeLog>>`                      |
| \[ ] Filter Task Logs between Date Ranges            | Date comparison, `Stream` or loop logic           |

### 🔹 PHASE 4 – Java 8 + Utility Layer
- [ ] Use Optional, Stream, Lambda for filtering, sorting
- [ ] Utility classes:
  - [ ] DateUtil: parsing and formatting LocalDateTime
  - [ ] InputValidator: reusable validations

### 🔹 PHASE 5 – Unit Testing (Optional But Good Practice)
- [ ] Create basic test methods for:
    * Adding task
    * Priority sort
    * Tag search
- [ ] Use JUnit (only if you're ready)

### 🧪 BONUS (Very Real-World Touch)
These can be used to build your next sprints:
- [ ] Auto ID generation with UUID or simple counter
- [ ] Export task report (text file)
- [ ] Task stats dashboard in console (e.g., pie chart with characters)
- [ ] Save backup to JSON (prep for DB in Spring Boot phase)
- [ ] GitHub README with:
    * About
    * Features
    * Data Structures used
    * Architecture
    * How to Run

## 📘 Suggested File Structure (Detailed)
```text
/taskmanager
├── Main.java
├── model/
│   ├── Task.java
│   ├── Priority.java
│   ├── Status.java
│   └── TimeLog.java
├── service/
│   ├── TaskService.java
│   ├── UndoService.java
│   └── ReportService.java
├── data/
│   ├── TaskRepository.java
│   └── FileStorage.java
├── util/
│   ├── DateUtil.java
│   └── InputValidator.java
```
## 🚀 How to Approach This?
| Day   | Goal                                          |
| ----- | --------------------------------------------- |
| Day 1 | Setup structure + Task model + CRUD           |
| Day 2 | Add priority, status, tags, task list view    |
| Day 3 | Add productivity logic (priority, due alerts) |
| Day 4 | Add Undo, History, Search by Tag/Title        |
| Day 5 | Add file storage, time logs, recursive tasks  |
| Day 6 | Polish with streams, formatting, validations  |
| Day 7 | Create README, test cases, and final refactor |

## 🧠 You're Ready If You Can:
* ✅ Use OOP + DSA + Java 8 cleanly
* ✅ Solve problems using your own logic
* ✅ Reuse concepts like Map, List, Queue, Comparator, and Recursion
* ✅ Explain how and why you used each DS