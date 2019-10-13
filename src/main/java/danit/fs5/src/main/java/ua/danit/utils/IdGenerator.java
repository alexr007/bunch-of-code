package ua.danit.utils;

import java.util.UUID;

public class IdGenerator {
    public static Integer makeId() {
        Long uniqueID = UUID.randomUUID().getMostSignificantBits();
        uniqueID = Math.abs(uniqueID);
        while (uniqueID > Integer.MAX_VALUE) {
            uniqueID /= 10;
        }
        Integer intMy = Math.toIntExact(uniqueID);
        return  intMy;
    }

}
