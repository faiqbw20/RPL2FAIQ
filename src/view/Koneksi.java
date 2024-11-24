package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    public static Connection getConnection() throws SQLException{
        Connection connection = null;
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/db_rpl2";
        String user="root";
        String password="";
        if(connection == null){
            try{
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            }catch(ClassNotFoundException | SQLException error){
                System.exit(0);
            }
        }
        return connection;
    }
}
