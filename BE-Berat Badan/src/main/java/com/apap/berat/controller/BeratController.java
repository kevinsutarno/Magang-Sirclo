package com.apap.berat.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.apap.berat.model.BeratModel;
import com.apap.berat.service.BeratService;
import com.apap.berat.model.BeratModel;
import com.apap.berat.service.BeratService;

@Controller
public class BeratController {
	@Autowired
	private BeratService beratService;
	
	@RequestMapping("/")
	public String home(Model model) {
		List<BeratModel> listBerat = beratService.findAllByOrderByDateDesc();
		model.addAttribute("listBerat", listBerat);
		
		double rataMax = beratService.rataMax(listBerat);
		double rataMin = beratService.rataMin(listBerat);
		double rataPerbedaan = beratService.rataPerbedaan(listBerat);
		model.addAttribute("rataMax", rataMax);
		model.addAttribute("rataMin", rataMin);
		model.addAttribute("rataPerbedaan", rataPerbedaan);
		return "home";
	}
	
	@RequestMapping("/berat/{id}")
		public String view(@PathVariable("id") long id, Model model) {
		BeratModel archive = beratService.findById(id);
		model.addAttribute("berat", archive);
		return "view-berat";
	}
	
	@RequestMapping(value = "/berat/tambah", method = RequestMethod.GET)
	private String tambahberat(Model model) {
		model.addAttribute("berat", new BeratModel());
		return "tambah-berat";
	}
	
	
	@RequestMapping(value = "/berat/tambah", method = RequestMethod.POST)
	private String tambahberatSubmit(@ModelAttribute BeratModel berat, Model model) {
		beratService.addBerat(berat);
		model.addAttribute("berat", berat);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/berat/update/{id}", method = RequestMethod.GET)
	public String ubahberat(@PathVariable long id, Model model) {
		BeratModel archive = beratService.findById(id);
		model.addAttribute("berat", archive);
		return "update-berat";
	}

	@RequestMapping(value = "/berat/update/{id}", method = RequestMethod.POST)
	public String ubahberatPost(@ModelAttribute BeratModel berat, Model model) {
		BeratModel archive = beratService.findById(berat.getId());
		archive.setMax(berat.getMax());
		archive.setMin(berat.getMin());
		archive.setTanggal(berat.getTanggal());
		beratService.addBerat(archive);
		model.addAttribute("berat",archive);
		return "redirect:/";
	}
}
