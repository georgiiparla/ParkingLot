package lib;

import java.util.HashMap;

public class ParkingFloor {
    private int[] spots;

    private HashMap<Vehicle, int[]> vehicleMap = new HashMap<Vehicle, int[]>();

    public ParkingFloor(int spotCount) {
        spots = new int[spotCount];
    }

    public boolean parkVehicle(Vehicle vehicle) {
        int size = vehicle.getSpotSize();
        int l = 0;
        int r = 0;
        while (r < spots.length) {
            if (spots[r] != 0) {
                l = r + 1;
            }
            if (r - l + 1 == size) {
                for (int k = l; k < r + 1; k++) {
                    spots[k] = 1;
                }
                vehicleMap.put(vehicle, new int[] { l, r });
                return true;
            }
            r++;
        }
        return false;
    }

    public void removeVehicle(Vehicle vehicle) {
        int start = vehicleMap.get(vehicle)[0];
        int end = vehicleMap.get(vehicle)[1];
        for (int i = start; i < end + 1; i++) {
            spots[i] = 0;
        }
        vehicleMap.remove(vehicle);
    }

    public int[] getParkingSpots() {
        return spots;
    }

    public int[] getVehicleSpots(Vehicle vehicle) {
        return vehicleMap.get(vehicle);
    }
}
