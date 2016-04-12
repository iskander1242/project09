package by.belisa.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.Provider.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MimeResponse;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;
import org.springframework.web.portlet.multipart.MultipartActionRequest;

import by.belisa.bean.AnketaDTO;
import by.belisa.bean.FileMeta;
import by.belisa.bean.ServiceData;
import by.belisa.bean.ServiceDataExt;
import by.belisa.bean.ServiceDataNTD;
import by.belisa.entity.ANO;
import by.belisa.entity.FileResult;
import by.belisa.entity.FileZapros;
import by.belisa.entity.OrgInfo;
import by.belisa.entity.Organization;
import by.belisa.entity.Services;
import by.belisa.entity.UchStepeni;
import by.belisa.entity.UchZvaniy;
import by.belisa.entity.User;
import by.belisa.exception.DaoException;
import by.belisa.exception.ServiceException;
import by.belisa.service.AnketaService;
import by.belisa.service.EServicesServiceOracle;
import by.belisa.service.EServicesServiceSqlServer;
import by.belisa.service.OrgService;
import by.belisa.service.UchStepeniService;
import by.belisa.service.UchZvaniyService;
import by.belisa.service.UserService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.util.PortalUtil;

@RequestMapping(value = "VIEW")
public class EServicesController {
	private static Logger log = Logger.getLogger(EServicesController.class);
	
	private String DOC_CONTENT_TYPE="application/msword";	

	private String DOCX_CONTENT_TYPE="application/"
			+ "vnd.openxmlformats-officedocument.wordprocessingml.document";

	private static enum ServiceType {
		jeneralService(53), 
		extendedService(52),
		preparationForRegistrarionService(59),
        receptionKitService(60),
        preparationProjectKidService(61),
        receptionKitElDocumentsService(62);

		ServiceType(long type) {
			this.type = type;
		}

		private long type;

		public long getType() {
			return type;
		}
	}

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
	@Autowired
	@Qualifier("eServicesServiceOracle")
	private EServicesServiceOracle eServicesServiceOracle;
	@Autowired
	@Qualifier("eServicesServiceSqlServer")
	private EServicesServiceSqlServer eServicesServiceSqlServers;

	private LinkedList<FileMeta> files = new LinkedList<FileMeta>();
	private FileMeta fileMeta = null;
	private Integer CURRENT_USER_PK;

	private long currentServiceID;

	@RenderMapping
	public String renderServiceList(Model model, PortletRequest request) {
		List<Services> servicesList = eServicesServiceOracle
				.getAllbyPublication();
		for (Services i : servicesList) {
			System.out.println(i);
		}
		model.addAttribute("servicesList", servicesList);
		return "eServiceList";
	}

	@RenderMapping(params = "view=eServiceUpload")
	public String renderServiceUpload(Model model, RenderRequest request) {
		System.out.println("+++++++++++++++++"
				+ request.getParameter("type"));
		model.addAttribute("type",
				ServiceType.valueOf(request.getParameter("type")).getType());
		setCurrentServiceType(ServiceType.valueOf(request.getParameter("type")).getType());
		return "eServiceUpload";
	}	

	@RenderMapping(params = "view=eServices")
	public String renderView(Model model, RenderRequest request)
			throws ServiceException, DaoException {
		AnketaDTO anketaDTO = null;
		try {
			com.liferay.portal.model.User user = PortalUtil.getUser(request);
			if (user != null) {
				long pk = user.getPrimaryKey();
				System.err.println("+++user.getPrimaryKey()="
						+ user.getPrimaryKey());
			} else {
				// anketaDTO = new AnketaDTO();
			}
			System.out.println("+++++++++++++++++"
					+ request.getParameter("type"));
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}		
		model.addAttribute("type",ServiceType.valueOf(request.getParameter("type")).getType());
		model.addAttribute("anketa", anketaDTO);
		return "eServices";
	}

	@RenderMapping(params = "view=eServiceUGR02")
	public String renderServiceUGR02(Model model, PortletRequest request)
			throws ServiceException, DaoException {
		AnketaDTO anketaDTO = null;
		try {
			com.liferay.portal.model.User user = PortalUtil.getUser(request);
			if (user != null) {
				long pk = user.getPrimaryKey();
				anketaDTO = anketaService.getDTO(pk);
				if (anketaDTO.getId() == 0) {
					SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
					// anketaDTO.setBirthday(df.format(user.getBirthday()));
				}

			} else {
				// anketaDTO = new AnketaDTO();
			}

		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		List<Organization> orgList = orgService.getAll();

		return "eServiceUGR02";
	}

	@ResourceMapping
	public void checkUnp(ResourceRequest req, ResourceResponse resp)
			throws IOException, ParseException {
		System.out.println("!!!!checkUnp");

		String unp = req.getParameter("unp");
		String dfrom = req.getParameter("dfrom");
		String dto = req.getParameter("dto");

		Object objectFoSerialize = null;
		switch (Integer.valueOf(unp)) {
		case 53:
			ServiceData serviceData = eServicesServiceSqlServers
					.getService01Res(dfrom, dto);
			objectFoSerialize = serviceData;
			break;
		case 52:
			ServiceDataExt serviceData1 = eServicesServiceSqlServers
					.getService01ResExt(dfrom, dto);
			objectFoSerialize = serviceData1;
			break;
		case 51:
			ServiceDataNTD serviceDataNTD = eServicesServiceSqlServers
					.getService02(dfrom);
			System.err.println(serviceDataNTD.toString());
			objectFoSerialize = serviceDataNTD;
			break;
		case 50:			
			System.out.println("++++getCURRENT_USER_PK()="+getCURRENT_USER_PK());
			setCURRENT_USER_PK(getUserPk(req));
			objectFoSerialize = eServicesServiceOracle.getAllFile(getCURRENT_USER_PK(),getCurrentServiceType());
			break;
		default:
			throw new IllegalArgumentException();

		}
		try (OutputStream outStream = resp.getPortletOutputStream()) {
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(objectFoSerialize);
			outStream.write(jsonString.getBytes());
		} catch (Exception e) {
			throw new IOException();
		}
	}

	/***************************************************
	 * upload(): receives files
	 * 
	 * @param request
	 *            : MultipartHttpServletRequest auto passed
	 * @return
	 * @return LinkedList<FileMeta> as json format
	 * @throws IOException
	 ****************************************************/
	@ActionMapping(params = "myActions=uploadMultipleFile")
	public void upload(MultipartActionRequest request, ActionResponse response)
			throws IOException {	
		Iterator<String> itr = request.getFileNames();		
		MultipartFile mpf = null;
		
		// 2. get each file
		while (itr.hasNext()) {
			// 2.1 get next MultipartFile			
			mpf = request.getFile(itr.next());
			System.out.println(mpf.getOriginalFilename() + " uploaded! "
					+ files.size());
			System.err.println("++++++++++++user.getPrimaryKey()=" + getUserPk(request));
			//TODO
			setCURRENT_USER_PK(getUserPk(request));		
		
			// TODO 
			eServicesServiceOracle.saveFile(getCURRENT_USER_PK(), mpf.getBytes(),
					mpf.getOriginalFilename(), 
					mpf.getContentType().equals(DOCX_CONTENT_TYPE)? DOC_CONTENT_TYPE:mpf.getContentType()
					,(int) Math.floor(mpf.getSize() / 1024),getCurrentServiceType());
		}
	}

	@ResourceMapping(value = "getFile")
	public void getFile(ResourceRequest req, ResourceResponse resp)
			throws IOException {
		log.info("!!!!!getFiles");
		String fileId = req.getParameter("fileName");
		FileZapros file = eServicesServiceOracle.getFile(FileZapros.class,
				Integer.valueOf(fileId));
		log.info("!!!!!getFiles==" + fileId);	
		byte[] usloviy = null;
		if (file != null&&file.getFileSize()!=0) {
			usloviy = file.getDocuments();
			resp.setContentType(file.getFileType() + ";charset=ISO-8859-1");
			//resp.setContentType(file.getFileType() + ";charset=UTF-8");
	
			resp.setContentLength(file.getFileSize());
			resp.setProperty(HttpHeaders.CONTENT_DISPOSITION,
					"attachment; filename=\"" + file.getFileName() + "\"");
		} else {
			usloviy = "NO data found".getBytes();
		}
		OutputStream outStream = null;
		try {
			outStream = resp.getPortletOutputStream();
			outStream.write(usloviy);
			outStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (outStream != null) {
				try {
					outStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	@ResourceMapping(value = "delFile")
	public void delFile(ResourceRequest req, ResourceResponse resp)
			throws IOException {
		String fileId = req.getParameter("fileName");
		eServicesServiceOracle.delFile(FileZapros.class,Integer.valueOf(fileId));
	}
	
	

	// TODO user?
	private Integer getUserPk(PortletRequest request) {
		com.liferay.portal.model.User user;
		Integer pk = null;
		try {
			user = PortalUtil.getUser(request);
			if (user != null) {
				pk = (int) user.getPrimaryKey();
				System.err.println("+++user.getPrimaryKey()=" + pk);
				System.err.println("+++user.user.getUserId()="
						+ user.getUserId());
			} else {
				throw new PortalException("User pk is null"); 
			}
		} catch (PortalException | SystemException e) {			
			e.printStackTrace();
		}
		return pk;
	}

	public Integer getCURRENT_USER_PK() {
		return CURRENT_USER_PK;
	}

	public void setCURRENT_USER_PK(Integer cURRENT_USER_PK) {
		CURRENT_USER_PK = cURRENT_USER_PK;
		
	}
	
	private void setCurrentServiceType(long currentServiceID) {
		System.err.println("currentServiceType="+currentServiceID);
		this.currentServiceID=currentServiceID;		
	}

	public long getCurrentServiceType() {
		System.err.println("+++++++++++++getCurrentServiceType() currentServiceType="+currentServiceID);
		return currentServiceID;
	}
}
