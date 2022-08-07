package HumanResources;

// File chứa thông tin chung về bộ phận
public class Department {

    // Các thuộc tính cho bộ phận
    private String partCode;
    private String partName;
    private int currentNumberOfEmployees;


    public Department(String partCode, String partName, int currentNumberOfEmployees){
        this.partCode = partCode;
        this.partName = partName;
        this.currentNumberOfEmployees = currentNumberOfEmployees;
    }

    // Hàm Get và Set cho các thuộc tính của bộ phận
    public String getPartCode(){
        return partCode;
    }

    public void setPartCode(String partCode){
        this.partCode = partCode;
    }

    public String getPartName(){
        return partName;
    }

    public void setPartName(String partName){
        this.partName = partName;
    }

    public int getCurrentNumberOfEmployees(){
        return currentNumberOfEmployees;
    }

    public void setCurrentNumberOfEmployees(int currentNumberOfEmployees){
        this.currentNumberOfEmployees = currentNumberOfEmployees;
    }
    
    public void add(Staff staffList){
        this.currentNumberOfEmployees++;
    }

    // Phương thức toString() hiển thị thông tin về bộ phận
    @Override
    public String toString(){
        return String.format("%-10s | %-20s | %-25s",
        getPartCode(),getPartName(),getCurrentNumberOfEmployees());
    }
}
