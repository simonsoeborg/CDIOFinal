package Data.DTO;

public class Recept {

    private int receptId;
    private String receptNavn;
    private int raavareId;
    private double maengde;
    private double tolerance;

    public Recept(){}

    public Recept(int receptId, String receptNavn, int raavareId, double maengde, double tolerance) {
        this.receptId = receptId;
        this.receptNavn = receptNavn;
        this.raavareId = raavareId;
        this.maengde = maengde;
        this.tolerance = tolerance;
    }


    public int getReceptId() {
        return receptId;
    }

    public String getReceptNavn() {
        return receptNavn;
    }

    public double getMaengde() {
        return maengde;
    }

    public double getTolerance() {
        return tolerance;
    }

    public int getRaavareId() {
        return raavareId;
    }
}
