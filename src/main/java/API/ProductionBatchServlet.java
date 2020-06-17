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
     @Path("Loading")
     public List<ProductionBatch> GetProductionBatch() { return DBProductionBatch.GetAllProductionBatch(); }

     @POST
    public void createProductionBatch(ProductionBatch ProductionBatch) {
            DBProductionBatch.createProductionBatch(ProductionBatch.getPbId(), ProductionBatch.getPbId());

    @DELETE
    @Path("{pbId}")}
    public void deleteProductionBatch(@PathParam("pbId") int pbId) {  DBProductionBatch.deleteProductionBatch(pbId);  }
    
    }