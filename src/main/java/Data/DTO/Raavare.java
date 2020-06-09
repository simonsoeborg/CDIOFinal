package Data.DTO;

public class Raavare {
    private int raavareId;
    private String raavareNavn;
    private String leveradoer;

    public Raavare (int raavareId, String raavareNavn, String leveradoer){
        this.raavareId = raavareId;
        this.raavareNavn = raavareNavn;
        this.leveradoer = leveradoer;
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

    public String getLeveradoer() {
        return leveradoer;
    }

    public void setLeveradoer(String leveradoer) {
        this.leveradoer = leveradoer;
    }
}
