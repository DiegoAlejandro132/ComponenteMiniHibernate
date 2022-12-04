package miniHibernate;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ReflactionOperations {

    public static List<String> getFields(String classPath) throws ClassNotFoundException {
        Class classe = Class.forName(classPath);

        Field[] fields = classe.getDeclaredFields();
        List<String> fieldsName = new ArrayList<>();

        for(Field field : fields){
            fieldsName.add(field.getName());
        }
        return fieldsName;
    }

    public static String getName(String classPath) throws ClassNotFoundException {
        Class classe = Class.forName(classPath);
        return classe.getSimpleName();
    }

    public static List<String> getTypes(String classPath) throws ClassNotFoundException {

        Class classe = Class.forName(classPath);
        Field[] fields = classe.getDeclaredFields();
        List<String> types = new ArrayList<>();
        for(Field field : fields){
            types.add(field.getType().getSimpleName());
        }
        return types;
    }

}
