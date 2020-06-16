package Controller;

import Data.DTO.User;

import java.util.ArrayList;
import java.util.List;

public class LocalUser implements IUser {
    private List<User> userList;

    @Override
    public List<User> listAllActivatedUsers() {
        userList = new ArrayList<>();
        userList = getAllActivatedUsers();
        return userList;
    }

    @Override
    public List<User> listAllDeactivatedUsers() {
        userList = new ArrayList<>();
        userList = getAllDeactivatedUsers();
        return userList;
    }

    @Override
    public List<User> listAllUsers() {
        userList = new ArrayList<>();
        userList = getAllUsers();
        return userList;
    }

    @Override
    public List<User> getAllActivatedUsers() {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public List<User> getAllDeactivatedUsers() {
        return null;
    }

    @Override
    public void deactivateUser(int userID) {

    }

    @Override
    public void activateUser(int userID) {

    }

    @Override
    public User searchUser(int userID) {
        return null;
    }

    @Override
    public void createUser(String firstName, String lastName, String role) {

    }

    @Override
    public void editUser(int userID, String firstName, String lastName, String role) {

    }
}
