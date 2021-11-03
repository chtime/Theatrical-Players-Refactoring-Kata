enum PlayType {

    TRAGEDY("tragedy", 40000),
    COMEDY("comedy", 30000),
    INVALID("", 0);

    private final String name;
    private final int baseAmount;

    PlayType(String typeString, int baseAmount) {
        this.name = typeString;
        this.baseAmount = baseAmount;
    }

    public int getBaseAmount() {
        return baseAmount;
    }

    //abstract int getBonusAmount();

    public static PlayType fromString(String type) {
        for (PlayType value : PlayType.values()) {
            if (value.name.equalsIgnoreCase(type)) {
                return value;
            }
        }
        return INVALID;
    }
}
