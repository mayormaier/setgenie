package setgenie.model;

public interface SwimmingElement {

    public abstract String calculateDuration();
    public abstract String calculateDistance();
    public abstract void updateTotals();

    // Include an interface class that contains the abstract methods to be overridden
    // Two model classes that implement the interface
    // Each class that implements the interface must provide updates to the abstract methods
    // TestHarness must include a method that is used to test the interface

}
