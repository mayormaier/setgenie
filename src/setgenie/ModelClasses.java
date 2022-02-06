package setgenie;

import java.util.ArrayList;
import java.util.List;

public class ModelClasses {

    public static void main(String[] args) {
        // Tests the WorkoutElement Class
        System.out.println("\n\n*******Testing WorkoutElement********");
        WorkoutElement e1 = new WorkoutElement(5, 100, 65, WorkoutElement.STROKE.FREESTYLE);
        System.out.println(e1);

        WorkoutElement e2 = new WorkoutElement(5, 100, 65, WorkoutElement.STROKE.FREESTYLE, "Descend 1-5");
        System.out.println(e2);

        WorkoutElement e3 = new WorkoutElement(400, 300, WorkoutElement.STROKE.IM, "Drill/Kick/Drill/Swim by 25");

        // Tests the WorkoutSet Class
        System.out.println("\n\n*******Testing WorkoutSet********");
        WorkoutSet warm = new WorkoutSet("Meet Warm Up", WorkoutSet.SETTYPE.WARMUP, 1);
        warm.addElement(e1);
        warm.addElement(e3);
        System.out.println(warm);

        // Tests the User Class
        System.out.println("\n\n*******Testing User********");
        User andrew = new User("Andrew", "Maier", "andrewswim13@gmail.com", "hello123", "mayormaier");
        System.out.println(andrew);

        // Tests the Workout Class
        System.out.println("\n\n*******Testing Workout********");
        Workout day1 = new Workout("My Daily Workout", andrew);
        day1.addSet(warm);
        System.out.println(day1);

        // Tests the Search Class
        System.out.println("\n\n*******Testing Search********");
        List<Workout> startingList = new ArrayList<>();
        startingList.add(day1);
        Search s1 = new Search("mayormaier", "Meet");
        s1.executeSearch(startingList);
        System.out.println(s1);

        //more workoutSet testing
        WorkoutElement ew1 = new WorkoutElement(500, 345, WorkoutElement.STROKE.FREESTYLE);
        WorkoutElement ew2 = new WorkoutElement(2,200, 165, WorkoutElement.STROKE.IM);
        WorkoutElement ew3 = new WorkoutElement(5,100, 80, WorkoutElement.STROKE.FREESTYLE);
        WorkoutSet w = new WorkoutSet("Good Warm Up", WorkoutSet.SETTYPE.WARMUP, 1);
        w.addElement(ew1);
        w.addElement(ew2);
        w.addElement(ew3);
        System.out.println(w);
    }
}
