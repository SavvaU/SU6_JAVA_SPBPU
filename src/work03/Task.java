package work03;

public class Task {
    public static void main(String[] args) {


        // Пункт 1. Считывание аргументов с командной строки
        for (String arg : args) {
            System.out.println(arg);
        }
        /*
        Input: java src/work03/Task.java arg1 arg2
        Output:
         arg1
         arg2
        */

        // Пункт 2. Операции стек с помощью массива
        // capacity - весь размер массива, size - занятый размер массива
        class DynamicArray {
            int[] array;
            int size;
            int capacity;

            DynamicArray() {
                array = new int[1];
                size = 0;
                capacity = 1;
            }

            boolean empty() {
                return size == 0;
            }

            void growCapacity() {

                int[] temp = new int[capacity * 2];
                for (int i = 0; i < capacity; i++) {
                    temp[i] = array[i];
                }
                array = temp;
                capacity = capacity * 2;
            }

            void push(int newElement) {
                if (size == capacity) {
                    growCapacity();
                }
                array[size] = newElement;
                size++;
            }

            int pop() {
                if (empty()) {
                    throw new RuntimeException("Stack empty");
                }
                int element = array[size - 1];
                array[size - 1] = 0;
                size--;
                return element;
            }
        }

        DynamicArray stack = new DynamicArray();
        System.out.println(stack.empty()); // true
        stack.push(1); // Capacity: 1, Size: 1
        System.out.println(stack.empty()); // false
        stack.push(2); // Capacity: 2, Size: 2
        stack.push(3); // Capacity: 4 Size: 3
        System.out.println(stack.size); // 3
        System.out.println(stack.pop()); // 3
        System.out.println(stack.size); // 2
        System.out.println(stack.pop()); // 2
        System.out.println(stack.pop()); // 1
        System.out.println(stack.pop()); // Exception, stack empty
        System.out.println(stack.pop());

    }
}
