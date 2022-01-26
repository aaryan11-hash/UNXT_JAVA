import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

       String name,dob,gender,mobileNumber,bloodGroup,bloodBankName,donorType,donationType = "",donationDate = "";
       Scanner sc = new Scanner(System.in);

       System.out.println("Enter the name:");
       name = sc.nextLine();
       System.out.println("Enter Date of birth");
       dob = sc.nextLine();
       System.out.println("Enter Gender");
       gender = sc.nextLine();
       System.out.println("Enter Mobile Number");
       mobileNumber = sc.nextLine();
       System.out.println("Enter Blood Group");
       bloodGroup = sc.nextLine();
       System.out.println("Enter Blood Bank Name");
       bloodBankName = sc.nextLine();
       System.out.println("Enter Donor Type");
       donorType = sc.nextLine();
       System.out.println("Enter Donation Type");
       donationType = sc.nextLine();
       System.out.println("Enter Donation Date");
       donationDate = sc.nextLine();

       Donor sampleDonor = new Donor(name,dob,gender,mobileNumber,bloodGroup,bloodBankName,donorType,donationType,donationDate);

       sampleDonor.displayDonationDetails();
    }
}



