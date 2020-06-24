/*Author:
Freja Nørgaard Jensen*/

package Data.DTO;

public class Recept {

    private int receptid;
    private String receptnavn;
    private String raavarenavn;
    private int raavareid;
    private double maengde;
    private double tolerance;

    public Recept(){}

    public Recept(int receptId, String receptNavn, int raavareId, String raavareNavn, double maengde, double tolerance) {
        this.receptid = receptId;
        this.receptnavn = receptNavn;
        this.raavareid = raavareId;
        this.raavarenavn = raavareNavn;
        this.maengde = maengde;
        this.tolerance = tolerance;
    }

    public Recept(int receptId, String receptNavn) {
        this.receptid = receptId;
        this.receptnavn = receptNavn;

    }

    public int getReceptid() {
        return receptid;
    }

    public String getReceptnavn() {
        return receptnavn;
    }

    public double getMaengde() {
        return maengde;
    }

    public double getTolerance() {
        return tolerance;
    }

    public String getRaavarenavn() {
        return raavarenavn;
    }

    public int getRaavareid() {
        return raavareid;
    }
}
