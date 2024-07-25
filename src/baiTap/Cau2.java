package baiTap;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Câu 2: 
 * 
 */
public class Cau2 {

	public static void main(String[] args) {
		SinhVien sv = new SinhVien();
		Scanner scanner = new Scanner(System.in);
		
		//1. Nhập nhiều SV bằng hàm dữ liệu giả
		ArrayList<SinhVien> listSV = nhapSV(scanner, sv);
		if (listSV == null || listSV.size() == 0) {
			System.out.println("Mảng rỗng!");
			return;
		}
		
		//2. Tính điểm TB, xếp loại từng SV
		tongKet(listSV);
		
		//3. In ra danh sách SV
		sv.xuatSV(listSV);
		
		//4. In ra SV có ĐTB cao nhất
		System.out.println("----------------------------------------------------------------------------------");
		sv.maxDiemTB(listSV);
		
		//5. In ra tất cả SV Yếu
		System.out.println("----------------------------------------------------------------------------------");
		sv.sinhVienYeu(listSV);
		
		//6. Tìm SV theo tênSV
		System.out.println("----------------------------------------------------------------------------------");
		timTenSV(scanner, listSV, sv);
		
		//7. Tìm SV theo mã SV
		System.out.println("----------------------------------------------------------------------------------");
		timMaSV(scanner, listSV, sv);
		
		//8. Xóa SV theo mã SV
		System.out.println("----------------------------------------------------------------------------------");
		xoaSV(scanner, listSV, sv);
		
		sv.xuatSV(listSV);
	}
	
	/**
	 * Nhập Sinh viên
	 * 
	 * @param scanner
	 * @param sv
	 * @return
	 */
	public static ArrayList<SinhVien> nhapSV(Scanner scanner, SinhVien sv) {
		int n;
		ArrayList<SinhVien> listSV = null;
		
		try {
			//B1: Người dùng nhập số SV
			do {
				System.out.println("Xin vui lòng nhập số sinh viên: ");
				n = scanner.nextInt();
			} while (n < 0);
			
			
			//B2: Dữ liệu giả
			listSV = sv.duLieuGia(n);
		} catch (InputMismatchException ex) {			
			System.out.println("Số sinh viên không hợp lệ!");
			System.err.println(ex.toString());
		} catch (Exception ex) {
			System.err.println(ex.toString());
		}
		
		return listSV;
	}
	
	/**
	 * Tính điểm TB + Xếp loại
	 * 
	 * @param list
	 */
	public static void tongKet(ArrayList<SinhVien> list) {
		//TH: Mảng rỗng
		if (list == null || list.size() == 0) {
			System.out.println("Mảng rỗng!");
			return;
		}
		
		for (SinhVien sv:list) {
			//1. Tính điểm TB
			sv.trungBinh();
			
			//2. Xếp loại
			sv.xepLoai();
		}
	}
	
	/**
	 * Tìm Sinh viên theo Tên SV
	 * 
	 * @param scanner
	 * @param list
	 * @param sv
	 */
	public static void timTenSV(Scanner scanner, ArrayList<SinhVien> list, SinhVien sv) {
		String ten;
		
		//B1: Người dùng nhập tên
		do {
			System.out.print("Xin vui lòng nhập tên SV cần tìm: ");
			ten = scanner.nextLine();
		} while (ten.strip() == "");
		
		//B2: Tìm SV
		sv.timTenSV(list, ten);
	}

	/**
	 * Tìm Sinh viên theo Mã SV
	 * 
	 * @param scanner
	 * @param list
	 * @param sv
	 */
	public static void timMaSV(Scanner scanner, ArrayList<SinhVien> list, SinhVien sv) {
		String ma;
		
		//B1: Người dùng nhập mã
		do {
			System.out.print("Xin vui lòng nhập mã SV cần tìm: ");
			ma = scanner.nextLine();
		} while (ma.strip() == "");
				
		//B2: Tìm SV
		sv.timMaSV(list, ma);
	}
	
	/**
	 * Xóa Sinh viên
	 * 
	 * @param scanner
	 * @param list
	 * @param sv
	 */
	public static void xoaSV(Scanner scanner, ArrayList<SinhVien> list, SinhVien sv) {
		//B1: Người dùng nhập mã (có thể trống)
		System.out.print("Xin vui lòng nhập mã SV cần xóa: ");
		String ma = scanner.nextLine();
		
		//B2: Xóa SV
		sv.xoaSV(list, ma);
	}
}
