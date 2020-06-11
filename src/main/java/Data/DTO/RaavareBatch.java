/* Author: Karl Emil */

package Data.DTO;

public class RaavareBatch {

    private int rbId;
    private int raavareId;
    private double maengde;

    public RaavareBatch(int rbId, int raavareId, double maengde) {
        this.rbId = rbId;
        this.raavareId = raavareId;
        this.maengde = maengde;
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
}
