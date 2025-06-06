import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CrudOperations {

    public String Operations() throws ClassNotFoundException, SQLException {

        Connection con = SinglTonClassForJdbc.getConnection();
        PreparedStatement statementObj = con.prepareStatement("insert into employe values (?,?,?,?)");
        statementObj.setInt(1, 3);
        statementObj.setString(2, "Kapil");
        statementObj.setString(3, "@Kapil20");
        statementObj.setInt(4, 21);

        int i = statementObj.executeUpdate();
        if (i > 0) {
            System.out.println("Done");
        } else {
            System.out.println("not Done");
        }
        return "";
    }
}