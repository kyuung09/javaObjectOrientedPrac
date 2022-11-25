public class BusTest {
    public static void main(String[] args) {
        publicTransport aBus = new Bus(1500);

        aBus.checkSpeed(10);
        aBus.checkSpeed(-10);

        aBus.addPassenger(2);
        aBus.addOiling(-50);
        aBus.endStatus();
        aBus.addOiling(10);

        aBus.startBusStatus();
        aBus.addOiling(-55);

    }
}
