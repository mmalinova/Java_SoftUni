package CatLady;

public class StreetExtraordinaire extends Cats{
    private double meowing;

    public StreetExtraordinaire(String catName, double specific) {
        super(catName);
        meowing = specific;
    }

    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %.2f", getName(), meowing);
    }
}
