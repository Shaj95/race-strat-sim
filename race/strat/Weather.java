package race.strat;

import java.util.Random;
public class Weather {

    String [] weatherType = {"Dry", "Overcast", "Light Rain", "Heavy Rain", "Dry to Wet", "Wet to Dry"};

    Random random = new Random();
    int randomIndex = random.nextInt(weatherType.length);

    // Retrieve the element at the random index and print it
    String randomWeather = weatherType[randomIndex];

    //System.out.println("Current Weather: " + randomWeather);

    Weather() {

        System.out.println("Weather: this determines the nature of the weather system for the race.\n");

    }
        public void currentWeather() {

            System.out.println("Current Weather: " + randomWeather);

        }

        public void chanceOfRain() {

        Random random = new Random();
        int rainChance = random.nextInt(0,100);

            System.out.println("The chance of rain during this session is " + rainChance + "%");

            switch (randomWeather) {
                case "Dry" -> {
                    if (rainChance < 70) {
                        System.out.println("The session is expected to remain dry");
                    } else {
                        System.out.println("Rain expected later in the session");
                    }
                }
                case "Overcast" -> {
                    if (rainChance < 70) {
                        System.out.println("Overcast conditions expected throughout the session");
                    } else {
                        System.out.println("Rain expected later in the session");
                    }
                }
                case "Light Rain" -> {
                    if (rainChance < 70) {
                        System.out.println("Rain expected to stop later in the session");
                    } else {
                        System.out.println("Light Rain expected throughout the session");
                    }
                }
                case "Heavy Rain" -> {
                    if (rainChance < 70) {
                        System.out.println("Rain expected to stop later in the session");
                    } else {
                        System.out.println("Conditions expected to worsen throughout the session");
                    }
                }
            }

            }

        }

