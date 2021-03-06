package setgenie.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User implements Serializable{

    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userPassword;
    private String username;
    private String userClubName;
    private ROLE userRole;

    private List<Workout> userSavedWorkouts;
    private List<Workout> userCreatedWorkouts;

    public enum ROLE {
        ATHLETE("Athlete"), COACH("Coach"), OTHER("Other");

        private final String roleName;

        private ROLE(String roleName) {
            this.roleName = roleName;
        }

        @Override
        public String toString() {
            return this.roleName;
        }
    }

    public User(String userFirstName, String userLastName, String userEmail, String userPassword, String username, String userClubName) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.username = username;
        this.userRole = null;
        this.userClubName = userClubName;
        userSavedWorkouts = new ArrayList<>();
        userCreatedWorkouts = new ArrayList<>();
    }

    public User(String userFirstName, String userLastName, String userEmail, String userPassword, String username) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.username = username;
        this.userRole = null;
        this.userClubName = "Unattached";
        userSavedWorkouts = new ArrayList<>();
        userCreatedWorkouts = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.userLastName).append(", ").append(this.userFirstName).append(":\t").append(this.username);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o){
        if (o.getClass() != this.getClass()){return false;}
        if (this.username.equals(((User) o).username)){return true;}
        else {return false;}
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ROLE getUserRole() {
        return userRole;
    }

    public void setUserRole(ROLE userRole) {
        this.userRole = userRole;
    }

    public List<Workout> getUserSavedWorkouts() {
        return userSavedWorkouts;
    }

    public void setUserSavedWorkouts(List<Workout> userSavedWorkouts) {
        this.userSavedWorkouts = userSavedWorkouts;
    }

    public List<Workout> getUserCreatedWorkouts() {
        return userCreatedWorkouts;
    }

    public void setUserCreatedWorkouts(List<Workout> userCreatedWorkouts) {
        this.userCreatedWorkouts = userCreatedWorkouts;
    }

    public String getUserClubName() {
        return this.userClubName;
    }

    public void setUserClubName(String userClubName) {
        this.userClubName = userClubName;
    }

    public void addUserCreatedWorkout(Workout newWorkout){
        this.userCreatedWorkouts.add(newWorkout);
    }

    public String shareWorkout(Workout w){
        return "Check out " + w.getWorkoutName() + " on SetGenie";
    }
}
