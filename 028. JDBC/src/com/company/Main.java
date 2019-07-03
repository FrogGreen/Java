//Java DataBase Connectivity

package com.company;

import java.sql.*;

public class Main {

    public static final String DB_NAME = "JDBC.DB";
    public static final String WORKING_DIRECTORY = System.getProperty("user.dir");
    public static final String GET_CONNECTION = "jdbc:sqlite:" + WORKING_DIRECTORY + "\\database\\" + DB_NAME;

    public static final String TABLE_FIRST = "contactsFirstGroup";
    public static final String TABLE_SECOND = "contactsSecondGroup";

    public static final String NAME = "name";
    public static final String PHONE = "phone";
    public static final String ADDRESS = "address";

    private static String stringToInject = "Henry\" or 1=1 or \"";
    private static String stringToExecute = "Henry";
    private static String preparedStatementStringWrong = "select " + NAME + ", " + ADDRESS + ", " + PHONE + " from " + TABLE_FIRST + " where " + NAME + " =\"";
    private static String preparedStatementStringRight = "select " + NAME + ", " + ADDRESS + ", " + PHONE + " from " + TABLE_FIRST + " where " + NAME + " =?";
    private static PreparedStatement preparedStatement;
    private static Connection connection = null;

    public static void main(String[] args) {

        //Get working directory
        System.out.println("Your working directory is: " + WORKING_DIRECTORY);
        System.out.println();
        System.out.println();

        //Create database
        //First method
        System.out.println("First method:");
        System.out.println();

        //Create database
        System.out.println("Create database...");
        open();
        System.out.println("Database create finished successful");
        System.out.println();

        try {
            //Create table
            System.out.println("Create table...");
            Statement statement = connection.createStatement();
            statement.execute("create table if not exists " + TABLE_FIRST + " (" + NAME + " Text, " + PHONE + " Integer, " + ADDRESS + " Text)");
            System.out.println("Table " + TABLE_FIRST + " created successful");
            System.out.println();

            //Clear database
            System.out.println("Clear database...");
            statement.execute("delete from " + TABLE_FIRST);
            System.out.println("Clear " + TABLE_FIRST + " finished successful");
            System.out.println();

            //Add new rows
            System.out.println("Add new rows to database...");
            newContact(statement, TABLE_FIRST, "Henry", 567859, "Somewhere 75, Greenwich");
            newContact(statement, TABLE_FIRST, "Chris", 452123, "Anywhere 23, Greenwich");
            newContact(statement, TABLE_FIRST, "Tom", 531764, "Local 65, London");
            newContact(statement, TABLE_FIRST, "Mark", 851354, "There 321, Greenwich");
            newContact(statement, TABLE_FIRST, "John", 945621, "Here 487, Greenwich");
            newContact(statement, TABLE_FIRST, "Henry", 487523, "Capital 9, London");
            System.out.println("Add rows finished successful");
            System.out.println();

            //Update rows
            System.out.println("Update Henry phone...");
            statement.execute("update contactsFirstGroup set phone = 456343 where name = 'Henry'");
            System.out.println("Phone update finished successful");
            System.out.println();

            //Get all rows
            System.out.println("Get all record...");
            statement.execute("select * from " + TABLE_FIRST);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(NAME) + "| " + resultSet.getString(ADDRESS) + "| " + resultSet.getInt(PHONE));
            }
            resultSet.close();
            System.out.println("All record get finished successful");
            System.out.println();

            System.out.println("Or get all record like this...");
            ResultSet resultSets = statement.executeQuery("select * from " + TABLE_FIRST);
            while (resultSets.next()) {
                System.out.println(resultSets.getString(NAME) + "| " + resultSets.getString(ADDRESS) + "| " + resultSets.getInt(PHONE));
            }
            resultSets.close();
            System.out.println("All record get finished successful");
            System.out.println();

            //Get all row injection
            System.out.println("Get record injection...");
            StringBuilder stringBuilder = new StringBuilder(preparedStatementStringWrong);
            stringBuilder.append(stringToInject);
            stringBuilder.append("\"");
            statement.execute(stringBuilder.toString());
            ResultSet resultsSet = statement.getResultSet();
            while (resultSet.next()) {
                System.out.println(resultsSet.getString(NAME) + "| " + resultsSet.getString(ADDRESS) + "| " + resultsSet.getInt(PHONE));
            }
            resultsSet.close();
            System.out.println("This is results");
            System.out.println();

            System.out.println("Or get record injection like this...");
            preparedStatement = connection.prepareStatement(preparedStatementStringRight);
            preparedStatement.setString(1, stringToInject);
            ResultSet resultsSets = preparedStatement.executeQuery();
            if (resultsSets.next()) {
                while (resultsSets.next()) {
                    System.out.println(resultsSets.getString(NAME) + "| " + resultsSets.getString(ADDRESS) + "| " + resultsSets.getInt(PHONE));
                }
            } else {
                System.out.println("Couldn't find the " + NAME + " and " + PHONE + " for Henry");
            }
            System.out.println();

            System.out.println("Should be this...");
            preparedStatement = connection.prepareStatement(preparedStatementStringRight);
            preparedStatement.setString(1, stringToExecute);
            String string = null;
            resultsSets = preparedStatement.executeQuery();
            if (resultsSets.next()) {
                System.out.println(resultsSets.getString(NAME) + "| " + resultsSets.getString(ADDRESS) + "| " + resultsSets.getInt(PHONE));
                while (resultsSets.next()) {
                    System.out.println(resultsSets.getString(NAME) + "| " + resultsSets.getString(ADDRESS) + "| " + resultsSets.getInt(PHONE));
                }
            } else {
                System.out.println("Couldn't find the " + NAME + " and " + PHONE + " for Henry");
            }

            preparedStatement.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

        close();
        System.out.println();
        System.out.println();

        //Second method
        System.out.println("Second method:");
        System.out.println();
        try (Connection connection = DriverManager.getConnection(GET_CONNECTION);
             Statement statement = connection.createStatement()) {

            //Drop table
            System.out.println("Drop table...");
            statement.execute("drop table if exists " + TABLE_SECOND);
            System.out.println("Table " + TABLE_SECOND + "dropped successful");
            System.out.println();

            //Create table
            System.out.println("Create table...");
            statement.execute("create table if not exists " + TABLE_SECOND + " (" + NAME + " Text, " + PHONE + " Integer, " + ADDRESS + " Text)");
            System.out.println("Table " + TABLE_SECOND + " created successful");
            System.out.println();

            //Add new rows
            System.out.println("Add new rows to database...");
            newContact(statement, TABLE_SECOND, "Charlie", 705396, "Saint 23, Paris");
            newContact(statement, TABLE_SECOND, "Archie", 403912, "Sky 65, Berlin");
            newContact(statement, TABLE_SECOND, "Logan", 991891, "Blue 321, Moscow");
            newContact(statement, TABLE_SECOND, "Lucas", 766295, "Red 478, Rome");
            newContact(statement, TABLE_SECOND, "Harold", 393501, "Green 9, Madrid");
            newContact(statement, TABLE_SECOND, "Rober", 986363, "Yellow 73, London");
            System.out.println("Add rows finished successful");
            System.out.println();

            //Get column name
            System.out.println("Here are names of the column in " + TABLE_SECOND);
            ResultSet resultset = statement.executeQuery("select * from " + TABLE_SECOND);
            ResultSetMetaData resultSetMetaData = resultset.getMetaData();
            int columnNumber = resultSetMetaData.getColumnCount();
            for (int i = 1; i <= columnNumber; i++) {
                System.out.format("Column %d in the " + TABLE_SECOND + " table is named %s", i, resultSetMetaData.getColumnName(i));
                if (i <= columnNumber) {
                    System.out.println();
                }
            }
            System.out.println("Column names printed successful");
            System.out.println();
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void open() {
        try {
            connection = DriverManager.getConnection(GET_CONNECTION);
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    public static void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    public static void newContact(Statement statement, String table, String name, Integer phone, String address) {
        try {
            statement.execute("insert into " + table + " (" + NAME + ", " + PHONE + ", " + ADDRESS + ") values ('" + name + "', " + phone + ", '" + address + "')");
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
