public class Main {
    public static void main(String[]args){
        Phone phone = new Phone(100, 50);
        phone.callPhone(20);
        phone.sendSMS();
        phone.chargeBattery(30);
        phone.sendSMS();
        phone.callPhone(30);
    }
}
