package Data.DTO;

public class ProductionBatchKomp {

    private int userId;
    private int rbId;
    private double tara;
    private double netto;

    public ProductionBatchKomp(int userId,int rbId, double tara, double netto) {
        this.userId = userId;
        this.rbId = rbId;
        this.tara = tara;
        this.netto = netto;
    }

    public int getuserId() {return userId; }

    public void setUserId(int userId) { this.userId = userId; }

    public int getrbid() {return rbId; }

    public void setRbId(int rbId) { this.rbId = rbId; }

    public double getTara() {return tara; }

    public void setTara(double tara) { this.tara = tara; }

    public double getNetto() {return netto; }

    public void setNetto(double netto) { this.netto = netto; }
}
