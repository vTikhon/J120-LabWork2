package ru.avalon.vergentev.j120.labwork2;
import java.io.Serializable;
import java.util.*;

public class Data<T1, T2> extends ArrayList  implements Serializable {
    T1 key;
    T2 data;

    public Data(T1 key, T2 data) {
        this.key = key;
        this.data = data;
    }

    @Override
    public String toString() {
        return key + "=" + data + '\n';
    }


}
