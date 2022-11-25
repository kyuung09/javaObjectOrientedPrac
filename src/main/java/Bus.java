
// 버스 인스턴스 생성자
// 기본적으로 초기화 되어야할 변수들을 입력한다.
// 생성시 버스의 상태는 운행중이여야하고, 최대 승객은 30, 운행료는 1000원이다.
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
