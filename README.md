```markdown
# Feed Formulation Portal (React & Node.js)

## Overview

This project is a web application designed to manage and formulate nutritional feed for various marine life studied by researchers. This new version of the portal is built using modern web technologies: ReactJS for the frontend and NodeJS for the backend. It aims to replicate the functionality of the previous portal, offering improved user experience and a more scalable architecture. The existing MariaDB database, containing ingredient, feeds, and feedingredient tables, will be utilized.

## Getting Started

This guide provides step-by-step instructions to get the development environment up and running on your local machine. Follow these instructions carefully to ensure a smooth setup.

### Prerequisites

Before you begin, ensure you have the following software installed on your local machine:

1.  **Node.js:** Ensure you have Node.js version 18 or higher installed. You can download it from [https://nodejs.org/](https://nodejs.org/). Node.js includes npm (Node Package Manager), which you will use to install project dependencies.

2.  **npm (or yarn):** npm comes bundled with Node.js. If you prefer using yarn, you can install it globally using the command: `npm install -g yarn`.

3.  **MySQL Client:** You will need a MySQL client (e.g., MySQL Workbench, DBeaver, or the command-line client) to connect to your existing MariaDB database for verification and potential data inspection.

4.  **Git:** Ensure you have Git installed on your machine for version control. You can download it from [https://git-scm.com/downloads](https://git-scm.com/downloads).

## Installation

Follow these steps to set up the project on your local machine:

1.  **Clone the Repository:**
    Open your terminal or command prompt and navigate to the directory where you want to store the project. Then, clone the repository using the following command:

    ```bash
    git clone <your_repository_url>
    cd <your_repository_name>
    ```

    *(Replace `<your_repository_url>` with the actual URL of your new GitHub repository and `<your_repository_name>` with the name of the cloned directory).*

2.  **Frontend Setup:**
    Navigate to the `frontend` directory:

    ```bash
    cd frontend
    ```

    Install the required dependencies using npm:

    ```bash
    npm install
    ```

    Or, if you prefer using yarn:

    ```bash
    yarn install
    ```

    Once the dependencies are installed, you can start the frontend development server using:

    ```bash
    npm start
    ```

    Or with yarn:

    ```bash
    yarn start
    ```

    This will typically start the React development server on `http://localhost:3000`. The browser should automatically open the application.

3.  **Backend Setup:**
    Navigate to the root directory of the project and then to the `backend` directory:

    ```bash
    cd ../backend
    ```

    Initialize a new Node.js project and install the necessary dependencies. For a basic setup, you might need `express` for the server, `mysql2` to connect to the database, `cors` for handling cross-origin requests, and `dotenv` to manage environment variables.

    Using npm:

    ```bash
    npm init -y
    npm install express mysql2 cors dotenv
    ```

    Or using yarn:

    ```bash
    yarn init -y
    yarn add express mysql2 cors dotenv
    ```

4.  **Backend Configuration:**
    In the `backend` directory, create a file named `.env`. This file will store your environment-specific configurations, such as database credentials and the server port. Add the following information to your `.env` file, replacing the placeholders with your actual database details:

    ```env
    PORT=5000
    DB_HOST=your_database_host  # e.g., localhost
    DB_USER=your_database_user  # e.g., root
    DB_PASSWORD=your_database_password # Your database password
    DB_NAME=feed_formulation_db # The name of your existing database
    ```

    *(Ensure you have the correct database host, user, password, and database name matching your MariaDB setup).*

5.  **Create a Backend Entry Point:**
    Create a file named `server.js` (or `index.js`) in the `backend` directory. This file will be the main entry point for your backend application. Here's a basic example to get you started:

    ```javascript
    const express = require('express');
    const cors = require('cors');
    const mysql = require('mysql2');
    require('dotenv').config();

    const app = express();
    const port = process.env.PORT || 5000;

    app.use(cors());
    app.use(express.json());

    // Database connection pool
    const pool = mysql.createPool({
      host: process.env.DB_HOST,
      user: process.env.DB_USER,
      password: process.env.DB_PASSWORD,
      database: process.env.DB_NAME,
      waitForConnections: true,
      connectionLimit: 10,
      queueLimit: 0
    });

    // Test database connection
    pool.getConnection((err, connection) => {
      if (err) {
        console.error('Error connecting to the database:', err);
        return;
      }
      console.log('Successfully connected to the database!');
      connection.release();
    });

    app.get('/api', (req, res) => {
      res.send('Backend API is running!');
    });

    app.listen(port, () => {
      console.log(`Server is running on port: ${port}`);
    });
    ```

6.  **Start the Backend Server:**
    Add a script to your `backend/package.json` file to easily start the server. In the `"scripts"` section, add:

    ```json
    "start": "node server.js",
    "dev": "nodemon server.js"
    ```

    *(Note: You might need to install `nodemon` globally or as a dev dependency (`npm install -D nodemon`) for the `dev` script to work. `nodemon` automatically restarts the server when you make changes, which is helpful during development.)*

    Now, you can start the backend server using npm:

    ```bash
    npm run start
    ```

    Or for development with automatic restarts:

    ```bash
    npm run dev
    ```

    The backend server should now be running on the port specified in your `.env` file (default is 5000). You should see a "Server is running" message in your terminal.

## Project Structure

Here's a suggested basic structure for your project directories:

```
feed-formulation-portal-react-node/
├── frontend/
│   ├── public/
│   ├── src/
│   │   ├── components/
│   │   ├── pages/
│   │   ├── App.js
│   │   └── ...
│   ├── package.json
│   └── ...
├── backend/
│   ├── routes/
│   ├── controllers/
│   ├── models/
│   ├── server.js
│   ├── package.json
│   ├── .env
│   └── ...
├── README.md
└── .gitignore
```

## Contribution Guidelines

To ensure a collaborative and organized development process, please follow these guidelines:

1.  **Branching:** For each new feature, bug fix, or improvement, create a new branch from the `main` branch. Use a descriptive name for your branch (e.g., `feature/ingredient-page`, `fix/login-issue`).

2.  **Pull Requests:** Once your work is complete and thoroughly tested, submit a pull request (PR) to the `main` branch.

3.  **Code Review:** Every pull request must be reviewed and approved by at least one other team member before it can be merged into the `main` branch. This ensures code quality and helps in knowledge sharing across the team. Provide constructive feedback during code reviews.

4.  **Coding Standards:** Maintain consistent coding styles and follow best practices for both ReactJS and NodeJS development.

5.  **Commit Messages:** Write clear and concise commit messages that explain the purpose of your changes.

## Next Steps

With the initial setup complete, you can now start building the core features of the application:

* **Frontend (ReactJS):** Focus on creating the user interface, components for displaying data, forms for adding and editing ingredients and feeds, and making API calls to the backend.
* **Backend (NodeJS):** Develop the API endpoints to handle requests from the frontend, interact with the MariaDB database to fetch and manipulate data for ingredients and feeds, and implement user authentication and authorization.

Remember to communicate effectively with your team and follow the contribution guidelines for a smooth development process.

## Contact

For any issues or questions regarding the setup, please reach out to the project administrators or refer to the team's communication channels.
```
