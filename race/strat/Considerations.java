package race.strat;

/*
 * Name: SHAJEE UR REHMAN
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/02/2024
 * File Name: Considerations.java
 * Description: This class contains all kinds of miscellaneous considerations that are involved in Race Strategy
 *
 * There can be even more coniditions added such as "expected traffic", "expected rejoin position"
 *
 * For now i kept it to some critical and interesting elements
 *
 * It passes the pit lane time loss and probability of virtual safety car to the strategy pattern for determining race strategies
 * It determines a random (reasonable) amount of pit lane time loss
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