package lib;

public class Driver {
    private int id;
    private Vehicle vehicle;
    private double paymentDue;

    public Driver(int id, Vehicle vehicle) {
        this.id = id;
        this.vehicle = vehicle;
        this.paymentDue = 0.0;
    }

    public int getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public double getPaymentDue() {
        return paymentDue;
    }

    public void charge(double amount) {
        paymentDue += amount;
    }
}
