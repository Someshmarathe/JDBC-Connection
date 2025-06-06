import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

interface Operations{
     public void operation();
     public Scanner sc = new Scanner(System.in);
     public ServiceLayerImplmentation ServiceLayerObject = new ServiceLayerImplmentation();
}

class Input{
       public static String name , password;
       public static int  age;

       public  static String setName(){
           System.out.println("Enter Your Name :");
           name = Operations.sc.next();
           return name;
       }
        public static String setPassword(){
            System.out.println("Enter Your Password :");
            password = Operations.sc.next();
            return password;
        }
        public  static int setAge(){
            System.out.println("Enter Your Age :");
            age = Operations.sc.nextInt();
            return age;
        }
}
class InsertionOperation implements  Operations
{

    @Override
    public void operation() {
          Student studentObject = new Student(Input.setName() , Input.setPassword() , Input.setAge());
          String result  = Operations.ServiceLayerObject.insertData(studentObject);
          System.out.println(result);
    }
}
class UpdationOperation implements  Operations
{
    @Override
    public void operation() {

    }
}
class DeletionOperation implements  Operations
{
    @Override
    public void operation() {
        Student studentObject = new Student(Input.setName(),Input.setPassword());
        String result  = null;
        result = Operations.ServiceLayerObject.deleteDataByNamePassword(studentObject);
        System.out.println(result);
    }
}
class FetchOperation implements  Operations
{
    @Override
    public void operation() {
        Student studentObject = new Student(Input.setName(),Input.setPassword());
        Student result  = null;
        try {
            result = Operations.ServiceLayerObject.fetchDataByNamePassword(studentObject);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result.toString());
    }
}

class FactoryClass{
    public static void performOperation(Operations doTask){
        doTask.operation();
    }
}

public class Main {
    public static void main(String[] args) {

        String[] operationArray = {"InsertionOperation" , "UpdationOperation" , "DeletionOperation" , "FactOperation"};
        System.out.println("Type Of Operations");

        for(int i=0;i<operationArray.length;i++){
            System.out.println(i+1+" "+operationArray[i]+" !");
        }
        String getInput = Operations.sc.next();
        switch (getInput){
            case "InsertionOperation" : FactoryClass.performOperation(new InsertionOperation());
            break;
            case "UpdationOperation" : FactoryClass.performOperation(new UpdationOperation());
                break;
            case "DeletionOperation" : FactoryClass.performOperation(new DeletionOperation());
                break;
            case "FactOperation" : FactoryClass.performOperation(new FetchOperation());
                break;
        }
    }
}
