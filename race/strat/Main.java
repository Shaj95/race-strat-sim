package race.strat;

/*
 * File Name: Main.java
 * Description: This class runs the overall program.
 * It starts by playing an F1 car sound
 * Then it calls several classes and the Circuit Name is inputted as a parameter
 * It then simulates the first 7 laps of the race by showing the laptimes getting degraded every lap
 * it then shows the recommended lap to pit
 *
 * The several throws clauses are because of the audio file usage
 */

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main (String[] args) throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {

        File file = new File("F1V10.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();

        System.out.println("Welcome to the Race Strategy Simulator App\n");

        // Circuit information created here
        // In the GUI, this would be a drop-down selection of multiple circuits instead of a hard-coded input here
        CircuitFactory circuitFactory = new CircuitFactory();

        Circuit monacoCircuit = circuitFactory.createCircuit("Monaco");
        System.out.println("Monaco Circuit Details:");
        System.out.println("Length: " + monacoCircuit.getTrackLength());
        System.out.println("Layout: " + monacoCircuit.getTrackLayout());
        System.out.println("Asphalt: " + monacoCircuit.getTrackAsphalt());
        System.out.println("Preferred Setup: " + monacoCircuit.getTrackDownforce());

        // Weather System
        Weather weather = new Weather();
        String currentWeather = weather.getCurrentWeather();
        weather.currentWeather();
        weather.chanceOfRain();

        // Tyre Info
        Tyres tyres = new Tyres();
        tyres.warmUp();
        tyres.weekendAllocation();

        // calls the data processor class which reads lap 1 data from a csv file and populates lists of each data that can be used
        DataProcessor dataProcessor = new DataProcessor();

        // Pit lane and other consideration in strategic calls
        Considerations considerations = new Considerations();
        int pitLaneTimeLoss = considerations.getPitLaneTimeLoss();
        int virtualSafetyCarChance = considerations.getVirtualSafetyCarChance();
        System.out.println("The pitlane time loss for this track is " + considerations.getPitLaneTimeLoss() + "s");

        // Executing the strategy models
        // These are currently basic conditionals, but they can be enhanced to take more nuanced information
        String currentCompound = tyres.getCurrentCompound();
        Strategy targetLapStrategy = new TargetLapStrategy(currentCompound);
        Strategy pitStopLapStrategy = new PitStopLapStrategy(currentCompound, pitLaneTimeLoss, virtualSafetyCarChance);
        Strategy startingCompoundStrategy = new StartingCompoundStrategy(currentWeather, currentCompound, "Monaco");
        startingCompoundStrategy.execute();
        targetLapStrategy.execute();

        // Calls the generate laps class which utilizes the lists populated by Data Processor
        // and generates subsequent laps based on Degradation
        GenerateLaps generateLaps = new GenerateLaps();

        System.out.println("\nWaiting for lap to complete...");
        Thread.sleep(10000); // 10 second delay to simulate lap 1 completion

        System.out.println("Lap 1");
        dataProcessor.lapTimes();

        // this for loop executes the laptimes and degradation for 7 laps
        // it starts at lap 2 which is the first of the generated laps based on degradation
        // the lap counter can be increased to 56 laps for a full race distance
        for (int lapCounter = 2; lapCounter <= 7; lapCounter++) {

            Thread.sleep(5000); // 5 second delay to simulate waiting for each lap to complete
            System.out.println("\nWaiting for lap to complete...");
            System.out.println("\nLap " + lapCounter + ":");
            generateLaps.generateAndProcessLapTimes(dataProcessor.getLapTimesList(), dataProcessor.getDriverNamesList(), dataProcessor.getCurrentTyreList());
        }

        // Safety Cars and other interruptions
        considerations.chanceOfSafetyCar();
        System.out.println("The likelihood of there being a virtual safety car is " + considerations.getVirtualSafetyCarChance() + "%");
        considerations.chanceOfRedFlag();
        pitStopLapStrategy.execute();

    }
}
