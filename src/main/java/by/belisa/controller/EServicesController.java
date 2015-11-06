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
	
	enum ServiceType{
		jeneralService(53),
		extendedService(52);
		
		ServiceType(int type){
			this.type=type;
		}
		private int type;
		
	    public int getType(){
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
	

	public LinkedList<FileMeta> files = new LinkedList<FileMeta>();
	public FileMeta fileMeta = null;
	
	@RenderMapping
	public String renderServiceList(Model model, PortletRequest request){
		List<Services> servicesList =eServicesServiceOracle.getAllbyPublication();	
		for (Services i : servicesList) {
			System.out.println(i);
		}
		model.addAttribute("servicesList", servicesList);
		return "eServiceList";
	}
	
	@RenderMapping(params="view=eServiceUpload")
	public String renderServiceUpload(){
		return "eServiceUpload";
	}


	@RenderMapping(params="view=eServices")
	public String renderView(Model model, RenderRequest request)
			throws ServiceException, DaoException {
		AnketaDTO anketaDTO = null;
		try {
			com.liferay.portal.model.User user = PortalUtil.getUser(request);
			if (user != null) {
				long pk = user.getPrimaryKey();
				anketaDTO = anketaService.getDTO(pk);
				if (anketaDTO.getId() == 0) {				
					SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
					//anketaDTO.setBirthday(df.format(user.getBirthday()));
				}

			} else {
				//anketaDTO = new AnketaDTO();
			}
			System.out.println("+++++++++++++++++"+request.getParameter("type"));
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Organization> orgList = orgService.getAll();		
		model.addAttribute("type", ServiceType.valueOf(request.getParameter("type")).getType());
		model.addAttribute("anketa", anketaDTO);
		return "eServices";
	}
	
	
	@RenderMapping(params="view=eServiceUGR02")
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
					//anketaDTO.setBirthday(df.format(user.getBirthday()));
				}

			} else {
				//anketaDTO = new AnketaDTO();
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
	//@ResourceMapping(value ="addFiles")
	public void checkUnp(ResourceRequest req, ResourceResponse resp) throws IOException{		
		System.out.println("!!!!checkUnp");	
		
		String unp = req.getParameter("unp");
		String dfrom=req.getParameter("dfrom");
		String dto=req.getParameter("dto");		
	    
		Object objectFoSerialize= null;
		switch (Integer.valueOf(unp)){
		   case 53:
			   ServiceData  serviceData=eServicesServiceSqlServers.getService01Res(dfrom,dto);	
			   objectFoSerialize=serviceData;
			   break;
		   case 52:
			  ServiceDataExt  serviceData1=eServicesServiceSqlServers.getService01ResExt(dfrom, dto);
			  objectFoSerialize=serviceData1;
			  break;
		   case 51:
			   ServiceDataNTD serviceDataNTD=eServicesServiceSqlServers.getService02(dfrom);
			   objectFoSerialize=serviceDataNTD;
			   break;
		   case 50:
			  /* for (FileResult i: eServicesServiceOracle.getAllFile()){
				    System.err.println(i);
			   };*/
			   objectFoSerialize=eServicesServiceOracle.getAllFile();
			   break;
		   default:
			   throw new IllegalArgumentException();
			  
		}		
		try (OutputStream outStream = resp.getPortletOutputStream()){
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(objectFoSerialize);
			outStream.write(jsonString.getBytes());}
		catch (Exception e) {
			throw new IOException();
		}		
	}	
	
	/***************************************************	
	 * upload(): receives files
	 * @param request : MultipartHttpServletRequest auto passed
	 * @return  
	 * @return LinkedList<FileMeta> as json format
	 * @throws IOException 
	 ****************************************************/	
	@ActionMapping(params = "myActions=uploadMultipleFile")		
    public void  upload(MultipartActionRequest request, ActionResponse response) throws IOException { 
	
	
		
    	 Iterator<String> itr =  request.getFileNames();
		 MultipartFile mpf = null;	 
		 //2. get each file
		 while(itr.hasNext()){			 
			 //2.1 get next MultipartFile
			 mpf = request.getFile(itr.next()); 
			 System.out.println(mpf.getOriginalFilename() +" uploaded! "+files.size());

			 //2.2 if files > 10 remove the first from the list
			 if(files.size() >= 10)				 
				 files.pop();
			 
			 //2.3 create new fileMeta
			 fileMeta = new FileMeta();
			 fileMeta.setFileName(mpf.getOriginalFilename());
			 fileMeta.setFileSize(mpf.getSize()/1024+" Kb");
			 fileMeta.setFileType(mpf.getContentType());
			 System.err.println("mpf.getName()=="+mpf.getName());	
			 response.addProperty("rus", "русский");
			 try {
				fileMeta.setBytes(mpf.getBytes());
				
				// copy file to local disk (make sure the path "e.g. D:/temp/files" exists)
				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream("D:/temp/files/"+mpf.getOriginalFilename()));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 //2.4 add to files			 
			 files.add(fileMeta);
			 System.err.println("++++++++++++++++user.getPrimaryKey()=");
			 System.err.println("++++++++++++"+getUserPk(request));
			 eServicesServiceOracle.saveFile(getUserPk(request),mpf.getBytes(),mpf.getOriginalFilename(),mpf.getContentType(),mpf.getSize()/1024);
		 }
		 
	}
	
	@ResourceMapping(value ="getFiles")
	public void getFiles(ResourceRequest req, ResourceResponse resp) throws IOException{
		System.out.println("!!!!!getFiles");
		String unp = req.getParameter("fileName");			
		FileMeta exist =null;
		for (FileMeta i : files) {
			if (i.getFileName().equals(unp)){
				exist=i;
				break;
			} 
		}
		/*for (FileMeta i : files) {
			System.out.println(i);
		}
		exist=files.getLast();*/
		System.out.println("!!!!!getFiles");		
		byte[] usloviy=null;
		if (exist!=null){
			  usloviy=exist.getBytes();
			  resp.setContentType(exist.getFileType()+";charset=ISO-8859-1");	
			  resp.setContentLength(exist.getBytes().length);
			  resp.setProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+req.getParameter("fileName")+"\"");		  
			     
		}else {
			usloviy="NO data found".getBytes();
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
	//TODO user?
	 private long getUserPk(MultipartActionRequest request){
			com.liferay.portal.model.User user;
			long pk=0;
			try {
				user = PortalUtil.getUser(request);
				if (user != null) {
					 pk= user.getPrimaryKey();
					 System.err.println("++++++++++++++++user.getPrimaryKey()="+pk);
					throw new NullPointerException("curr User must be not null");
				}
			} catch (PortalException | SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return pk;						
	     }	
	}


	

