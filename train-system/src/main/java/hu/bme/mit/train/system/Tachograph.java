package hu.bme.mit.train.system;

import com.google.common.collect.HashBasedTable;

public class Tachograph {
    public static final String CurrentTime = "current_time";
    public static final String JoystickPosition = "joystick_pos";
    public static final String ReferenceSpeed = "reference_speed";

    public HashBasedTable<Integer, String, Integer> table;
    private int rowKey = 0;


    public Tachograph() {
        table = HashBasedTable.create();
    }

    public void put(int currentTime, int joyPos, int refSpeed) {
        table.put(rowKey, CurrentTime, currentTime);
        table.put(rowKey, JoystickPosition, joyPos);
        table.put(rowKey, ReferenceSpeed, refSpeed);
        rowKey++;
    }

}
