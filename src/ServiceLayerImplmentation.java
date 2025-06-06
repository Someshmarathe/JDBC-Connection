import java.sql.SQLException;

public class ServiceLayerImplmentation implements ServiceLayerRepository
{

    @Override
    public  Student fetchDataByNamePassword(Student getObject) throws SQLException, ClassNotFoundException {
        return  new CrudOperations().fetchJDBCOperation(getObject);
    }

    @Override
    public String insertData(Student stdObject) {
        try{
            return new CrudOperations().insertJDBCOperation(stdObject);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return "Not Inserted";
    }

    @Override
    public Student updateDataById(int id) {
        return null;
    }

    @Override
    public String deleteDataByNamePassword(Student delObject){
        try{
            return new CrudOperations().deleteJDBCOperation(delObject);
        }
        catch (Exception e){
            return "Not Delete";
        }
    }
}
