package work08;


import java.util.Objects;

public class Task {

    public static class Triple<T extends Comparable<T>> {
        private T first;
        private T second;
        private T third;

        Triple(T first, T second, T third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Triple<?> triple) {
                return first == triple.first && second == triple.second && third == triple.third;
            }
            return false;
        }

        public T getFirst() {
            return first;
        }

        public T getSecond() {
            return second;

        }

        public T getThird() {
            return third;
        }

        public int hashCode() {
            return Objects.hash(first, second, third);
        }

        public String toString() {
            return "Triple " + Integer.toHexString(hashCode()) + ": ("
                    + first.toString() + ", " + second.toString() + ", " + third.toString() + ")";
        }

        public T max() {
            if (!(first instanceof Number)) {
                throw new IllegalArgumentException("Mean calculation is supported only for numeric types");
            }
            T max = first;
            if (second.compareTo(max) > 0) max = second;
            if (third.compareTo(max) > 0) max = third;
            return max;
        }

        public T min() {
            if (!(first instanceof Number)) {
                throw new IllegalArgumentException("Mean calculation is supported only for numeric types");
            }
            T min = first;
            if (second.compareTo(min) < 0) min = second;
            if (third.compareTo(min) < 0) min = third;
            return min;
        }

        public double mean() {
            if (first instanceof Number) {
                double sum = ((Number) first).doubleValue() + ((Number) second).doubleValue() + ((Number) third).doubleValue();
                return sum / 3;
            } else {
                throw new IllegalArgumentException("Mean calculation is supported only for numeric types");

            }
        }
    }

    public static void main(String[] args) {
        Triple<Integer> integerTriple = new Triple<Integer>(2, 50, 100);
        System.out.println(integerTriple.max()); // 100
        System.out.println(integerTriple.mean()); // 50.66
        System.out.println(integerTriple.min()); // 2
        System.out.println(integerTriple.hashCode()); // 33363

        Triple<String> stringTriple = new Triple<>("s", "dsa", "das");
        System.out.println(stringTriple.getFirst()); // s
        System.out.println(stringTriple.hashCode()); // 3332150
        System.out.println(stringTriple.mean()); // Exception
        System.out.println(stringTriple.max()); // Exception

    }
}
