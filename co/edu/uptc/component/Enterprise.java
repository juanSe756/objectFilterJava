package co.edu.uptc.component;

public class Enterprise {
    private long nit;
    private String socialR;
    private String dateOrigin;
    private long capital;

    public Enterprise(long nit, String socialR, String dateOrigin, long capital) {
        this.nit = nit;
        this.socialR = socialR;
        this.dateOrigin = dateOrigin;
        this.capital = capital;
    }
    public long getNit() {
        return nit;
    }
    public String getSocialR() {
        return socialR;
    }
    public String getDateOrigin() {
        return dateOrigin;
    }
    public double getCapital() {
        return capital;
    }
    @Override
    public String toString() {
        return "Enterprise:"+nit+"Razon Social:"+socialR+"Fecha de creacion;"+dateOrigin+"Capital:"+capital;
    }

}
