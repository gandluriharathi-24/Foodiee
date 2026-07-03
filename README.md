# 🍔 Foodiee - Online Food Ordering System

Foodiee is a Java-based Online Food Ordering System developed using JSP, Servlets, JDBC, MySQL, HTML, CSS, and JavaScript. The application allows users to browse restaurants, view menus, add food items to the cart, and place orders through a simple and user-friendly interface.

---

# 📋 Requirements

Before running the project, ensure the following software is installed:

- Java JDK 17 or later
- Eclipse IDE for Enterprise Java Developers
- Apache Tomcat 10
- MySQL Server 8.0
- MySQL Workbench
- Git (Optional)
- Google Chrome, Microsoft Edge, or Firefox

### Technologies Used

- Java
- JSP
- Servlets
- JDBC
- MySQL
- HTML5
- CSS3
- JavaScript

---

# ⚙️ Installation Process

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/Foodiee.git
```

### 2. Open the Project

Import the project into Eclipse:

```
File → Import → Existing Projects into Workspace
```

### 3. Configure Apache Tomcat

- Install Apache Tomcat 10.
- Add Tomcat Server in Eclipse.

### 4. Create the Database

Open MySQL Workbench and execute:

```sql
CREATE DATABASE foodiee;
```

### 5. Import the SQL File

Import the provided database SQL file into the `foodiee` database.

### 6. Configure Database Connection

Update your JDBC connection details:

```java
String url = "jdbc:mysql://localhost:3306/foodiee";
String username = "root";
String password = "your_password";
```

### 7. Add MySQL Connector

Add the MySQL Connector JAR file to the project's build path if it is not already included.

---

# ▶️ Execution Steps

1. Open Eclipse.
2. Start the Apache Tomcat Server.
3. Right-click the project.
4. Select:

```
Run As → Run on Server
```

5. Choose Apache Tomcat Server.
6. Click **Finish**.
7. Open the application in your browser:

```
http://localhost:8080/Foodiee/
```

8. Register or log in.
9. Browse restaurants and menus.
10. Add items to the cart.
11. Place your order.

---

# ✨ Features

- User Registration
- User Login & Logout
- Restaurant Listing
- Restaurant Search
- Dynamic Menu Display
- Food Item Details
- Add to Cart
- Update Cart Quantity
- Remove Cart Items
- Checkout System
- Order Placement
- User Profile
- Session Management
- Responsive User Interface
- MySQL Database Integration
- MVC Architecture (JSP + Servlets)

---

# 📁 Project Structure

```
Foodiee/
│
├── src/
│   ├── Servlet/
│   ├── DAO/
│   ├── Model/
│   └── Utility/
│
├── WebContent/
│   ├── css/
│   ├── images/
│   ├── js/
│   ├── home.jsp
│   ├── cart.jsp
│   ├── checkout.jsp
│   └── profile.jsp
│
├── database/
│   └── foodiee.sql
│
└── README.md
```

---

# 🚀 Future Enhancements

- Online Payment Integration
- Live Order Tracking
- Admin Dashboard
- Restaurant Dashboard
- Email Notifications
- Mobile Responsive Improvements
- Rating and Review System

---

# 📌 Conclusion

Foodiee is a simple and efficient online food ordering system developed using Java Full Stack technologies. The project demonstrates the implementation of JSP, Servlets, JDBC, MySQL, HTML, CSS, and JavaScript following the MVC architecture. It provides essential food ordering functionalities while maintaining clean code structure and database integration, making it suitable as an academic project and a foundation for future enhancements.

---

## 👨‍💻 Author

**Vamsi Krishna Mula**

---

## 📄 License

This project is intended for educational purposes.
