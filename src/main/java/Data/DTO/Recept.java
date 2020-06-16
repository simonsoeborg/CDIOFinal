package Data.DTO;

public class Recept {

    private int receptId;
    private String receptNavn;
    private String raavareNavn;
    private double maengde;
    private double tolerance;

    public Recept(){}

    public Recept(int receptId, String receptNavn, String raavareNavn, double maengde, double tolerance) {
        this.receptId = receptId;
        this.receptNavn = receptNavn;
        this.raavareNavn = raavareNavn;
        this.maengde = maengde;
        this.tolerance = tolerance;
    }


    public int getReceptId() {
        return receptId;
    }

    public String getReceptNavn() {
        return receptNavn;
    }

    public String getRaavareNavn() {
        return raavareNavn;
    }

    public double getMaengde() {
        return maengde;
    }

    public double getTolerance() {
        return tolerance;
    }
}
