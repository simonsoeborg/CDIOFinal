package Data.DTO;
// Author: Kamilia Marikh

public class ProductionBatch {

    private int pbId;
    private int receptid;
    private int status;
    private int userId;
    private int rbId;
    private double tara;
    private double netto;


    public ProductionBatch(int pbId, int receptid, int status, int userId, int rbId, double tara, double netto) {
        this.pbId = pbId;
        this.status = status;
        this.receptid = receptid;
        this.userId = userId;
        this.rbId = rbId;
        this.tara = tara;
        this.netto = netto;
    }

    public int getpbId() {return pbId;}

    public void setPbId(int pbId) { this.pbId = pbId; }

    public int getreceptid(){return receptid; }

    public void setReceptid(int receptId) {this.receptid = receptid; }

    public int getstatus() {return status;}

    public void setstatus(int status) {this.status = status;}

    public int getuserId(){return userId; }

    public void setuserId (int userId) { this.userId = userId; }

    public int getrbid() {return rbId; }

    public void setrbId(int rbId) { this.rbId = rbId; }

    public double gettara() {return tara; }

    public void settara(double tara) { this.tara = tara; }

    public double getnetto() {return netto; }

    public void setnetto (double netto) { this.netto = netto; }

    }






