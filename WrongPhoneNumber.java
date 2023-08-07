public class WrongPhoneNumber extends RuntimeException{
    public WrongPhoneNumber(){
        super("Неверный формат номера телефона.");
    }
}
