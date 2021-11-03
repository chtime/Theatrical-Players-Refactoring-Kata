import playtype.PlayType;
import playtype.PlayTypeFactory;

public class Play {

    private final String name;
    private final PlayType type;

    public Play(String name, String type) {
        this.name = name;
        this.type = PlayTypeFactory.typeFromString(type);
    }

    public int calculateAmount(int audienceSize) {
        return this.getBaseAmount() + this.getBonusAmount(audienceSize);
    }

    public int calculateVolumeCredits(int audienceSize){
        return this.type.calculateVolumeCredits(audienceSize);
    }

    public String getName() {
        return name;
    }

    private int getBaseAmount() {
        return this.type.getBaseAmount();
    }

    private int getBonusAmount(int audienceSize) {
        return this.type.getBonusAmount(audienceSize);
    }

}
