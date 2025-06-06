import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CrudOperations {

    public String insertJDBCOperation(Student obj) throws ClassNotFoundException, SQLException {
        Connection con = SinglTonClassForJdbc.getConnection();
        PreparedStatement statementObj = con.prepareStatement("insert into employe values (?,?,?,?)");
        statementObj.setInt(1, obj.getId());
        statementObj.setString(2, obj.getName());
        statementObj.setString(3, obj.getPassword());
        statementObj.setInt(4, obj.getAge());
        int i = statementObj.executeUpdate();
        if (i > 0) {
            return "Done";
        } else {
             return "Not Insert";
        }
    }

    public Student fetchJDBCOperation(Student obj) throws ClassNotFoundException, SQLException {
        Connection con = SinglTonClassForJdbc.getConnection();
        PreparedStatement statementObj = con.prepareStatement("Select * from employe where name= ? and password = ?");
        statementObj.setString(1 , obj.getName());
        statementObj.setString(2 , obj.getPassword());
        Student std = null;
        ResultSet rs  = statementObj.executeQuery();
        if (rs.next()) {
              return new Student(rs.getInt("id"),rs.getString("name"),rs.getString("password") , rs.getInt("age"));
        } else {
               return null;
        }

    }

    public String deleteJDBCOperation(Student obj) throws ClassNotFoundException, SQLException {
        Connection con = SinglTonClassForJdbc.getConnection();
        PreparedStatement statementObj = con.prepareStatement("delete from employe where name = ? and password = ?");
        statementObj.setString(1 , obj.getName());
        statementObj.setString(2 , obj.getPassword());

        int i = statementObj.executeUpdate();
        if (i>0) {
            return "Delete Your Record";
        } else {
            return "Not Record Deleted";
        }

    }


}