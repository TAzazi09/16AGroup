public class Registration {
    public static void main(String FirstName, String Surname, String Gender, Integer Age, String PhoneNumber, String DoctorChosen, String Details) {
        if (FirstName.length() > 15 )
        {
            throw new RuntimeException("First name too long!");
        }
        else if (Surname.length() > 15 )
        {
            throw new RuntimeException("Surname too long!");
        }
        else if (Age > 120 )
        {
            throw new RuntimeException("Invalid age!");
        }
        else if (Age < 18 )
        {
            throw new RuntimeException("You need to be 18 to register!");
        }
        else if (!PhoneNumber.matches("\\d{5} \\d{6}"))
        {
            throw new RuntimeException("Invalid phone number");
        }
        // else if (DoctorChosen.length() > 15 )
        // {
        //     throw new RuntimeException("First name too long!")
        // }
        else if (Details.length() > 100 )
        {
            throw new RuntimeException("First name too long!");
        }

        System.out.println("Correct! Sending data!");
    }
}