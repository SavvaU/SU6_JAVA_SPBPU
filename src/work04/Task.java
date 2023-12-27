package work04;


import java.lang.reflect.Field;

public class Task {
    static void swap(Object first, Object second) throws IllegalAccessException {
        Field[] class1DeclaredFields = first.getClass().getDeclaredFields();
        Field[] class2DeclaredFields = second.getClass().getDeclaredFields();

        for (Field field1 : class1DeclaredFields) {
            Object temp = field1.get(first);
            for (Field field2 : class2DeclaredFields) {
                if (field1.equals(field2) && field1.getType() == field2.getType()) {
                    field1.set(first, field2.get(second));
                    field2.set(second, temp);
                    break;
                }
            }
        }
    }


    public static void main(String[] args) throws IllegalAccessException {
        class AnyClass {
            int arg;

            AnyClass(int newArg) {
                arg = newArg;
            }
        }
        AnyClass first = new AnyClass(1);
        System.out.println(first.arg); // 1
        AnyClass second = new AnyClass(2);
        System.out.println(second.arg); // 2
        swap(first, second);
        System.out.println(first.arg); // 2
        System.out.println(second.arg); // 1
    }
}
