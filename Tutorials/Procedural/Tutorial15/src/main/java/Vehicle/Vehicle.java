package Vehicle;

import Crachable.Crashable;
import Drivable.Drivable;

// Cannot use fields
public class Vehicle extends Crashable implements Drivable
{
    int numOfWheels = 2;
    double theSpeed = 0;
    int carStrength = 0;


    public int getWheels()
    {
        return this.numOfWheels;
    }

    @Override
    public int getWheel() {
        return 0;
    }

    public void setWheels(int numWheels)
    {
        this.numOfWheels = numWheels;
    }

    public double getSpeed()
    {
        return this.theSpeed;
    }

    public void setSpeed(double speed)
    {
        this.theSpeed = speed;
    }

    public Vehicle(int wheels, double speed)
    {
        this.numOfWheels = wheels;
        this.theSpeed = speed;
    }

    public void setCarDrivable(int carStrength)
    {
        this.carStrength = carStrength;
    }

    public int getCarStrength()
    {
        return this.carStrength;
    }

    public void setCarStrength(int carStrength) {
        this.carStrength = carStrength;
    }
}
