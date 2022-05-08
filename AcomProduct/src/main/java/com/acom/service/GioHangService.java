package com.acom.service;

import com.acom.entities.GioHang;
import com.acom.entities.NguoiDung;

public interface GioHangService {
	
	GioHang getGioHangByNguoiDung(NguoiDung n);
	
	GioHang save(GioHang g);
}
