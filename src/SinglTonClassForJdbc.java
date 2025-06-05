import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SinglTonClassForJdbc {
    private static volatile  Connection con = null;


    private SinglTonClassForJdbc(){
        throw new UnsupportedOperationException("Cannot Call Constructor");
    }

    public static  void LoadClass() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    public static Connection getConnection() throws SQLException {
        if(con == null){
            synchronized (SinglTonClassForJdbc.class){
                if(con == null){
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employe","root" , "@Somesh17");
                }
            }
        }
        return  con;
    }
}
