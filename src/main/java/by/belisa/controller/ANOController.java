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

import by.belisa.entity.ANO;
import by.belisa.entity.GirIntd;
import by.belisa.exception.ServiceException;
import by.belisa.service.ANOService;
import by.belisa.service.GirIntdService;

import com.liferay.portal.kernel.servlet.HttpHeaders;

@Controller(value = "ANOController")
@RequestMapping(value = "VIEW")
public class ANOController {
	
	@Autowired
	@Qualifier("ANOService")
	private ANOService anoService;
	@Autowired
	@Qualifier("girIntdService")
	private GirIntdService girIntdService;
	
	@RenderMapping
	public String renderServiceList(){
		return "anoServiceList";
	}
	@RenderMapping(params="view=anoActualList")
	public String renderActualANOList(Model model){
		List<ANO> ano = anoService.getActualAno();
		model.addAttribute("anoList", ano);
		return "anoActualList";
	}
	@RenderMapping(params="view=anoExcludedList")
	public String renderExcludedANOList(Model model){
		List<ANO> ano = anoService.getExcludedAno();
		model.addAttribute("anoList", ano);
		return "anoExcludedList";
	}
	@RenderMapping(params="view=anoRequestList")
	public String renderRequestANOList(Model model){
		List<ANO> ano = anoService.getRequestAno();
		model.addAttribute("anoList", ano);
		return "anoRequestList";
	}
	@RenderMapping(params="view=anoByUnp")
	public String renderANOByUnpForm(){
		return "anoByUnp";
	}
	@ResourceMapping
	public void checkUnp(ResourceRequest req, ResourceResponse resp) throws IOException{
		String unp = req.getParameter("unp");
		ANO ano = anoService.getOrgByUnp(unp);
		
		try (OutputStream outStream = resp.getPortletOutputStream()){
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(ano);
			outStream.write(jsonString.getBytes());
		}
	}
	
	@ResourceMapping(value="downloadFile")
	public void downloadFile(ResourceRequest req, ResourceResponse resp) throws ServiceException, IOException{
		GirIntd girIntd = girIntdService.get(1);
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
