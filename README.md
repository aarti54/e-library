# Library Management System

A full-stack web application for managing library operations, built with Java, Servlets, JDBC, Hibernate, and MySQL. Designed to simplify book management, user authentication, and reporting for library administrators.

---

## Features

- **User Authentication** — Secure login and registration for admin and users
- **Book Management** — Add, update, delete, and search books by title, author, or category
- **Issue & Return System** — Track which books are issued, by whom, and due dates
- **Reporting Module** — View reports on issued books, available stock, and user activity
- **Responsive Frontend** — Clean and simple UI built with HTML and CSS

---

## Tech Stack

| Layer       | Technology              |
|-------------|-------------------------|
| Backend     | Java, Servlets          |
| ORM         | Hibernate               |
| Database    | MySQL, JDBC             |
| Frontend    | HTML, CSS               |
| Server      | Apache Tomcat           |

---

## Project Structure

```
LibraryManagementSystem/
├── src/
│   ├── servlets/         # Java Servlets (controllers)
│   ├── models/           # Hibernate entity classes
│   ├── dao/              # Database access layer (JDBC/Hibernate)
│   └── utils/            # Helper/utility classes
├── WebContent/
│   ├── WEB-INF/
│   │   └── web.xml       # Deployment descriptor
│   ├── css/              # Stylesheets
│   ├── jsp/              # JSP view pages
│   └── index.html        # Landing page
├── hibernate.cfg.xml     # Hibernate configuration
└── README.md
```

---

## How to Run Locally

### Prerequisites
- Java JDK 8 or above
- Apache Tomcat 9+
- MySQL 5.7+
- Eclipse IDE (or any Java IDE)

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/aarti54/library-management-system.git
   ```

2. **Set up the database**
   - Open MySQL and create a database:
     ```sql
     CREATE DATABASE library_db;
     ```
   - Import the SQL file from `/database/library_db.sql`

3. **Configure Hibernate**
   - Open `hibernate.cfg.xml` and update your MySQL username and password:
     ```xml
     <property name="connection.username">your_username</property>
     <property name="connection.password">your_password</property>
     ```

4. **Deploy on Tomcat**
   - Import the project into Eclipse as a Dynamic Web Project
   - Add the project to your Tomcat server
   - Start the server and open `http://localhost:8080/LibraryManagementSystem`

