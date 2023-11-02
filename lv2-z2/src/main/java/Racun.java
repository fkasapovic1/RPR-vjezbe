
public class Racun {
    private Long brojRacuna;
    private Osoba korisnikRacuna;
    private Boolean odobrenjePrekoracenja;
    private Double stanjeRacuna;
    private Double prekoracenje;

    public Racun(Long racun, Osoba o){
        this.brojRacuna=racun;
        this.korisnikRacuna=o;
    }

    public boolean provjeriOdobrenjePrekoracenja(Double iznos){
        return this.prekoracenje>iznos;
    }

    public boolean izvrsiUplatu(Double iznos){
        this.stanjeRacuna+=iznos;
        return true;
    }

    public boolean izvrsiIsplatu(Double iznos){
        if(this.prekoracenje + this.stanjeRacuna < iznos) return false;
        else{
            this.stanjeRacuna-=iznos;
            return true;
        }
    }

    public void odobriPrekoracenje(Double iznos){
        this.prekoracenje=iznos;
    }

    public Long getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(Long brojRacuna){
        this.brojRacuna=brojRacuna;
    }

    public Osoba getKorisnikRacuna(){
        return korisnikRacuna;
    }

    public void setKorisnikRacuna(Osoba o){
        this.korisnikRacuna=o;
    }

    public Double getStanjeRacuna(){
        return stanjeRacuna;
    }

    public void setStanjeRacuna(Double iznos){
        this.stanjeRacuna=iznos;
    }

    public Double getPrekoracenje(){
        return prekoracenje;
    }

    public void setPrekoracenje(Double iznos){
        this.prekoracenje=iznos;
    }

}
