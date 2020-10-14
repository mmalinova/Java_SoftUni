package CatLady;

public class Cymric extends Cats{
    private double furLength;

    public Cymric(String catName, double specific) {
        super(catName);
        furLength = specific;
    }

    @Override
    public String toString() {
        return String.format("Cymric %s %.2f", getName(), furLength);
    }
}
