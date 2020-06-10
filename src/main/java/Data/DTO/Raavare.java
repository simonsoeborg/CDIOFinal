package Data.DTO;

public class Raavare {
    private int raavareId;
    private String raavareNavn;
    private String leverandoer;

    public Raavare () {

    }

    public Raavare (int raavareId, String raavareNavn, String leverandoer){
        this.raavareId = raavareId;
        this.raavareNavn = raavareNavn;
        this.leverandoer = leverandoer;
    }

    public int getRaavareId() {
        return raavareId;
    }

    public void setRaavareId(int raavareId) {
        this.raavareId = raavareId;
    }

    public String getRaavareNavn() {
        return raavareNavn;
    }

    public void setRaavareNavn(String raavareNavn) {
        this.raavareNavn = raavareNavn;
    }

    public String getLeverandoer() {
        return leverandoer;
    }

    public void setLeverandoer(String leverandoer) {
        this.leverandoer = leverandoer;
    }
}
