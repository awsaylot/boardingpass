import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //TODO add input validation and exception checks
        System.out.println("Enter your name.");
        String name = scan.nextLine();

        System.out.println("Enter your age.");
        int age = scan.nextInt();

        System.out.println("Enter your email.");
        String email = scan.nextLine();

        System.out.println("Enter your phone number.");
        String phone = scan.nextLine();

        System.out.println("Enter your gender.");
        String gender = scan.nextLine();

        // create new passenger
        Passenger passenger = new Passenger(name, email, phone, gender, age);
//        System.out.println(passenger.getAge());
//        System.out.println(passenger.getEmail());
//        System.out.println(passenger.getGender());
//        System.out.println(passenger.getName());
//        System.out.println(passenger.getPhoneNumber());

        System.out.println("Enter your destination.");
        String dest = scan.nextLine();

        System.out.println("Enter your departure time");
        int depart = scan.nextInt();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime date = LocalDateTime.now();

        BoardingTicket boardingTicket = new BoardingTicket(date.toString(), "ATLANTA", dest, depart, passenger);

        createAFile();
    }



    public static void createAFile() {
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

    public void writeToAFile(BoardingTicket boardingTicket, Passenger passenger) throws IOException {
        Path boarding_pass_path = Path.of("boarding_pass.txt");
        //TODO have contents print out formatted boarding pass and information
        String content = "hello world";
        Files.writeString(boarding_pass_path, content);
    }
}