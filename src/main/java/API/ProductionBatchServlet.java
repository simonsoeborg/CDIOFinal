package API;

import Controller.DBProductionBatch;
import Data.DTO.ProductionBatch;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("ProductionBatch")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductionBatchServlet {

     DBProductionBatch DBProductionBatch = new DBProductionBatch();

    @GET
    @Path("load")
    public List<ProductionBatch> getProductionBatch() {
        return DBProductionBatch.GetAllProductionBatch();
    }

     @POST
    public void createProductionBatch(ProductionBatch productionBatch) {
         DBProductionBatch.createProductionBatch(productionBatch.getpbid(), productionBatch.getreceptid(),productionBatch.getstatus());
     }

    @DELETE
    @Path("{pbid}/{rbid}")
    public void deleteProductionBatch(@PathParam("pbid") int pbid, @PathParam("rbid") int rbid) {
        DBProductionBatch.deleteProductionBatch(pbid,rbid);  }
    
    }
