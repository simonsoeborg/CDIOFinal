package API;

import DB.DBConnector;
import Data.DBUser;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class UserServlet {
    private DBConnector DBC = new DBConnector();
    private DBUser dbUser = new DBUser();

    @GET
    public List<DBUser> listAllUsers() {
        return dbUser.listAllUsers();
    }

    @GET
    @Path("{id}")
    public DBUser searchUser(@PathParam("id") int id){return dbUser.searchUser(id);}


    @POST
    public void createUser(DBUser user) {
        dbUser.createUser(user.getFirstname(), user.getLastname(), user.getRole());
    }

    @PUT
    @Path("{id}")
    public void editUser(@PathParam("id") int id, DBUser user) {
        dbUser.editUser(id, user.getFirstname(), user.getLastname(), user.getRole());
    }

    @DELETE
    @Path("{id}")
    public void deleteUser(@PathParam("id") int id) {
        dbUser.deleteUser(id);
    }


}
