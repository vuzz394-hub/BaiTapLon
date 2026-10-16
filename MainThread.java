package BaiTapLon;

import java.util.Scanner;

public class MainThread {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentController controller = new StudentController();
        int choice; 
        while(true){
            System.out.println("==================================================");
            System.out.println("          HỆ THỐNG QUẢN LÝ SINH VIÊN ");
            System.out.println("==================================================");
            System.out.println("1. Thêm sinh viên mới");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo tên");
            System.out.println("4. Cập nhật điểm GPA theo mã sinh viên");
            System.out.println("5. Xóa sinh viên theo mã sinh viên");
            System.out.println("6. Sắp xếp sinh viên giảm dần theo GPA");
            System.out.println("7. Thoát chương trình");
            System.out.println("===============================");
            System.out.print("Vui lòng chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    controller.addStudent();
                    break;
                case 2:
                    controller.printStudentList();
                    break;
                case 3:
                    controller.searchStudentByName();
                    break;
                case 4:
                    controller.updateStudentGpa();
                    break;
                case 5:
                    controller.deleteStudent();
                    break;
                case 6:
                    controller.sortStudentsByGpaDescending();
                    break;
                case 7:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn từ 1 đến 7!");
            }
        } 
    } 
}
