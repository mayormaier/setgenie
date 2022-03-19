package setgenie.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Athlete extends User{

    private Map<String, Double> userBestTimes;
    private List<Workout> userCompletedWorkouts;
    private String userCollegeName;
    private int userAge;


    public Athlete(String userFirstName, String userLastName, String userEmail, String userPassword, String username, String userClubName) {
        super(userFirstName, userLastName, userEmail, userPassword, username, userClubName);
        this.setUserRole(ROLE.ATHLETE);
        this.userBestTimes = new HashMap<>();
        this.userCompletedWorkouts = new ArrayList<>();
    }

    public Athlete(String userFirstName, String userLastName, String userEmail, String userPassword, String username) {
        super(userFirstName, userLastName, userEmail, userPassword, username, "Unattached");
        this.setUserRole(ROLE.ATHLETE);
        this.userBestTimes = new HashMap<>();
        this.userCompletedWorkouts = new ArrayList<>();
    }

    public Athlete(String userFirstName, String userLastName, String userEmail, String userPassword, String username, String userClubName, int userAge) {
        super(userFirstName, userLastName, userEmail, userPassword, username, userClubName);
        this.setUserRole(ROLE.ATHLETE);
        this.userAge = userAge;
        this.userBestTimes = new HashMap<>();
        this.userCompletedWorkouts = new ArrayList<>();

    }

    public Athlete(String userFirstName, String userLastName, String userEmail, String userPassword, String username, int userAge) {
        super(userFirstName, userLastName, userEmail, userPassword, username, "Unattached");
        this.setUserRole(ROLE.ATHLETE);
        this.userAge = userAge;
        this.userBestTimes = new HashMap<>();
        this.userCompletedWorkouts = new ArrayList<>();
    }

    public Map<String, Double> getUserBestTimes() {
        return userBestTimes;
    }

    public void setUserBestTimes(Map<String, Double> userBestTimes) {
        this.userBestTimes = userBestTimes;
    }

    public String getUserCollegeName() {
        return userCollegeName;
    }

    public void setUserCollegeName(String userCollegeName) {
        if (userAge > 16) {
            this.userCollegeName = userCollegeName;
        }
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public List<Workout> getUserCompletedWorkouts() {
        return userCompletedWorkouts;
    }

    public void setUserCompletedWorkouts(List<Workout> userCompletedWorkouts) {
        this.userCompletedWorkouts = userCompletedWorkouts;
    }

    public void addBestTime(WorkoutElement.STROKE stroke, int distance, double time){
        String event = stroke.toString() + distance;
        this.getUserBestTimes().put(event, time);
    }

    public void addCompletedWorkout(Workout w) {
        this.userCompletedWorkouts.add(w);
    }

    @Override
    public String shareWorkout(Workout workout){
        return "I just completed a new workout! Check out Coach " + workout.getWorkoutOwner().getUsername() + "'s " + workout.getWorkoutName() + " workout on SetGenie.";
    }


}
