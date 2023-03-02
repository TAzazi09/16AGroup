import java.lang.RuntimeException;

import javax.management.RuntimeErrorException;
public class Registration {
    public static void main(String FirstName, String Surname, Character Gender, Integer age, String PhoneNumber, String DoctorChosen, String Details) {
        if (FirstName.length() > 15 )
        {
            throw new RuntimeException("First name too long!")
        }
    }
}