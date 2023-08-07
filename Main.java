import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        boolean flag = true;
        String name = null;
        String surname = null;
        String patronymic = null;
        String birthday = null;
        Long phoneNumber = null;
        while(flag){
            System.out.println("Введите ФИО или номер телефона (11 символов) или ДР (ДД-ММ-ГГГГ): ");
            Scanner scanner = new Scanner(System.in);
            String temp = scanner.nextLine();
            if(temp.contains(" ")){
                int num = temp.indexOf(" ");
                if (temp.indexOf(" ", num + 1) != -1){
                    String[] parts = temp.split(" ");
                    name = parts[1];
                    surname = parts[0];
                    patronymic = parts[2];
                    System.out.println("ФИО принято.");
                }
                else
                    try{
                        throw new WrongNameException();
                    }
                    catch (WrongNameException e){
                        System.out.println(e.getMessage());
                }
            }
            else if(temp.contains("-")){
                int num = temp.indexOf("-");
                if(temp.indexOf("-", num + 1) != -1){
                    String[] parts = temp.split("-");
                    try{
                        int day = Integer.parseInt(parts[0]);
                        int month = Integer.parseInt(parts[1]);
                        int year = Integer.parseInt(parts[2]);
                        birthday = temp;
                        System.out.println("ДР принято.");
                    }
                    catch (Exception e){
                        System.out.println("Неверный формат ДР!");
                    }
                }
                else{
                    try{
                        throw new WrongBirthday();
                    }
                    catch (WrongBirthday e){
                        System.out.println(e.getMessage());
                    }
                }

            }
            else {
                try{
                    long tempPN = Long.parseLong(temp);
                    if(temp.length() == 11){
                        phoneNumber = tempPN;
                        System.out.println("Номер телефона принят.");
                    }
                    else{
                        try{
                            throw new WrongPhoneNumber();
                        }
                        catch (WrongPhoneNumber e){
                            System.out.println(e.getMessage());
                        }
                    }
                }
                catch (Exception e){
                    System.out.println("Невалидные данные");
                }
            }
            if(name != null && surname != null && patronymic != null && phoneNumber != null && birthday != null){
                flag = false;
            }
        }
        Human human = new Human(name, surname, patronymic, phoneNumber, birthday);
        human.save();
    }
}
