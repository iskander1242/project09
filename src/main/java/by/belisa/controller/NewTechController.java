package by.belisa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import by.belisa.entity.NewTech;
import by.belisa.exception.ServiceException;
import by.belisa.service.NewTechService;
import by.belisa.service.EServicesService;

@Controller
@RequestMapping("VIEW")
public class NewTechController {
	@Autowired
	@Qualifier("newTechService")
	private NewTechService newTechService;
	@RequestMapping
	public String renderView(Model model) throws ServiceException{
		List<NewTech> newTechList = newTechService.getAll();
		model.addAttribute("newTechList", newTechList);
		return "newTech";
	}
}
