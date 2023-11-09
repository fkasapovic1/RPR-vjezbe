public class MobilniBroj extends TelefonskiBroj {
    private int mobilnaMreza;
    private String broj;

    public MobilniBroj(int mobilnaMreza, String broj){
        this.broj=broj;
        this.mobilnaMreza=mobilnaMreza;
    }

    public String getBroj(){
        return broj;
    }

    public int getMobilnaMreza(){
        return mobilnaMreza;
    }


    @Override
    public String ispisi() {
        return "0"+getMobilnaMreza()+"/"+getBroj();
    }

    @Override
    public int hashCode() {
        int hash = 17;


        hash = 31 * hash + mobilnaMreza;

        hash = 31 * hash ^ broj.hashCode();

        return hash;
    }



}