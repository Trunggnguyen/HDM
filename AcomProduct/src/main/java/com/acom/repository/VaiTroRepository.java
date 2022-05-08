package com.acom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acom.entities.VaiTro;

public interface VaiTroRepository extends JpaRepository<VaiTro, Long> {

	VaiTro findByTenVaiTro(String tenVaiTro);
}
