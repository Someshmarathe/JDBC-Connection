import java.sql.SQLException;

public interface ServiceLayerRepository {

      String insertData(Student stdObject);
      Student fetchDataById(Student getObject) throws SQLException, ClassNotFoundException;
      Student updateDataById(int id);
     int deleteDataById(int id);

}
