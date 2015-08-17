package by.belisa.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.servlet.HttpHeaders;

import by.belisa.entity.GirIntd;
import by.belisa.entity.SII;
import by.belisa.exception.ServiceException;
import by.belisa.service.GirIntdService;
import by.belisa.service.SIIService;

@Controller(value = "SIIController")
@RequestMapping(value = "VIEW")
public class SIIController {
	
	@Autowired
	@Qualifier("SIIService")
	private SIIService siiService;
	@Autowired
	@Qualifier("girIntdService")
	private GirIntdService girIntdService;
	
	@RenderMapping
	public String renderServiceList(){
		return "siiServiceList";
	}
	@RenderMapping(params="view=siiActualList")
	public String renderSIIActualList(Model model){
		List<SII> subjects = siiService.getActualSubjects();
		model.addAttribute("subjects", subjects);
		return "siiActualList";
	}
	@RenderMapping(params="view=siiExcludedList")
	public String renderSIIExcludedList(Model model){
		List<SII> subjects = siiService.getExcludedSubjects();
		model.addAttribute("subjects", subjects);
		return "siiExcludedList";
	}
	@RenderMapping(params="view=siiRequestList")
	public String renderSIIRequestList(Model model){
		List<SII> subjects = siiService.getRequestSubjects();
		model.addAttribute("subjects", subjects);
		return "siiRequestList";
	}
	
	@RenderMapping(params="view=siiByUnp")
	public String renderSIIByUnpForm(){
		return "siiByUnp";
	}
	@ResourceMapping
	public void checkUnp(ResourceRequest req, ResourceResponse resp) throws IOException{
		String unp = req.getParameter("unp");
		SII sii = siiService.getSubjectByUnp(unp);
		
		try (OutputStream outStream = resp.getPortletOutputStream()){
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(sii);
			outStream.write(jsonString.getBytes());
		}
	}
	@ResourceMapping(value="downloadFile")
	public void downloadFile(ResourceRequest req, ResourceResponse resp) throws ServiceException, IOException{
		GirIntd girIntd = girIntdService.get(2);
		byte[] file = girIntd.getFile();
		String fileName = URLEncoder.encode(girIntd.getFileName(), "UTF-8");
		fileName = URLDecoder.decode(fileName, "ISO8859_1");
		resp.setProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+fileName);
		resp.setContentType(girIntd.getMimeType());
		resp.setCharacterEncoding("utf-8");
		
		
		try (OutputStream out = resp.getPortletOutputStream(); 
			 ByteArrayInputStream in = new ByteArrayInputStream(file)){
			
			byte[] buf = new byte[1024];
	        int len;
	        int size = 0;
	        while((len=in.read(buf))>0){
	        	size+=len;
	            out.write(buf,0,len);
	        }
	        resp.setContentLength(size);
		}
	}

}
