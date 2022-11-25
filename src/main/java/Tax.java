
public class Tax extends publicTransport{
    public Tax(int taxNumber){
        super.status = "탑승불가";
        super.Num = taxNumber;
        super.maxPassenger = 5;
        super.pay = 3000;
        super.nowPassenger = 0;
        super.distance = 1;
        System.out.println("택시가 생성되었습니다.");
    }
}
