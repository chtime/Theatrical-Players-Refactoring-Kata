package playtype;

public class InvalidType implements PlayType {

    @Override
    public int calculateVolumeCredits(int audienceSize) {
        throw new Error("unknown type");
    }

    @Override
    public int getBaseAmount() {
        throw new Error("unknown type");
    }

    @Override
    public int getBonusAmount(int audienceSize) {
        throw new Error("unknown type");
    }
}
