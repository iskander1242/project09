package by.belisa.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import by.belisa.bean.AnketaDTO;
import by.belisa.entity.ANO;
import by.belisa.entity.OrgInfo;
import by.belisa.entity.Organization;
import by.belisa.entity.UchStepeni;
import by.belisa.entity.UchZvaniy;
import by.belisa.entity.User;
import by.belisa.exception.DaoException;
import by.belisa.exception.ServiceException;
import by.belisa.service.AnketaService;
import by.belisa.service.OrgService;
import by.belisa.service.UchStepeniService;
import by.belisa.service.UchZvaniyService;
import by.belisa.service.UserService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.util.PortalUtil;


@RequestMapping(value = "VIEW")
// @SessionAttributes("anketa")
public class EServicesController {
	private static Logger log = Logger.getLogger(EServicesController.class);

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	@Autowired
	@Qualifier("anketaService")
	private AnketaService anketaService;
	@Autowired
	@Qualifier("uchStepeniService")
	private UchStepeniService uchStepeniService;
	@Autowired
	@Qualifier("uchZvaniyService")
	private UchZvaniyService uchZvaniyService;
	@Autowired
	@Qualifier("orgService")
	private OrgService orgService;	

	@RenderMapping
	public String renderView(Model model, PortletRequest request)
			throws ServiceException, DaoException {
		AnketaDTO anketaDTO = null;
		try {
			com.liferay.portal.model.User user = PortalUtil.getUser(request);
			if (user != null) {
				long pk = user.getPrimaryKey();
				anketaDTO = anketaService.getDTO(pk);
				if (anketaDTO.getId() == 0) {
					anketaDTO.setEmail(user.getEmailAddress());
//					anketaDTO.setFullFio(user.getLastName() + " "
//							+ user.getFirstName() + " " + user.getMiddleName());
//					anketaDTO.setFio(user.getLastName() + " "
//							+ user.getFirstName().charAt(0) + "."
//							+ user.getMiddleName().charAt(0) + ".");
					anketaDTO.setName(user.getFirstName());
					anketaDTO.setSurname(user.getLastName());
					anketaDTO.setPatronymic(user.getMiddleName());
					SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
					anketaDTO.setBirthday(df.format(user.getBirthday()));
				}

			} else {
				anketaDTO = new AnketaDTO();
			}

		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<UchStepeni> uchStepeniList = uchStepeniService.getAll();
		List<UchZvaniy> uchZvaniyList = uchZvaniyService.getAll();
		List<Organization> orgList = orgService.getAll();
		model.addAttribute("uchStepeniList", uchStepeniList);
		model.addAttribute("uchZvaniyList", uchZvaniyList);
		model.addAttribute("orgList", orgList);
		model.addAttribute("anketa", anketaDTO);
		return "eServices";
	}
	
	@ActionMapping
	public void getFormData1(@ModelAttribute AnketaDTO anketaDTO,
			ActionRequest aRequest, Model model) throws ServiceException,
			PortalException, SystemException, ParseException, DaoException {
//		long pk = PortalUtil.getUser(aRequest).getUserId();
//		anketaDTO.setId(pk);
//		anketaDTO.setFullFio(anketaDTO.getSurname() + " "
//		+ anketaDTO.getName() + " " + anketaDTO.getPatronymic());
//		anketaDTO.setFio(anketaDTO.getSurname() + " "
//		+ anketaDTO.getName().charAt(0) + "."
//		+ anketaDTO.getPatronymic().charAt(0) + ".");
//		anketaService.saveOrUpdate(anketaDTO);
//		User user = userService.get(pk);
//		
//		user.setFirstName(anketaDTO.getName());
//		user.setMiddleName(anketaDTO.getPatronymic());
//		user.setLastName(anketaDTO.getSurname());
//		user.setGreeting("Welcome "+anketaDTO.getSurname()+" "+anketaDTO.getName());
//		userService.update(user);
		model.addAttribute("save_result", "ok");
	}
	
	@ResourceMapping
	public void checkUnp(ResourceRequest req, ResourceResponse resp) throws IOException{
		String unp = req.getParameter("unp");
		
		     ANO ano = new ANO();
		     OrgInfo oi=new OrgInfo();
		     oi.setCity("Минск11111");
		     oi.setNameRus("ИППС11111");
		     ano.setOrg(oi);
		 
			 ANO ano1 = new ANO();
			 OrgInfo oi1=new OrgInfo();
			 oi1.setCity("Минск1");
			 oi1.setNameRus("ИППС1");
			 ano1.setOrg(oi1);
			 
			 List<ANO> arr=new ArrayList<ANO>();
			 
			 arr.add(ano1);
			 arr.add(ano);			 
		   
		try (OutputStream outStream = resp.getPortletOutputStream()){
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(arr);
			outStream.write(jsonString.getBytes());
		}
	}

}
