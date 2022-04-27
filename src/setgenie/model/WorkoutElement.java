package setgenie.model;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class WorkoutElement implements Serializable, Comparable<WorkoutElement>{

    private int elementQuantity;
    private int elementDistance;
    private int elementInterval;
    private int elementTotalDistance;
    private int elementTotalDuration;
    private STROKE elementStroke;
    private String elementNotes;

    private String elementAuthor;

    @Override
    public int compareTo(WorkoutElement o) {
        if (this.elementQuantity == o.elementQuantity && this.elementDistance == o.elementDistance && this.elementInterval == o.elementInterval && this.elementStroke == o.elementStroke){
            return 0;
        } else if (this.elementTotalDistance > o.elementTotalDistance || this.elementTotalDuration > o.elementTotalDuration){
            return 1;
        } else {
            return -1;
        }
    }

    public enum STROKE {
        BUTTERFLY("Butterfly"), BACKSTROKE("Backstroke"), BREASTSTROKE("Breaststroke"), FREESTYLE("Freestyle"),
        KICK("Kick"), IM("IM");

        private final String strokeName;

        private STROKE(String strokeName) {
            this.strokeName = strokeName;
        }

        @Override
        public String toString() {
            return strokeName;
        }
    }

    public WorkoutElement(int elementQuantity, int elementDistance, int elementInterval, STROKE elementStroke, String elementNotes) {
        this.elementQuantity = elementQuantity;
        this.elementDistance = elementDistance;
        this.elementInterval = elementInterval;
        this.elementStroke = elementStroke;
        this.elementNotes = elementNotes;
        this.elementAuthor = null;

        elementTotalDistance = elementQuantity * elementDistance;
        elementTotalDuration = elementQuantity * elementInterval;
    }

    public WorkoutElement(int elementDistance, int elementInterval, STROKE elementStroke, String elementNotes) {
        this.elementQuantity = 1;
        this.elementDistance = elementDistance;
        this.elementInterval = elementInterval;
        this.elementStroke = elementStroke;
        this.elementNotes = elementNotes;
        this.elementAuthor = null;

        elementTotalDistance = elementDistance;
        elementTotalDuration = elementInterval;
    }

    public WorkoutElement(int elementQuantity, int elementDistance, int elementInterval, STROKE elementStroke) {
        this.elementQuantity = elementQuantity;
        this.elementDistance = elementDistance;
        this.elementInterval = elementInterval;
        this.elementStroke = elementStroke;
        this.elementNotes = null;
        this.elementAuthor = null;

        elementTotalDistance = elementQuantity * elementDistance;
        elementTotalDuration = elementQuantity * elementInterval;
    }

    public WorkoutElement(int elementDistance, int elementInterval, STROKE elementStroke) {
        this.elementQuantity = 1;
        this.elementDistance = elementDistance;
        this.elementInterval = elementInterval;
        this.elementStroke = elementStroke;
        this.elementNotes = null;
        this.elementAuthor = null;

        elementTotalDistance = elementDistance;
        elementTotalDuration = elementInterval;
    }

    public WorkoutElement(int elementQuantity, int elementDistance, int elementInterval, String elementAuthor, STROKE elementStroke,
                          String elementNotes) {
        this.elementQuantity = elementQuantity;
        this.elementDistance = elementDistance;
        this.elementInterval = elementInterval;
        this.elementStroke = elementStroke;
        this.elementNotes = elementNotes;
        this.elementAuthor = elementAuthor;

        elementTotalDistance = elementQuantity * elementDistance;
        elementTotalDuration = elementQuantity * elementInterval;
    }

    public WorkoutElement(int elementDistance, int elementInterval, String elementAuthor, STROKE elementStroke, String elementNotes) {
        this.elementQuantity = 1;
        this.elementDistance = elementDistance;
        this.elementInterval = elementInterval;
        this.elementStroke = elementStroke;
        this.elementNotes = elementNotes;
        this.elementAuthor = elementAuthor;

        elementTotalDistance = elementDistance;
        elementTotalDuration = elementInterval;
    }

    public WorkoutElement(int elementQuantity, int elementDistance, int elementInterval, String elementAuthor, STROKE elementStroke) {
        this.elementQuantity = elementQuantity;
        this.elementDistance = elementDistance;
        this.elementInterval = elementInterval;
        this.elementStroke = elementStroke;
        this.elementAuthor = elementAuthor;
        this.elementNotes = null;

        elementTotalDistance = elementQuantity * elementDistance;
        elementTotalDuration = elementQuantity * elementInterval;
    }

    public WorkoutElement(int elementDistance, int elementInterval, String elementAuthor, STROKE elementStroke) {
        this.elementQuantity = 1;
        this.elementDistance = elementDistance;
        this.elementInterval = elementInterval;
        this.elementStroke = elementStroke;
        this.elementAuthor = elementAuthor;
        this.elementNotes = null;

        elementTotalDistance = elementDistance;
        elementTotalDuration = elementInterval;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.elementQuantity).append("x").append(this.elementDistance).append(" ")
                .append(this.elementStroke.toString()).append(" ").append("@");
        int intervalTemp = this.elementInterval;
        if (intervalTemp >= 60) {
            long mins = TimeUnit.SECONDS.toMinutes(intervalTemp);
            intervalTemp -= TimeUnit.MINUTES.toSeconds(mins);
            long secs = intervalTemp;

            sb.append(mins).append(":");
            if (secs >= 10) {
                sb.append(secs);
            } else {
                sb.append("0").append(secs);
            }
        } else {
            sb.append(":");
            if (intervalTemp >= 10) {
                sb.append(intervalTemp);
            } else {
                sb.append("0").append(intervalTemp);
            }
        }

        if (this.elementNotes != null) {
            sb.append("\tNOTES: ").append(this.elementNotes);
        }

        return sb.toString();
    }

    public int getElementQuantity() {
        return elementQuantity;
    }

    public void setElementQuantity(int elementQuantity) {
        this.elementQuantity = elementQuantity;
    }

    public int getElementDistance() {
        return elementDistance;
    }

    public void setElementDistance(int elementDistance) {
        this.elementDistance = elementDistance;
    }

    public int getElementInterval() {
        return elementInterval;
    }

    public void setElementInterval(int elementInterval) {
        this.elementInterval = elementInterval;
    }

    public int getElementTotalDistance() {
        return elementTotalDistance;
    }

    public void setElementTotalDistance(int elementTotalDistance) {
        this.elementTotalDistance = elementTotalDistance;
    }

    public int getElementTotalDuration() {
        return elementTotalDuration;
    }

    public void setElementTotalDuration(int elementTotalDuration) {
        this.elementTotalDuration = elementTotalDuration;
    }

    public STROKE getElementStroke() {
        return elementStroke;
    }

    public void setElementStroke(STROKE elementStroke) {
        this.elementStroke = elementStroke;
    }

    public String getElementNotes() {
        return elementNotes;
    }

    public void setElementNotes(String elementNotes) {
        this.elementNotes = elementNotes;
    }

    public String getElementAuthor() {
        return elementAuthor;
    }

    public void setElementAuthor(String elementAuthor) {
        this.elementAuthor = elementAuthor;
    }

    public boolean decideToInsert(WorkoutElement w){
        boolean decision = false;

        if (this.elementTotalDistance < w.elementTotalDistance){
            return true;
        } else if (this.elementTotalDistance == w.elementTotalDistance){
            if (this.elementTotalDuration < w.elementTotalDuration){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
