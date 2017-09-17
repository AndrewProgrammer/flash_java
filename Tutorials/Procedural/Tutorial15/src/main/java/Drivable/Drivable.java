package Drivable;

//These methods and fields are only final(const(C++))
public interface Drivable {

    double PI = 3.14;

    //public abstract int getWheel();
    int getWheel();

    void setWheels(int numWheels);

    double getSpeed();

    void setSpeed(double speed);

}
