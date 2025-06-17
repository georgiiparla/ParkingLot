package lib;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;

public class ParkingSystem {
    private ParkingGarage parkingGarage;
    private double hourlyRate;
    private HashMap<Integer, LocalDateTime> timeParked = new HashMap<>();

    public ParkingSystem(ParkingGarage parkingGarage, double hourlyRate) {
        this.parkingGarage = parkingGarage;
        this.hourlyRate = hourlyRate;
    }

    public boolean parkVehicle(Driver driver) {
        boolean isParked = parkingGarage.parkVehicle(driver.getVehicle());
        if (isParked) {
            timeParked.put(driver.getId(), LocalDateTime.now());
        }
        return isParked;
    }

    public boolean removeVehicle(Driver driver) {
        LocalDateTime entryTime = timeParked.get(driver.getId());
        if (entryTime == null) {
            return false;
        }

        LocalDateTime now = LocalDateTime.now();
        long totalMinutes = Duration.between(entryTime, now).toMinutes();

        long billedHours = (totalMinutes + 59) / 60;
        driver.charge(billedHours * hourlyRate);

        timeParked.remove(driver.getId());
        return parkingGarage.removeVehicle(driver.getVehicle());
    }
}
