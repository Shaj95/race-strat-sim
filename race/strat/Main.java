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

        DataProcessor dataProcessor = new DataProcessor();
        Weather weather = new Weather();
        CircuitFactory circuitFactory = new CircuitFactory();

        Circuit monacoCircuit = circuitFactory.createCircuit("Monaco");
        System.out.println("Monaco Circuit Details:");
        System.out.println("Length: " + monacoCircuit.getTrackLength());
        System.out.println("Layout: " + monacoCircuit.getTrackLayout());
        System.out.println("Asphalt: " + monacoCircuit.getTrackAsphalt());
        System.out.println("Preferred Setup: " + monacoCircuit.getTrackDownforce());

        //Circuit circuit = new Circuit();
        Considerations considerations = new Considerations();
        GenerateLaps generateLaps = new GenerateLaps();
        String currentWeather = weather.getCurrentWeather();

        int pitLaneTimeLoss = considerations.getPitLaneTimeLoss();
        int virtualSafetyCarChance = considerations.getVirtualSafetyCarChance();

        //String circuitName = circuit.characteristics();
        System.out.println("The pitlane time loss for this track is " + considerations.getPitLaneTimeLoss() + "s");
        weather.currentWeather();
        weather.chanceOfRain();
        Tyres tyres = new Tyres();
        tyres.warmUp();
        tyres.weekendAllocation();
        String currentCompound = tyres.getCurrentCompound();
        // Strategies strategies = new Strategies(currentWeather, currentCompound, pitLaneTimeLoss, virtualSafetyCarChance, "Bahrain");
        Strategy targetLapStrategy = new TargetLapStrategy(currentCompound);
        Strategy pitStopLapStrategy = new PitStopLapStrategy(currentCompound, pitLaneTimeLoss, virtualSafetyCarChance);
        Strategy startingCompoundStrategy = new StartingCompoundStrategy(currentWeather, currentCompound, "Monaco");
        startingCompoundStrategy.execute();
        targetLapStrategy.execute();
        // pitStopLapStrategy.execute();

        //strategies.startingCompound();

        Degradation degradation = Degradation.getInstance();
        //strategies.targetLap();

        System.out.println("The expected laptime degradation is: " + degradation.getTyreDeg() + "s per lap");

        System.out.println("\nWaiting for lap to complete...");
        Thread.sleep(10000); // 10 second delay

        System.out.println("Lap 1");
        dataProcessor.lapTimes();

        // this for loop executes the laptimes and degradation for 7 laps
        for (int lapCounter = 2; lapCounter <= 7; lapCounter++) {

            Thread.sleep(5000); // 5 second delay
            System.out.println("\nWaiting for lap to complete...");
            System.out.println("\nLap " + lapCounter + ":");
            generateLaps.generateAndProcessLapTimes(dataProcessor.getLapTimesList(), dataProcessor.getDriverNamesList(), dataProcessor.getCurrentTyreList());
        }

        considerations.chanceOfSafetyCar();
        System.out.println("The likelihood of there being a virtual safety car is " + considerations.getVirtualSafetyCarChance() + "%");
        considerations.chanceOfRedFlag();
        pitStopLapStrategy.execute();
        // strategies.pitStopLap();

    }
}
