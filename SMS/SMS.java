import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

class SMS { 
    public String name;
    public String DOB;
    public int age;
    public String regNo;
    public String branch;
    public String mail;
    private int admissionYear;
    private int curentYear;
    private int pursuingYear;
    private String doing;
    public String fullNameOfBranch;

    LocalDate curr = LocalDate.now();
    String currDate = curr.toString();

    private static int itSeq = 1, cseSeq = 1, ceSeq = 1, meSeq = 1;
    private static int eceSeq = 1, eeSeq = 1, ttSeq = 1, cheSeq = 1, otherSeq = 1;

    private static SMS[] students = new SMS[100]; 
    private static int studentCount = 0;         

    void setName(String name) {
        this.name = name;
    }

    void setDOB(String DOB) {
        this.DOB = DOB;
    }

    void setAge(String DOB) {
        try {
            LocalDate birthDate = LocalDate.parse(DOB);
            int birthYear = birthDate.getYear();
            int currentYear = LocalDate.now().getYear();
            age = currentYear - birthYear;
        } catch (DateTimeParseException e) {
            System.out.println("Error parsing DOB: " + DOB);
            age = 0; 
        }
    }

    void setAdmissionYear(int admissionYear) {
        this.admissionYear = admissionYear;
    }

    void setBranch(String branch) {
        if (branch.startsWith("DSY ")) {
            branch = branch.replace("DSY ", ""); 
            pursuingYear = 1; 
        } 

        switch (branch.toLowerCase()) {
            case "information technology": this.branch = "IT"; break;
            case "computer science": this.branch = "CSE"; break;
            case "mechanical engineering": this.branch = "ME"; break;
            case "electrical engineering": this.branch = "EE"; break;
            case "civil engineering": this.branch = "CE"; break;
            case "electronics and telecommunication": this.branch = "ECE"; break;
            case "textile engineering": this.branch = "TT"; break;
            case "chemical engineering": this.branch = "Che"; break;
            default: 
                System.out.println("Invalid Branch: " + branch);
                this.branch = "Unknown"; 
        }

        curentYear = Integer.parseInt(currDate.substring(0, 4));
        pursuingYear = curentYear - admissionYear;
    }

    void setMail(String regNo) {
        mail = regNo + "@sggs.ac.in";
    }

    SMS(String[] array) { 
        for (String field : array) {
            if (!field.contains("=")) {
                System.out.println("Invalid field format: " + field);
                continue;
            }

            String[] pair = field.split("=");

            if (pair.length != 2) {
                System.out.println("Invalid key-value pair: " + field);
                continue;
            }

            String key = pair[0].trim();
            String value = pair[1].trim();

            switch (key) {
                case "Name": setName(value); break;
                case "DOB": setDOB(value); setAge(value); break;
                case "AdmissionYear": setAdmissionYear(Integer.parseInt(value)); break;
                case "Branch": fullNameOfBranch = value; setBranch(value); break;
                default: System.out.println("Unknown key: " + key);
            }
        }

        curentYear = LocalDate.now().getYear();
        pursuingYear = curentYear - admissionYear;

        if (pursuingYear > 0 && pursuingYear < 5) { 
            doing = "B.Tech in " + fullNameOfBranch;
            if (branch.equalsIgnoreCase("IT")) {
                regNo = admissionYear + "BIT" + String.format("%03d", itSeq++);
            } else if (branch.equalsIgnoreCase("CE")) {
                regNo = admissionYear + "BCE" + String.format("%03d", ceSeq++);
            } else if (branch.equalsIgnoreCase("CSE")) {
                regNo = admissionYear + "BCS" + String.format("%03d", cseSeq++);
            } else if (branch.equalsIgnoreCase("ME")) {
                regNo = admissionYear + "BME" + String.format("%03d", meSeq++);
            } else if (branch.equalsIgnoreCase("EE")) {
                regNo = admissionYear + "BEE" + String.format("%03d", eeSeq++);
            } else if (branch.equalsIgnoreCase("ECE")) {
                regNo = admissionYear + "BEC" + String.format("%03d", eceSeq++);
            } else if (branch.equalsIgnoreCase("TT")) {
                regNo = admissionYear + "BTT" + String.format("%03d", ttSeq++);
            } else if (branch.equalsIgnoreCase("Che")) {
                regNo = admissionYear + "BChe" + String.format("%03d", cheSeq++);
            } else {
                regNo = admissionYear + "B" + branch + String.format("%03d", otherSeq++);
            }
        } else if (pursuingYear > 4 && pursuingYear < 7) {  
            doing = "M.Tech " + fullNameOfBranch;
            regNo = admissionYear + branch + "001";  
        } else {  
            doing = "PhD";
            regNo = "PhD" + admissionYear;
        }
        setMail(regNo); 

        if (studentCount < students.length) {
            students[studentCount++] = this; 
        } else {
            System.out.println("Student array is full!");
        }
    }

    public String getInformation() {
        return "Name: " + name + "\n"
             + "Age: " + age + "\n"
             + "DOB: " + DOB + "\n"
             + "Pursuing: " + doing + "\n"
             + "RegNo.: " + regNo + "\n"
             + "E-Mail: " + mail + "\n"
             + "Date: " + LocalDateTime.now() + "\n"
             + "-------------------------------------";
    }

    static void Display(String[] array) {
        for (String record : array) {
            String[] details = record.split(",");
            SMS student = new SMS(details); 
            System.out.println(student.getInformation());
        }
    }

    public static SMS getStudent(int index) {
        if (index >= 0 && index < studentCount) {
            return students[index]; 
        } else {
            System.out.println("Invalid student index!");
            return null;
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No input provided. Please provide student data.");
            return;
        }

        String information = args[0];
        if (!information.contains("=")) {
            System.out.println("Invalid input format! Expected format: Name=Ritesh,DOB=2005-11-11,AdmissionYear=2023,Branch=Information Technology");
            return;
        }

        String[] studentRecords = information.split("#");
        Display(studentRecords);
    }
}