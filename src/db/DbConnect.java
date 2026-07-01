package db;
import java.sql.*;

public class DbConnect {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String dbName = "students";
    private String username = "root";
    private String password = "123456";

    public Connection getDbConnect() throws SQLException, ClassNotFoundException {
        String url1 = "jdbc:mysql://localhost:3306/" + dbName;
        String url2 = "?user="+username+"&password="+password;
        String url3 = "&useUnicode=true&characterEncoding=utf-8";
        String url = url1 + url2 + url3;
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            return conn;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void closeDB(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
        if(conn != null){
            conn.close();
        }
        if(ps != null){
            ps.close();
        }
        if(rs != null){
            rs.close();
        }
    }

}
