import java.util.HashMap;
import java.util.*;


public class Imenik {
    private HashMap<String , TelefonskiBroj> imenik = new HashMap<>();
    public void dodaj(String ime, TelefonskiBroj broj){
        imenik.put(ime,broj);
    }

    public String dajBroj(String ime){
        TelefonskiBroj broj = imenik.get(ime);
        if(broj!=null){
            return broj.ispisi();
        }
        return "Osoba nije pronađena u imeniku.";
    }

    public String dajIme(TelefonskiBroj broj){
        for(String ime : imenik.keySet()){
            if(imenik.get(ime).equals(broj)){
                return ime;
            }
        }
        return "Broj nije pronađen";
    }

    public String naSlovo(char s){
        StringBuilder result = new StringBuilder();
        int brojac = 1;

        for (Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()) {
            String ime = entry.getKey();
            if (ime.charAt(0) == s) {
                TelefonskiBroj broj = entry.getValue();
                result.append(brojac).append(". ").append(ime).append(" - ").append(broj.ispisi()).append("\n");
                brojac++;
            }
        }

        if (result.isEmpty()) {
            return "Nema osoba čije ime počinje na slovo '" + s + "'.";
        }

        return result.toString();
    }

    public Set<String> izGrada(Grad g) {
        Set<String> osobeIzGrada = new TreeSet<>();

        for (Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()) {
            TelefonskiBroj broj = entry.getValue();
            if (broj instanceof FiksniBroj fiksniBroj) {
                if (fiksniBroj.getGrad() == g) {
                    osobeIzGrada.add(entry.getKey());
                }
            }
        }

        return osobeIzGrada;
    }

    public Set<TelefonskiBroj> izGradaBrojevi(Grad g) {
        Set<TelefonskiBroj> brojeviIzGrada = new TreeSet<>(new Comparator<TelefonskiBroj>() {
            @Override
            public int compare(TelefonskiBroj broj1, TelefonskiBroj broj2) {
                return broj1.ispisi().compareTo(broj2.ispisi());
            }
        });

        for (Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()) {
            TelefonskiBroj broj = entry.getValue();
            if (broj instanceof FiksniBroj fiksniBroj) {
                if (fiksniBroj.getGrad() == g) {
                    brojeviIzGrada.add(fiksniBroj);
                }
            }
        }
        return brojeviIzGrada;
    }
}