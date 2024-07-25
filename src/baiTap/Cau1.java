package baiTap;

import java.util.Scanner;

/**
 * Câu 1: Xd ctrinh cho phép người dùng nhập: Tên, Mã SV, điểm Toán, Lý, Hóa.
 * 		+ Tính điểm TB từng sinh viên (T + L + H)/3
 * 		+ Xếp loại từng SV: >= 9 -> Xuất sắc, 9>Giỏi>=8, 8>Khá>=7, 7>TB>=5, còn lại Yếu
 */
public class Cau1 {

	static double[] OUT_RANKS = {10, 0};
	static double[] RANKS = {9, 8, 7, 5};
	static String[] XEP_LOAI = {"Xuất Sắc", "Giỏi", "Khá", "Trung Bình", "Yếu"};
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//B1: Người dùng nhập: Tên, Mã SV, điểm Toán, Lý, Hóa
		System.out.println("Nhập số SV: ");
		int n = scanner.nextInt();
		String[] ten = new String[n];
		String[] maSV = new String[n];
		double[] diemToan = new double[n];
		double[] diemLy = new double[n];
		double[] diemHoa = new double[n];
		double[] trungBinh = new double[n];
		String[] xepLoai = new String[n];
 		
		for (int i = 0; i < n; i++) {
			scanner.nextLine();
			System.out.println("Xin vui lòng nhập thông tin SV số " + (i + 1) + " : ");
			System.out.print("Tên SV: ");
			ten[i] = scanner.nextLine();
			System.out.print("Mã SV: ");
			maSV[i] = scanner.nextLine();
			System.out.print("Điểm Toán: ");
			diemToan[i] = scanner.nextDouble();
			System.out.print("Điểm Lý: ");
			diemLy[i] = scanner.nextDouble();
			System.out.print("Điểm Hóa: ");
			diemHoa[i] = scanner.nextDouble();
						
			//B2: Kiểm tra Tên, Mã SV, điểm Toán, Lý, Hóa
			if (ten[i].strip() == "" || maSV[i].strip() == ""
					|| diemToan[i] < 0 || diemLy[i] < 0 || diemHoa[i] < 0
					|| diemToan[i] > 10 || diemLy[i] > 10 || diemHoa[i] > 10) {
				System.out.println("Dữ liệu nhập vào không hợp lệ!");
				return;
			}
			
			//B3: Tính điểm trung bình
			trungBinh[i] = (diemToan[i] + diemLy[i] + diemHoa[i]) / 3;
			
			//B4: Xếp loại từng SV
			if (trungBinh[i] < OUT_RANKS[1] || trungBinh[i] > OUT_RANKS[0]) {
				System.out.println("Điểm trung bình không hợp lệ!");
			} else if (trungBinh[i] >= RANKS[0]) {
				xepLoai[i] = XEP_LOAI[0];
			} else if (trungBinh[i] < RANKS[0] && trungBinh[i] >= RANKS[1]) {
				xepLoai[i] = XEP_LOAI[1];
			} else if (trungBinh[i] < RANKS[1] && trungBinh[i] >= RANKS[2]) {
				xepLoai[i] = XEP_LOAI[2];
			} else if (trungBinh[i] < RANKS[2] && trungBinh[i] >= RANKS[3]) {
				xepLoai[i] = XEP_LOAI[3];
			} else {
				xepLoai[i] = XEP_LOAI[4];
			}			
		}
		
		//B5: Xuất thông tin SV
		System.out.println("-----------------------------------------------------");
		for (int i = 0; i < n; i++) {
			String thongTin = String.format("%s ; Mã SV: %s ; Xếp Loại: %s - Điểm Toán, Lý, Hóa là: %s , %s , %s"
					, ten[i], maSV[i], xepLoai[i], diemToan[i], diemLy[i], diemHoa[i]);
			System.out.println(thongTin);
		}
	}
}
