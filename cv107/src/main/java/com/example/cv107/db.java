package com.example.cv107;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class db {
    private static db instance;
    private static final String DB_URL = "jdbc:sqlite:mycv.db";
    private Connection connection;

    private db() {
        try {
            connection = DriverManager.getConnection(DB_URL);
            initializeDatabase();
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }

    public static db getInstance() {
        if (instance == null) {
            instance = new db();
        }
        return instance;
    }

    private void initializeDatabase() {
        String createTableSQL = """
            CREATE TABLE IF NOT EXISTS cvs (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                fullName TEXT NOT NULL,
                email TEXT NOT NULL,
                phone TEXT NOT NULL,
                address TEXT,
                education TEXT,
                skills TEXT,
                workExperience TEXT,
                projects TEXT,
                photoPath TEXT,
                createdAt TEXT NOT NULL,
                updatedAt TEXT NOT NULL
            )
            """;

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSQL);
        } catch (SQLException e) {
            System.err.println("Error initializing database: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL);
            }
        } catch (SQLException e) {
            System.err.println("Error getting connection: " + e.getMessage());
        }
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Error closing connection: " + e.getMessage());
        }
    }
}