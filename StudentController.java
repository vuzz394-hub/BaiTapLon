package BaiTapLon;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {
    private ArrayList<Student> studentList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    public void addStudent() {
        System.out.println("--- THÊM SINH VIÊN MỚI ---");
        System.out.print("Nhập mã ID sinh viên: ");
        String id = scanner.nextLine();

        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) {
                System.out.println("Lỗi: Mã ID này đã tồn tại trong hệ thống!");
                return;
            }
        }
        System.out.print("Nhập tên sinh viên: ");
        String fullName = scanner.nextLine();
        System.out.print("Nhập điểm GPA: ");
        double gpa = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập email của sinh viên: ");
        String email = scanner.nextLine();
        System.out.println("Nhập số điện thoại của sinh viên: ");
        String phone = scanner.nextLine();
        Student student = new Student(id, fullName, email, phone, gpa);
        studentList.add(student);
        System.out.println("Thêm sinh viên thành công!");
    }
    public void printStudentList() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sách sinh viên trống!");
            return;
        }
        System.out.println("--- DANH SÁCH SINH VIÊN ---");
        for (Student s : studentList) {
            System.out.println(s);
        }
    }
    public void searchStudentByName() {
        System.out.print("Nhập tên sinh viên cần tìm: ");
        String keyword = scanner.nextLine().toLowerCase();
        boolean found = false;
        System.out.println("--- KẾT QUẢ TÌM KIẾM ---");
        for (Student s : studentList) {
            if (s.getFullName().toLowerCase().contains(keyword)) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sinh viên có tên phù hợp!");
        }
    }
    public void updateStudentGpa() {
        System.out.print("Nhập mã ID sinh viên cần cập nhật điểm GPA: ");
        String id = scanner.nextLine();
        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Không tìm thấy sinh viên có mã ID: " + id);
            return;
        }
        System.out.print("Nhập điểm GPA mới: ");
        double newGpa = Double.parseDouble(scanner.nextLine());
        student.setGpa(newGpa);
        System.out.println("Cập nhật điểm GPA thành công!");
    }
    public void deleteStudent() {
        System.out.print("Nhập mã ID sinh viên cần xóa: ");
        String id = scanner.nextLine();
        boolean removed = studentList.removeIf(s -> s.getId().equalsIgnoreCase(id));
        if (removed) {
            System.out.println("Xóa sinh viên thành công!");
        } else {
            System.out.println("Không tìm thấy sinh viên có mã ID: " + id);
        }
    }
    public void sortStudentsByGpaDescending() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sách sinh viên trống, không thể sắp xếp!");
            return;
        }
        studentList.sort((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()));
        System.out.println("Đã sắp xếp danh sách sinh viên giảm dần theo GPA thành công!");
        printStudentList();
    }
    private Student findStudentById(String id) {
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }
}
