package race.strat;

/*
 * File Name: CircuitFactory.java
 * Description: This class utilizes the Factory Method Pattern in connjunction with the Builder Pattern from CircuitBuilder.
 * It relies on input of the track name being inputted in the Main method to create the circuit object.
 *
 * The builder pattern then builds the specific characteristics
 *
 */

public class CircuitFactory {

    public Circuit createCircuit(String circuitType) {
        CircuitBuilder builder = new CircuitBuilder();

        switch (circuitType) {
            case "Bahrain":
                return builder.setTrackLength("Intermediate")
                        .setTrackLayout("High Deg")
                        .setTrackAsphalt("Abrasive")
                        .setTrackDownforce("Medium Downforce")
                        .build();
            case "Monaco":
                return builder.setTrackLength("Short")
                        .setTrackLayout("Low Deg")
                        .setTrackAsphalt("Abrasive")
                        .setTrackDownforce("High Downforce")
                        .build();
            case "Belgium":
                return builder.setTrackLength("Long")
                        .setTrackLayout("High Deg")
                        .setTrackAsphalt("Abrasive")
                        .setTrackDownforce("Low Downforce")
                        .build();
            default :
                throw new IllegalArgumentException("This circuit type is invalid " + circuitType);
        }
    }
}
