package QLCB;

import java.util.Scanner;

public class Test_insertCB {
    public static void doInsertCB(){
        QLCB cb = new QLCB();
        int SoTK, Luong;
        String Hoten, GT, Diachi;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap So tai khoan: ");
        SoTK = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhap Ho ten: ");
        Hoten = scanner.nextLine();
        System.out.print("Nhap Gioi tinh: ");
        GT = scanner.nextLine();
        System.out.print("Nhap Dia chi: ");
        Diachi = scanner.nextLine();
        System.out.print("Nhap Luong: ");
        Luong = scanner.nextInt();

        cb.insertCB(SoTK, Hoten, GT, Diachi, Luong);
    }
    public static void main(String[] args) {
        doInsertCB();
    }
}
