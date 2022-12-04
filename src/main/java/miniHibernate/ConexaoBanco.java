package miniHibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    public Connection conection(){
        Connection con = null;
        try{
            String url = "jdbc:mysql://localhost:3306/meu_banco?user=root&password=root";
            con = DriverManager.getConnection(url);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return con;
    }

}
