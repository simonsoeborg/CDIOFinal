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
    public List<Recept> getRecepts() {
        return dbr.GetAllRecepts();
    }

    @POST
    public void createRecept(Recept recept) {
        dbr.createRecept(recept.getReceptId(), recept.getReceptNavn(),
                recept.getRaavareId(), recept.getMaengde(), recept.getTolerance());
    }

    @DELETE
    @Path("/komponent/{id}")
    public void deleteReceptComponent(@PathParam("id") int id, Recept recept) {
        dbr.deleteReceptKomponent(id, recept.getReceptId());
    }

    @DELETE
    @Path("{id}")
    public void deleteReceptId(@PathParam("id") int id) {
        dbr.deleteReceptId(id);
    }

    @GET
    @Path("receptIdOversigt")
    public List<Recept> getReceptsFromRecept() {
        return dbr.GetAllReceptsFromRecept();

    }
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
    @DELETE
    @Path("{id}")
    public void deleteRecept(@PathParam("id") int id) {
        dbr.deleteRecept(id);
    }


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

