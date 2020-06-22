package Controller;

import Data.DTO.User;

import java.util.List;

public interface IUser {
    List<User> listAllActivatedUsers();
    List<User> listAllDeactivatedUsers();
    List<User> listAllUsers();
    List<User> getAllActivatedUsers();
    List<User> getAllUsers();
    List<User> getAllDeactivatedUsers();
    List<User> getAllSpeceficRoles(String role);
    List<User> listAllSpeceficRole(String role);

    void deactivateUser(int userID);
    void activateUser(int userID);
    User searchUser(int userID);
    void createUser(String firstName, String lastName, String role);
    void editUser(int userID, String firstName, String lastName, String role);
}
