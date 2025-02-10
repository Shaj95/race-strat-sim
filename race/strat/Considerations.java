package race.strat;

/*
 * Name: SHAJEE UR REHMAN
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/02/2024
 * File Name: Considerations.java
 * Description: This class contains all kinds of miscellaneous considerations that are involved in Race Strategy
 *
 * There can be even more conditions added such as "expected traffic", "expected rejoin position"
 *
 * For now i kept it to some critical and interesting elements
 *
 * It passes the pit lane time loss and probability of virtual safety car to the strategy pattern for determining race strategies
 * It determines a random (reasonable) amount of pit lane time loss
 *
 * For now, there is a fixed target lap and pit stop lap due to the fact that i have to move to various other projects
 *
 * In future, there can be a more nuanced decision making based on various conditionals to determine the pitstop lap
 * which can be determined by a simple algorithm.
 */

import java.util.Random;

public class Considerations {
    private int pitLaneTimeLoss; // added a private variable to store pit lane time loss
    private int virtualSafetyCarChance; // added a private variable to store virtual safety car chance

    public Considerations() {

        calculatePitLaneTimeLoss(); // calculating the pit lane time loss upon object creation
        calculateVirtualSafetyCarChance(); // calculating the virtual safety car probability upon object creation
    }

    private void calculatePitLaneTimeLoss() {
        Random random = new Random();
        pitLaneTimeLoss = random.nextInt(28 - 18) + 18;
    }

    private void calculateVirtualSafetyCarChance() {
        Random random = new Random();
        virtualSafetyCarChance = random.nextInt(101);
    }

    public int getPitLaneTimeLoss() {
        return pitLaneTimeLoss;
    }

    public int getVirtualSafetyCarChance() {
        return virtualSafetyCarChance;
    }

    public void chanceOfSafetyCar() {
        Random random = new Random();
        int safetyCarChance = random.nextInt(101);
        System.out.println("\nThe likelihood of there being a safety car is " + safetyCarChance + "%");
    }

    public void chanceOfRedFlag() {
        Random random = new Random();
        int redFlagChance = random.nextInt(101);
        System.out.println("The likelihood of there being a red flag is " + redFlagChance + "%");
    }
}