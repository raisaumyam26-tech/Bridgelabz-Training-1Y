public class Main {
    public static void main(String[] args) {
        Driver myDriver = new Driver("D1204", "Kavita Nair");
        Delivery c1 = new Delivery("C1", "Warehouse A", 30.0, 60.0, 70.0);
        FuelCp c2 = new FuelCp("C2", "Pump 12", 20.0, 15.0, 15.0);
        RestCheckpoint c3 = new RestCheckpoint("C3", "Motel X", 50.0, 60.0, 95.0);
        Delivery c4 = new Delivery("C4", "Client Hub", 20.0, 45.0, 60.0);
        myDriver.routeHistory.addCheckpoint(c1);
        myDriver.routeHistory.addCheckpoint(c2);
        myDriver.routeHistory.addCheckpoint(c3);
        myDriver.routeHistory.addCheckpoint(c4);
        myDriver.printSummary();
    }
}