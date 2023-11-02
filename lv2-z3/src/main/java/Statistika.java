import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Statistika {
    public static void main(String[] args) {
        List<Double> brojevi = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Unesite broj (ili 'stop' za kraj unosa): ");
            String unos = scanner.nextLine();

            if (unos.equalsIgnoreCase("stop")) {
                break;
            }

            try {
                double broj = Double.parseDouble(unos);
                brojevi.add(broj);
            } catch (NumberFormatException e) {
                System.out.println("Niste uneli validan broj. Pokušajte ponovo.");
            }
        }

        scanner.close();

        if (brojevi.isEmpty()) {
            System.out.println("Niste uneli nijedan broj.");
        } else {
            double min = brojevi.get(0);
            double max = brojevi.get(0);
            double sum = 0;

            for (double broj : brojevi) {
                if (broj < min) {
                    min = broj;
                }
                if (broj > max) {
                    max = broj;
                }
                sum += broj;
            }

            double mean = sum / brojevi.size();

            double sumOfSquares = 0;
            for (double broj : brojevi) {
                sumOfSquares += Math.pow(broj - mean, 2);
            }

            double standardDeviation = Math.sqrt(sumOfSquares / brojevi.size());

            System.out.println("Minimum: " + min);
            System.out.println("Maksimum: " + max);
            System.out.println("Srednja vrednost: " + mean);
            System.out.println("Standardna devijacija: " + standardDeviation);
        }
    }
}
