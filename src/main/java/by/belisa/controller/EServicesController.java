package by.belisa.controller;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import by.belisa.entity.NewTech;
import by.belisa.entity.Services;
import by.belisa.exception.ServiceException;
import by.belisa.service.EServicesService;

@Controller
@RequestMapping("VIEW")
public class EServicesController {
	@Autowired
	@Qualifier("eServicesService")
	private EServicesService eServicesService;
	@RequestMapping
	public String renderView(Model model) throws ServiceException{
		List<Services> newTechList =eServicesService.getAllbyPublication(new Long(1));	
		model.addAttribute("newTechList", newTechList);
		return "eServices";
	}
}
