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
    DB_HOST=your_database_host
    DB_USER=your_database_user
    DB_PASSWORD=your_database_password
    DB_NAME=feed_formulation_db
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
    Ensure that the database credentials in your `backend/.env` file match your MariaDB database setup. The database name should be `feed_formulation_db`, and the tables (`ingredient`, `feeds`, `feedingredient`) should already exist.

## Next Steps

Once you have completed these steps, you should have both the frontend and backend development servers running on your local machine. You can then start working on the different features of the Feed Formulation Portal.

## Contribution Guidelines

To contribute to this project, please follow these guidelines:

1.  Create a new branch for your work.
2.  Make your changes and commit them with clear messages.
3.  Submit a pull request to the `main` branch for review.

## User Management

We will be building a custom user management dashboard for this project. More details on its setup and usage will be provided as it is developed.

## Contact

For any setup issues or questions, please reach out to the project team.
