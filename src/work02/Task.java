package work02;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) throws IOException {
        // Пункт 1. Работа со строками
        String str1 = "Hello";
        String str2 = ", ";
        String str3 = "Hello";
        System.out.println(str1 + str2 + str3);
        System.out.println(str3.toUpperCase());
        System.out.println(str3.toLowerCase());
        System.out.println(str3.equals(str2));
        System.out.println(str3 == str2);

        // Пункт 2. Метод hasNext()
        // Консольный ввод
        Scanner stdIn = new Scanner(System.in); // Стандартный консольный ввод
        System.out.println("Result: " + stdIn.hasNext()); // Result: true
        System.out.println("String: " + stdIn.nextLine()); // String: Hello, world!
        System.out.println("Final Result: " + stdIn.hasNext());

        // Ввод из буфера
        String str4 = "Hello, World!";
        Scanner buffer = new Scanner(str4);
        System.out.println("Result: " + buffer.hasNext()); // Result: true
        System.out.println("String: " + buffer.nextLine()); // String: Hello, world!
        System.out.println("Final Result: " + buffer.hasNext()); // Final Result: false, так как в буфере ничего не осталось
        buffer.close();

        // Ввод из файла
        Scanner fileInput = new Scanner(new File("src/work02/string.txt"), StandardCharsets.UTF_8);
        while (fileInput.hasNext()) {
            System.out.println(fileInput.nextLine());
        }

        // Пункт 3. Использование операторов
        // Операторы сравнения и логические операторы
        int a = Integer.parseInt(stdIn.next());
        int b = Integer.parseInt(stdIn.next());
        if (a != b && a > 0 || b > 0) {
            System.out.println("a не равно b, a или b больше 0");
        }

        // Тернарный оператор
        int c = a > b ? a : b; // Берём максимум

        // Под разрядные операторы
        System.out.println(12 & 10); // 12 = 1100, 10 = 1010, 8 = 1000
        System.out.println(12 | 10); // 12 = 1100, 10 = 1010, 14 = 1110
        System.out.println(2 ^ 3); // XOR, результат: 1
        System.out.println(~6); // побитовое отражение, результат: -7
        System.out.println(6 >> 2); // побитовый сдвиг вправо, результат: 1
        System.out.println(6 << 2); // побитовый сдвиг влево, результат: 24
        System.out.println(6 >>> 3); // побитовый нулевой сдвиг вправо, результат: 0

        // Пункт 4. Типы данных в switch

        switch (a) {
            case 0:
                System.out.println("a равен 0");
                break;
            case 1:
                System.out.println("a равен 1");
                break;
            default:
                System.out.println("a не равен 1 и не равен 0");
        }
        String word = stdIn.next();
        switch (word) {
            case "Hello":
                System.out.println("word = Hello");
                break;
            case "World":
                System.out.println("word = World");
                break;
            default:
                System.out.println("word != Hello && word != Hello");
                break;
        }
        // Есть ещё типы, но это те же int или str, enum, но в другом виде, boolean и остальные не поддерживают switch

    }
}
