public class publicTransport {
    int maxPassenger;
    int nowPassenger;
    int pay;

    int totalPay;
    int Num;
    int oiling = 100;
    int speed = 0;

    int distance;
    String status;


    // 1. 버스 운행 시작시 상태를 출력하는 기능
    public void startBusStatus() {
        this.status = "운행중";
        System.out.println("|*.Alert" + this.status + "으로 상태가 변경 되었습니다.|");
    }

    // 2. 버스 운행 종료시 상태를 출력하는 기능
    public void endStatus() {
        this.status = "차고지행";
        System.out.println("|*.Alert" + this.status + "으로 상태가 변경 되었습니다.|");
    }

    // 3.주유기능
    // 주유량을 입력받아 현재 주유량을 업데이트한다.
    // 만약 주유량이 10 이하라면, 상태를 차고지행으로 변경한다.
    public void addOiling(int addOil) {
        this.oiling += addOil;
        if (oiling > 10) {
            System.out.println("|현재 주유량:" + this.oiling + "|");
        } else {
            this.status = "차고지행";
            System.out.println("|*.Alert 주유 필요|");
        }
    }

    // 4. 택시 | 시작시 주유량 확인 기능
    // 운행시작 시 주유량을 확인하여 10 이상이면 주행가능상태("일반")으로 변경한다/
    // 10이하면 탑승 불가하다.
    public void startCheckTax() {
        if (this.oiling > 10) {
            this.status = "일반";
            System.out.println("|상태:"+ this.status +"|주유량:" + this.oiling + "|");
        } else {
            this.status = "탑승 불가";
        }
    }

    // 5. 현재 주유량, 누적요금, 상태를 알려주는 기능
    // 현재 주유량이 0 이상일때는 주유량, 누적요금을 알려주고, 0 이하로 더이상 운행이 불가할때에는 상태까지 같이 보여준다.
    public void reportTax() {
        if ( this.oiling > 0) {
            System.out.println("|주유량|" + this.oiling + "|누적요금|" + this.totalPay + "|");
        } else {
            this.status = "운행불가";
            System.out.println("|주유량|" + this.oiling + "|상태|" + this.status + "|" +"|누적요금|" + this.totalPay + "|");
        }
    }

    // 6. 속도 변경 기능
    // 현재 속도 확인 및 속도를 입력받아 속도를 변경하는 기능을 한다.
    // 만약 현재 속도 보다 줄이고 싶은 속도의 수가 더 크면 Alert을 출력한다.
    public void checkSpeed(int changeSpeed) {
        if (this.oiling > 10) {
            if (this.speed + changeSpeed >= 0) {
                this.speed += changeSpeed;
                System.out.println("|속도 변경|" + changeSpeed + "|현재속도|" + this.speed + "|");
            } else {
                System.out.println("|*Alert. 0보다 더 줄일 수 없습니다.|");
            }
        } else {
            System.out.println("|*.Alert. 주유량(0)을 확인해 주세요.|");
        }
    }

    // 7.1 승객 탑승 기능(버스)
    // 승객탑승 기능은 탑승할 승객 인원을 입력받아서 잔여 좌석이 있는지, 없는지 확인한다. (max = 30)
    // 잔여 좌석이 있고, 현재 상태가 운행중이라면 nowPassenger에 탑승한 승객 수를 더한다.
    // 버스의 경우 탑승료(boarding)가 1000원이므로, 승객수 * 기본 탑승료를 곱하여 총 합계 금액을 계산한다.
    // 만일 잔여 좌석보다 신규 탑승자가 많으면 Alert을 발생시킨다.
    public void addPassenger(int addPassenger) {
        if (addPassenger + nowPassenger <= this.maxPassenger && status.equals("운행중")) {
            this.nowPassenger += addPassenger;
            int boarding = 1000;
            this.totalPay = addPassenger * boarding;
            int totalPassenger = this.maxPassenger - this.nowPassenger;
            System.out.println("|탑승 승객수:" + addPassenger + "|잔여 좌석:" + totalPassenger + "|요금 :" + this.totalPay + "|");
        } else {
            System.out.println("|*.Alert. 탑승자 초과|");
        }
    }
    // 7.2 승객 탑승 기능(택시)
    // 승객탑승 기능은 탑승할 승객 인원을 입력받아서 잔여 좌석이 있는지, 없는지 확인한다.
    // 택시는 운행요금을 계산하는 기능을 추가하였다. 입력받은 운행거리가 기본 주행거리보다 길면, 거리를 계산하여 금액을 측정한다.
    // 계산한 금액은 totalPay 변수에 넣어서 출력한다.
    public void addPassenger(int addPassenger, int distanceDriven) {
        if (addPassenger + nowPassenger < this.maxPassenger && status.equals("일반")) {
            this.status = "운행중";

            if (distanceDriven > distance) {
                int boarding = 1000;
                this.pay = 3000;
                this.pay += (distanceDriven - distance) * boarding;
                System.out.println("|탑승승객수:" + addPassenger + "|거리:"+distanceDriven+"km|"+"탑승 요금|" + this.pay+"|");
                this.totalPay += this.pay;
                this.status = "일반";
            } else {
                int boarding = 1000;
                this.pay += distanceDriven * boarding;
                System.out.println("|탑승 승객수:" + addPassenger + "|거리:"+distanceDriven+"km|"+"탑승 요금| " + this.pay+"|");
                this.totalPay += this.pay;
                this.status = "일반";
            }
        } else if (addPassenger + nowPassenger > this.maxPassenger ) {
            System.out.println("|*.Alert 최대 승객 수 초과|");
        } else {
            System.out.println("|*.Alert 탑승 불가|");
        }


    }
}
