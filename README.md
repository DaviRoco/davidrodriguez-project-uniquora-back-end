# Uniquora Back-End

Uniquora is an e-commerce application specializing in clothing, designed to provide a seamless and enjoyable shopping experience for fashion enthusiasts. The platform offers a wide range of clothing options, including casual wear, formal attire, activewear, and accessories, catering to diverse styles and preferences.

## Features

- **Product Management**: Add, update, and delete products with detailed descriptions and images.
- **User Authentication**: Secure user registration and login functionalities.
- **Order Processing**: Manage customer orders, including order creation, status updates, and history tracking.
- **Inventory Management**: Monitor stock levels and receive notifications for low inventory.
- **Payment Integration**: Process payments securely through integrated payment gateways.

## Technologies Used

- **Backend Framework**: [Spring Boot](https://spring.io/projects/spring-boot)
- **Database**: [PostgresSQL](https://www.postgresql.org/)
- **Authentication**: [Spring Security](https://spring.io/projects/spring-security)


## Getting Started

Make sure you **request the .env File**

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/DaviRoco/davidrodriguez-project-uniquora-back-end.git
   ```
2. **Build the project and begin Application in Docker:**
   
 - To create Docker Container: 
   ```bash
   docker-compose up --build
   ```
- To Delete Docker Container: 
   ```bash
   docker-compose down -v  
   ```
3. **Log in to the Application**
   ```bash
   Username: User
   Password: Auto Generated inside the logs

4. **To run Application Tests**
   ```bash
   ./gradlew test jacocoTestReport 
- After you run this Test Report, got to build/reports/jacoco/test/html/index.html and check the report in your browser.
