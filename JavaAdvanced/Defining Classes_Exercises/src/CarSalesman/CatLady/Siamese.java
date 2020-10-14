package CatLady;

public class Siamese extends Cats{
    private double earSize;

    public Siamese(String catName, double specific) {
        super(catName);
        earSize = specific;
    }

    @Override
    public String toString() {
        return String.format("Siamese %s %.2f", getName(), earSize);
    }
}
