package lib;

import java.util.ArrayList;

public class ParkingGarage {
    private ArrayList<ParkingFloor> parkingFloors = new ArrayList<ParkingFloor>();

    public ParkingGarage(int floorCount, int sportsPerFloor) {
        for (int i = 0; i < floorCount; i++) {
            parkingFloors.add(new ParkingFloor(sportsPerFloor));
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingFloor parkingFloor : parkingFloors) {
            if (parkingFloor.parkVehicle(vehicle)) {
                return true;
            }
            return false;
        }
    }

    public boolean removeVehicle(Vehicle vehicle) {
        for (ParkingFloor parkingFloor : parkingFloors) {
            if (parkingFloor.getVehicleSpots(vehicle).length > 0) {
                parkingFloor.removeVehicle(vehicle);
                return true;
            }
        }
        return false;
    }
}
