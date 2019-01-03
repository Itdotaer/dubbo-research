package com.itdotaer.basiclearn.threadsafe.chapter4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * MonitorVehicleTracker
 *
 * @author jt_hu
 * @date 2018/11/22
 */
public class MonitorVehicleTracker {

    private final Map<String, MutablePoint> locations;

    public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String, MutablePoint> getLocations() {
        return deepCopy(locations);
    }

    public synchronized MutablePoint getLocation(String id) {
        MutablePoint location = locations.get(id);
        return location == null ? null : new MutablePoint(location);
    }

    public synchronized void setLocation(String id, int x, int y) {
        MutablePoint location = locations.get(id);

        if (location == null) {
            throw new IllegalArgumentException("no such id: " + id);
        }

        location.x = x;
        location.y = y;
    }

    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> m) {
        Map<String, MutablePoint> result = new HashMap<>();

        for (String id : m.keySet()) {
            result.put(id, new MutablePoint(m.get(id)));
        }

        return Collections.unmodifiableMap(result);
    }

}
