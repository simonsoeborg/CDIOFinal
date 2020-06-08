package API;

import DB.DBConnector;
import Data.DBUser;
import Data.DTO.User;

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
    @Path("activated")
    public List<User> listAllActiveUsers() { return dbUser.listAllActivatedUsers(); }

    @GET
    @Path("deactivated")
    public List<User> listAllDeactivatedUsers() { return dbUser.listAllDeactivatedUsers(); }

    @GET
    @Path("search")
    public User searchUser(@QueryParam("id") int id){return dbUser.searchUser(id);}


    @POST
    public void createUser(User user) {
        dbUser.createUser(user.getFirstname(), user.getLastname(), user.getRole());
    }

    @PUT
    @Path("{id}")
    public void editUser(@PathParam("id") int id, User user) {
        dbUser.editUser(id, user.getFirstname(), user.getLastname(), user.getRole());
    }

    @PUT
    @Path("{id}")
    public void deactivateUser(@PathParam("id") int id) {
        dbUser.deactivateUser(id);
    }

}
