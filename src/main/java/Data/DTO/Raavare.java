package Data.DTO;
// Author: Kristoffer
public class Raavare {
    private int raavareid;
    private String raavarenavn;

    public Raavare () {

    }

    public Raavare (int raavareid, String raavarenavn){
        this.raavareid = raavareid;
        this.raavarenavn = raavarenavn;
    }

    public int getRaavareid() {
        return raavareid;
    }

    public String getRaavarenavn() {
        return raavarenavn;
    }

}
