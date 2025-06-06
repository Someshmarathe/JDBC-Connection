import java.sql.SQLException;

public class ServiceLayerImplmentation implements ServiceLayerRepository
{

    @Override
    public  Student fetchDataById(Student getObject) throws SQLException, ClassNotFoundException {
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
    public int deleteDataById(int id) {
        return 0;
    }
}
