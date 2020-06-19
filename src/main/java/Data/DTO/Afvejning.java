package Data.DTO;

public class Afvejning {
    private int pbid;
    private int rbid;
    private double afvejetmaengde;
    private double tara;

    public Afvejning() {

    }

    public Afvejning(int pbid,int rbid, double tara, double afvejetmaengde) {
        this.pbid = pbid;
        this.rbid = rbid;
        this.afvejetmaengde = afvejetmaengde;
        this.tara = tara;
    }

    public int getPbid() {
        return pbid;
    }

    public void setPbid(int pbid) {
        this.pbid = pbid;
    }

    public double getTara() {
        return tara;
    }

    public void setTara(double tara) {
        this.tara = tara;
    }

    public int getRbid() {
        return rbid;
    }

    public void setRbid(int rbid) {
        this.rbid = rbid;
    }

    public double getAfvejetmaengde() {
        return afvejetmaengde;
    }

    public void setAfvejetmaengde(double afvejetmaengde) {
        this.afvejetmaengde = afvejetmaengde;
    }
}
