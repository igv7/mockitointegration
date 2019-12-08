package mockitointegration.reactor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import mockitointegration.reactor.Sensor;
import mockitointegration.reactor.Thermometer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ThermometerTest {

    @InjectMocks   // Instantiates Thermometer then injects Sensor mock into it
    Thermometer thermometer;

    @Mock
    Sensor sensor;

    @Test
    void testWorkingSensor() {
        thermometer.setTemperature(250.0);
        when(sensor.isBlocked()).thenReturn(false);
        assertEquals(sensor, thermometer.getSensor());
        assertEquals(250.0, thermometer.getTemperature(), 0.1);
        verify(sensor, times(1)).isBlocked();
    }

    @Test
    void testBlockedSensor() {
        thermometer.setTemperature(250.0);
        when(sensor.isBlocked()).thenReturn(true);
        assertEquals(sensor, thermometer.getSensor());
        assertThrows(RuntimeException.class, () -> thermometer.getTemperature());
        verify(sensor, times(1)).isBlocked();
    }
}
