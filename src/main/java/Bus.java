
public class Bus extends publicTransport{
    public Bus(int busNumber){
        super.status = "운행중";
        super.Num = busNumber;
        super.maxPassenger = 30;
        super.pay = 1000;
        super.nowPassenger = 0;
        System.out.println("버스가 생성되었습니다.");
    }
}
