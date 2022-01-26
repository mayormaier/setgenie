public class ModelClasses {

    public static void main(String[] args) {
        WorkoutElement e1 = new WorkoutElement(5, 100, 65, WorkoutElement.STROKE.FREESTYLE);
        System.out.println(e1.toString());

        WorkoutElement e2 = new WorkoutElement(5, 100, 65, WorkoutElement.STROKE.FREESTYLE, "Descend 1-5");
        System.out.println(e2.toString());

        WorkoutElement e3 = new WorkoutElement(400, 300, WorkoutElement.STROKE.IM, "Drill/Kick/Drill/Swim by 25");

        WorkoutSet warm = new WorkoutSet("Meet Warm Up", WorkoutSet.SETTYPE.WARMUP, 1);
        warm.addElement(e1);
        warm.addElement(e3);
        System.out.println(warm.toString());

        User andrew = new User("Andrew", "Maier", "andrewswim13@gmail.com", "hello123", "mayormaier");

        Workout day1 = new Workout("My Daily Workout", andrew);

        day1.addSet(warm);

        System.out.println(day1.toString());
    }
}
