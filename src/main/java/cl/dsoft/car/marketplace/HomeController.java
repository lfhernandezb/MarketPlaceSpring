package cl.dsoft.car.marketplace;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cl.dsoft.car.marketplace.domain.ComunaHome;
import cl.dsoft.car.marketplace.domain.Pais;
import cl.dsoft.car.marketplace.domain.PaisHome;
import cl.dsoft.car.marketplace.domain.Region;
import cl.dsoft.car.marketplace.domain.RegionHome;
import cl.dsoft.car.marketplace.domain.Comuna;
import cl.dsoft.car.marketplace.domain.Usuario;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private ApplicationContext appContext;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/", "/home**"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		Usuario u = new Usuario();
		
		RegionHome rh = (RegionHome) appContext.getBean("Region");
		
		List<Region> listRegiones = rh.findByCriteria(DetachedCriteria.forClass(Region.class).add(Restrictions.like("descripcion", "%%")));
		
		u.setNombreusuario("admin");
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		Boolean exito = false;
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		
		model.addAttribute("Usuario", u);
		
		model.addAttribute("exito", exito);
		
		model.addAttribute("listRegiones", listRegiones);
		
		model.addAttribute("listComunas", new ArrayList<Comuna>());
		
		return "home";
	}
	
	// @ResponseBody to convert returned object to json
	// @RequestBody - Convert the json data into object (SearchComunaCriteria) mapped by field name.
	@RequestMapping(value = "/getComunas", method=RequestMethod.POST, headers = {"Content-type=application/json"})
	public @ResponseBody AjaxResponseBody getComunasViaAjax(@RequestBody SearchComunaCriteria search) {
		
		//HibernateTemplate template = (HibernateTemplate) appContext.getBean("mpTemplate");

		AjaxResponseBody result = new AjaxResponseBody();

		//if (isValidSearchCriteria(search)) {
			/*
			ComunaHome ch = (ComunaHome) appContext.getBean("Comuna");
			
			List<Comuna> comunas = ch.findByCriteria(DetachedCriteria
					.forClass(Comuna.class)
					.createCriteria("region")
					.add(Restrictions.eq("idRegion", Integer.valueOf(search.getIdRegion())))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY));
			*/
			RegionHome rh = (RegionHome) appContext.getBean("Region");
		
			Region region = rh.getRegionWithComunas(Integer.valueOf(search.getIdRegion()));

			if (region.getComunas().size() > 0) {
				result.setCode("200");
				result.setMsg("");
				
				List<Comuna> listComuna = new ArrayList<Comuna>();
				
			    Iterator<Comuna> iterator = region.getComunas().iterator();
			    while(iterator.hasNext()) {
			        Comuna setElement = iterator.next();
			        
			        setElement.setRegion(null);
			        setElement.setUsuarios(null);
			        setElement.setCotizacions(null);
			        setElement.setProveedorSucursals(null);
			        
			        listComuna.add(setElement);
			    }
				
				result.setComunas(listComuna);
			} else {
				result.setCode("204");
				result.setMsg("Ninguna comuna!");
			}

		//} else {
		//	result.setCode("400");
		//	result.setMsg("Search criteria is empty!");
		//}
		
		return result;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("admin");

		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}
	
	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();
		
		//check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);
		
			model.addObject("username", userDetail.getUsername());
			
		}
		
		model.setViewName("403");
		return model;

	}

	private boolean isValidSearchCriteria(SearchComunaCriteria search) {

		boolean valid = true;

		if (search == null) {
			valid = false;
		}

		if ((StringUtils.hasText(search.getIdRegion()))) {
			valid = false;
		}

		return valid;
	}
}
