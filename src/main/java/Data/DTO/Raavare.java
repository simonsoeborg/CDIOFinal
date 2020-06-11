package Data.DTO;
// Author: Kristoffer
public class Raavare {
    private int raavareid;
    private String raavarenavn;
    private String leverandoer;

    public Raavare () {

    }

    public Raavare (int raavareid, String raavarenavn, String leverandoer){
        this.raavareid = raavareid;
        this.raavarenavn = raavarenavn;
        this.leverandoer = leverandoer;
    }

    public int getRaavareid() {
        return raavareid;
    }

    public String getRaavarenavn() {
        return raavarenavn;
    }

    public String getLeverandoer() {
        return leverandoer;
    }

}
