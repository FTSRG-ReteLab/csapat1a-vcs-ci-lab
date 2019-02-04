package hu.bme.mit.train.system;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class Tachograph {
    public static final String CurrentTime = "current_time";
    public static final String JoystickPosition = "joystick_pos";
    public static final String ReferenceSpeed = "reference_speed";

    public HashBasedTable<Integer, String, Integer> table;
    private int rowKey = 0;


    public Tachograph() {
        table = HashBasedTable.create();
    }

    public void put(int currentTime, int joy_pos, int ref_speed) {
        table.put(rowKey, CurrentTime, currentTime);
        table.put(rowKey, JoystickPosition, joy_pos);
        table.put(rowKey, ReferenceSpeed, ref_speed);
        rowKey++;
    }

}
