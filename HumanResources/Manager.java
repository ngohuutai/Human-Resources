package HumanResources;

// File chứa thông tin chung về quản lý
public class Manager extends Staff implements ICalculator{
    // Thuộc tính chức danh
    private String position;

    public Manager(String id, String name, int age, double coefficientsSalary,
    String workingDay,int numberOfDaysOfLeave, String workingParts, String position){
        super(id, name, age, coefficientsSalary, workingDay, workingParts, numberOfDaysOfLeave);
        this.position = position;
    }

    public Manager() {}

    // Hàm Get và Set cho thuộc tính của chức danh
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // Phương thức calculateSalary() tính lương quản lí
    @Override
    public double calculateSalary() {
        double salaryResponsible = 0;
        if(position == "Business Leader"){
            salaryResponsible = 8000000;
        } else if(position == "Project Leader"){
            salaryResponsible = 5000000;
        } else if(position == "Technical Leader"){
            salaryResponsible = 6000000;
        }
        double salary = getCoefficientsSalary() * 5000000 + salaryResponsible;
        return salary;
    }

    // Phương thức displayInformation() hiển thị thông tin bao gồm cả chức danh
    @Override
    public void displayInformation() {
        System.out.printf("%-12s | %-20s | %-4s | %-10s | %-13s | %-15s | %-20s | %-23s | %5.2f\n",
        getId(),getName(),getAge(),getCoefficientsSalary(),getWorkingDay(),getNumberOfDaysOfLeave(),getWorkingParts(),getPosition(),calculateSalary());
    }
    
}
