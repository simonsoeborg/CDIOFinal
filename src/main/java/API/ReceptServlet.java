/*Author:
Freja Nørgaard Jensen*/

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
        dbr.createRecept(recept.getReceptid(), recept.getReceptnavn(),
                recept.getRaavareid(), recept.getMaengde(), recept.getTolerance());
    }

    @DELETE
    @Path("/komponent/{raavareid}/{receptid}")
    public void deleteReceptKomponent(@PathParam("raavareid") int raavareid, @PathParam("receptid") int receptid) {
        dbr.deleteReceptKomponent(raavareid, receptid);
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
