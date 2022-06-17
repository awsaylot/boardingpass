import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static boolean validName = false;
    static boolean validAge = false;
    static boolean validEmail = false;
    static boolean validPhoneNumber = false;
    static boolean validGender = false;
    public static void main(String[] args) {
        String name = askName();
        int age = askAge();
        String email = askEmail();
        String phone_number = askPhoneNumber();
        String gender = askGender();

//        System.out.println(name);
//        System.out.println(age);
//        System.out.println(email);
//        System.out.println(phone_number);
//        System.out.println(gender);

        // create new passenger
        Passenger passenger = new Passenger(name, email, phone_number, gender, age);
//        System.out.println(passenger.getAge());
//        System.out.println(passenger.getEmail());
//        System.out.println(passenger.getGender());
//        System.out.println(passenger.getName());
//        System.out.println(passenger.getPhoneNumber());
    }

    public void createAFile() {
        try {
            // set the path and create new file object
            String path = "boarding_pass.txt";
            File file = new File(path);

            // create a new file if it does not already exist
            if (file.createNewFile()) {
                System.out.println("New File Created : " + file.getName());
            } else {
                System.out.println("File Already Exists");
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    public void writeToAFile() throws IOException {
        Path boarding_pass_path = Path.of("boarding_pass.txt");
        //TODO have contents print out formatted boarding pass and information
        String content = "hello world";
        Files.writeString(boarding_pass_path, content);
    }

    public static void validNameCheck(String name) throws CustomException {
        //match for only letters and white space
        Pattern pattern = Pattern.compile("^[a-zA-Z\\\\s]*$");
        Matcher matcher = pattern.matcher(name.trim());

         if (name.isBlank()) {
             System.out.println("Blank input. Enter a name.");
             throw new CustomException();
         }
        if (matcher.matches()) {
            validName = true;
        } else {
            System.out.println("No special characters or numbers. Try again.");
            throw new CustomException();
        }
    }

    public static void validEmailCheck(String email) throws CustomException {
        // checks local and domain: letters Az-Zz and 0-9 allowed
        // underscores, dots, and hyphens allowed but...
        // no consecutive dots and no hyphens and dots at beginning and end of domain
        // for local part, maximum of 64 characters allowed
        Pattern pattern = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);

        if (email.isBlank()) {
            System.out.println("Blank input. Enter an email.");
            throw new CustomException();
        }
        if (matcher.matches()) {
            validEmail = true;
        } else {
            System.out.println("Not a valid email. Try again. ");
            throw new CustomException();
        }
    }

    public static void validPhoneNumberCheck(String phoneNumber) throws CustomException {
        // validate phone numbers of format "1234567890"
        Pattern pattern_1 = Pattern.compile("\\d{10}");
        // validating phone number with -, . or spaces
        Pattern pattern_2 = Pattern.compile("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}");

        Matcher matcher_1 = pattern_1.matcher(phoneNumber);
        Matcher matcher_2 = pattern_2.matcher(phoneNumber);

        if (phoneNumber.isBlank()) {
            System.out.println("Blank input. Enter a phone number.");
            throw new CustomException();
        }

        if (matcher_1.matches() || matcher_2.matches()) {
            validPhoneNumber = true;
        } else {
            System.out.println("Not a valid phone number. Try again.");
            System.out.println("");
            System.out.println("Accepted formats:");
            System.out.println("1234567890");
            System.out.println("123 456 7890");
            System.out.println("123-456-7890");
            System.out.println("123.456.7890");
            throw new CustomException();
        }
    }

    static void validGenderCheck(String gender) throws CustomException {
        if (gender.isBlank()) {
            System.out.println("Blank input. Enter a gender (m/f).");
        }

        if (gender.trim().equals("m") || gender.trim().equals("f")) {
            validGender = true;
        } else {
            System.out.println("Not a valid input. Try again.");
            throw new CustomException();
        }
    }

    public static String askName() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name.");
        String name = scan.nextLine();
        while (!validName) {
            try {
                validNameCheck(name);
            } catch (CustomException e) {
                name = scan.nextLine();
            }
        }
        return name;
    }

    public static int askAge() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your age.");
        int age = 0;
        while (!validAge) {
            try {
                age = scan.nextInt();
                if (age >= 0 && age <= 130) {
                    validAge = true;
                } else {
                    System.out.println("Number out of range.");
                    System.out.println("Please enter a number between 0-130.");
                    age = scan.nextInt();
                }
            } catch (InputMismatchException e) {
                System.out.println("Mismatch exception.");
                System.out.println("Please enter a number between 0-130.");
                scan.next();
            }
        }
        return age;
    }

    public static String askEmail(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your email.");
        String email = scan.nextLine();
        while (!validEmail) {
            try {
                validEmailCheck(email);
            } catch (CustomException e) {
                email = scan.nextLine();
            }
        }
        return email;
    }

    public static String askPhoneNumber(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your phone number.");
        String phone_number = scan.nextLine();
        while (!validPhoneNumber) {
            try {
                validPhoneNumberCheck(phone_number);
            } catch (CustomException e) {
                phone_number = scan.nextLine();
            }
        }
        return phone_number;
    }

    public static String askGender(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a gender (m/f).");
        String gender = scan.nextLine().toLowerCase();
        while (!validGender) {
            try {
                validGenderCheck(gender);
            } catch (CustomException e) {
                gender = scan.nextLine();
            }
        }
        return gender;
    }
}

class CustomException extends Exception {
    public CustomException() {
        // Call constructor of parent Exception
        super();
    }
}