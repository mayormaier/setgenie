package setgenie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Workout {
    private UUID uuid;

    private String workoutName;
    private String workoutNotes;

    private int workoutDistance;
    private int workoutDuration;

    private Map<String, Double> workoutStrokePercentages;
    private List<WorkoutSet> workoutSetList;

    private User workoutOwner;

    public Workout(String workoutName, String workoutNotes, User workoutOwner) {
        this.uuid = UUID.randomUUID();
        this.workoutName = workoutName;
        this.workoutNotes = workoutNotes;
        this.workoutDistance = 0;
        this.workoutDuration = 0;
        this.workoutStrokePercentages = new HashMap<>();
        this.workoutSetList = new ArrayList<>();
        this.workoutOwner = workoutOwner;
    }

    public Workout(String workoutName, User workoutOwner) {
        this.uuid = UUID.randomUUID();
        this.workoutName = workoutName;
        this.workoutNotes = null;
        this.workoutDistance = 0;
        this.workoutDuration = 0;
        this.workoutStrokePercentages = new HashMap<>();
        this.workoutSetList = new ArrayList<>();
        this.workoutOwner = workoutOwner;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.workoutName);
        sb.append("\nDistance: ").append(this.workoutDistance);
        sb.append("\nDuration: ");
        int durTemp = this.workoutDuration;
        if (durTemp >= 3600) {
            long hrs = TimeUnit.SECONDS.toHours(durTemp);
            durTemp -= TimeUnit.HOURS.toSeconds(hrs);
            sb.append(hrs).append(":");
        }
        if (durTemp >= 60) {
            if (durTemp < 600) {
                sb.append("0");
            }
            long mins = TimeUnit.SECONDS.toMinutes(durTemp);
            durTemp -= TimeUnit.MINUTES.toSeconds(mins);
            long secs = durTemp;

            sb.append(mins).append(":");
            if (secs >= 10) {
                sb.append(secs);
            } else {
                sb.append("0").append(secs);
            }
        } else {
            sb.append(":");
            if (durTemp >= 10) {
                sb.append(durTemp);
            } else {
                sb.append("0").append(durTemp);
            }
        }
        return sb.toString();
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public String getWorkoutNotes() {
        return workoutNotes;
    }

    public void setWorkoutNotes(String workoutNotes) {
        this.workoutNotes = workoutNotes;
    }

    public int getWorkoutDistance() {
        return workoutDistance;
    }

    public void setWorkoutDistance(int workoutDistance) {
        this.workoutDistance = workoutDistance;
    }

    public int getWorkoutDuration() {
        return workoutDuration;
    }

    public void setWorkoutDuration(int workoutDuration) {
        this.workoutDuration = workoutDuration;
    }

    public Map<String, Double> getWorkoutStrokePercentages() {
        return workoutStrokePercentages;
    }

    public void setWorkoutStrokePercentages(Map<String, Double> workoutStrokePercentages) {
        this.workoutStrokePercentages = workoutStrokePercentages;
    }

    public List<WorkoutSet> getWorkoutSetList() {
        return workoutSetList;
    }

    public void setWorkoutSetList(List<WorkoutSet> workoutSetList) {
        this.workoutSetList = workoutSetList;
    }

    public User getWorkoutOwner() {
        return workoutOwner;
    }

    public void setWorkoutOwner(User workoutOwner) {
        this.workoutOwner = workoutOwner;
    }

    public void calculateMetadata() {
        int tempDist = 0;
        int tempDur = 0;

        for (WorkoutSet s : this.workoutSetList) {
            tempDist += s.getWorkoutSetDistance();
            tempDur += s.getWorkoutSetDuration();
        }

        this.workoutDistance = tempDist;
        this.workoutDuration = tempDur;

    }

    public void addSet(WorkoutSet newSet) {
        this.workoutSetList.add(newSet);
        calculateMetadata();
    }
}
