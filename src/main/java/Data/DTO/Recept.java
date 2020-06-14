package Data.DTO;

public class Recept {

    private int receptId;
    private String receptNavn;
    private int raavareId;
    private double nonNetto;
    private double tolerance;

    public Recept(){}

    public Recept(int receptId, String receptNavn, int raavareId, double nonNetto, double tolerance) {
        this.receptId = receptId;
        this.receptNavn = receptNavn;
        this.raavareId = raavareId;
        this.nonNetto = nonNetto;
        this.tolerance = tolerance;
    }

    public int getReceptId() {
        return receptId;
    }

    public String getReceptNavn() {
        return receptNavn;
    }

    public int getRaavareId() {
        return raavareId;
    }

    public double getNonNetto() {
        return nonNetto;
    }

    public double getTolerance() {
        return tolerance;
    }
}
