package app.task_5.com.interfaces;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.PooledConnection;

public abstract class AbstractBookShopData {

    public abstract void printElements() throws SQLException;

    public abstract void addElement() throws SQLException;

    public abstract void transactionExample() throws SQLException;

}

    /*public void printBooks() throws SQLException {

        String sql = "select * from books";

        Statement statement = connection.createStatement();
        ResultSet books = statement.executeQuery(sql);
        while (books.next()) {
            String bookName = books.getString("book_name");
            String authorName = books.getString("author_name");
            String genre = books.getString("genre");
            String originalLanguage = books.getString("original_language");
            int quantity = books.getInt("quantity");
            int countOfSales = books.getInt("sales_count");
            String published = books.getString("first_published");
            Timestamp dateOfDelivering = books.getTimestamp("date_delivered");
            String content = books.getString("content");
            Blob image = books.getBlob("image");

            System.out.println(bookName + " " + authorName + " " + genre
                + " " + originalLanguage + " " + quantity + " " + countOfSales
                + " " + published + " " + dateOfDelivering + " " + content
                + " " + image);
        }
    }*/

    /*public void addBook() throws SQLException {
        String sql = "insert into books(book_name, author_name, genre, original_language, quantity , sales_count, first_published, date_delivered, content,image) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Calendar rightNow = Calendar.getInstance();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "Don Quixote");
        preparedStatement.setString(2, "Miguel de Cervantes");
        preparedStatement.setString(3, "novel");
        preparedStatement.setString(4, "Spanish");
        preparedStatement.setInt(5, 500);
        preparedStatement.setInt(6, 500);
        preparedStatement.setDate(7, String.valueOf(rightNow));
        preparedStatement.setTimestamp(8, Timestamp.valueOf("1605-02-22 04:14:09"));
        preparedStatement.setText(9, "CONTENT");
        preparedStatement.setBlob(10, );
        preparedStatement.setInt(11,AUTO_INCREMENT);
        preparedStatement.execute();
    }*/

    /*@Override
    public void printElements() {
        String sql = "select * from books";

        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet books = null;
        try {
            books = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (books.next()) {
                String bookName = books.getString("book_name");
                String authorName = books.getString("author_name");
                String genre = books.getString("genre");
                String originalLanguage = books.getString("original_language");
                int quantity = books.getInt("quantity");
                int countOfSales = books.getInt("sales_count");
                String published = books.getString("first_published");
                Timestamp dateOfDelivering = books.getTimestamp("date_delivered");
                String content = books.getString("content");
                Blob image = books.getBlob("image");

                System.out.println(bookName + " " + authorName + " " + genre
                    + " " + originalLanguage + " " + quantity + " " + countOfSales
                    + " " + published + " " + dateOfDelivering + " " + content
                    + " " + image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addElement() {
        String sql = "insert into books(book_name, author_name, genre, original_language, quantity , sales_count, first_published, date_delivered, content,image) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Calendar rightNow = Calendar.getInstance();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setString(1, "Don Quixote");
            preparedStatement.setString(2, "Miguel de Cervantes");
            preparedStatement.setString(3, "novel");
            preparedStatement.setString(4, "Spanish");
            preparedStatement.setInt(5, 500);
            preparedStatement.setInt(6, 500);
            preparedStatement.setDate(7, String.valueOf(rightNow));
            preparedStatement.setTimestamp(8, Timestamp.valueOf("1605-02-22 04:14:09"));
            preparedStatement.setText(9, "CONTENT");
            preparedStatement.setBlob(10, );
            preparedStatement.setInt(11, AUTO_INCREMENT);
            preparedStatement.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void transactionExample()  {
        FileReader fileReader2 = null;
        try {
            fileReader2 = new FileReader(file2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileReader fileReader3 = null;
        try {
            fileReader3 = new FileReader(file3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String sql1 = "insert into books(book_name, author_name, genre, original_language, quantity , sales_count, first_published, date_delivered) values(('A Tale of Two Cities', 'Charles Dickens', 'historical fiction', 'English', 500, 500, '22-02-1861', '1859-02-22 04:14:09')";
        String sql2 = "insert into books(book_name, author_name, genre, original_language, quantity , sales_count, first_published, date_delivered) values('The Lord of the Rings', 'J. R. R. Tolkien', 'fantasy', 'English', 500, 500, '22-05-1947', '1947-02-22 04:14:09',)";

        try {
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
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void batchExample() {
        String sql = "insert into books(book_name, author_name, genre, original_language, quantity , sales_count, first_published, date_delivered) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //connection.setAutoCommit(false);
        try {
            for (int i = 0; i < 10; i++) {
                Calendar rightNow = Calendar.getInstance();
                preparedStatement.setString(1, "Don Quixote");
                preparedStatement.setString(2, "Miguel de Cervantes");
                preparedStatement.setString(3, "novel");
                preparedStatement.setString(4, "Spanish");
                preparedStatement.setInt(5, 500);
                preparedStatement.setInt(6, 500);
                preparedStatement.setDate(7, String.valueOf(rightNow));
                preparedStatement.setTimestamp(8, Timestamp.valueOf("1605-02-22 04:14:09"));
                preparedStatement.setText(9, "CONTENT");
                preparedStatement.setBlob(10, );
                preparedStatement.setInt(11, AUTO_INCREMENT);

                if (i != 5) {
                    preparedStatement.setNull(4, Types.NUMERIC);
                }
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
        }catch (SQLException e) {
            e.printStackTrace();
        }

        //connection.setAutoCommit(true);
    }*/

   /* public void addInfoAboutBook() throws SQLException, FileNotFoundException {
        String sql = "update books set info = ? where id = 10";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        File currentfile = new File(String.valueOf(content));
        FileReader fileReader = new FileReader(currentfile);

        preparedStatement.setCharacterStream(10, fileReader);

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }
    public void readInfoAboutBook() throws SQLException, IOException {
        String sql = "select info from books where id = 10";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            Clob content = resultSet.getClob("content");
            Reader reader = content.getCharacterStream();
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
        String sql = "update books set photo = ? where id = 11";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        File currentphoto = new File(String.valueOf(file));
        FileInputStream fileInputStream = new FileInputStream(currentphoto);

        preparedStatement.setBinaryStream(11, fileInputStream);

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }
    public void retrievePhoto() throws SQLException, IOException {
        String sql = "select photo from students where id = 11";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            Blob blob = resultSet.getBlob("image");
            byte[] bytes = Base64.getEncoder().encode(blob.getBytes(10, (int) blob.length()));
            String encodedBytes = new String(bytes);
            System.out.println(encodedBytes);
        }

        resultSet.close();
        statement.close();
    }
    public void retrievePhotoInBase64() throws SQLException, IOException {
        String sql = "select photo from students where id = 11";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            Blob blob = resultSet.getBlob("image");
            FileOutputStream fileOutputStream = new FileOutputStream(fileCopy);
            fileOutputStream.write(blob.getBytes(11, (int)blob.length()));

            fileOutputStream.flush();
            fileOutputStream.close();
        }

        resultSet.close();
        statement.close();
    }*/
