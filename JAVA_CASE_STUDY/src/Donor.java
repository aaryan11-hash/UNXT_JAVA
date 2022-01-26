public class Donor extends Person{

    private String bloodBankName;
    private String donorType;
    private String donationType;
    private String donationDate;

    public Donor(String name,String dateOfBirth,String gender,String mobileNumber,String bloodGroup,String bloodBankName,String donorType,String donationType,String donationDate){

            super(name,dateOfBirth,gender,mobileNumber,bloodGroup);
            this.bloodBankName = bloodBankName;
            this.donorType = donorType;
            this.donationType = donationType;
            this.donationDate = donationDate;

            this.inputDataCheck(name,dateOfBirth,gender,mobileNumber,bloodGroup,bloodBankName,donorType,donationType,donationDate);
    }


    //function to check the input data for the correct format
    //date will be entered the following format to be accepted : dd/mm/yyyy i.e. 11-01-2000
    //name will be entered in the following format to be acepted : firstName <space> lastName i.e. Aaryan Srivastava
    //mobile number has to be of 10 digit length and only numeric values will be accepted i.e. 8830922498
    private void inputDataCheck(String name, String dateOfBirth, String gender, String mobileNumber, String bloodGroup, String bloodBankName, String donorType, String donationType, String donationDate) {

        boolean trigger = false;

        if(!dateOfBirth.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}")){
            System.out.println("Date Pattern does not match, refer to the correct format!!!");
            trigger = true;
        }
        if(!mobileNumber.matches("[0-9]{10}")) {
            System.out.println("Phone number has to be of 10 digits!!");
            trigger = true;
        }
        if(!donationDate.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}")) {
            System.out.println("Donation date pattern does not match!!!");
            trigger = true;
        }
        if(!name.matches("[a-zA-z.]{1,25} [a-zA-z]{1,25}")){
            System.out.println("Enter valid firstName and lastName");
            trigger = true;
        }

        //todo gender regexp is not working properly, need to fix it..
//        if(!name.toLowerCase().matches("(male|female|other|none|na|m|f)")){
//            System.out.println("Please enter appropriate Gender");
//            trigger = true;
//        }

        if(trigger) {
            System.exit(0);
        }


    }


    public void displayDonationDetails(){
        System.out.println("""
                Donation Details:
                Name :  """ + this.getName() +
                """
                \nDate Of Birth :  """ + this.getDateOfBirth() +
                """
                \nGender :  """ + this.getGender() +
                """
                \nMobile Number : """ + this.getMobileNumber() +
                """
                \nBlood Group :  """ + this.getBloodGroup() +
                """
                \nBlood Bank Type :  """ + this.getBloodBankName() +
                """
                \nDonor Type :  """ + this.getDonorType() +
                """
                \nDonation Date :  """ + this.getDonationDate()
        );
    }


    public String getBloodBankName() {
        return bloodBankName;
    }

    public String getDonorType() {
        return donorType;
    }

    public String getDonationType() {
        return donationType;
    }

    public void setBloodBankName(String bloodBankName) {
        this.bloodBankName = bloodBankName;
    }

    public void setDonorType(String donorType) {
        this.donorType = donorType;
    }

    public void setDonationType(String donationType) {
        this.donationType = donationType;
    }

    public String getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(String donationDate) {
        this.donationDate = donationDate;
    }
}
