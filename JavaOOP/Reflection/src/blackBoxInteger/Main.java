package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;

        BlackBoxInt instance = null;
        try {
            Constructor<BlackBoxInt> ctor = clazz.getDeclaredConstructor();
            ctor.setAccessible(true);
            instance = ctor.newInstance();

        } catch (NoSuchMethodException
                | InstantiationException
                | IllegalAccessException
                | InvocationTargetException ignored) {
        }

        String input = scan.nextLine();
        while (!"END".equals(input)) {
            String command = input.split("_")[0];
            int value = Integer.parseInt(input.split("_")[1]);

            try {
                Method method = clazz.getDeclaredMethod(command, int.class);
                method.setAccessible(true);
                method.invoke(instance, value);

                Field innerValue = clazz.getDeclaredField("innerValue");
                innerValue.setAccessible(true);
                System.out.println(innerValue.get(instance));

            } catch (NoSuchMethodException
                    | IllegalAccessException
                    | InvocationTargetException
                    | NoSuchFieldException ignored) {
            }

            input = scan.nextLine();
        }
    }
}
