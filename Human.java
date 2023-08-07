import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;

public class Human {
    String birthday;
    String name;
    String surname;
    String patronymic;
    Long phoneNumber;
    Human(String name, String surname, String patronymic, Long phoneNumber, String birthday){
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Human{" +
                "birthday='" + birthday + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
    public void save() throws FileNotFoundException {
        String tempSurname = surname + ".txt";
        try(FileReader reader = new FileReader(tempSurname)){
            try(FileWriter writer = new FileWriter(tempSurname, true)){
                writer.append("Фамилия: " + surname + " Имя: " + name + " Отчество: " + patronymic + " ДР: " + birthday + " Номер телефона: " + phoneNumber + "\n");
            }
            catch(Exception e){
                System.out.println("Ошибка добавления.");
            }
        }
        catch(Exception e){
            try(FileWriter writer = new FileWriter(tempSurname)){
                writer.write("Фамилия: " + surname + " Имя: " + name + " Отчество: " + patronymic + " ДР: " + birthday + " Номер телефона: " + phoneNumber + "\n");
            }
            catch (Exception ex){
                System.out.println("Ошибка создания файла " + tempSurname);
            }
        }
        }
}
