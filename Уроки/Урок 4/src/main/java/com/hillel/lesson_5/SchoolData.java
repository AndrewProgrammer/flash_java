package com.hillel.lesson_5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SchoolData {

    private Connection connection;

    public SchoolData() throws SQLException, IOException {
        /*InputStream inputStream = getClass().getResourceAsStream("/db.properties");
        Properties properties = new Properties();
        properties.load(inputStream);*/

    /*
    connection = DriverManager
        .getConnection(properties.getProperty("url"),
            properties.getProperty("username"),
            properties.getProperty("password"));
            */

        /*MysqlConnectionPoolDataSource cp = new MysqlConnectionPoolDataSource();
        cp.setServerName("localhost");
        cp.setPortNumber(3306);
        cp.setUser("root");
        cp.setPassword("root");
        cp.setDatabaseName("students");

        PooledConnection pooledConnection = cp.getPooledConnection();

        connection = pooledConnection.getConnection();

        System.out.println("Connected");*/

        connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/university?useTimezone=true&serverTimezone=UTC",
            "root",
            "root");
        System.out.println("Connection successful");

    }

    public void printStudents() throws SQLException {
        String sql = "select * from students";

        Statement statement = connection.createStatement();
        ResultSet students = statement.executeQuery(sql);

        while (students.next()) {
            String first_name = students.getString("first_name");
            String last_name = students.getString("last_name");
            int age = students.getInt("age");
            System.out.println(first_name + " " + last_name + " " + age);
        }
    }

    public void addStudent() throws SQLException {
        String sql = "insert into students(first_name, last_name, age) values(?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "Ivan");
        preparedStatement.setString(2, "Ivanov");
        preparedStatement.setInt(3, 16);

        preparedStatement.execute();
    }

    public void transactionExample() throws SQLException {

        String sql1 = "insert into students(first_name, last_name, email) values('John', 'Wick', 17)";
        String sql2 = "insert into students(first_name, last_name, email) values('Sam', 'Johnson', NULL)";

        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();

        try {
            statement.executeUpdate(sql1);
            statement.executeUpdate(sql2);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        }

        connection.setAutoCommit(true);
    }

   /* public void batchExample() throws SQLException {
        String sql = "insert into students(first_name, last_name, age) values(?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //connection.setAutoCommit(false);

        for (int i = 0; i < 10; i++) {
            preparedStatement.setString(1, "Ivan");
            preparedStatement.setString(2, "Ivanov");
            preparedStatement.setInt(3, 16);
            if (i != 5) {
                preparedStatement.setNull(3, Types.NUMERIC);
            }
            preparedStatement.addBatch();
        }

        preparedStatement.executeBatch();

        //connection.setAutoCommit(true);
    }*/

    public void addInfoAboutStudent() throws SQLException, FileNotFoundException {
        String sql = "update students set content = ? where content = 4";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        File file = new File("items/text.txt");
        FileReader fileReader = new FileReader(file);

        preparedStatement.setCharacterStream(1, fileReader);

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    public void readInfoAboutStudent() throws SQLException, IOException {
        String sql = "select content from students where content = 4";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            Clob info = resultSet.getClob("content");
            Reader reader = info.getCharacterStream();
            BufferedReader bufferedReader = new BufferedReader(reader);

            //bufferedReader.lines().forEach(System.out::println);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }

        resultSet.close();
        statement.close();
    }

    public void savePhoto() throws SQLException, FileNotFoundException {
        String sql = "update students set image = ? where image = 5";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        File file = new File("items/monster.jpg");
        FileInputStream fileInputStream = new FileInputStream(file);

        preparedStatement.setBinaryStream(1, fileInputStream);

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    public void retrievePhotoInBase64() throws SQLException, IOException {
        String sql = "select image from students where image = 5";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            Blob blob = resultSet.getBlob("image");
            FileOutputStream fileOutputStream = new FileOutputStream("items/monster_copy.jpg");
            fileOutputStream.write(blob.getBytes(1, (int)blob.length()));

            fileOutputStream.flush();
            fileOutputStream.close();
        }

        resultSet.close();
        statement.close();
    }
}
