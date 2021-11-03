package playtype;

public class Comedy implements PlayType {

    @Override
    public int getBaseAmount() {
        return 30_000;
    }

    @Override
    public int getBonusAmount(int audienceSize) {
        int base = 300 * audienceSize;
        int possibleBonus = 10_000 + 500 * (audienceSize - 20);
        return (audienceSize > 20) ? base + possibleBonus : base;
    }

    public int calculateVolumeCredits(int audienceSize){
        return (int) (Math.max(audienceSize - 30, 0) + Math.floor(audienceSize / 5));
    }
}
