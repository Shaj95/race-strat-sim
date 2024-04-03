package race.strat;

import java.util.Random;
public class Tyres {

    String [] tyreRange = {"C1","C2", "C3", "C4", "C5"};
    String [] allocation = {tyreRange[0], tyreRange[1], tyreRange[2]};

    Tyres() {

        System.out.println("Tyres: all the information and dynamics surrounding the " +
                "Tyres (warm up, compound, longevity, delta, offset).\n");
    }

    void weekendAllocation() {

        System.out.println("The tyre allocation for this race weekend is:");
        for (int i = 0; i < allocation.length; i++) {
            System.out.println(allocation[i]);
        }

    }

    void warmUp() {

        String [] warmUpRate = {"slow", "neutral", "fast"};
        Random random = new Random();
        int randomIndex = random.nextInt(warmUpRate.length);

        // Retrieve the element at the random index and print it
        String randomWarmUpRate = warmUpRate[randomIndex];

        System.out.println("\nTyre Warm Up Rate: " + randomWarmUpRate);
    }

    void currentCompound() {

        String [] compound = {"Soft", "Medium", "Hard", "intermediate", "wet"};
        Random random = new Random();
        int randomIndex = random.nextInt(compound.length);

        // Retrieve the element at the random index and print it
        String randomCompound = compound[randomIndex];

        System.out.println("Current Tyre Compound: " + randomCompound);


    }
}
