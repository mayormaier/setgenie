package setgenie;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutSetTest {

    @Test
    void testToString() {
        WorkoutElement e1 = new WorkoutElement(500, 345, WorkoutElement.STROKE.FREESTYLE);
        WorkoutElement e2 = new WorkoutElement(2,200, 165, WorkoutElement.STROKE.IM);
        WorkoutElement e3 = new WorkoutElement(5,100, 80, WorkoutElement.STROKE.FREESTYLE);
        WorkoutSet w = new WorkoutSet("Good Warm Up", WorkoutSet.SETTYPE.WARMUP, 1);
        w.addElement(e1);
        w.addElement(e2);
        w.addElement(e3);
        assertEquals("""
                Name: Good Warm Up
                Type: Warm-up
                \t1x500 Freestyle @5:45
                \t2x200 IM @2:45
                \t5x100 Freestyle @1:20
                """, w.toString());
    }

    @Test
    void getWorkoutSetName() {
        WorkoutSet w = new WorkoutSet("Good Warm Up", WorkoutSet.SETTYPE.WARMUP, 1);
        assertEquals("Good Warm Up", w.getWorkoutSetName());
    }

    @Test
    void setWorkoutSetName() {
        WorkoutSet w = new WorkoutSet("Good Warm Up", WorkoutSet.SETTYPE.WARMUP, 1);
        w.setWorkoutSetName("A better warm up");
        assertEquals("A better warm up", w.getWorkoutSetName());
    }

    @Test
    void getWorkoutSetNotes() {
        WorkoutSet w = new WorkoutSet("Good Warm Up", "these are some notes for my workout", WorkoutSet.SETTYPE.WARMUP, 1);
        assertEquals("these are some notes for my workout", w.getWorkoutSetNotes());
    }

    @Test
    void setWorkoutSetNotes() {
        WorkoutSet w = new WorkoutSet("Good Warm Up", WorkoutSet.SETTYPE.WARMUP, 1);
        w.setWorkoutSetNotes("I have written some notes here about my workout");
        assertEquals("I have written some notes here about my workout", w.getWorkoutSetNotes());
    }

    @Test
    void getWorkoutSetType() {
        WorkoutSet w = new WorkoutSet("Good Warm Up", WorkoutSet.SETTYPE.WARMUP, 1);
        assertEquals(WorkoutSet.SETTYPE.WARMUP, w.getWorkoutSetType());
    }

    @Test
    void setWorkoutSetType() {
        WorkoutSet w = new WorkoutSet("Good Warm Up", WorkoutSet.SETTYPE.WARMUP, 1);
        w.setWorkoutSetType(WorkoutSet.SETTYPE.PRE);
        assertEquals(WorkoutSet.SETTYPE.PRE, w.getWorkoutSetType());
    }

    @Test
    void getWorkoutSetRounds() {
        WorkoutSet w = new WorkoutSet("Good Warm Up", WorkoutSet.SETTYPE.WARMUP, 4);
        assertEquals(4, w.getWorkoutSetRounds());
    }

    @Test
    void setWorkoutSetRounds() {
        WorkoutSet w = new WorkoutSet("Good Warm Up", WorkoutSet.SETTYPE.WARMUP, 1);
        w.setWorkoutSetRounds(7);
        assertEquals(7, w.getWorkoutSetRounds());
    }

    @Test
    void getWorkoutSetDistance() {
        WorkoutElement e1 = new WorkoutElement(500, 345, WorkoutElement.STROKE.FREESTYLE);
        WorkoutElement e2 = new WorkoutElement(2,200, 165, WorkoutElement.STROKE.IM);
        WorkoutElement e3 = new WorkoutElement(5,100, 80, WorkoutElement.STROKE.FREESTYLE);
        WorkoutSet w = new WorkoutSet("Good Warm Up", WorkoutSet.SETTYPE.WARMUP, 1);
        w.addElement(e1);
        w.addElement(e2);
        w.addElement(e3);
        assertEquals(1400, w.getWorkoutSetDistance());
    }

    @Test
    void setWorkoutSetDistance() {
        WorkoutSet w = new WorkoutSet("Good Warm Up", WorkoutSet.SETTYPE.WARMUP, 1);
        w.setWorkoutSetDistance(0);
        assertEquals(0, w.getWorkoutSetDistance());
    }

    @Test
    void getWorkoutSetDuration() {
        WorkoutElement e1 = new WorkoutElement(500, 345, WorkoutElement.STROKE.FREESTYLE);
        WorkoutElement e2 = new WorkoutElement(2,200, 165, WorkoutElement.STROKE.IM);
        WorkoutElement e3 = new WorkoutElement(5,100, 80, WorkoutElement.STROKE.FREESTYLE);
        WorkoutSet w = new WorkoutSet("Good Warm Up", WorkoutSet.SETTYPE.WARMUP, 1);
        w.addElement(e1);
        w.addElement(e2);
        w.addElement(e3);
        assertEquals(1075, w.getWorkoutSetDuration());
    }

    @Test
    void setWorkoutSetDuration() {
        WorkoutSet w = new WorkoutSet("Good Warm Up", WorkoutSet.SETTYPE.WARMUP, 1);
        w.setWorkoutSetDuration(45);
        assertEquals(45, w.getWorkoutSetDuration());
    }

    @Test
    void getElementList() {
        WorkoutElement e1 = new WorkoutElement(500, 345, WorkoutElement.STROKE.FREESTYLE);
        WorkoutElement e2 = new WorkoutElement(2,200, 165, WorkoutElement.STROKE.IM);
        WorkoutElement e3 = new WorkoutElement(5,100, 80, WorkoutElement.STROKE.FREESTYLE);
        WorkoutSet w = new WorkoutSet("Good Warm Up", WorkoutSet.SETTYPE.WARMUP, 1);
        w.addElement(e1);
        w.addElement(e2);
        w.addElement(e3);

        ArrayList<WorkoutElement> l = new ArrayList<>();
        l.add(e1);
        l.add(e2);
        l.add(e3);

        assertEquals(l, w.getElementList());

    }

    @Test
    void setElementList() {
        WorkoutElement e1 = new WorkoutElement(500, 345, WorkoutElement.STROKE.FREESTYLE);
        WorkoutElement e2 = new WorkoutElement(2,200, 165, WorkoutElement.STROKE.IM);
        WorkoutElement e3 = new WorkoutElement(5,100, 80, WorkoutElement.STROKE.FREESTYLE);
        WorkoutSet w = new WorkoutSet("Good Warm Up", WorkoutSet.SETTYPE.WARMUP, 1);

        ArrayList<WorkoutElement> l = new ArrayList<>();
        l.add(e1);
        l.add(e2);
        l.add(e3);

        w.setElementList(l);

        assertEquals(l, w.getElementList());
    }

    @Test
    void calculateMetadata() {
        //this test works given the assumption that the set metadata will update when a new value is added
        //calculateMetadata() is called by the addElement() method.
        //calculateMetadata updates workoutSetDistance and workoutSetDuration
        WorkoutElement e1 = new WorkoutElement(500, 345, WorkoutElement.STROKE.FREESTYLE);
        WorkoutElement e2 = new WorkoutElement(2,200, 165, WorkoutElement.STROKE.IM);
        WorkoutElement e3 = new WorkoutElement(5,100, 80, WorkoutElement.STROKE.FREESTYLE);
        WorkoutSet w = new WorkoutSet("Good Warm Up", WorkoutSet.SETTYPE.WARMUP, 1);
        assertEquals(0, w.getWorkoutSetDistance());
        assertEquals(0, w.getWorkoutSetDuration());

        w.addElement(e1);
        w.addElement(e2);
        w.addElement(e3);
        assertEquals(1400, w.getWorkoutSetDistance());
        assertEquals(1075, w.getWorkoutSetDuration());
    }

    @Test
    void addElement() {
        WorkoutElement e1 = new WorkoutElement(500, 345, WorkoutElement.STROKE.FREESTYLE);
        WorkoutElement e2 = new WorkoutElement(2,200, 165, WorkoutElement.STROKE.IM);
        WorkoutElement e3 = new WorkoutElement(5,100, 80, WorkoutElement.STROKE.FREESTYLE);
        WorkoutSet w = new WorkoutSet("Good Warm Up", WorkoutSet.SETTYPE.WARMUP, 1);
        ArrayList<WorkoutElement> l = new ArrayList<>();
        assertEquals(l, w.getElementList());

        l.add(e1);
        w.addElement(e1);
        assertEquals(l, w.getElementList());

        w.addElement(e2);
        w.addElement(e3);

        l.add(e2);
        l.add(e3);
        assertEquals(l, w.getElementList());
    }
}