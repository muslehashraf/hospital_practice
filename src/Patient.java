public class Patient {

    public Patient(String problem, String firstName, String lastName, String dateOfBirth, boolean hasInsurance) {
        this.problem = problem;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.hasInsurance = hasInsurance;
    }

    public static final String askProblem = "What are your symptoms?";
    public static final String askFirstName = "What is your first name?";
    public static final String askLastName = "What is your last name?";
    public static final String askDateOfBirth = "What is your date of birth? (mm/dd/yyyy)";
    public static final String askDateOfBirthAgain = "Date of birth is invalid please enter a valid date? \"(mm/dd/yyyy)\"";
    public static final String askInsurance = "Do you have any insurance? (Y/N)";

    public String problem;
    private String firstName;
    private String lastName;
    private String dateOfBirth; // mm/dd/yyyy
    private boolean hasInsurance;
    public Doctor patientDoctor;

    public static Patient createPatient() {
        String problem = ScannerHelper.getString(askProblem);
        String firstName = ScannerHelper.getString(askFirstName);
        String lastName = ScannerHelper.getString(askLastName);
        String dateOfBirth = ScannerHelper.getString(askDateOfBirth);
        while (!isDateOfBirthValid(dateOfBirth)){
            dateOfBirth = ScannerHelper.getString(askDateOfBirthAgain);
        }
        boolean hasInsurance = ScannerHelper.getString(askInsurance).toUpperCase().startsWith("Y");

        return new Patient(problem, firstName, lastName, dateOfBirth, hasInsurance);
    }

    public static boolean isDateOfBirthValid(String dateOfBirth) {
        // mm/dd/yyyy
        // 1-12/1-31/1900+ - 2022
        String[] digits = dateOfBirth.split("/");

        String mm = digits[0];
        // validation for checking the characters are only digits
        for (int i = 0; i < mm.length(); i++) {
            if (!Character.isDigit(mm.charAt(i))) return false;
        }
        // validation of 1- 12
        int mmInt = Integer.parseInt(mm); // converting String into an int variable
        if (mmInt < 1 || mmInt > 12) return false;
        // validation of the length 2
        if (mm.length() != 2) return false;

        String dd = digits[1];
        // validation for checking the characters are only digits
        for (int i = 0; i < dd.length(); i++) {
            if (!Character.isDigit(dd.charAt(i))) return false;
        }
        // validation of 1- 31
        int ddInt = Integer.parseInt(dd); // converting String into an int variable
        if (ddInt < 1 || ddInt > 31) return false;
        // validation of the length 2
        if (dd.length() != 2) return false;


        String yyyy = digits[2];
        for (int i = 0; i < yyyy.length(); i++) {
            if (!Character.isDigit(yyyy.charAt(i))) return false;
        }
        int yyyyInt = Integer.parseInt(yyyy); // converting String into an int variable
        if (yyyyInt < 1900 || yyyyInt > 2022) return false;

        if (yyyy.length() != 4) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "problem='" + problem + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", hasInsurance=" + hasInsurance +
                ", patientDoctor=" + patientDoctor +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(createPatient());
    }

}