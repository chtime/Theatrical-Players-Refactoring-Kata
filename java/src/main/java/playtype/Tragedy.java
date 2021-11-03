package playtype;

public class Tragedy implements PlayType {
    @Override
    public int getBaseAmount() {
        return 40_000;
    }

    @Override
    public int getBonusAmount(int audienceSize) {
        int bonus = 1_000 * (audienceSize - 30);
        return (audienceSize > 30) ? bonus : 0;
    }

    public int calculateVolumeCredits(int audienceSize){
        return  Math.max(audienceSize - 30, 0);
    }

}
