package by.belisa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import by.belisa.entity.GirProducts;
import by.belisa.service.GirProductsService;

@Controller(value="VTTController")
@RequestMapping(value = "VIEW")
public class VTTController {
	@Autowired
	@Qualifier(value="girProductsService")
	private GirProductsService girProductsService;
	
	@RenderMapping
	public String renderServiceList(){
		return "vttServiceList";
	}
	@RenderMapping(params="view=vttActualList")
	public String renderActualVTTList(Model model){
		List<GirProducts> vttList = girProductsService.getActualVTT();
		model.addAttribute("vttList", vttList);
		return "vttActualList";
	}
	@RenderMapping(params="view=vttRequestList")
	public String renderRequestVTTList(Model model){
		List<GirProducts> vttList = girProductsService.getRequestVTT();
		model.addAttribute("vttList", vttList);
		return "vttRequestList";
	}
	
	

}
