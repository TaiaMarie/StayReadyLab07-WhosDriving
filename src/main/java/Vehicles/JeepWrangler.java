package Vehicles;

import Driving.Car;

public class JeepWrangler extends Car 
{
    private double milesTraveled;

    public void milesTraveled(double milesTraveled)
    {
        this.milesTraveled = milesTraveled;
    }
    public double getMilesTraveled() 
    {
        return milesTraveled;
    }
    /**
     * A jeep wrangler should need an oil change every
     * 10,000 miles traveled. Once the oil is
     * changed, the car may travel another 10,000
     * miles before needing another oil change.
     *
     * @return true if an oil change is needed
     */
    @Override
    public Boolean needsOilChange()
    {   if(getMilesTraveled() == 10000)
        {
            return true;
        }
        return false;
    }

    /**
     * This method should reset any flags set
     * from when an oil change was needed. It
     * should also indicate that another 10,000
     * miles may be traveled before another oil
     * change is needed.
     */
    @Override
    public void changeOil()
    {   //set miles back to 0
        this.milesTraveled(0);
    }

    /**
     * the check engine light should be on whenever
     * something is wrong with the car. This class
     * simply turns on the light when an oil change
     * is needed.
     * @return true if anything is wrong with the car
     */
    @Override
    public Boolean checkEngineLight()
    {   
        if(needsOilChange())
        {
            return true;
        }
        return false;
    }

    /**
     * This method should return the total distance
     * traveled by the car. This number can never
     * decrease, so every time it is called the newest
     * value returned should be equal to or higher
     * than all previous values.
     * @return total distance as a Double
     */


    @Override
    public Double getDistanceTraveled()
    {
        return milesTraveled;
    }

    /**
     * Should return the top speed for a Jeep Wrangler (180 MPH)
     * @return 160.0
     */
    //@Override
    public Double getTopSpeed()
    {
        return 160.0;
    }

    /**
     * transport should calculate the time it takes in
     * seconds to travel a distance base on the top
     * speed and update the amount of miles traveled.
     *
     * @param distance - length of travel in miles
     * @return time in seconds to travel distance
     */
    //@Override
    public Integer transport(Double distance)
    {   Integer time;

        milesTraveled(getMilesTraveled() + distance);
        double result  = distance / getTopSpeed() * (60 * 60);
        time = (int) result;
        return time;
    }
}