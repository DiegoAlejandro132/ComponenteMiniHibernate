package test;

import miniHibernate.MiniHibernate;
import miniHibernate.ReflactionOperations;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //MiniHibernate.createTable("model.Pessoa");
        ResultSet getall = (ResultSet) MiniHibernate.getAll("Pessoa");
        System.out.println(getall);
    }
}
