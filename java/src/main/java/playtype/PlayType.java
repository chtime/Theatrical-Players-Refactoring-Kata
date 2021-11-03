package playtype;

public interface PlayType {
    int calculateVolumeCredits(int audienceSize);
    int getBaseAmount();
    int getBonusAmount(int audienceSize);
}
