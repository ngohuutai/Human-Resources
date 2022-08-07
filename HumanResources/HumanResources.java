package HumanResources;
import java.util.Scanner;
import java.util.ArrayList;

// File chứa thông tin chung về nhân viên
public class HumanResources {
    
    // Hàm main để xử lý luồng chính của chương trình 
    public static void main(String[] args) {
        list();
        parts();

        // vòng lặp do…while để cho phép người dùng chọn lại chức năng 
        do{
            menu();
        } while(true);
    }
    // Mảng để lưu thông tin nhân viên
    public static ArrayList<Staff>staffList = new ArrayList<>();
    // Mảng để lưu thông tin bộ phận
    public static ArrayList<Department>departmentList = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public static void menu() {
        // Menu của chương trình
        System.out.println(
                 "1. Hien thi danh sach nhan vien hien co trong cong ty.\n"
               + "2. Hien thi cac bo phan trong cong ty.\n"
               + "3. Hien thi cac nhan vien theo tung bo phan\n"
               + "4. Them nhan vien moi vao cong ty.\n"
               + "5. Tim kiem thong tin nhan vien theo ten hoac ma nhan vien.\n"
               + "6. Hien thi bang luong cua nhan vien toan cong ty.\n"
               + "7. Hien thi bang luong cua nhan vien theo thu tu tang dan hoac giam dan.\n"
               + "0. Thoat chuong trinh.\n" );
        System.out.println();
        System.out.print("Lua chon cua ban: ");

        String choose = sc.next();
        switch(Integer.parseInt(choose)) {
            case 1:
                // Chức năng hiển thị danh sách nhân viên hiện có trong công ty
                printList();
                break;
            case 2:
                // Chức năng hiển thị các bộ phận trong công ty
                printParts();
                break;
            case 3:
                // Chức năng hiển thị các nhân viên theo từng bộ phận
                printEmployeesByDepartment();
                break;
            case 4:
                // Chức năng thêm nhân viên mới vào công ty
                addStaff();
                break;
            case 5:
                // Chức năng tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên
                searchStaff();
                break;
            case 6:
                // Chức năng hiển thị bảng lương của nhân viên toàn công ty 
                printList();
                break;
            case 7:
                // Chức năng hiển thị bảng lương của nhân viên theo thứ tự tăng dần hoặc giảm dần
                salaryInAscendingOrder(staffList);
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Chuc nang ban chon chua duoc cap nhat");
                System.out.println();
        }
    }

    // Hàm danh sách nhân viên và quản lí
    public static void list() {
        // Tạo đối tượng nhân viên
        Employee staff1 = new Employee("E001", "Phong Tuyet Hoa", 28, 3.2, "10/10/2010", 10, "Hanh chinh nhan su", 4.0);
        Employee staff2 = new Employee("E002", "Tran Thi B", 24, 2.2, "09/10/2019", 7, "Hanh chinh nhan su", 3.0);
        
        // Tạo đối tượng quản lí
        Manager manager1 = new Manager("M001", "Nguyen Van An", 25, 2.5, "11/11/2010", 5, "Cong nghe thong tin", "Business Leader");
        Manager manager2 = new Manager("M002", "Ta Van Luc", 32, 4.5, "01/11/2010", 1, "Cong nghe thong tin", "Technical Leader");
        
        // Thêm nhân viên và quản lí vào mảng
        staffList.add(staff1);
        staffList.add(staff2);
        staffList.add(manager1);
        staffList.add(manager2);
    }

    // Hàm hiển thị danh sách nhân viên trong công ty.
    public static void printList(){
        System.out.printf("%-10s | %-20s | %-4s | %-10s | %-13s | %-15s | %-20s | %-23s | %5s\n",
        "Ma nhan vien", "Ten nhan vien", "Tuoi", "HS Luong", "Ngay vao lam", "Ngay nghi phep",  "Bo phan", "So gio lam them/Chuc vu", "Luong");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        for (Staff x : staffList) {
            x.displayInformation();
        }
        System.out.println();
    }

    // Hàm danh sách các bộ phận trong công ty
    public static void parts(){

        // Thông tin bộ phận
        Department bp1 = new Department("HC","Hanh chinh nhan su",2);
        Department bp2 = new Department("IT","Cong nghe thong tin",2);
        Department bp3 = new Department("MKT","Marketing",0);
        
        // Thêm bộ phận vào mảng
        departmentList.add(bp1);
        departmentList.add(bp2);
        departmentList.add(bp3);
    }

    // Hàm hiển thị danh sách các bộ phận trong công ty.
    public static void printParts(){
            System.out.printf("%-10s | %-20s | %-25s\n","Ma bo phan", "Ten bo phan", "So luong nhan vien hien tai");
        for (Department x:departmentList) {
            System.out.println(x);
         }
        System.out.println();
    }

    // Hàm hiển thị các nhân viên theo từng bộ phận
    public static void printEmployeesByDepartment(){
        for (Department x:departmentList) {
            System.out.println(x.getPartName());
            System.out.println("--------------------------");
            System.out.printf("%-10s | %-20s | %-4s | %-10s | %-13s | %-15s | %-20s | %-23s | %5s\n",
            "Ma nhan vien", "Ten nhan vien", "Tuoi", "HS Luong", "Ngay vao lam", "Ngay nghi phep",  "Bo phan", "So gio lam them/Chuc vu", "Luong");
            for (Staff y: staffList) {
                if(y.getWorkingParts().equals(x.getPartName())){
                    y.displayInformation();
                }
            }
            System.out.println();
         }
    }

    // Hàm thêm nhân viên mới vào công ty
    public static void addStaff(){
        while(true){
            System.out.println("1. Them nhan vien thong thuong");
            System.out.println("2. Them nhan vien la cap quan ly (co them chuc vu)");
            System.out.print("Ban chon: ");
            int choose = sc.nextInt();
            sc.nextLine();
            // Thêm nhân viên thông thường:
            if(choose == 1){
                // Tạo đối tượng nhân viên mới
                Employee addStaff = new Employee();
                // Nhập thông tin từ bàn phím
                System.out.print("Nhap ma nhan vien: ");
                addStaff.setId(sc.nextLine());
                System.out.print("Nhap ten nhan vien: ");
                addStaff.setName(sc.nextLine());
                System.out.print("Nhap tuoi nhan vien: ");
                addStaff.setAge(sc.nextInt());
                System.out.print("Nhap he so luong cua nhan vien: ");
                addStaff.setCoefficientsSalary(sc.nextDouble());
                System.out.print("Nhap ngay vao lam cua nhan vien: ");
                sc.nextLine();
                addStaff.setWorkingDay(sc.nextLine());
                System.out.print("Nhap so ngay nghi phep cua nhan vien: ");
                addStaff.setNumberOfDaysOfLeave(sc.nextInt());
                // Chọn bộ phận làm việc
                System.out.println("1. HC - Hanh chinh nhan su");
                System.out.println("2. IT - Cong nghe thong tin");
                System.out.println("3. MKT - Marketing");
                System.out.print("Ban chon bo phan: ");
                int chooseParts = sc.nextInt();
                if(chooseParts == 1){
                    addStaff.setWorkingParts("Hanh chinh nhan su");
                } else if(chooseParts == 2){
                    addStaff.setWorkingParts("Cong nghe thong tin");
                } else if(chooseParts == 3){
                    addStaff.setWorkingParts("Marketing");
                }
                System.out.print("Nhap so gio lam them: ");
                addStaff.setOvertimeHours(sc.nextInt());
                // Thêm vào nhân viên vào mảng
                staffList.add(addStaff);

                // Thêm nhân viên là cấp quản lý (có thêm chức vụ)
            } else if(choose == 2){
                // Tạo đối tượng quản lí mới
                Manager addManager = new Manager();
                // Nhập thông tin từ bàn phím
                System.out.print("Nhap ma nhan vien: ");
                addManager.setId(sc.nextLine());
                System.out.print("Nhap ten nhan vien: ");
                addManager.setName(sc.nextLine());
                System.out.print("Nhap tuoi nhan vien: ");
                addManager.setAge(sc.nextInt());
                System.out.print("Nhap he so luong cua nhan vien: ");
                addManager.setCoefficientsSalary(sc.nextDouble());
                System.out.print("Nhap ngay vao lam cua nhan vien: ");
                sc.nextLine();
                addManager.setWorkingDay(sc.nextLine());
                System.out.print("Nhap so ngay nghi phep cua nhan vien: ");
                addManager.setNumberOfDaysOfLeave(sc.nextInt());
                // Chọn bộ phận làm việc
                System.out.println("1. HC - Hanh chinh nhan su");
                System.out.println("2. IT - Cong nghe thong tin");
                System.out.println("3. MKT - Marketing");
                System.out.print("Ban chon bo phan: ");
                int chooseParts = sc.nextInt();
                if(chooseParts == 1){
                    addManager.setWorkingParts("Hanh chinh nhan su");
                } else if(chooseParts == 2){
                    addManager.setWorkingParts("Cong nghe thong tin");
                } else if(chooseParts == 3){
                    addManager.setWorkingParts("Marketing");
                }
                // Chọn chức vụ
                System.out.println("Chuc danh:");
                System.out.println("1. Business Leader");
                System.out.println("2. Project Leader");
                System.out.println("3. Technical Leader");
                System.out.print("Nhap chuc danh: ");
                int choosePosition = sc.nextInt();
                if(choosePosition == 1){
                    addManager.setPosition("Business Leader");
                } else if(chooseParts == 2){
                    addManager.setPosition("Project Leader");
                } else if(chooseParts == 3){
                    addManager.setPosition("Technical Leader");
                }
                // Thêm quản lí vào mảng
                staffList.add(addManager);
            }
            System.out.println();
            break;
        }
    }

    // Hàm tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên
    public static void searchStaff(){
        System.out.println("1. Tim nhan vien bang ten:");
        System.out.println("2. Tim nhan vien bang ma nhan vien:");
        System.out.print("Ban chon: ");
        int choose = sc.nextInt();
        // Tìm kiếm thông tin nhân viên theo tên
        if(choose == 1){
            System.out.println();
            System.out.println("Nhap ten nhan vien can tim:");
            String search = sc.next();
            for (Staff x : staffList){
                if(x.getName().toUpperCase().contains(search.toUpperCase())){
                    System.out.printf("%-10s | %-20s | %-4s | %-10s | %-13s | %-15s | %-20s | %-23s | %5s\n",
                    "Ma nhan vien", "Ten nhan vien", "Tuoi", "HS Luong", "Ngay vao lam", "Ngay nghi phep",  "Bo phan", "So gio lam them/Chuc vu", "Luong");
                    x.displayInformation();
                    System.out.println();
                    System.out.println("--------------------------------------------------------------------------");
                }
            }

        // Tìm kiếm thông tin nhân viên theo mã nhân viên
        } else if(choose == 2){
            System.out.println();
            System.out.println("Nhap ma nhan vien can tim:");
            String search = sc.next();
            for (Staff x : staffList) {
                if(search.equalsIgnoreCase(x.getId())){
                    System.out.printf("%-10s | %-20s | %-4s | %-10s | %-13s | %-15s | %-20s | %-23s | %5s\n",
                    "Ma nhan vien", "Ten nhan vien", "Tuoi", "HS Luong", "Ngay vao lam", "Ngay nghi phep",  "Bo phan", "So gio lam them/Chuc vu", "Luong");
                    x.displayInformation();
                    System.out.println();
                    System.out.println("--------------------------------------------------------------------------");
                }
            }
        }
    }

    // Hiển thị bảng lương của nhân viên theo thứ tự tăng dần hoặc giảm dần
    public static void salaryInAscendingOrder(ArrayList<Staff>staffList){
        System.out.println("1. Hien thi bang luong cua nhan vien theo thu tu tang dan");
        System.out.println("2. Hien thi bang luong cua nhan vien theo thu tu giam dan");
        System.out.print("Ban chon: ");
        int choose = sc.nextInt();
        // Hiển thị bảng lương của nhân viên theo thứ tự tăng dần
        if(choose ==1){
            int n =  staffList.size();
            for(int i=0; i<n-1; i++){
                for(int j=0; j<n-i-1; j++){
                    if(staffList.get(j).calculateSalary() > staffList.get(j+1).calculateSalary()){
                        Staff temp = staffList.get(j);
                        staffList.remove(j);
                        staffList.add(j+1, temp);
                    }
                }
            }
            printList();

        // Hiển thị bảng lương của nhân viên theo thứ tự giảm dần
        } else if(choose == 2){
            int n =  staffList.size();
            for(int i=0; i<n-1; i++){
                for(int j=0; j<n-i-1; j++){
                    if(staffList.get(j).calculateSalary() < staffList.get(j+1).calculateSalary()){
                        Staff temp = staffList.get(j);
                        staffList.remove(j);
                        staffList.add(j+1, temp);
                    }
                }
            }
            printList();
        }
    }
}
