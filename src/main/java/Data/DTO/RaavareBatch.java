/* Author: Karl Emil */

package Data.DTO;

public class RaavareBatch {

    private int rbId;
    private int raavareId;
    private double maengde;
    private String leverandoer;

    public RaavareBatch() {
    }

    public RaavareBatch(int rbId, int raavareId, double maengde, String leverandoer) {
        this.rbId = rbId;
        this.raavareId = raavareId;
        this.maengde = maengde;
        this.leverandoer = leverandoer;
    }

    public int getRbId() {
        return rbId;
    }

    public int getRaavareId() {
        return raavareId;
    }

    public double getMaengde() {
        return maengde;
    }

    public String getLeverandoer() {
        return leverandoer;
    }
}
