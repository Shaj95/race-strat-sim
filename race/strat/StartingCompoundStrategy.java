package race.strat;

/*
 * File Name: StartingCompoundStrategy.java
 * Description: This class makes use of the Strategy Pattern to determine a strategy for the Starting Tyre for the race
 *
 * It implements the Strategy Interface for more detailed strategies
 */

public class StartingCompoundStrategy implements Strategy {
    private String currentWeather;
    private String currentCompound;
    private String circuit;

    public StartingCompoundStrategy(String currentWeather, String currentCompound, String circuit) {
        this.currentWeather = currentWeather;
        this.currentCompound = currentCompound;
        this.circuit = circuit;
    }

    @Override
    public void execute() {
        System.out.println("Strategy: Here is the recommended starting tyre:");
        System.out.println("Given that the track is " + circuit + " and the weather conditions are " + currentWeather +
                ", the recommended starting tyre is " + currentCompound);
    }
}


