public class Penguin extends Bird implements Swim {

    private boolean swimming;
    private int depths;

    public Penguin(String name) {
        super(name);
        this.swimming = false;
        this.depths = 0;
    }

    @Override
    public String sing() {
        return "Coin coin!";
    }

    public int getDepths() {
        return depths;
    }

    public boolean isSwimming() {
        return swimming;
    }

    /**
     * plonge, doit être au sol
     */
    @Override
    public void dive() {
        if (!this.swimming && this.depths == 0) {
            this.swimming = true;
            System.out.println(this.getName() + " plonge dans l'eau.");
        }
    }

    /**
     * nage vers le fond
     * @param meters augmentation de la profondeur
     * @return profondeur
     */
    @Override
    public int swimDown(int meters) {
        if (this.swimming) {
            this.depths = Math.min(this.depths + meters, 325);
            System.out.println(this.getName() + " nage vers le fond, profondeur : " + this.depths + " mètres.");
        }
        return this.depths;
    }

    /**
     * nage vers la surface
     * @param meters diminution de la profondeur
     * @return profondeur
     */
    @Override
    public int swimUp(int meters) {
        if (this.swimming) {
            this.depths = Math.max(this.depths - meters, 0);
            System.out.println(this.getName() + " nage vers la surface, profondeur : " + this.depths + " mètres.");
        }
        return this.depths;
    }

    /**
     * sort de l'eau, doit être à la surface
     */
    @Override
    public void getOut() {
        if (this.swimming && this.depths == 0) {
            System.out.println(this.getName() + " sort de l'eau.");
        } else {
            System.out.println(this.getName() + " est trop profond, il ne peut pas sortir.");
        }
    }
}
