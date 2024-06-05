package race.strat;

/*
 * File Name: targetLapStrategy.java
 * Description: This class makes use of the Strategy Pattern to determine a strategy for the Targetted Pit Stop Lap
 * which is determined before the start of the race
 *
 * It implements the Strategy Interface for more detailed strategies
 */

public class TargetLapStrategy implements Strategy {
    private String currentCompound;

    public TargetLapStrategy(String currentCompound) {
        this.currentCompound = currentCompound;
    }

    @Override
    public void execute() {
        System.out.println("Strategy: Here is the recommended target lap:");
        System.out.println("Given that " + currentCompound + " is the starting tyre, the recommended target lap is 9");
    }
}
