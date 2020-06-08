package API;

import Data.DBAfvejning;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("afvejning")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class afvejningServlet {

    DBAfvejning dba = new DBAfvejning();

    @GET
    @Path("lab")
    public String findLaborant(@QueryParam("labNr") int id) {return dba.findBruger(id);}

    //@GET
    //@Path("pb")
    //public List findRecept(@QueryParam("pbNr") int id) {return dba.findRecept(id);};
}
