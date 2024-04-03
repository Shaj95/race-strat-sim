package race.strat;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class DataProcessor {

    DataProcessor() {

        System.out.println("DataProcessor: This class reads lap times, current tyre, laps, driver/team names from a text or csv file " +
                "(perhaps go sheet by sheet on each lap) and store the information " +
                "(maybe overwrite previous lap in the collection), 3s time delay between each reading.\n");
    }

    public void lapTimes() {

        String csvFilePath = "/Users/SaudRAlvi/Desktop/Personal Projects/Motorsports Strategy Simulation/Lap_Times.csv"; // Replace this with the actual path to your CSV file

        try (FileReader reader = new FileReader(csvFilePath);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader())) {

            for (CSVRecord csvRecord : csvParser) {
                String driver = csvRecord.get("Driver");
                String lapTime = csvRecord.get("Lap Times");
                String currentTyre = csvRecord.get("Current Tyre");


                // Process the data as needed
                System.out.println("Driver: " + driver);
                System.out.println("Lap Time: " + lapTime);
                System.out.println("Current Tyre: " + currentTyre);
                System.out.println("--------------------");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
