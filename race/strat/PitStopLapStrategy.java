package race.strat;

/*
 * File Name: PitStopLapStrategy.java
 * Description: This class makes use of the Strategy Pattern to determine a strategy for the Pit Stop Lap
 * which is determined after 7 laps of the race
 *
 * It implements the Strategy Interface for more detailed strategies
 *
 */

public class PitStopLapStrategy implements Strategy {
    private String currentCompound;
    private int pitLaneTimeLoss;
    private int virtualSafetyCarChance;

    public PitStopLapStrategy(String currentCompound, int pitLaneTimeLoss, int virtualSafetyCarChance) {
        this.currentCompound = currentCompound;
        this.pitLaneTimeLoss = pitLaneTimeLoss;
        this.virtualSafetyCarChance = virtualSafetyCarChance;
    }

    @Override
    public void execute() {
        System.out.println("Strategy: Here is the recommended lap for your pitstop:");
        System.out.println("Given that " + currentCompound + " is the starting tyre, the pitlane time loss is " +
                pitLaneTimeLoss + "s and there is a " + virtualSafetyCarChance + "% likelihood of interruptions, " +
                "the recommended pit lap is 12");
    }
}
