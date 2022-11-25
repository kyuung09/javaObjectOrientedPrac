public class TaxTest {
    public static void main(String[] args) {
        publicTransport aTax = new Tax(2000);
        publicTransport bTax = new Tax(2000);

        aTax.startCheckTax();
        aTax.addPassenger(2,2);
        aTax.addOiling(-80);
        aTax.reportTax();
        aTax.addPassenger(5,2);
        aTax.addPassenger(3,12);
        aTax.addOiling(-20);
        aTax.reportTax();
    }
}
