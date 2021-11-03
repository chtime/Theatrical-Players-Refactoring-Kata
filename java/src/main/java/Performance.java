public class Performance {

    private final Play play;

    private final int audience;

    public Performance(Play play, int audience) {
        this.play = play;
        this.audience = audience;
    }

    public int getAudienceSize() {
        return audience;
    }

    public int getAmount() {
        return this.play.calculateAmount(this.audience);
    }

    public int getVolumeCredits() {
        return this.play.calculateVolumeCredits(this.audience);
    }

    public String getPlayName() {
        return this.play.getName();
    }
}
