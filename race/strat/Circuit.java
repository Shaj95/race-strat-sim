package race.strat;
import java.util.Scanner;
public class Circuit {

    String [] tracks = {"Bahrain", "Monaco", "Singapore", "Belgium", "Spain", "Zandvoort", "Las Vegas", "Brazil"};

    String [] length = {"Short", "Intermediate", "Long"};
    String [] layout = {"Low Deg", "Medium Deg", "High Deg"};

    String [] asphalt = {"Smooth", "Abrasive"};


    String [] downforce = {"Low Downforce", "Medium Downforce", "High Downforce"};

    String trackLength;
    String trackAsphalt;
    String trackLayout;
    String trackDownforce;

    Circuit() {

        System.out.println("Circuit: Track characteristics (layout, nature, length, altitude, asphalt)/temperature/evolution.\n");
    }

    public void characteristics () {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\nPlease choose a race track: " +
                    "Bahrain, Monaco, Singapore, Belgium, Spain, Zandvoort, Las Vegas, Brazil");
            String circuit = scanner.nextLine();

            switch (circuit) {
                case "Bahrain":
                    trackLength = length[1];
                    trackLayout = layout[2];
                    trackAsphalt = asphalt[1];
                    trackDownforce = downforce[1];
                    break;
                case "Monaco":
                    trackLength = length[0];
                    trackLayout = layout[0];
                    trackAsphalt = asphalt[1];
                    trackDownforce = downforce[2];
                    break;
                case "Singapore":
                    trackLength = length[2];
                    trackLayout = layout[1];
                    trackAsphalt = asphalt[1];
                    trackDownforce = downforce[2];
                    break;
                case "Belgium":
                    trackLength = length[2];
                    trackLayout = layout[2];
                    trackAsphalt = asphalt[0];
                    trackDownforce = downforce[0];
                    break;
                case "Spain":
                    trackLength = length[1];
                    trackLayout = layout[2];
                    trackAsphalt = asphalt[0];
                    trackDownforce = downforce[1];
                    break;
                case "Zandvoort":
                    trackLength = length[0];
                    trackLayout = layout[1];
                    trackAsphalt = asphalt[0];
                    trackDownforce = downforce[2];
                    break;
                case "Las Vegas":
                    trackLength = length[2];
                    trackLayout = layout[1];
                    trackAsphalt = asphalt[0];
                    trackDownforce = downforce[0];
                    break;
                case "Brazil":
                    trackLength = length[1];
                    trackLayout = layout[2];
                    trackAsphalt = asphalt[1];
                    trackDownforce = downforce[2];
                    break;

            }

        System.out.println("Track details:\n" +
                "Track: " + circuit + "\n" +
                "Length: " + trackLength + "\n" +
                "Layout: " + trackLayout + "\n" +
                "Asphalt: " + trackAsphalt + "\n" +
                "Preferred Setup: " + trackDownforce + "\n");
        }
    }



