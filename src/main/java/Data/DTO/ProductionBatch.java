package Data.DTO;
// Author: Kamilia Marikh

public class ProductionBatch {

    private int pbId;
    private int receptId;
    private int status;

    public ProductionBatch(int pbId,int receptId, int status){
        this.pbId = pbId;
        this.status = receptId;
        this.receptId = status;
    }

    public int getPbId() {return pbId;}

    public void setPbId(int pbId) { this.pbId = pbId; }

    public int getReceptId(){return receptId; }

    public void setReceptId(int receptId) {this.receptId = receptId; }

    public int getstatus() {return status;}

    public void setstatus(int status) {this.status = status; }


}


