package jo.secondstep.hr.controller;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jo.secondstep.hr.entity.Region;
import jo.secondstep.hr.service.RegionService;
 
 

@Controller
//@RequestMapping("app")
public class RegionController {
 
    
    @Autowired
    private RegionService regionService;
    
    @RequestMapping("/")
    public String home() {
    	
    	return "index";
    }
 
    
    @RequestMapping("/all")
    public ModelAndView getAllRegions() {
    	
    	ModelAndView model = new ModelAndView("regions");
    	List<Region> regions = regionService.getAllRegions();
    	
    	model.addObject("regions", regions);
    	
    	return model;
    }
    
    @RequestMapping(value = "/name1/{language}")
	public String name(ModelMap model, @PathVariable String language) { 
		
		if (language.equals("en")) {
			model.addAttribute("name", "Mohammad");
		}
		else if (language.equals("ar")) {
			model.addAttribute("name", "");
		}
		
		return "name";
	}
    
    @GetMapping("/printname")
	public String hello(ModelMap model, @RequestParam String firstName, @RequestParam String lastName) {
		
		Map<String, String> names = new HashMap<>();
		names.put("firstName", firstName);
		names.put("lastName", lastName);
		model.addAllAttributes(names);
		
		return "firstandlastname";
	}

}