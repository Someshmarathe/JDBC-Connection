import java.sql.SQLException;

public interface ServiceLayerRepository {

      String insertData(Student stdObject);
      Student fetchDataByNamePassword(Student getObject) throws SQLException, ClassNotFoundException;
      Student updateDataById(int id);
      String deleteDataByNamePassword(Student delObject) throws SQLException, ClassNotFoundException;

}
