package com.MobiLapy.MobiLapy.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.MobiLapy.MobiLapy.dto.DataDTO;
import com.MobiLapy.MobiLapy.service.EmailServiceImpl;

@RestController
//@RequestMapping("/api/mobilapy")
public class HomeController {

	@Autowired
	EmailServiceImpl emailServiceImpl;
    @RequestMapping({"/","/home"})
    public ModelAndView homePage(ModelAndView mv) {
        System.out.println("***************************");
        //emailServiceImpl.sendSimpleMessage("mahesh.rvrjc@gmail.com", "Hi", "Hi");
        mv.setViewName("index");

        return mv;

    }
    
    @RequestMapping("/contact")
    public ModelAndView contactPage(ModelAndView mv) {
        System.out.println("***************************");
        mv.setViewName("contact");

        return mv;

    }
    
    @RequestMapping(value ="/insert",method = RequestMethod.POST, consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    @ResponseBody
    public ModelAndView sendMail(@RequestBody DataDTO dataDTO ,ModelAndView mv) {
        System.out.println("***************************");
        try {
        	System.out.println("000000000000000000000"+dataDTO);
            
            mv.addObject("MSG","Thanks!! Our Team will contact you");
            mv.setViewName("index");

            
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        return mv;

    }

    @GetMapping({"/hello"})
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }
    
    


}
