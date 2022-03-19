package setgenie;

import org.junit.jupiter.api.Test;
import setgenie.model.WorkoutElement;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutElementTest {

    @Test
    void testToString() {
        WorkoutElement e = new WorkoutElement(500, 600, WorkoutElement.STROKE.FREESTYLE);
        assertEquals("1x500 Freestyle @10:00", e.toString());
    }

    @Test
    void getElementQuantity() {
        WorkoutElement e = new WorkoutElement(500, 600, WorkoutElement.STROKE.FREESTYLE);
        assertEquals(1, e.getElementQuantity());
    }

    @Test
    void setElementQuantity() {
        WorkoutElement e = new WorkoutElement(500, 600, WorkoutElement.STROKE.FREESTYLE);
        e.setElementQuantity(10);
        assertEquals(10, e.getElementQuantity());
    }

    @Test
    void getElementDistance() {
        WorkoutElement e = new WorkoutElement(500, 600, WorkoutElement.STROKE.FREESTYLE);
        assertEquals(500, e.getElementDistance());
    }

    @Test
    void setElementDistance() {
        WorkoutElement e = new WorkoutElement(500, 600, WorkoutElement.STROKE.FREESTYLE);
        e.setElementDistance(300);
        assertEquals(300, e.getElementDistance());
    }

    @Test
    void getElementInterval() {
        WorkoutElement e = new WorkoutElement(500, 600, WorkoutElement.STROKE.FREESTYLE);
        assertEquals(600, e.getElementInterval());
    }

    @Test
    void setElementInterval() {
        WorkoutElement e = new WorkoutElement(500, 600, WorkoutElement.STROKE.FREESTYLE);
        e.setElementInterval(400);
        assertEquals(400, e.getElementInterval());
    }

    @Test
    void getElementTotalDistance() {
        WorkoutElement e = new WorkoutElement(6, 500, 600, WorkoutElement.STROKE.FREESTYLE);
        assertEquals(3000, e.getElementTotalDistance());
    }

    @Test
    void setElementTotalDistance() {
        WorkoutElement e = new WorkoutElement(500, 600, WorkoutElement.STROKE.FREESTYLE);
        e.setElementTotalDistance(2000);
        assertEquals(2000, e.getElementTotalDistance());
    }

    @Test
    void getElementTotalDuration() {
        WorkoutElement e = new WorkoutElement(5, 100, 100, WorkoutElement.STROKE.FREESTYLE);
        assertEquals(500, e.getElementTotalDuration());
    }

    @Test
    void setElementTotalDuration() {
        WorkoutElement e = new WorkoutElement(500, 600, WorkoutElement.STROKE.FREESTYLE);
        e.setElementTotalDuration(1234);
        assertEquals(1234, e.getElementTotalDuration());
    }

    @Test
    void getElementStroke() {
        WorkoutElement e = new WorkoutElement(500, 600, WorkoutElement.STROKE.FREESTYLE);
        assertEquals(WorkoutElement.STROKE.FREESTYLE, e.getElementStroke());
    }

    @Test
    void setElementStroke() {
        WorkoutElement e = new WorkoutElement(500, 600, WorkoutElement.STROKE.FREESTYLE);
        e.setElementStroke(WorkoutElement.STROKE.BUTTERFLY);
        assertEquals(WorkoutElement.STROKE.BUTTERFLY, e.getElementStroke());
    }

    @Test
    void getElementNotes() {
        WorkoutElement e = new WorkoutElement(500, 600, WorkoutElement.STROKE.FREESTYLE, "This is a Note.");
        assertEquals("This is a Note.", e.getElementNotes());
    }

    @Test
    void setElementNotes() {
        WorkoutElement e = new WorkoutElement(500, 600, WorkoutElement.STROKE.FREESTYLE);
        e.setElementNotes("Wow another note");
        assertEquals("Wow another note", e.getElementNotes());
    }
}