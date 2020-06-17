package Data.DTO;
// Author: Kamilia Marikh

public class ProductionBatch {

    private int pbId;
    private int receptId;
    private int status;
    private int userId;
    private int rbId;
    private double tara;
    private double netto;


    public ProductionBatch(int pbId,int receptId, int status,int userId,int rbId, double tara, double netto){
        this.pbId = pbId;
        this.status = receptId;
        this.receptId = status;
        this.userId = userId;
        this.rbId = rbId;
        this.tara = tara;
        this.netto = netto;
    }

    public int getPbId() {return pbId;}

    public void setPbId(int pbId) { this.pbId = pbId; }

    public int getReceptId(){return receptId; }

    public void setReceptId(int receptId) {this.receptId = receptId; }

    public int getstatus() {return status;}

    public void setstatus(int status) {this.status = status;

    public int getuserId() {return userId; }

    public void setUserId (int userId) { this.userId = userId; }

    public int getrbid() {return rbId; }

    public void setRbId(int rbId) { this.rbId = rbId; }

    public double getTara() {return tara; }

    public void setTara(double tara) { this.tara = tara; }

    public double getNetto() {return netto; }

    public void setNetto (double netto) { this.netto = netto; } }

    }



