package Vehicles;
import Driving.Bike;

public class RacingBicycle extends Bike
{
    private Integer tirePressure = 30;
    private double topSpeed = 25;
    
    /**
     * The top speed of a racing bike should be 25
     * but for every 1 PSI under the recommended tire
     * pressure the tires of the bike are, the top
     * speed should be reduced 1mph.
     *
     * @return 25 minus any reduction to top speed
     */
    //@Override
    public Double getTopSpeed() {
        return topSpeed;
    }


    /**
     * transport should calculate the time it takes in
     * seconds to travel a distance base on the top
     * speed and update the tire pressure. Long trips
     * on a mountain bike will reduce its PSI, so for
     * every 30 miles traveled in a single trip, the
     * tires of the bike should reduce 1 PSI until
     * the tires register 20 PSI where no more air
     * will be lost on trips.
     *
     * @param distance - length of travel in miles
     * @return time in seconds to travel distance
     */
    //@Override
    public Integer transport(Double distance)
    {
        Integer time = 0;
        Integer limit = 20;

        if(distance < 30)
        {   
            time = 3600;
            time = time.intValue();
            return time;
        }
        else
        {
            while(distance - 30 >= 0)
            {
                if(tirePressure > 20)
                {
                    tirePressure = tirePressure - 1;
                }
                topSpeed = topSpeed - 1;
                distance = distance - 30;
                
                time = (int) (time + distance / topSpeed);
                 time  = (int) (distance / getTopSpeed() * (60 * 60) + time);
            }
        }
    
        return time;
    }

    /**
     * Gets the current amount of pressure in PSI
     * in the tires
     *
     * @return PSI as Integer
     */
    @Override
    public Integer getTirePressure() {
         return tirePressure;
    }

    /**
     * Returns the tires to the recommended PSI
     */
    @Override
    public void inflateTires() 
    {
        recommendedTirePressure();
        topSpeed = 25;
    }

    /**
     * The Recommended PSI of a mountain bike is 30
     * @return recommended PSI
     */
    @Override
    public Integer recommendedTirePressure() {
        return tirePressure;
    }
}