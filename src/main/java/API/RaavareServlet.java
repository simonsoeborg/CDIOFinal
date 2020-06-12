package API;
// Author: Kristoffer

import Controller.DBRaavare;
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
    @Path("load")
    public List<Raavare> GetRaavare() {
        return DBRaavare.GetAllRaavare();
    }

    @POST
    public void createRaavare(Raavare raavare) {
        DBRaavare.createRaavare(raavare.getRaavareid(), raavare.getRaavarenavn());
    }

    @DELETE
    @Path("{raavareid}")
    public void deleteRaavare(@PathParam("raavareid") int raavareid) {
        DBRaavare.deleteRaavare(raavareid);
    }

    @GET
    @Path("{raavarenavn}")
    public Raavare searchRaavare(@PathParam("raavarenavn") String raavarenavn){return DBRaavare.searchRaavare(raavarenavn);}
}
