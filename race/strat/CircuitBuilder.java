package race.strat;

/*
 * File Name: CircuitBuilder.java
 * Description: This class utilizes the Builder Pattern in connjunction with the Factory Method Pattern from CircuitFactory.
 *
 * The builder pattern 'builds' specific characteristics.
 *
 * The importance of using this is that the Circuit File is now well segmented and these attributes can be used throughout
 * the program or specific characteristics can be built easily by adding some setters.
 *
 */

public class CircuitBuilder {
    private String trackLength;
    private String trackAsphalt;
    private String trackLayout;
    private String trackDownforce;

    public CircuitBuilder setTrackLength(String trackLength) {
        this.trackLength = trackLength;
        return this;
    }

    public CircuitBuilder setTrackAsphalt(String trackAsphalt) {
        this.trackAsphalt = trackAsphalt;
        return this;
    }

    public CircuitBuilder setTrackLayout(String trackLayout) {
        this.trackLayout = trackLayout;
        return this;
    }

    public CircuitBuilder setTrackDownforce(String trackDownforce) {
        this.trackDownforce = trackDownforce;
        return this;
    }

    public Circuit build() {
        return new Circuit(trackLength, trackAsphalt, trackLayout, trackDownforce);
    }
}
