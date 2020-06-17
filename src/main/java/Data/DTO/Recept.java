package Data.DTO;

public class Recept {

    private int receptid;
    private String receptnavn;
    private int raavareid;
    private String raavarenavn;
    private double maengde;
    private double tolerance;

    public Recept(){}

    //Identisk med ReceptView2
    public Recept(int receptid, String receptnavn, int raavareid, String raavarenavn, double maengde, double tolerance) {
        this.receptid = receptid;
        this.receptnavn = receptnavn;
        this.raavareid = raavareid;
        this.raavarenavn = raavarenavn;
        this.maengde = maengde;
        this.tolerance = tolerance;
    }


    public int getReceptid() {
        return receptid;
    }

    public String getReceptnavn() {
        return receptnavn;
    }

    public int getRaavareid() {
        return raavareid;
    }

    public String getRaavarenavn() {
        return raavarenavn;
    }

    public double getMaengde() {
        return maengde;
    }

    public double getTolerance() {
        return tolerance;
    }


}

