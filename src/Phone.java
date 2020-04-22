public class Phone implements ServicePhone{
    private int MAXIMUM_BATTERY_POWER;
    private int currentBatteryPower;

    public int getMAXIMUM_BATTERY_POWER() {
        return MAXIMUM_BATTERY_POWER;
    }

    public void setMAXIMUM_BATTERY_POWER(int MAXIMUM_BATTERY_POWER) {
        this.MAXIMUM_BATTERY_POWER = MAXIMUM_BATTERY_POWER;
    }

    public int getCurrentBatteryPower() {
        return currentBatteryPower;
    }

    public void setCurrentBatteryPower(int currentBatteryPower) {
        this.currentBatteryPower = currentBatteryPower;
    }

    public Phone() {
    }

    public Phone(int MAXIMUM_BATTERY_POWER, int currentBatteryPower) {
        this.MAXIMUM_BATTERY_POWER = MAXIMUM_BATTERY_POWER;
        this.currentBatteryPower = currentBatteryPower;
    }

    @Override
    public void callPhone(int minutes) {
        if(getCurrentBatteryPower() < 1){
            System.out.println("Недостаточно заряда для совершения звонка!");
        }else {
        setCurrentBatteryPower(getCurrentBatteryPower()-minutes);
            if(minutes == 1){
                System.out.println("Звонок продожительностью " + minutes + " минута");
                }
            if(minutes > 1 && minutes<5){
                System.out.println("Звонок продожительностью " + minutes + " минуты");
            }
            if(minutes > 5){
                System.out.println("Звонок продожительностью " + minutes + " минут");
            }

        }
    }

    @Override
    public void sendSMS() {
        if(getCurrentBatteryPower() < 1){
            System.out.println("Недостаточно заряда для отправки сообщения!");
        }else {
        setCurrentBatteryPower(getCurrentBatteryPower()-1);
            System.out.println("Сообщение отправлено!");
        }
    }

    @Override
    public void chargeBattery(int charges) {
        if(getCurrentBatteryPower() == getMAXIMUM_BATTERY_POWER()){
            System.out.println("Аккумулятор полностью заряжен!");
        }
        setCurrentBatteryPower(getCurrentBatteryPower()+charges);
        if (getCurrentBatteryPower() > getMAXIMUM_BATTERY_POWER()){
            System.out.println("Аккумулятор полностью заряжен!");
            setCurrentBatteryPower(getMAXIMUM_BATTERY_POWER());
        }else {
            System.out.println("Аккумулятор заряжен на " + getCurrentBatteryPower());
        }
    }
}
