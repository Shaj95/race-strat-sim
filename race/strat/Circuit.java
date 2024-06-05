package race.strat;

/*
 * File Name: Circuit.java
 * Description: This class contains circuit characteristics and works in conjunction with the CircuitFactory and CircuitBuilder.
 * This class originally had several switch statements and clunky code before the Factory and Builder Patterns were applied
 *
 */

public class Circuit {
    private final String trackLength;
    private final String trackAsphalt;
    private final String trackLayout;
    private final String trackDownforce;

    public Circuit(String trackLength, String trackAsphalt, String trackLayout, String trackDownforce) {
        this.trackLength = trackLength;
        this.trackAsphalt = trackAsphalt;
        this.trackLayout = trackLayout;
        this.trackDownforce = trackDownforce;
    }

    public String getTrackLength() {
        return trackLength;
    }

    public String getTrackAsphalt() {
        return trackAsphalt;
    }

    public String getTrackLayout() {
        return trackLayout;
    }

    public String getTrackDownforce() {
        return trackDownforce;
    }
}