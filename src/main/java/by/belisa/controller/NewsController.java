package by.belisa.controller;

import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import by.belisa.entity.FullNews;
import by.belisa.entity.News;
import by.belisa.exception.ServiceException;
import by.belisa.service.FullNewsService;
import by.belisa.service.NewsService;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

@Controller(value = "newsController")
@RequestMapping(value = "VIEW")
public class NewsController {
	private static Logger log = Logger.getLogger(NewsController.class);
	@Autowired
	@Qualifier(value="newsService")
	private NewsService newsService;
	@Autowired
	@Qualifier(value="fullNewsService")
	private FullNewsService fullNewsService;
	@RequestMapping()
	public String renderView(Model model, PortletRequest request) throws SystemException{
		
		String portletId = PortalUtil.getPortletId(request);
		Integer page = ParamUtil.getInteger(request, "page", 1);
		Integer count = ParamUtil.getInteger(request, "count", 10);
		List<News> newsList = newsService.list(page, count);
		model.addAttribute("newsList", newsList);
		model.addAttribute("portletId", portletId);
		model.addAttribute("currentPage", page);
		model.addAttribute("lastPage", newsService.listSize()/count);
		return "news";
	}
	@RequestMapping(params="view=fullNews")
	public String renderFullNews(PortletRequest req, PortletResponse resp,Model model) throws ServiceException{
		Integer id = ParamUtil.getInteger(req, "new_id");
		FullNews fullNews = fullNewsService.get(id);
		model.addAttribute("fullNews", fullNews);
		return "fullNews";
	}
}
