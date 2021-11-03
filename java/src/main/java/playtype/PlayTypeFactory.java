package playtype;


public class PlayTypeFactory {

    public static PlayType typeFromString(String typeString) {
        switch (typeString) {
            case "tragedy": return new Tragedy();
            case "comedy": return new Comedy();
            default: return new InvalidType();
        }
    }
}
