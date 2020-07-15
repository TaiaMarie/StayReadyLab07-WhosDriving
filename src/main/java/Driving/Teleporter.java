package Driving;

public class Teleporter implements Drivable
{
    private final double maxSpeed = Double.MAX_VALUE;

    public Teleporter()
    {

    }

    public Double getTopSpeed()
    {
        return maxSpeed;
    }

    public Integer transport(Double distance)
    {
        return 0;
    }
}