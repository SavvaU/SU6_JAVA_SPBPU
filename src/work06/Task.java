package work06;

import java.lang.reflect.*;

public class Task {

    static void printClassInfo(Class LClass) {
        System.out.println(LClass.getName());
        Field[] fields = LClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field name: " + field.getName() + ", field type:" + field.getType());
        }
        Method[] dmethods = LClass.getDeclaredMethods();
        for (Method method : dmethods) {
            Parameter[] parameters = method.getParameters();
            System.out.println("Method name: " + method.getName() + ", return type: " + method.getReturnType());
            if (parameters.length != 0) {
                System.out.println("Parameters types:");
                for (Parameter parameter : parameters) {
                    System.out.println(parameter.getType());
                }
            } else {
                System.out.println("Not parameters for this method");
            }
        }
        System.out.println("Constructors:");
        Constructor[] dctors = LClass.getDeclaredConstructors();
        for (Constructor constructor : dctors) {
            System.out.println(constructor.getName());
            Parameter[] parameters = constructor.getParameters();
            if (parameters.length != 0) {
                System.out.println("Parameters types:");
                for (Parameter parameter : parameters) {
                    System.out.println(parameter.getType());
                }
            } else {
                System.out.println("Not parameters for this constructor");
            }
        }
    }

    static Object createObject(Class className) throws InstantiationException, IllegalAccessException {
        Object obj = className.newInstance();
        return obj;
    }

    static void execute_method(Object obj, Method method, Object... args) throws InvocationTargetException, IllegalAccessException {
        method.invoke(obj, args);
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // Пункт 1.
        class AnyClass {
            int arg;

            AnyClass() {
                System.out.println("c-tor");
                arg = 1;
            }

            public int getArg() {
                return arg;
            }

            public void setArg(int abc) {
                System.out.println("setArg");
                arg = abc;
            }
        }
        printClassInfo(AnyClass.class);
        /* Out:
        class work06.Task$1AnyClass
        Field name: arg, field type:int
        Method name: getArg, return type: int
        Not parameters for this method
        Method name: setArg, return type: void
        Parameters types:
        int
        Constructors:
        work06.Task$1AnyClass
        Not parameters for this constructor
         */
        // Пункт 2.
        Object anyObj = createObject(AnyClass.class); // c-tor
        execute_method(anyObj, AnyClass.class.getMethod("setArg", int.class), 1); // Out: setArg
    }


}
