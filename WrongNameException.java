public class WrongNameException extends RuntimeException{
    public WrongNameException(){
        super("Формат ФИО неверен");
    }
}
