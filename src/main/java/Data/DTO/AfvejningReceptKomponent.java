package Data.DTO;

public class AfvejningReceptKomponent {
    private int raavareid;
    private String raavarenavn;
    private double maengde;
    private double tolerance;

    public AfvejningReceptKomponent() {}

    public AfvejningReceptKomponent(int raavareid, String raavarenavn, double maengde, double tolerance) {
        this.raavareid = raavareid;
        this.raavarenavn = raavarenavn;
        this.maengde = maengde;
        this.tolerance = tolerance;
    }

    public int getRKRaavareid() {
        return raavareid;
    }

    public void setRKRaavareid(int raavareid) {
        this.raavareid = raavareid;
    }

    public String getRKRaavarenavn() {
        return raavarenavn;
    }

    public void setRKRaavarenavn(String raavarenavn) {
        this.raavarenavn = raavarenavn;
    }

    public double getRKMaengde() {
        return maengde;
    }

    public void setRKMaengde(double maengde) {
        this.maengde = maengde;
    }

    public double getRKTolerance() {
        return tolerance;
    }

    public void setRKTolerance(double tolerance) {
        this.tolerance = tolerance;
    }
}
