package Crachable;

public abstract class Crashable {

    boolean carDrivable = true;

    public void youCrashed()
    {
        this.carDrivable = false;
    }

    public abstract void setCarDrivable(int carStrength);

    public abstract int getCarStrength();

    public abstract void setCarStrength(int carStrength);
}
