package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        Method[] methods = address.getClass().getMethods();

        for (Method m : methods) {
            if (m.getAnnotation(Inspect.class) != null) {
                System.out.println("Method " + m.getName() +" returns a value of type " + m.getReturnType().getName());
            }
        }
        // END
    }
}
