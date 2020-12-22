package viceCity.models.guns;

public class Rifle extends BaseGun{
    public Rifle(String name) {
        super(name, 50, 500);
    }

    @Override
    public int fire() {
        //The rifle can shoot with 5 bullets.
        if (this.getBulletsPerBarrel() <= 0) {
            this.reload();
        }
        return this.decreaseBullets(5);
    }
}
