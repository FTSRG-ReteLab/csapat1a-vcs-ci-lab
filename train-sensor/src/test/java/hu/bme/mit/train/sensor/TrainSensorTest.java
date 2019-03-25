package hu.bme.mit.train.sensor;


import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.user.TrainUserImpl;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TrainSensorTest {

    private TrainController controller;
    private TrainSensor sensor;
    private TrainUser user;

    @Before
    public void before() {
        controller =  new TrainControllerImpl();
        user = mock(TrainUserImpl.class);
        sensor = new TrainSensorImpl(controller, user);
        sensor.overrideSpeedLimit(50);
    }

    @Test
    public void alertState_BiggerThan500() {
        sensor.overrideSpeedLimit(540);
        verify(user, times(1)).setAlertState(true);

    }

    @Test
    public void alerState_LowerThan0() {
        sensor.overrideSpeedLimit(-3);
        verify(user, times(1)).setAlertState(true);
    }

    @Test
    public void alerState_LowerThanHalf() {
        sensor.overrideSpeedLimit((int)(controller.getReferenceSpeed()*0.5-1));
        verify(user, times(1)).setAlertState(true);
    }

    @Test
    public void alertState_everythingWorkingFine() {
        sensor.overrideSpeedLimit(100);
        verify(user, times(0)).setAlertState(true);
    }
}
