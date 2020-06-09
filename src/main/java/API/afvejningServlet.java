/*
    Author: Simon Søborg
    Github: simonsoeborg
*/
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
    @Path("lab")
    public String findLaborant(@QueryParam("labNr") int id) {
        return dba.getLaborantName(id);
    }

    @GET
    @Path("pb")
    public String findRecept(@QueryParam("pbNr") int id) {
        return dba.findRecept(id);
    }
}
