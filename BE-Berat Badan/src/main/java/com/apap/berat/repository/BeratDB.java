package com.apap.berat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.berat.model.BeratModel;

public interface BeratDB extends JpaRepository<BeratModel, Long> {
	BeratModel findById(long id);
	List<BeratModel> findAllByOrderByTanggalDesc();
}
