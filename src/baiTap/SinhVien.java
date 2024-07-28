package baiTap;

import java.util.ArrayList;
import java.util.Random;

public class SinhVien {

	static int[] RANKS = {10, 9, 8, 7, 5, 0};
	static String[] XEP_LOAI = {"Xuất Sắc", "Giỏi", "Khá", "Trung Bình", "Yếu"};
	
	String ten;
	String maSV;
	double diemToan;
	double diemLy;
	double diemHoa;
	double trungBinh;
	String xepLoai;
	
	SinhVien() {
	}
	
	SinhVien(String ten, String maSV, double diemToan, double diemLy, double diemHoa) {
		this.ten = ten;
		this.maSV = maSV;
		this.diemToan = diemToan;
		this.diemLy = diemLy;
		this.diemHoa = diemHoa;
	}
	
	ArrayList<SinhVien> duLieuGia(int n) {
		ArrayList<SinhVien> listSV = new ArrayList<SinhVien>();
		
		try {
			//Kiểm tra số sinh viên
			if (n < 0) {
				throw new Exception("Số sinh viên không hợp lệ!");
			}
			
			String tienToTen = "Sinh viên ";
			String tienToMa = "1200012";
			String ten;
			String ma;
			double toan; double ly; double hoa;
			Random rd = new Random();
			
			for (int i = 0; i < n; i++) {
				ten = tienToTen + (i + 1);
				ma = tienToMa + (i + 1);
				toan = rd.nextInt(0, 101) / 10.0;
				ly = rd.nextInt(0, 101) / 10.0;
				hoa = rd.nextInt(0, 101) / 10.0;
				
				listSV.add(new SinhVien(ten, ma, toan, ly, hoa));
			}			
		} catch (Exception e) {
			System.out.println("Số sinh viên không hợp lệ!");
			System.err.println(e.toString());
		}
		
		return listSV;
	}
	
	double trungBinh() {
		double diem = (this.diemToan + this.diemLy + this.diemHoa)/3;
		String diemTron = String.format("%.1f", diem);
		this.trungBinh = Double.parseDouble(diemTron);
		
		return this.trungBinh;
	}
	
	String xepLoai() {
		if (this.trungBinh > RANKS[0] || this.trungBinh < RANKS[5]) { //TH1: TB > 10 || TB < 0
			System.out.println("Điểm trung bình không hợp lệ!");
		} else if (this.trungBinh >= RANKS[1]) { //TH2: TB >= 9 -> Xuất sắc
			this.xepLoai = XEP_LOAI[0];
		} else if (RANKS[1] > this.trungBinh && this.trungBinh >= RANKS[2]) { //TH3: 9>TB>=8 -> Giỏi
			this.xepLoai = XEP_LOAI[1];
		} else if (RANKS[2] > this.trungBinh && this.trungBinh >= RANKS[3]) { //TH4: 8>TB>=7 -> Khá
			this.xepLoai = XEP_LOAI[2];
		} else if (RANKS[3] > this.trungBinh && this.trungBinh >= RANKS[4]) { //TH5: 7>TB>=5 -> TB
			this.xepLoai = XEP_LOAI[3];
		} else { //TH6: TB < 5 -> Yếu
			this.xepLoai = XEP_LOAI[4];
		}
		
		return this.xepLoai;
	}
	
	void xuatSV() {
		String thongTin = String.format("%s; Mã SV: %s; Điểm Toán, Lý, Hóa là: %s, %s, %s; Trung Bình: %s; Xếp loại: %s"
				, this.ten, this.maSV, this.diemToan, this.diemLy, this.diemHoa, this.trungBinh, this.xepLoai);
		System.out.println(thongTin);
	}
	
	void xuatSV(ArrayList<SinhVien> list) {
		//TH: Mảng rỗng
		if (list == null || list.size() == 0) {
			System.out.println("Mảng rỗng!");
			return;
		}
				
		for (SinhVien sv:list) {
			sv.xuatSV();
		}
	}
	
	void maxDiemTB(ArrayList<SinhVien> list) {
		//TH: Mảng rỗng
		if (list == null || list.size() == 0) {
			System.out.println("Mảng rỗng!");
			return;
		}
		
		double max = 0;
		
		//B1: Tìm điểm TB max
		for(SinhVien sv:list) {
			if (max < sv.trungBinh) {
				max = sv.trungBinh;
			}
		}
		
		//B2: In ra kết quả
		System.out.println("Những SV có điểm TB cao nhất là: ");
		for(SinhVien sv:list) {
			if (sv.trungBinh == max) {
				sv.xuatSV();
			}
		}
	}
	
	void sinhVienYeu(ArrayList<SinhVien> list) {
		//TH: Mảng rỗng
		if (list == null || list.size() == 0) {
			System.out.println("Mảng rỗng!");
			return;
		}
		
		//In ra kết quả
		int count = 0;
		System.out.println("Những SV Xếp loại Yếu là: ");
		for(SinhVien sv:list) {
			if (sv.xepLoai == XEP_LOAI[4]) {
				sv.xuatSV();
				count = 1;
			}
		}
		if (count == 0) {
			System.out.println("Không có SV Yếu!");
		}
	}
	
	void timTenSV(ArrayList<SinhVien> list, String tenSV) {
		//TH: Mảng rỗng
		if (list == null || list.size() == 0) {
			System.out.println("Mảng rỗng!");
			return;
		}
		
		//Tìm SV theo tên
		int count = 0;
		for(SinhVien sv:list) {
			if (sv.ten.equals(tenSV.strip())) {
				sv.xuatSV();
				count = 1;
			}
		}
		if (count == 0) {
			System.out.println("Không có SV cần tìm!");
		}
	}
	
	void timMaSV(ArrayList<SinhVien> list, String ma) {
		//TH: Mảng rỗng
		if (list == null || list.size() == 0) {
			System.out.println("Mảng rỗng!");
			return;
		}
		
		//Tìm SV theo mã
		int count = 0;
		for(SinhVien sv:list) {
			if (sv.maSV.equals(ma.strip())) {
				sv.xuatSV();
				count = 1;
			}
		}
		if (count == 0) {
			System.out.println("Không có SV cần tìm!");
		}
	}
	
	void xoaSV(ArrayList<SinhVien> list, String ma) {
		//TH: Mảng rỗng
		if (list == null || list.size() == 0) {
			System.out.println("Mảng rỗng!");
			return;
		}
				
		for(int i = 0; i < list.size(); i++) {
			String maSV = list.get(i).maSV;
			if (maSV.equals(ma.strip())) {
				list.remove(i);
			}
		}
	}
}
