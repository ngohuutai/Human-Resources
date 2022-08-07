package HumanResources;
//  File abstract chứa các thông tin của nhân viên
public abstract class Staff {
    // Các thuộc tính cho nhân viên
    private String id;
    private String name;
    private int age;
    private double coefficientsSalary;
    private String workingDay;
    private String workingParts;
    private int numberOfDaysOfLeave;

    // Hàm constructor cho lớp Staff
    public Staff(String id, String name, int age, double coefficientsSalary,
    String workingDay, String workingParts, int numberOfDaysOfLeave){
        this.id = id;
        this.name = name;
        this.age = age;
        this.coefficientsSalary = coefficientsSalary;
        this.workingDay = workingDay;
        this.workingParts = workingParts;
        this.numberOfDaysOfLeave = numberOfDaysOfLeave;
    }
    
    public Staff() {}

    // Hàm Get và Set cho các thuộc tính của nhân viên
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getCoefficientsSalary() {
        return coefficientsSalary;
    }

    public void setCoefficientsSalary(double coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }

    public String getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(String workingDay) {
        this.workingDay = workingDay;
    }

    public String getWorkingParts() {
        return workingParts;
    }

    public void setWorkingParts(String workingParts) {
        this.workingParts = workingParts;
    }

    public int getNumberOfDaysOfLeave() {
        return numberOfDaysOfLeave;
    }

    public void setNumberOfDaysOfLeave(int numberOfDaysOfLeave) {
        this.numberOfDaysOfLeave = numberOfDaysOfLeave;
    }
    
    public double calculateSalary() {
        return 0;
    }

    // Phương thức displayInformation() hiển thị thông tin nhân viên
    public abstract void displayInformation();
}
