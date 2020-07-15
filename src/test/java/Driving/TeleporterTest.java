package Driving;

import org.junit.Test;
import static org.junit.Assert.*;

public class TeleporterTest
{
    @Test
    public void getTopSpeedTest()
    {
        //given
        Double maxVal = Double.MAX_VALUE;

        //when
        Teleporter tele = new Teleporter();
        Double maxSpeed = tele.getTopSpeed();

        //then
        assertEquals(maxVal, maxSpeed);
    }

    @Test
    public void transportTest()
    {
        //given
        int  ans = 0;

        //when
        Teleporter tele = new Teleporter();
        int res = tele.transport(100000.0);
    }
}