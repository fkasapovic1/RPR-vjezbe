public class Kalkulator {
    public static double calculateSin(double value) {
        return Math.sin(value);
    }

    public static long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Faktorijel nije definisan za negativne brojeve.");
        }

        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
