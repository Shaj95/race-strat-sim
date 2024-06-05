package race.strat;

/*
 * File Name: Strategies.java
 * Description: This class was originally quite clunky and contained all the strategies but has now been cleaned up with the
 * use of the Strategy Pattern and is not being used anymore in the main method.
 *
 * I have left it here to show the difference in code
 *
 * This class and its uses have been commented out of the Main method, which is now using the strategy pattern for strategies
 *
 */

public class Strategies {
    private String currentWeather;
    private String currentCompound;
    private int pitLaneTimeLoss;
    private int virtualSafetyCarChance;
    private String circuit; // include circuit variable in Strategies

    Strategies(String currentWeather, String currentCompound, int pitLaneTimeLoss, int virtualSafetyCarChance, String circuit) {
        this.currentWeather = currentWeather;
        this.currentCompound = currentCompound;
        this.pitLaneTimeLoss = pitLaneTimeLoss;
        this.virtualSafetyCarChance = virtualSafetyCarChance;
        this.circuit = circuit; //

    }

    public void startingCompound() {
        System.out.println("Strategy: Here is the recommended starting tyre:");
        System.out.println("Given that the track is " + circuit + " and the weather conditions are " + currentWeather +
                ", the recommended starting tyre is " + currentCompound);
    }

    public void targetLap() {

        System.out.println("Strategy: Here is the recommended target lap:");
        System.out.println("Given that " + currentCompound + " is the starting tyre, the recommended target lap is 9");
    }

    public void pitStopLap() {
        System.out.println("Strategy: Here is the recommended lap for your pitstop:");
        System.out.println("Given that " + currentCompound + " is the starting tyre, the pitlane time loss is " +
                pitLaneTimeLoss + "s and there is a " + virtualSafetyCarChance + "% likelihood of interruptions, " +
                "the recommended pit lap is 12");
    }
}