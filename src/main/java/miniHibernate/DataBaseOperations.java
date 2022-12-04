package miniHibernate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseOperations {

//    public static void createDatabase(String databaseName) throws SQLException {
//        Connection connection = new ConexaoBanco().conection();
//        PreparedStatement stmt = null;
//
//        try{
//            stmt = connection.prepareStatement("CREATE DATABASE IF NOT EXISTS ?");
//            stmt.setString(1, databaseName);
//            stmt.execute();
//            stmt.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static void createTable(String tableName, List<String> fields, List<String> types) throws SQLException {
        Connection connection = new ConexaoBanco().conection();

        List<String> newTypes = changeType(types);
        newTypes.set(0, "varchar(250)"); //gambiarra pra substituir string por varchar -> ver o q esta errado na função change type
        String datatypes = "";
        int index = 0;
        while (index < fields.size()){
            if(index == fields.size() - 1){
                datatypes += fields.get(index) + " " + newTypes.get(index);
            }else{
                datatypes += fields.get(index) + " " + newTypes.get(index) + ", ";
            }
            index ++;
        }
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + "( " + datatypes + ");";

        try {
            connection.createStatement().executeUpdate(sql);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }

    public static void insert(String tableName, Object object){
        Connection connection = new ConexaoBanco().conection();
        PreparedStatement stmt = null;

    }

    public static List<Object> getAll(String tableName){
        Connection connection = new ConexaoBanco().conection();
        try{
            String sql = "SELECT * FROM " + tableName;
            ResultSet rs = connection.createStatement().executeQuery(sql);
            List<Object> rsList = new ArrayList<>();
            int index = 0;
            while(rs.next()){
                rsList.set(index, rs.getObject(index));
                index++;
            }
            connection.close();
            return rsList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteAt(String tableName, String column, String index){
        Connection connection = new ConexaoBanco().conection();
        PreparedStatement stmt = null;

        try{
            stmt = connection.prepareStatement("DELETE FROM ? WHERE ? = ?");
            stmt.setString(1, tableName);
            stmt.setString(2, column);
            stmt.setString(3, index);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private static List<String> changeType(List<String> types){
        List<String> newTypes = new ArrayList<>();
        for(String type : types){
            if (type == "String"){
                String string = "varchar(255)";
                newTypes.add(string);
                System.out.println("entrou");
            }else{
                newTypes.add(type);
            }
            System.out.println(type);
        }
        return newTypes;
    }

}
