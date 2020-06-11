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

    public void setRaavareid(int raavareid) {
        this.raavareid = raavareid;
    }


    public String getRaavarenavn() {
        return raavarenavn;
    }

    public void setRaavarenavn(String raavarenavn) {
        this.raavarenavn = raavarenavn;
    }

    public String getLeverandoer() {
        return leverandoer;
    }

    public void setLeverandoer(String leverandoer) {
        this.leverandoer = leverandoer;
    }
}
