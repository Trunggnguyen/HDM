package com.acom.service;

import java.text.ParseException;

import org.springframework.data.domain.Page;

import com.acom.dto.SearchLienHeObject;
import com.acom.entities.LienHe;

public interface LienHeService {

	Page<LienHe> getLienHeByFilter(SearchLienHeObject object, int page) throws ParseException;

	LienHe findById(long id);
	
	LienHe save(LienHe lh);
	
	int countByTrangThai(String trangThai);

}
