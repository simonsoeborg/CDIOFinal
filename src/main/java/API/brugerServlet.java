/*
Author: Simon Fridolf
Github: IceMonk3y
*/

package API;

import Controller.DBUser;
import Data.DTO.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class brugerServlet {
    private DBUser dbUser = new DBUser();

    @GET
    @Path("activated")
    public List<User> listAllActiveUsers() {
        return dbUser.listAllActivatedUsers();
    }

    @GET
    @Path("deactivated")
    public List<User> listAllDeactivatedUsers() {
        return dbUser.listAllDeactivatedUsers();
    }

    @GET
    public List<User> getAllUsers() {
        return dbUser.listAllUsers();
    }

    @GET
    @Path("search")
    public User searchUser(@QueryParam("id") int id) {
        return dbUser.searchUser(id);
    }

    //*Todo Implement auto generated initials.
    @POST
    public void createUser(User user) {
        dbUser.createUser(user.getFirstname(), user.getLastname(), user.getInitial(), user.getRole());
    }

    // *todo Test edit-user:
    @PUT
    @Path("{id}")
    public void editUser(@PathParam("id") int id, User user) {
        dbUser.editUser(id, user.getFirstname(), user.getLastname(), user.getRole());
    }

    @PUT
    @Path("deactivate")
    public void deactivateUser(@QueryParam("id") int id) {
        dbUser.deactivateUser(id);
    }

    @PUT
    @Path("activate")
    public void activateUser(@QueryParam("id") int id) {
        dbUser.activateUser(id);

    }
}
