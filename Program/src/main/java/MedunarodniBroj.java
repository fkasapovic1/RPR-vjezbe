public class MedunarodniBroj extends TelefonskiBroj{
    private String drzava;
    private String broj;

    public MedunarodniBroj(String drzava, String broj){
        this.drzava=drzava;
        this.broj=broj;
    }

    public String getDrzava(){
        return drzava;
    }

    public String getBroj(){
        return broj;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public void setBroj(String broj){
        this.broj=broj;
    }


    @Override
    public String ispisi() {
        return getDrzava()+"/"+getBroj();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + drzava.hashCode();
        result = 31 * result + broj.hashCode();
        return result;
    }
}