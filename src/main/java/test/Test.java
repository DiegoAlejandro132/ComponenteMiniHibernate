package test;

import miniHibernate.DataBaseOperations;
import miniHibernate.Dataset;
import model.Pessoa;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//        Object objeto = new Object(){String nome ="murad";};
//        System.out.println(objeto);
//        //MiniHibernate.createTable("model.Pessoa");
//        List<Dataset> getall = MiniHibernate.getAll("Pessoa");
//        System.out.println(getall.get(2).getField());
////        for(Object obj : getall){
////            System.out.println(obj);
////        }
//        Pessoa p = getObject(getall);
//        System.out.println(p.getNome());
//        System.out.println(p.getIdade());
//        Classe classe = new Classe();
//        Pessoa a = classe.get(1, Pessoa.class);

//        Pessoa pessoa = new Pessoa("Diego", 123);
//        DataBaseOperations.insert("model.Pessoa", pessoa);

//        MiniHibernate.createTable("model.Animal");
//        Animal animal = new Animal("verde", "diego", "cachorro");
//        DataBaseOperations.insert("model.Animal", animal);

        //List<Dataset> gays = DataBaseOperations.getAll("model.Animal");

        DataBaseOperations.deleteAt("Pessoa", "nome", "diego");


    }
    public static <T> T getObject(List<Dataset> lista) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class classee = Class.forName(Pessoa.class.getName());
        Object obj = classee.newInstance();
        Field[] fields = classee.getDeclaredFields();
        for(Field field : fields){
            //System.out.println(field.getName());
            for(Dataset dataset : lista){
                if(dataset.getField().equals(field.getName())){
                    field.setAccessible(true);
                    if(field.getType().getSimpleName().toLowerCase().equals("int")){
                        field.set(obj, Integer.parseInt(dataset.getValue()));
                    }else{
                        field.set(obj, dataset.getValue());
                    }
                }
            }
        }
        return (T) obj;

    }
}
