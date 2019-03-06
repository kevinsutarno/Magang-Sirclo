package com.apap.berat.service;

import java.util.List;

import com.apap.berat.model.BeratModel;

public interface BeratService {
	BeratModel findById(long id);
	void addBerat(BeratModel berat);
	List<BeratModel> findAllByOrderByDateDesc();
	int perbedaan(BeratModel berat);
	double rataMax(List<BeratModel> listBerat);
	double rataMin(List<BeratModel> listBerat);
	double rataPerbedaan(List<BeratModel> listBerat);
} 
