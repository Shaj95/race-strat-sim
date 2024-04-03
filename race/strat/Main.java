package race.strat;

public class Main {

    public static void main (String[] args) {

        System.out.println("Welcome to the Race Strategy Simulator App\n");

        DataProcessor dataProcessor = new DataProcessor();
        DriverTracker driverTracker = new DriverTracker();
        Weather weather = new Weather();
        Tyres tyres = new Tyres();
        Circuit circuit = new Circuit();
       //Degradation degradation = new Degradation();
        //Considerations considerations = new Considerations();
       // GenerateLaps generateLaps = new GenerateLaps();
        //Strategies strategies = new Strategies();

        /*
        weather.currentWeather();
        weather.chanceOfRain();
        tyres.warmUp();
        tyres.weekendAllocation();
        tyres.currentCompound();
        circuit.characteristics();

         */

        dataProcessor.lapTimes();
        driverTracker.interval();

    }
}
