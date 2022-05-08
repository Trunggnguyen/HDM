package com.acom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acom.entities.ChiMucGioHang;
import com.acom.entities.GioHang;
import com.acom.entities.SanPham;

public interface ChiMucGioHangRepository extends JpaRepository<ChiMucGioHang, Long>{
	
	ChiMucGioHang findBySanPhamAndGioHang(SanPham sp,GioHang g);
	
	List<ChiMucGioHang> findByGioHang(GioHang g);
}
