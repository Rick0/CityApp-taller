package com.uba.fi.bdd.cityapp.controller;

import com.uba.fi.bdd.cityapp.repository.AtmRepository;
import com.uba.fi.bdd.cityapp.repository.BankRepository;
import com.uba.fi.bdd.cityapp.repository.CommuneRepository;
import com.uba.fi.bdd.cityapp.repository.NeighbourhoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class StatisticsController {

	private final NeighbourhoodRepository neighbourhoodRepository;
	private final CommuneRepository communeRepository;
	private final BankRepository bankRepository;
	private final AtmRepository atmRepository;

	@Autowired
	public StatisticsController(NeighbourhoodRepository neighbourhoodRepository, CommuneRepository communeRepository,
							  BankRepository bankRepository, AtmRepository atmRepository) {
		this.neighbourhoodRepository = neighbourhoodRepository;
		this.communeRepository = communeRepository;
		this.bankRepository = bankRepository;
		this.atmRepository = atmRepository;
	}

	@GetMapping({"/statistics"})
	public String getAllNeighbourhoods(Model model) {
		model.addAttribute("tablesCountMap", getTablesCountMap());
		return "info/statistics";
	}

	private Map<String, Integer> getTablesCountMap() {
		Map<String, Integer> tablesCountMap = new LinkedHashMap<>();
		tablesCountMap.put(neighbourhoodRepository.getTableName(), neighbourhoodRepository.getCount());
		tablesCountMap.put(communeRepository.getTableName(), communeRepository.getCount());
		tablesCountMap.put(bankRepository.getTableName(), bankRepository.getCount());
		tablesCountMap.put(atmRepository.getTableName(), atmRepository.getCount());

		return tablesCountMap;
	}

}
