# Rofuf - Book Store Application

Rofuf is a feature-rich desktop application developed in Java, serving as a comprehensive book store platform. With a focus on user-friendly interactions, security, and efficient functionality, Rofuf provides a seamless experience for both readers and administrators.

## Features

### General Features
- **Buy Books:** Browse, select, and purchase books seamlessly through the application.
- **Review Book:** Users can share their thoughts and feedback by providing reviews for the books they've read.
- **Tickets System:** Users can seek support and address queries through the ticketing system.

### User Management
- **Login/Register/Forget Password:** Secure user authentication with options for account creation, login, and password recovery.
- **User ID Security:** Utilizes UUIDs for enhanced security, ensuring robust user identification.

### Search Functionality
- **Binary Search Implemented:** The main page features a search bar using binary search for efficient and fast search results.

### Security
- **Security Best Practices:** Adherence to security best practices to ensure the confidentiality and integrity of user data.
- **3-DES Encryption:** Sensitive data stored as ciphertext in the MySQL database using the Triple DES encryption method.
- **Password Security:** User passwords stored as MD5 hashes for enhanced security.

### User Engagement
- **Vouchers System:** Users can apply vouchers for discounts on purchases.
- **Points System:** Earn points with each book purchase, contributing to a rewarding experience.

### Communication
- **Chat System:** Implemented using socket server and client-side communication for real-time interaction between users.

### Roles System
- **User Roles:** Distinct roles for Normal users, Owners, and Admins.
- **Admin and Owner Privileges:**
  - Add, delete, and update books.
  - Ban users and manage user bans.
  - Edit and delete reviews.
  - Ticket management.
  - View online user lists.

### Auto Update System
- **Splash Screen:** A welcoming splash screen checks for updates and facilitates an auto-update system.

### Advanced Features
- **Average Review Calculation:** Automatically calculates the average review score whenever a user reviews a book.
- **Database:** Utilizes MySQL database with an ERD diagram available in the repository.

## Getting Started
1. Clone the repository.
2. Run the application on your local machine.
3. Explore the book store, engage in reviews, and enjoy the features offered by Rofuf.

# TO-DO
Complete Linking Frames With Back-End
