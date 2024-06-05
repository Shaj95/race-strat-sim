package race.strat;

/*
 * File Name: Weather.java
 * Description: This class contains all weather related information.
 * It picks a weather system at random and also determines the chance of rain.
 *
 * There are many switch statements in this but i did not feel the need to use a design pattern here
 * since this is as far as it gets with the weather system.
 *
 */

import java.util.Random;

public class Weather {

    String[] weatherType = {"Dry", "Overcast", "Light Rain", "Heavy Rain", "Dry to Wet", "Wet to Dry"};
    String currentWeather;

    Weather() {
        setCurrentWeather(); // sets the current weather during object creation
    }

    private void setCurrentWeather() {
        Random random = new Random();
        int randomIndex = random.nextInt(weatherType.length);
        currentWeather = weatherType[randomIndex];
    }

    public void currentWeather() {
        System.out.println("\nCurrent Weather: " + currentWeather);
    }

    public String getCurrentWeather() {
        return currentWeather;
    }

    public void chanceOfRain() {
        Random random = new Random();
        int rainChance = random.nextInt(101);
        System.out.println("The chance of rain during this session is " + rainChance + "%");

        switch (currentWeather) {
            case "Dry":
                if (rainChance < 70) {
                    System.out.println("The session is expected to remain dry");
                } else {
                    System.out.println("Rain expected later in the session");
                }
                break;
            case "Overcast":
                if (rainChance < 70) {
                    System.out.println("Overcast conditions expected throughout the session");
                } else {
                    System.out.println("Rain expected later in the session");
                }
                break;
            case "Light Rain":
                if (rainChance < 70) {
                    System.out.println("Rain expected to stop later in the session");
                } else {
                    System.out.println("Light Rain expected throughout the session");
                }
                break;
            case "Heavy Rain":
                if (rainChance < 70) {
                    System.out.println("Rain expected to stop later in the session");
                } else {
                    System.out.println("Conditions expected to worsen throughout the session");
                }
                break;
        }

    }
}
