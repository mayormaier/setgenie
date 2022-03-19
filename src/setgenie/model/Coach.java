package setgenie.model;

import java.util.List;

public class Coach extends User{

    private int userYearsExperience;
    private int userSetsAuthored;
    private COACHING_LEVEL userCoachingLevel;

    public enum COACHING_LEVEL {
        AGE_GROUP("Age Group"), SENIOR("Senior"), COLLEGE("College"), MASTERS("Masters");

        private final String ageGroupName;

        private COACHING_LEVEL(String ageGroupName) {this.ageGroupName = ageGroupName;}

        @Override
        public String toString() { return this.ageGroupName; }
    }

    public Coach(String userFirstName, String userLastName, String userEmail, String userPassword, String username, String userClubName, int userYearsExperience, COACHING_LEVEL userCoachingLevel) {
        super(userFirstName, userLastName, userEmail, userPassword, username, userClubName);
        this.setUserRole(ROLE.COACH);
        this.userCoachingLevel = userCoachingLevel;
        this.userYearsExperience = userYearsExperience;
        this.userSetsAuthored = 0;
    }

    public Coach(String userFirstName, String userLastName, String userEmail, String userPassword, String username, int userYearsExperience, COACHING_LEVEL userCoachingLevel) {
        super(userFirstName, userLastName, userEmail, userPassword, username, "Unattached");
        this.setUserRole(ROLE.COACH);
        this.userCoachingLevel = userCoachingLevel;
        this.userYearsExperience = userYearsExperience;
        this.userSetsAuthored = 0;
    }

    public int getUserYearsExperience() {
        return userYearsExperience;
    }

    public void setUserYearsExperience(int userYearsExperience) {
        this.userYearsExperience = userYearsExperience;
    }

    public int getUserSetsAuthored() {
        return userSetsAuthored;
    }

    public void setUserSetsAuthored(int userSetsAuthored) {
        this.userSetsAuthored = userSetsAuthored;
    }

    public COACHING_LEVEL getUserCoachingLevel() {
        return userCoachingLevel;
    }

    public void setUserCoachingLevel(COACHING_LEVEL userCoachingLevel) {
        this.userCoachingLevel = userCoachingLevel;
    }

    @Override
    public void addUserCreatedWorkout(Workout newWorkout){
        List<Workout> wl = this.getUserCreatedWorkouts();
        wl.add(newWorkout);
        this.userSetsAuthored++;
        this.setUserCreatedWorkouts(wl);
    }

    @Override
    public String shareWorkout(Workout workout){
        return "I just created a new workout for " + this.getUserClubName() + "! Check out my " + workout.getWorkoutName() + " workout on SetGenie.";
    }



}
