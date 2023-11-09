;
public class FiksniBroj extends TelefonskiBroj {
    private Grad grad;
    private String broj;

    public FiksniBroj(Grad grad, String broj){
        this.grad=grad;
        this.broj=broj;
    }


    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + grad.hashCode();
        result = 31 * result + broj.hashCode();
        return result;
    }

    public Grad getPozivniBroj(){
        return grad;
    }

    @Override
    public String ispisi() {
        return this.getPozivniBroj()+"/"+getBroj();
    }

    public Grad getGrad() {
        return grad;
    }

    public String getBroj(){
        return broj;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }
}
