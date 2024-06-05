package race.strat;

/*
 * File Name: Tyres.java
 * Description: This class contains all tyre related information and prompts the user to choose their starting tyre
 */

import java.util.Random;
import java.util.Scanner;

public class Tyres {
    private String[] tyreRange = {"C1", "C2", "C3", "C4", "C5"};
    private String[] allocation = {tyreRange[0], tyreRange[1], tyreRange[2]};
    private String currentCompound;

    public Tyres() {

        setCurrentCompound(); // used here in the initialization because it was not being accessed in the strategies
    }

    public void weekendAllocation() {
        System.out.println("The tyre allocation for this race weekend is:");
        for (int i = 0; i < allocation.length; i++) {
            System.out.println(allocation[i]);
        }
    }

    public void warmUp() {
        String[] warmUpRate = {"slow", "neutral", "fast"};
        Random random = new Random();
        int randomIndex = random.nextInt(warmUpRate.length);
        String randomWarmUpRate = warmUpRate[randomIndex];
        System.out.println("\nTyre Warm Up Rate: " + randomWarmUpRate);
    }

    private void setCurrentCompound() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWhich tyre do you prefer for these conditions?\nDry Compounds: Soft, Medium, Hard\nDamp Track: Intermediate\nWet Track: Full Wets");
        currentCompound = scanner.nextLine();
        System.out.println("You will start the race on the " + currentCompound + " compound tyre");
    }

    public String getCurrentCompound() {
        return currentCompound;
    }
}
