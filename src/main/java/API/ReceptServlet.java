package API;

import Controller.DBRecept;
import Data.DTO.Recept;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("recepts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReceptServlet {

    private DBRecept dbr = new DBRecept();

    @GET
    public List<Recept> getRecepts() { return dbr.GetAllRecepts(); }

    @POST
    public void createRecept(Recept recept) {
        dbr.createRecept(recept.getReceptid(), recept.getReceptnavn(), recept.getRaavareid(),
                recept.getRaavarenavn(), recept.getMaengde(), recept.getTolerance());
    }

    @DELETE
    @Path("{id}")
    public void deleteReceptKomponent(@PathParam("id") int id, Recept recept) {
        dbr.deleteReceptKomponent(recept.getReceptid(), recept.getReceptnavn(), recept.getRaavareid(),
                recept.getRaavarenavn(), recept.getMaengde(),recept.getTolerance());
    }

/*
    @PUT
    @Path("{id}")
    public void updateRecept(@PathParam("id") int id, Recept recept) {
        dbr.UpdateRecept(id, recept.getReceptNavn(), recept.getRaavareNavn(),
                recept.getMaengde(), recept.getTolerance());
    }
*/

/*



    @PUT
    @Path("component/{id}")
    public void updateReceptComponent(@PathParam("id") int id, Recept recept) {
        dbr.UpdateReceptComponent(recept.getRaavareId(), recept.getNonNetto(), recept.getTolerance());
    }

    @DELETE
    @Path("component/{id}")
    public void deleteReceptComponent(@PathParam("id") int id) {
        dbr.deleteReceptComponent(id);
    }*/
}
