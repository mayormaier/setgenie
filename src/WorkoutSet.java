import java.util.ArrayList;
import java.util.List;

public class WorkoutSet {

    private String workoutSetName;
    private String workoutSetNotes;
    private SETTYPE workoutSetType;
    private int workoutSetRounds;
    private int workoutSetDistance;
    private int workoutSetDuration;

    private List<WorkoutElement> elementList;

    public enum SETTYPE {
        WARMUP("Warm-up"), MAIN("Main Set"), PRE("Pre-set"), POST("Post-set"), KICK("Kick Set"), PULL("Pull Set"), COOLDOWN("cooldown");

        private final String typeName;
        private SETTYPE(String typeName){
            this.typeName = typeName;
        }

        @Override
        public String toString() {
            return this.typeName;
        }
    }

    public WorkoutSet(String workoutSetName, String workoutSetNotes, SETTYPE workoutSetType, int workoutSetRounds) {
        this.workoutSetName = workoutSetName;
        this.workoutSetNotes = workoutSetNotes;
        this.workoutSetType = workoutSetType;
        this.workoutSetRounds = workoutSetRounds;
        this.workoutSetDistance = 0;
        this.workoutSetDuration = 0;
        this.elementList = new ArrayList<>();
    }

    public WorkoutSet(String workoutSetName, SETTYPE workoutSetType, int workoutSetRounds) {
        this.workoutSetName = workoutSetName;
        this.workoutSetNotes = null;
        this.workoutSetType = workoutSetType;
        this.workoutSetRounds = workoutSetRounds;
        this.workoutSetDistance = 0;
        this.workoutSetDuration = 0;
        this.elementList = new ArrayList<>();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(this.workoutSetName);
        sb.append("\nType: " ).append(this.workoutSetType.toString());
        sb.append("\n");
        for (WorkoutElement element: this.elementList) {
            sb.append("\t").append(element.toString()).append("\n");
        }
        return sb.toString();
    }

    public String getWorkoutSetName() {
        return workoutSetName;
    }

    public void setWorkoutSetName(String workoutSetName) {
        this.workoutSetName = workoutSetName;
    }

    public String getWorkoutSetNotes() {
        return workoutSetNotes;
    }

    public void setWorkoutSetNotes(String workoutSetNotes) {
        this.workoutSetNotes = workoutSetNotes;
    }

    public SETTYPE getWorkoutSetType() {
        return workoutSetType;
    }

    public void setWorkoutSetType(SETTYPE workoutSetType) {
        this.workoutSetType = workoutSetType;
    }

    public int getWorkoutSetRounds() {
        return workoutSetRounds;
    }

    public void setWorkoutSetRounds(int workoutSetRounds) {
        this.workoutSetRounds = workoutSetRounds;
    }

    public int getWorkoutSetDistance() {
        return workoutSetDistance;
    }

    public void setWorkoutSetDistance(int workoutSetDistance) {
        this.workoutSetDistance = workoutSetDistance;
    }

    public int getWorkoutSetDuration() {
        return workoutSetDuration;
    }

    public void setWorkoutSetDuration(int workoutSetDuration) {
        this.workoutSetDuration = workoutSetDuration;
    }

    public List<WorkoutElement> getElementList() {
        return elementList;
    }

    public void setElementList(List<WorkoutElement> elementList) {
        this.elementList = elementList;
    }

    public void calculateMetadata() {
        int tempDist = 0;
        int tempDur = 0;
        for (WorkoutElement element: this.elementList) {
            tempDist += element.getElementTotalDistance();
            tempDur += element.getElementTotalDuration();

            this.workoutSetDistance = tempDist;
            this.workoutSetDuration = tempDur;
        }
    }

    public void addElement(WorkoutElement element) {
        this.elementList.add(element);
        calculateMetadata();
    }
}
