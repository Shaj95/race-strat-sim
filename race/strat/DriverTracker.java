package race.strat;

public class DriverTracker {


    DriverTracker() {

        System.out.println("DriverTracker: will determine track position, (interval) gap between drivers after each lap," +
                " calculates anticipated total race time.\n");
    }

    public void interval() {

        String lapTime1 = "1:38.765"; // Example lap time format: minutes:seconds.milliseconds
        String lapTime2 = "1:40.123"; // Another example lap time

        double timeInSeconds1 = convertToSeconds(lapTime1);
        double timeInSeconds2 = convertToSeconds(lapTime2);

        double gapInSeconds = Math.abs(timeInSeconds2 - timeInSeconds1);
        System.out.printf("Interval: %,.3f", gapInSeconds);
        System.out.print(" seconds\n");

        }

    public static double convertToSeconds(String lapTime) {
        String[] parts = lapTime.split(":");
        int minutes = Integer.parseInt(parts[0]);

        String[] secondsAndMillis = parts[1].split("\\.");
        int seconds = Integer.parseInt(secondsAndMillis[0]);
        int milliseconds = Integer.parseInt(secondsAndMillis[1]);

        return minutes * 60 + seconds + milliseconds / 1000.0;

    }
}
