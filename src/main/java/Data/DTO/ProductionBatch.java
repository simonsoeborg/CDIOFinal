package Data.DTO;
// Author: Kamilia Marikh

public class ProductionBatch {

    private int pbid;
    private int receptid;
    private String status;
    private int userid;
    private int rbid;
    private double tara;
    private double afvejetmaengde;

    public ProductionBatch() {}


    public ProductionBatch(int pbid, int receptid, String status, int userid, int rbid, double tara, double afvejetmaengde) {
        this.pbid = pbid;
        this.receptid = receptid;
        this.status = status;
        this.userid = userid;
        this.rbid = rbid;
        this.tara = tara;
        this.afvejetmaengde = afvejetmaengde;
    }

    public int getpbid() {return pbid;}

    public void setPbid(int pbid) { this.pbid = pbid; }

    public int getreceptid(){return receptid; }

    public void setReceptid(int receptid) {this.receptid = receptid; }

    public String getstatus() {return status;}

    public void setstatus(String status) {this.status = status;}

    public int getuserid(){return userid; }

    public void setuserid (int userid) { this.userid = userid; }

    public int getrbid() {return rbid; }

    public void setrbid(int rbId) { this.rbid = rbid; }

    public double gettara() {return tara; }

    public void settara(double tara) { this.tara = tara; }

    public double getafvejetmaengde() {return afvejetmaengde; }

    public void setAfvejetmaengde (double afvejetmaengde) { this.afvejetmaengde = afvejetmaengde; }

    }






