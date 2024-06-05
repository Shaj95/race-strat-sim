package race.strat;

/*
 * File Name: DataProcessor.java
 * Description: This class uses the csv external libraries and reads from a csv file to populate a list of laptimes, drivernames
 * and current tyres
 * It then prints these for lap 1 of the race.
 *
 * The aforementioned lists are then being used in the GenerateLaps file which further utilizes them to print the subsequent laps
 *
 */

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class DataProcessor {

    private ArrayList<String> lapTimesList;
    private ArrayList<String> driverNamesList;
    private ArrayList<String> currentTyreList;
    private Degradation degradation;

    DataProcessor() {

        lapTimesList = new ArrayList<>();
        driverNamesList = new ArrayList<>();
        currentTyreList = new ArrayList<>();
    }

    public void lapTimes() {

        String csvFilePath = "Lap_Times.csv";

        try (FileReader reader = new FileReader(csvFilePath);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader())) {

            for (CSVRecord csvRecord : csvParser) {

                String lapTime = csvRecord.get("Lap Times");
                lapTimesList.add(lapTime); // adding the lap time to an ArrayList 'lapTimesList'

                String driver = csvRecord.get("Driver");
                driverNamesList.add(driver);

                String currentTyre = csvRecord.get("Current Tyre");
                currentTyreList.add(currentTyre);


                System.out.printf("%-20s %-20s %-20s%n", driver, lapTime, currentTyre);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getLapTimesList() {return lapTimesList;}

    public ArrayList<String> getDriverNamesList() {return driverNamesList;}

    public ArrayList<String> getCurrentTyreList() {return currentTyreList;}

}
