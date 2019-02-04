package hu.bme.mit.train.system;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class Tachograph {
    public HashBasedTable<Integer, String, Integer> table;
    private int rowKey = 0;


    public Tachograph() {
        table = HashBasedTable.create();
    }

    public void put(String column, int value) {
        table.put(rowKey++, column, value);
    }

}
