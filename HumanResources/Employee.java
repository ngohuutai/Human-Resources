package HumanResources;

// File chứa thông tin chung về nhân viên
public class Employee extends Staff implements ICalculator {
    
    // Thuộc tính giờ làm thêm
    private double overtimeHours;

    // Hàm constructor cho lớp Employee
    public Employee(String id, String name, int age, double coefficientsSalary,
    String workingDay,int numberOfDaysOfLeave, String workingParts, double overtimeHours){
        super(id, name, age, coefficientsSalary, workingDay, workingParts, numberOfDaysOfLeave);
        this.overtimeHours = overtimeHours;
    }

    public Employee(){}
    public Employee(double overtimeHours){
        this.overtimeHours = overtimeHours;
    }
    
    // Hàm Get và Set cho thuộc tính giờ làm thêm
    public double getOvertimeHours() {
        return  overtimeHours;
    }

    public void setOvertimeHours(double overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    // Phương thức displayInformation() hiển thị thông tin nhân viên
    @Override
    public void displayInformation() {
        System.out.printf("%-12s | %-20s | %-4s | %-10s | %-13s | %-15s | %-20s | %-23s | %5.2f\n",
        getId(),getName(),getAge(),getCoefficientsSalary(),getWorkingDay(),getNumberOfDaysOfLeave(),getWorkingParts(),getOvertimeHours(),calculateSalary());
    }
    
    // Phương thức calculateSalary() tính lương nhân viên
    @Override
    public double calculateSalary() {
        double Salary = getCoefficientsSalary() * 3000000 + getOvertimeHours() * 200000;
        return Salary;
    }
}
