package miniHibernate;

import java.sql.SQLException;
import java.util.List;

public class MiniHibernate {


    public static void createTable(String classPath) throws ClassNotFoundException, SQLException {

        String name = ReflactionOperations.getName(classPath);
        List<String> fields = ReflactionOperations.getFields(classPath);
        List<String> types =  ReflactionOperations.getTypes(classPath);

        Repository.createTable(name, fields, types);

    }

    public static void deleteBykey(String classPath, String column, String key) throws ClassNotFoundException {
        String name = ReflactionOperations.getName(classPath);
        Repository.deleteAt(name, column, key);
    }

     public static void findByKey(String classPath, String column, String key) throws ClassNotFoundException {
        Repository.findByKey(classPath, column, key);
    }

    public static void insertInto(String classPath, Object object) throws SQLException, ClassNotFoundException, IllegalAccessException {
        Repository.insert(classPath, object);
    }

    public static List<Dataset> getAll(String classPath){
        List<Dataset> data = Repository.getAll(classPath);
        return data;
    }

}
