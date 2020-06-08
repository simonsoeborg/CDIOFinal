package API;

import Data.DBRaavare;
import Data.DTO.Raavare;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("raavare")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RaavareServlet {

    DBRaavare DBRaavare = new DBRaavare();

    @GET
    public List<Raavare> GetRaavare() {
        return DBRaavare.listAllRaavare();
    }

    // @GET
   //@Path("{raavareId}")
   // public Raavare searchRaavare(@PathParam("raavareId") int id){return DBRaavarer.searchRaavarer(raavarerId);}

    @DELETE
    @Path("{raavareId}")
    public void deleteRaavare(@PathParam("raavareId") int raavareId) {
        DBRaavare.deleteRaavare(raavareId);
    }
}
