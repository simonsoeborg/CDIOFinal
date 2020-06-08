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
}
