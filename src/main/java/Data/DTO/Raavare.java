package Data.DTO;
// Author: Kristoffer
public class Raavare {
    private int raavareId;
    private String raavareNavn;
    private String leverandoer;

    public Raavare (int raavareId, String raavareNavn, String leverandoer){
        this.raavareId = raavareId;
        this.raavareNavn = raavareNavn;
        this.leverandoer = leverandoer;
    }

    public int getRaavareId() {
        return raavareId;
    }

    public String getRaavareNavn() {
        return raavareNavn;
    }

    public String getLeveradoer() {
        return leverandoer;
    }
}
