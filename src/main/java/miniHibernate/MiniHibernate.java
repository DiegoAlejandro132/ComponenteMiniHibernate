package miniHibernate;

import java.sql.SQLException;
import java.util.List;

public class MiniHibernate {


    public static void createTable(String classPath) throws ClassNotFoundException, SQLException {

        String name = ReflactionOperations.getName(classPath);
        List<String> fields = ReflactionOperations.getFields(classPath);
        List<String> types =  ReflactionOperations.getTypes(classPath);

        DataBaseOperations.createTable(name, fields, types);

    }

//    public static List<Dataset> getAll(String databaseName) throws SQLException {
//        List<Dataset> data = DataBaseOperations.getAll(databaseName);
//        return data;
//    }
}
