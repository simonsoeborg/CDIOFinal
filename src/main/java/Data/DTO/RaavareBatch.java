/* Author: Karl Emil */

package Data.DTO;

public class RaavareBatch {

    private int rbId;
    private int raavareId;
    private double maengde;
    private String leverandoer;
    private String raavareNavn;

    public RaavareBatch() {
    }

    public RaavareBatch(int rbId, int raavareId, double maengde, String leverandoer, String raavareNavn) {
        this.rbId = rbId;
        this.raavareId = raavareId;
        this.maengde = maengde;
        this.leverandoer = leverandoer;
        this.raavareNavn = raavareNavn;
    }

    public RaavareBatch(int rbId, int raavareId, double maengde, String leverandoer) {
        this.rbId = rbId;
        this.raavareId = raavareId;
        this.maengde = maengde;
        this.leverandoer = leverandoer;
        this.raavareNavn = null;
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
