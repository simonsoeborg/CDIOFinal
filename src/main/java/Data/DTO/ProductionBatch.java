package Data.DTO;
// Author: Kamilia Marikh

public class ProductionBatch {

    private int pbID;
    private int receptID;
    private int status;
    private int userID;
    private int rbID;
    private double tara;
    private double netto;


    public ProductionBatch(int pbID, int receptID, int status, int userID, int rbID, double tara, double netto) {
        this.pbID = pbID;
        this.status = status;
        this.receptID = receptID;
        this.userID = userID;
        this.rbID = rbID;
        this.tara = tara;
        this.netto = netto;
    }

    public int getpbId() {return pbID;}

    public void setPbID(int pbID) { this.pbID = pbID; }

    public int getReceptID(){return receptID; }

    public void setReceptID(int receptId) {this.receptID = receptID; }

    public int getstatus() {return status;}

    public void setstatus(int status) {this.status = status;}

    public int getuserId(){return userID; }

    public void setuserId (int userId) { this.userID = userId; }

    public int getrbid() {return rbID; }

    public void setrbId(int rbId) { this.rbID = rbId; }

    public double gettara() {return tara; }

    public void settara(double tara) { this.tara = tara; }

    public double getnetto() {return netto; }

    public void setnetto (double netto) { this.netto = netto; }

    }






