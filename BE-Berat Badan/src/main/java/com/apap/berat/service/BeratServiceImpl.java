package com.apap.berat.service;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.berat.model.BeratModel;
import com.apap.berat.repository.BeratDB;
import com.apap.berat.model.BeratModel;
import com.apap.berat.repository.BeratDB;

@Service
@Transactional
public class BeratServiceImpl implements BeratService{
	@Autowired
	BeratDB beratDB;
	
	@Override
	public BeratModel findById(long id) {
		return beratDB.findById(id);					
	}
	
	@Override
	public List<BeratModel> findAllByOrderByDateDesc(){
		return beratDB.findAllByOrderByTanggalDesc();
	}
	
	@Override
	public void addBerat(BeratModel berat) {
		beratDB.save(berat);
		
	}

	@Override
	public int perbedaan(BeratModel berat) {
		// TODO Auto-generated method stub
		return berat.getMax()-berat.getMin();
	}

	@Override
	public double rataMax(List<BeratModel> listBerat) {
		int rata = 0;
		for (BeratModel berat : listBerat) {
			rata+=berat.getMax();
		}
		return rata/(double)listBerat.size();
	}

	@Override
	public double rataMin(List<BeratModel> listBerat) {
		int rata = 0;
		for (BeratModel berat : listBerat) {
			rata+=berat.getMin();
		}
		return rata/(double)listBerat.size();
	}

	@Override
	public double rataPerbedaan(List<BeratModel> listBerat) {
		int rata = 0;
		for (BeratModel berat : listBerat) {
			rata+=berat.getMax()-berat.getMin();
		}
		return rata/(double)listBerat.size();
	}
	
	
}
