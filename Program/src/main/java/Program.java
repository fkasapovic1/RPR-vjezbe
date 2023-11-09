
import java.util.Scanner;
import java.util.Set;

public class Program {
    private static Grad pronadiGrad(String pozivniBroj) {
        for (Grad grad : Grad.values()) {
            if (grad.label.equals(pozivniBroj)) {
                return grad;
            }
        }
        // Ukoliko nije pronađen grad, vratite null ili bacite iznimku, ovisno o potrebama.
        return null;
    }
    public static void main(String[] args){
        Imenik imenik = new Imenik();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Izaberite opciju:");
            System.out.println("1. Dodaj osobu u imenik");
            System.out.println("2. Pronađi broj po imenu");
            System.out.println("3. Pronađi ime po broju");
            System.out.println("4. Ispis imenika po početnom slovu");
            System.out.println("5. Ispis osoba iz određenog grada");
            System.out.println("0. Izlaz");

            int opcija = scanner.nextInt();
            scanner.nextLine(); // Da biste konzumirali preostali unos nakon broja.

            switch (opcija) {
                case 1:
                    System.out.print("Unesite ime osobe: ");
                    String ime = scanner.nextLine();
                    System.out.print("Unesite broj osobe (format: 0XX/XXXXXXXX za mobilni, XX/XXXXXXXXX za fiksni, +XX/XXXXXXXXX za međunarodni): ");
                    String broj = scanner.nextLine();

                    TelefonskiBroj telefonskiBroj = null;
                    if (broj.matches("^0\\d{2}/\\d{8}$")) {
                        // Unesen je mobilni broj
                        String[] parts = broj.split("/");
                        int mobilnaMreza = Integer.parseInt(parts[0].substring(1));
                        String brojTelefona = parts[1];
                        telefonskiBroj = new MobilniBroj(mobilnaMreza, brojTelefona);
                    } else if (broj.matches("^\\d{2}/\\d{9}$")) {
                        // Unesen je fiksni broj
                        String[] parts = broj.split("/");
                        Grad grad = pronadiGrad(parts[0]);
                        String brojTelefona = parts[1];
                        telefonskiBroj = new FiksniBroj(grad, brojTelefona);
                    } else if (broj.matches("^\\+\\d{2}/\\d{9}$")) {
                        // Unesen je međunarodni broj
                        String[] parts = broj.split("/");
                        String drzava = parts[0].substring(1);
                        String brojTelefona = parts[1];
                        telefonskiBroj = new MedunarodniBroj(drzava, brojTelefona);
                    } else {
                        System.out.println("Neispravan format broja. Molimo pokušajte ponovo.");
                        break;
                    }

                    imenik.dodaj(ime, telefonskiBroj);
                    System.out.println("Osoba dodana u imenik.");
                    break;




                case 2:
                    System.out.print("Unesite ime osobe za pretragu: ");
                    String trazenoIme = scanner.nextLine();
                    String trazeniBroj = imenik.dajBroj(trazenoIme);
                    System.out.println("Pronađeni broj: " + trazeniBroj);
                    break;

                case 3:
                    System.out.print("Unesite broj za pretragu (format: 0XX/XXXXXXXX): ");
                    String trazeniBroj1 = scanner.nextLine();
                    String trazenoIme1 = imenik.dajIme(new FiksniBroj(Grad.SARAJEVO, trazeniBroj1));
                    // Ili prilagodite pretragu za mobilni ili međunarodni broj prema potrebi.
                    System.out.println("Pronađeno ime: " + trazenoIme1);
                    break;

                case 4:
                    System.out.print("Unesite početno slovo za ispis: ");
                    char slovo = scanner.nextLine().charAt(0);
                    String rezultat = imenik.naSlovo(slovo);
                    System.out.println("Osobe čije ime počinje na slovo '" + slovo + "':");
                    System.out.println(rezultat);
                    break;

                case 5:
                    System.out.print("Unesite grad za pretragu: ");
                    Grad grad = Grad.valueOf(scanner.nextLine().toUpperCase());
                    Set<String> osobeIzGrada = imenik.izGrada(grad);
                    System.out.println("Osobe iz grada " + grad + ":");
                    for (String imeOsobe : osobeIzGrada) {
                        System.out.println(imeOsobe);
                    }
                    break;

                case 0:
                    System.out.println("Hvala što ste koristili imenik. Doviđenja!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Nepoznata opcija. Molimo pokušajte ponovo.");
            }
        }
    }
}