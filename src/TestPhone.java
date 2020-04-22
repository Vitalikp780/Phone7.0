//	Создать класс для объектов телефоны.
//	Характеристики телефона:
//Максимальный заряд аккамулятра
//Текущий заряд аккамулятра
//С телефона можно:
//позвонить  - тратит n зараядов из аккумулятора, где n равно количеству минут разговора.
//отправить смс – тратит 1 заряд из аккумулятора
//Если телефон разряжен, то звонки и отправку смс сделать нельзя.
//Должна быть возможность зарядить телефон на определенное текущее количество зарядов.
//Протестировть с помощью JUnit

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestPhone {
    //позвонить  - тратит n зараядов из аккумулятора, где n равно количеству минут разговора.
    @Test
    public void testCallPhone(){
        int minutes = 10;
        Phone phone = new Phone(100, 100);

        phone.callPhone(minutes);
        assertEquals(90, phone.getCurrentBatteryPower());
    }

    @Test
    public void testCallPhoneWhenBatteryZero(){
        int minutes = 10;
        Phone phone = new Phone(100, 0);

        phone.callPhone(minutes);
        assertEquals(0, phone.getCurrentBatteryPower());
    }

    @Test
    public void testSendSMS(){
        Phone phone = new Phone(100, 100);

        phone.sendSMS();
        assertEquals(99,  phone.getCurrentBatteryPower());
    }

    @Test
    public void testSendSMSWhenBatteryZero(){
        Phone phone = new Phone(100, 0);

        phone.sendSMS();
        assertEquals(0,  phone.getCurrentBatteryPower());
    }

    @Test
    public void testChargeBattery(){
        Phone phone = new Phone(100, 0);

        phone.chargeBattery(20);
        assertEquals(20, phone.getCurrentBatteryPower());
    }

    @Test
    public void testOverMaxChargeBattery(){
        Phone phone = new Phone(100, 90);

        phone.chargeBattery(20);
        assertEquals(100, phone.getCurrentBatteryPower());
    }
}
