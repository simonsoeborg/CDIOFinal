package API;

import Data.DBAfvejning;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("afvejning")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class afvejningServlet {

    DBAfvejning dba = new DBAfvejning();

    @GET
    @Path("{laborantNr}")
    public String findLaborant(@PathParam("laborantNr") int id) {return dba.findBruger(id);}

}
