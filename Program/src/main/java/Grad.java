
public enum Grad  {
    SARAJEVO("033"),
    TUZLA("O35"),
    ZENICA("032"),
    MOSTAR("036"),
    TRAVNIK("030"),
    BANJALUKA("051"),
    ORASJE("031"),
    LIVNO("033"),
    BIHAC("037"),
    GORAZDE("038"),
    SIROKI_BRIJEG("039"),
    BRCKO("049");
    public final String label;
    private Grad(String label){
        this.label=label;
    }

    @Override
    public String toString() {
        return label;
    }
}
