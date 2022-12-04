package miniHibernate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MiniHibernate {


    public static void createTable(String classPath) throws ClassNotFoundException, SQLException {

        String name = ReflactionOperations.getName(classPath);
        List<String> fields = ReflactionOperations.getFields(classPath);
        List<String> types =  ReflactionOperations.getTypes(classPath);

        DataBaseOperations.createTable(name, fields, types);

    }

    public static Object getAll(String databaseName) throws SQLException {
        List<Object> data = DataBaseOperations.getAll(databaseName);
        System.out.println(data);
        return data;
    }



}
