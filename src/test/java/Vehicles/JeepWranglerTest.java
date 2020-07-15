package Vehicles;

import Driving.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class JeepWranglerTest 
{
    Car jeepWrangler = new JeepWrangler();

    @Before
    public void setUp() throws Exception {
        this.jeepWrangler = new JeepWrangler();
    }

    @Test
    public void needsOilChange() {
        // Arrange

        // Act
        Boolean newCivicNeedsOilChange = jeepWrangler.needsOilChange();
        // Assert
        assertFalse(newCivicNeedsOilChange);
    }

    @Test
    public void needsOilChangeAfterTravel() {
        // Arrange
        jeepWrangler.transport(10000.0);
        // Act
        Boolean needsOilAfter50kMiles = jeepWrangler.needsOilChange();
        // Assert
        assertTrue(needsOilAfter50kMiles);
    }

    @Test
    public void needsOilChangeAfterTravelThenOilChange() {
        // Arrange
        jeepWrangler.transport(10010.5);
        // Act
        jeepWrangler.changeOil();
        Boolean needsOilChangeAfterOilChange = jeepWrangler.needsOilChange();
        // Assert
        assertFalse(needsOilChangeAfterOilChange);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel49kMiles() {
        // Arrange
        jeepWrangler.transport(11000.0);
        // Act
        jeepWrangler.changeOil();
        jeepWrangler.transport(49000.0);
        Boolean oilNeedsChanging49kMiles = jeepWrangler.needsOilChange();

        // Assert
        assertFalse(oilNeedsChanging49kMiles);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel50kMiles() {
        // Arrange
        jeepWrangler.transport(11000.0);
        // Act
        jeepWrangler.changeOil();
        jeepWrangler.transport(10000.0);
        Boolean oilNeedsChanging50kMiles = jeepWrangler.needsOilChange();

        // Assert
        assertTrue(oilNeedsChanging50kMiles);
    }

    @Test
    public void checkEngineLight() {
        // Arrange
        jeepWrangler.transport(10000.0);
        // Act
        Boolean checkEngineLightIsOn = jeepWrangler.checkEngineLight();

        // Assert
        assertTrue(checkEngineLightIsOn);
    }

    @Test
    public void checkEngineLight2() {
        // Arrange
        jeepWrangler.transport(40000.0);
        // Act
        Boolean checkEngineLightIsOn = jeepWrangler.checkEngineLight();

        // Assert
        assertFalse(checkEngineLightIsOn);
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 160.0;
        // Act
        Double actual = jeepWrangler.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = 2 * 60 * 60;
        // Act
        Integer actual = jeepWrangler.transport(160.0 * 2);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveled() {
        // Arrange
        Double expected = 300.0;
        // Act
        jeepWrangler.transport(300.0);
        Double actual = jeepWrangler.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveledNewCar() {
        // Arrange
        Double expected = 0.0;
        // Act
        Double actual = jeepWrangler.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }
}