

import java.util.Objects;

public class Korisnik extends Osoba{

    private Racun racun;

    public Korisnik(String ime, String prezime){
        super(ime, prezime);
    }

    public void dodajRacun(Racun r){
        this.racun=r;
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        Korisnik korisnik=(Korisnik) o;
        return Objects.equals(korisnik.racun, racun);
    }
}
