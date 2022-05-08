package com.acom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acom.entities.GioHang;
import com.acom.entities.NguoiDung;

public interface GioHangRepository extends JpaRepository<GioHang, Long>{
	
	GioHang findByNguoiDung(NguoiDung n);
	
}
