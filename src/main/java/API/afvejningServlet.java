/*
    Author: Simon Søborg
    Github: simonsoeborg
*/
package API;

import Controller.DBAfvejning;
import Data.DTO.Afvejning;
import Data.DTO.AfvejningReceptKomponent;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("afvejning")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class afvejningServlet {

    DBAfvejning dba = new DBAfvejning();

    // #### GET Requests ####

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

    @GET
    @Path("{id}")
    public List<AfvejningReceptKomponent> GetData(@PathParam("id") int id) {
        return dba.getAfvejningReceptKomponent(id);
    }

    @GET
    @Path("/status/" + "{id}")
    public String getProduktionStatus(@PathParam("id") int id) {
        return dba.getProduktionStatus(id);
    }

    @POST
    public void updateAfvejetRB(Afvejning afvejning) {
        dba.updateAfvejetData(afvejning.getPbid(), afvejning.getRbid(), afvejning.getAfvejetmaengde(), afvejning.getTara());
    }

    @PUT
    @Path("/status/update/" + "{id}")
    public void updateProduktionStatus(@PathParam("id") int id) {
        dba.updateProduktionStatus(id);
    }
}
