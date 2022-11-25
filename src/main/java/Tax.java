
// 택시 인스턴스 생성자
// 기본적으로 초기화 되어야할 변수들을 입력한다.
// 생성시 택시의 상태는 탑승불가상태여야하고, 최대 승객은 5, 기본운행료는 3000원이다.
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
