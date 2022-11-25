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


    public void startBusStatus() {
        this.status = "운행중";
        System.out.println("|*.Alert" + this.status + "으로 상태가 변경 되었습니다.|");
    }

    public void endStatus() {
        this.status = "차고지행";
        System.out.println("|*.Alert" + this.status + "으로 상태가 변경 되었습니다.|");
    }

    public void addOiling(int addOil) {
        this.oiling += addOil;
        if (oiling > 10) {
            System.out.println("|현재 주유량:" + this.oiling + "|");
        } else {
            this.status = "차고지행";
            System.out.println("|*.Alert 주유 필요|");
        }
    }
    public void startCheckTax() {
        if (this.oiling > 10) {
            this.status = "일반";
            System.out.println("|상태:"+ this.status +"|주유량:" + this.oiling + "|");
        } else {
            this.status = "탑승 불가";
        }
    }

    public void reportTax() {
        if ( this.oiling > 0) {
            System.out.println("|주유량|" + this.oiling + "|누적요금|" + this.totalPay + "|");
        } else {
            this.status = "운행불가";
            System.out.println("|주유량|" + this.oiling + "|상태|" + this.status + "|" +"|누적요금|" + this.totalPay + "|");
        }
    }

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
    public static void main(String[] args) {
        publicTransport aTax = new Tax(2000);
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
