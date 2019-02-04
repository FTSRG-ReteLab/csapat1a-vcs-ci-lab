package hu.bme.mit.train.interfaces;

public interface TrainController {

	void followSpeed();

	int getReferenceSpeed();

	int getJoystickSpeed();

	void setSpeedLimit(int speedLimit);

	void setReferenceSpeed(int referenceSpeed);

	void setJoystickPosition(int joystickPosition);
}
