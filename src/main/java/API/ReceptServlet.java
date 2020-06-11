package API;

import Data.DBRecept;
import Data.DTO.Recept;
import Data.DTO.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("recepts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReceptServlet {

    DBRecept dbr = new DBRecept();

    @GET
    public List<Recept> getRecepts() { return dbr.listAllRecepts(); }

    @POST
    public void createRecept(Recept recept) {
        dbr.createRecept(recept.getReceptId(), recept.getReceptNavn(),
                recept.getRaavareId(), recept.getNonNetto(), recept.getTolerance());
    }

    @PUT
    @Path("{id}")
    public void updateRecept(@PathParam("id") int id, Recept recept) {
        dbr.UpdateRecept(id, recept.getReceptNavn(),
                recept.getRaavareId(), recept.getNonNetto(), recept.getTolerance());
    }

    @DELETE
    @Path("{id}")
    public void deleteRecept(@PathParam("id") int id) {
        dbr.deleteRecept(id);
    }

    @PUT
    @Path("{id}")
    public void updateReceptComponent(@PathParam("id") int id, Recept recept) {
        dbr.UpdateReceptComponent(recept.getRaavareId(), recept.getNonNetto(), recept.getTolerance());
    }

    @DELETE
    @Path("{id}")
    public void deleteReceptComponent(@PathParam("id") int id) {
        dbr.deleteReceptComponent(id);
    }
}
