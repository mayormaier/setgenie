package setgenie.tests;

import setgenie.model.*;

import java.util.*;

/**
 * @author andrewmaier
 *
 * Creating manual tests to validate SetGenie classes.
 */
public class TestHarness {

    public TestHarness() {
        testUserClass();
        testWorkoutClass();
        testClassHierarchy();
        testInterface();
    }

    public void testUserClass() {
        System.out.println("*** Testing User Class ***");
        User u1 = new User("Bob", "Jones", "bjones@email.com" , "bobstrongpassword", "bjones1");

        if (u1 != null){
            System.out.println("User instance 1 created successfully!");
            // Get all user info - testing getters
            System.out.println("User Info: " + u1.getUserFirstName() + " " + u1.getUserLastName() + " " + u1.getUserEmail() + " " + u1.getUsername() + " " + u1.getUserPassword() + " " + u1.getUserRole() + " " + u1.getUserCreatedWorkouts() + " " + u1.getUserSavedWorkouts());

            // Set new info - testing setters
            u1.setUserFirstName("Mary");
            u1.setUserLastName("Smith");
            u1.setUserEmail("msmith@email.com");
            u1.setUserPassword("msmithstrongpass");
            u1.setUsername("msmith1");
            u1.setUserRole(User.ROLE.COACH);

            List<Workout> testList1= new ArrayList<>();
            u1.setUserCreatedWorkouts(testList1);
            u1.setUserSavedWorkouts(testList1);
        } else {
            System.out.println("Could not properly create user class");
        }
        User u2 = new User("Bob", "Jones", "bjones@email.com" , "bobstrongpassword", "bjones1");

        if (u2 != null) {
            System.out.println("User instance 2 created successfully!");
            //test toString()
            System.out.println(u2.toString());
        } else {
            System.out.println("Error creating user 2");
        }
    }

    public void testWorkoutClass() {
        System.out.println("*** Testing Workout Class ***");

        // Creating WorkoutElements
        WorkoutElement e1 = new WorkoutElement(5, 100, 65, WorkoutElement.STROKE.FREESTYLE);
        WorkoutElement e2 = new WorkoutElement(5, 100, 65, WorkoutElement.STROKE.FREESTYLE, "Descend 1-5");
        WorkoutElement e3 = new WorkoutElement(400, 300, WorkoutElement.STROKE.IM, "Drill/Kick/Drill/Swim by 25");

        // Creating WorkoutSets
        WorkoutSet s1 = new WorkoutSet("Meet Warm Up", WorkoutSet.SETTYPE.WARMUP, 1);
        s1.addElement(e1);
        s1.addElement(e2);
        s1.addElement(e3);

        System.out.println("**********************");
        System.out.println(s1.calculateDuration());
        System.out.println(s1.calculateDistance());
        // Creating User
        User u1 = new User("Bob", "Jones", "bjones@email.com" , "bobstrongpassword", "bjones1");
        User u2 = new User("Billy", "Johns", "bjohns@email.com" , "billystrongpassword", "bjohns1");

        //Testing Workout
        System.out.println("w****w************");
        Workout w1 = new Workout("Workout 1", "This is a workout test", u1);
        System.out.println(w1.calculateDuration());
        System.out.println(w1.calculateDistance());

        if (w1 != null){
            System.out.println("Workout instance created successfully!");

            //Getting workout information - testing getters
            System.out.println("Workout info: " + w1.getWorkoutName() + " " + w1.getWorkoutNotes()  + " " + w1.getWorkoutOwner() + " " + w1.getWorkoutDistance() + " " + w1.getWorkoutDuration() + " " + w1.getUuid() + " " + w1.getWorkoutSetList() + " " + w1.getWorkoutStrokePercentages());

            //Setting new information - testing setters
            UUID testUUID = UUID.randomUUID();
            w1.setUuid(testUUID);

            w1.setWorkoutDistance(100);
            w1.setWorkoutName("Testing Set Name");
            w1.setWorkoutDuration(3600);
            w1.setWorkoutNotes("setting the notes");
            w1.setWorkoutOwner(u2);

            Map<String, Double> strokesTest = new HashMap<>();
            strokesTest.put("Freestyle", 100.0);
            w1.setWorkoutStrokePercentages(strokesTest);


            List<WorkoutSet> testSetList = new ArrayList();
            testSetList.add(s1);
            w1.setWorkoutSetList(testSetList);

            // test additional methods
            w1.addSet(s1);
            w1.updateTotals();

            // testing toString()
            System.out.println(w1.toString());
        } else {
            System.out.println("Error creating workout instance");
        }
    }

    public static void testClassHierarchy() {
        // add workout for testing
        WorkoutElement e1 = new WorkoutElement(5, 100, 65, WorkoutElement.STROKE.FREESTYLE);
        WorkoutElement e2 = new WorkoutElement(5, 100, 65, WorkoutElement.STROKE.FREESTYLE, "Descend 1-5");
        WorkoutElement e3 = new WorkoutElement(400, 300, WorkoutElement.STROKE.IM, "Drill/Kick/Drill/Swim by 25");

        WorkoutSet s1 = new WorkoutSet("Meet Warm Up", WorkoutSet.SETTYPE.WARMUP, 1);
        s1.addElement(e1);
        s1.addElement(e2);
        s1.addElement(e3);

        User u1 = new User("Bob", "Jones", "bjones@email.com" , "bobstrongpassword", "bjones1");
        User u2 = new User("Billy", "Johns", "bjohns@email.com" , "billystrongpassword", "bjohns1");

        Workout w1 = new Workout("Workout 1", "This is a workout test", u1);

        // test polymorphism
        ArrayList<User> users = new ArrayList<>();
        User testAthlete = new Athlete("John", "Jones", "jjones@email.com", "testpin", "jjones", "New York Athletic Club", 20);
        User testCoach = new Coach("Bob", "Brown", "brown1@gmail.com", "testpin2", "bbrown", "New York Athletic Club",10, Coach.COACHING_LEVEL.SENIOR);
        users.add(testAthlete);
        users.add(testCoach);

        System.out.println("\n\n-------User Polymorphism/Share workout test--------");
        for (User u:users){
            System.out.println(u.shareWorkout(w1));
        }

    }

    public static void testInterface(){
        System.out.println("\n\n***** Testing Interface *****");

        // add workout for testing
        WorkoutElement e1 = new WorkoutElement(5, 100, 65, WorkoutElement.STROKE.FREESTYLE);
        WorkoutElement e2 = new WorkoutElement(5, 100, 65, WorkoutElement.STROKE.FREESTYLE, "Descend 1-5");
        WorkoutElement e3 = new WorkoutElement(400, 300, WorkoutElement.STROKE.IM, "Drill/Kick/Drill/Swim by 25");

        WorkoutSet s1 = new WorkoutSet("Meet Warm Up", WorkoutSet.SETTYPE.WARMUP, 1);
        s1.addElement(e1);
        s1.addElement(e2);
        s1.addElement(e3);

        WorkoutElement e4 = new WorkoutElement(5, 200, 100, WorkoutElement.STROKE.FREESTYLE);
        WorkoutElement e5 = new WorkoutElement(5, 500, 400, WorkoutElement.STROKE.FREESTYLE, "Descend 1-5");
        WorkoutElement e6 = new WorkoutElement(400, 300, WorkoutElement.STROKE.IM, "Drill/Kick/Drill/Swim by 25");

        WorkoutSet s2 = new WorkoutSet("Small Pre-Set", WorkoutSet.SETTYPE.PRE, 1);
        s2.addElement(e4);
        s2.addElement(e5);
        s2.addElement(e6);

        User u1 = new User("Bob", "Jones", "bjones@email.com" , "bobstrongpassword", "bjones1");
        // User u2 = new User("Billy", "Johns", "bjohns@email.com" , "billystrongpassword", "bjohns1");

        Workout w1 = new Workout("Workout 1", "This is a workout test", u1);
        w1.addSet(s1);
        w1.addSet(s2);

        ArrayList<SwimmingElement> testArray = new ArrayList<>();
        testArray.add(s1);
        testArray.add(s2);
        testArray.add(w1);

        for (SwimmingElement sE : testArray){
            System.out.println("****************");
            System.out.println(sE.calculateDistance());
            System.out.println(sE.calculateDuration());
        }
    }
}
