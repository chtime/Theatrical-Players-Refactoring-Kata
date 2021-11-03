public class Play {

    private final String name;
    private final PlayType type;

    public Play(String name, String type) {
        this.name = name;
        this.type = PlayType.fromString(type);
    }

    public int calculateAmount(int audienceSize) {
        if (this.type == PlayType.INVALID) {
            throw new Error("unknown type: ${play.type}");
        }

        return this.getBaseAmount() + this.getBonusAmount(audienceSize);
    }

    public int calculateVolumeCredits(int audienceSize){
        // add volume credits
        int volumeCredits = Math.max(audienceSize - 30, 0);
        // add extra credit for every ten comedy attendees
        if (this.type == PlayType.COMEDY) volumeCredits += Math.floor(audienceSize / 5);
        return volumeCredits;
    }

    public String getName() {
        return name;
    }

    private int getBaseAmount() {
        switch(this.type){
            case TRAGEDY:
                return 40_000;
            case COMEDY:
                return 30_000;
            case INVALID:
                return 0;
            default:
                throw new RuntimeException();
        }
    }

    private int getBonusAmount(int audienceSize) {
        switch(this.type) {
            case TRAGEDY:
                int bonus = 1_000 * (audienceSize - 30);
                return (audienceSize > 30) ? bonus : 0;
            case COMEDY:
                int base = 300 * audienceSize;
                int possibleBonus = 10_000 + 500 * (audienceSize - 20);
                return (audienceSize > 20) ? base + possibleBonus : base;
            default:
                return 0;
        }
    }

}
