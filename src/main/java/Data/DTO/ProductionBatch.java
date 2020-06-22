package Data.DTO;
// Author: Kamilia Marikh

public class ProductionBatch {

    private int pbID;
    private int receptID;
    private String status;
    private int userID;
    private int rbID;
    private double tara;
    private double netto;


    public ProductionBatch(int pbID, int receptID, String status, int userID) {
        this.pbID = pbID;
        this.status = status;
        this.receptID = receptID;
        this.userID = userID;
    }

    public int getpbId() {return pbID;}

    public void setPbID(int pbID) { this.pbID = pbID; }

    public int getReceptID(){return receptID; }

    public void setReceptID(int receptId) {this.receptID = receptID; }

    public String getstatus() {return status;}

    public void setstatus(String status) {this.status = status;}

    public int getuserId(){return userID; }

    public void setuserId (int userId) { this.userID = userId; }

    public int getrbid() {return rbID; }

    public void setrbId(int rbId) { this.rbID = rbId; }

    public double gettara() {return tara; }

    public void settara(double tara) { this.tara = tara; }

    public double getnetto() {return netto; }

    public void setnetto (double netto) { this.netto = netto; }

    }






