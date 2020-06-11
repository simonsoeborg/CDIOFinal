/* Author: Karl Emil */

package API;

import Controller.DBRaavareBatch;
import Data.DTO.raavareBatch;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("raavarebatch")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class raavareBatchServlet {

    DBRaavareBatch DBrb = new DBRaavareBatch();

    @GET
    @Path("load")
    public List<raavareBatch> GetRaavareBatch() {
        return DBrb.listAllRaavareBatch();
    }

    @DELETE
    @Path("{rbId}")
    public void deleteRaavareBatch(@PathParam("rbId") int rbId) {
        DBrb.deleteRaavareBatch(rbId);
    }

    @GET
    @Path("/raavare/" + "{raavareId}")
    public String getRaavareNavn(@PathParam("raavareId") int raavareId) { return DBrb.getRaavareNavn(raavareId);}

}


