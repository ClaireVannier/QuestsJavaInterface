public class Eagle extends Bird implements Fly {

    private boolean flying;
    private int altitude;

    public Eagle(String name) {
        super(name);
        this.flying = false;
        this.altitude = 0;
    }

    public int getAltitude() {
        return altitude;
    }

    public boolean isFlying() {
        return flying;
    }

    @Override
    public String sing() {
        return "Cri strident!";
    }

    @Override
    public void takeOff() {
        if (!this.flying && this.altitude == 0) {
            this.flying = true;
            System.out.println(this.getName() + " décolle dans le ciel.");
        }
    }

    @Override
    public void ascend(int meters) {
        if (this.flying) {
            this.altitude += meters;
            System.out.println(this.getName() + " monte à une altitude de " + this.altitude + " mètres.");
        }
    }

    @Override
    public void descend(int meters) {
        if (this.flying) {
            this.altitude = Math.max(this.altitude - meters, 0);
            System.out.println(this.getName() + " descend à une altitude de " + this.altitude + " mètres.");
        }
    }

    @Override
    public void glide() {
        if (this.flying) {
            System.out.println(this.getName() + " plane.");
        }
    }

    @Override
    public void land() {
        if (this.flying && this.altitude <= 1) {
            this.flying = false;
            System.out.println(this.getName() + " atterrit sur le sol.");
        } else {
            System.out.println(this.getName() + " est trop haut, il ne peut pas atterrir.");
        }
    }
}
