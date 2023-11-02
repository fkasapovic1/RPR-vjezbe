public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Morate unijeti tačno jedan broj.");
            return;
        }

        double vrijednost = Double.parseDouble(args[0]);

        double sinus = Kalkulator.calculateSin(vrijednost);
        System.out.println("Sinus(" + vrijednost + ") = " + sinus);

        if (vrijednost % 1 == 0) {
            long faktorijel = Kalkulator.calculateFactorial((int) vrijednost);
            System.out.println(vrijednost + "! = " + faktorijel);
        } else {
            System.out.println("Faktorijel se može računati samo za cijeli broj.");
        }
    }
}
