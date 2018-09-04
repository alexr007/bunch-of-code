package annot;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class PersonTest {
    public static void main(String[] args) {
        for (Field f : Person.class.getDeclaredFields()) {
            Class type = f.getType(); // int
            String name = f.getName(); // id
            Annotation[] annotations = f.getDeclaredAnnotations();
            System.out.println("field:"+f);
            System.out.println("type:"+type);
            System.out.println("name:"+name);
            for (Annotation a : annotations) {
                Class<? extends Annotation> c = a.annotationType();
                System.out.println("c.getSimpleName():"+c.getSimpleName());
                Field[] declaredFields = c.getDeclaredFields();
                System.out.println("DF:"+declaredFields);
                System.out.println(" a:"+a);
            }
            if (f.isAnnotationPresent(Fi.class)) {
                Fi ta = f.getAnnotation(Fi.class);
                System.out.println("_key value:"+ta.key());
            }
        }
    }
}
