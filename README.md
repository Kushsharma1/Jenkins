# Feed Formulation Portal (React & Node.js)

## Getting Started

This guide will walk you through the steps to set up the Feed Formulation Portal on your local machine for development.

### Prerequisites

Before you begin, make sure you have the following software installed:

1.  **Node.js:** (Version 18 or higher recommended) - [https://nodejs.org/](https://nodejs.org/)
2.  **npm** (comes with Node.js) or **yarn:** [https://yarnpkg.com/](https://yarnpkg.com/)
3.  **MySQL Client:** (e.g., MySQL Workbench, DBeaver)

### Installation

Follow these steps to get the project running:

1.  **Clone the Repository:**
    Open your terminal or command prompt and navigate to your desired project directory. Then, clone the repository:

    ```bash
    git clone <your_repository_url>
    cd <your_repository_name>
    ```

    *(Replace `<your_repository_url>` with your repository's URL and `<your_repository_name>` with the directory name).*

2.  **Frontend Setup:**
    a. Navigate to the `frontend` directory:
    ```bash
    cd frontend
    ```
    b. Install the frontend dependencies using npm:
    ```bash
    npm install
    ```
    Or, if you use yarn:
    ```bash
    yarn install
    ```
    c. Start the frontend development server:
    ```bash
    npm start
    ```
    Or with yarn:
    ```bash
    yarn start
    ```
    The frontend should now be running at `http://localhost:3000`.

3.  **Backend Setup:**
    a. Navigate back to the root directory and then to the `backend` directory:
    ```bash
    cd ../backend
    ```
    b. Initialize a new Node.js project and install the necessary dependencies (e.g., `express`, `mysql2`, `cors`, `dotenv`):
    Using npm:
    ```bash
    npm init -y
    npm install express mysql2 cors dotenv
    ```
    Using yarn:
    ```bash
    yarn init -y
    yarn add express mysql2 cors dotenv
    ```
    c. Create a `.env` file in the `backend` directory with your database credentials and server port:
    ```env
    PORT=5000
    DB_HOST=your_database_host   # e.g., localhost
    DB_USER=your_database_user   # e.g., root
    DB_PASSWORD=your_database_password  # Your database password
    DB_NAME=feed_formulation_db  # The name of your database
    ```
    *(Replace the placeholders with your actual database details).*
    d. Create a backend entry point file (e.g., `server.js` or `index.js`) with the basic server setup and database connection (as shown in the previous detailed README).
    e. Add a `start` script to your `backend/package.json` file:
    ```json
    "scripts": {
      "start": "node server.js",
      "dev": "nodemon server.js"
    }
    ```
    *(You may need to install `nodemon` as a dev dependency: `npm install -D nodemon` or `yarn add -D nodemon`).*
    f. Start the backend server:
    Using npm:
    ```bash
    npm run start
    ```
    Or for development with automatic restarts:
    ```bash
    npm run dev
    ```
    The backend should now be running on the port specified in your `.env` file (e.g., `http://localhost:5000`).

4.  **Database Configuration:**
    a. **Database Name:** Ensure your MariaDB database is named `feed_formulation_db`.
    b. **Import Database Schema and Data:** You will need to import the database structure and initial data. This is typically done using an SQL file. In your previous project, this file was named `db.sql` and was located in a `database/sql` folder. Please locate this `db.sql` file (or ensure it is present in your new repository, potentially in a `database/sql` directory).
    c. **Import using phpMyAdmin:** If you have phpMyAdmin installed (as part of XAMPP, for example), you can import the `db.sql` file by navigating to `http://localhost/phpmyadmin`, selecting the `feed_formulation_db` database, and then going to the "Import" tab.
    d. **Import using MySQL command line:** Alternatively, you can use the MySQL command-line client. Open your terminal and run the following command, replacing the placeholders with your actual database credentials and the path to the `db.sql` file:
    ```bash
    mysql -h your_database_host -u your_database_user -p feed_formulation_db < path/to/db.sql
    ```
    You will be prompted to enter your database password.
    e. **`.env` File:** As mentioned in the Backend Setup (step 3c), ensure you have a `.env` file in your `backend` directory with the correct database connection details. This is how your NodeJS backend will connect to the MariaDB database.

## Next Steps

Once you have completed these steps, you should have both the frontend and backend development servers running on your local machine, and your database should be configured. You can then start working on the different features of the Feed Formulation Portal.

## Contribution Guidelines

To contribute to this project, please follow these guidelines:

1.  Create a new branch for your work.
2.  Make your changes and commit them with clear messages.
3.  Submit a pull request to the `main` branch for review.

## User Management

We will be building a custom user management dashboard for this project. More details on its setup and usage will be provided as it is developed.

## Contact

For any setup issues or questions, please reach out to the project team.
