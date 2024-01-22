package com.web.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {
	//控制器方法
	@GetMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("title", "歡迎蒞臨君雅網路商城!!!");
		model.addAttribute("subtitle", "網路上獨一無二的購物天堂");
		return "welcome";
	}
	@GetMapping("/")
	public String index(Model model) {
		System.out.println("in index(), kitty-id=" + model.getAttribute("kitty-id"));
		System.out.println("in index(), snoopy-id=" + model.getAttribute("snoopy-id"));
		System.out.println("in index(), mickey-id=" + model.getAttribute("mickey-id"));
		return "index";    // 
	}
	@ModelAttribute("kitty-id")
	public String m1()
	{
		System.out.println("in m1()");
		return "Hello, Kitty";
	}
	@ModelAttribute
	public void m2(Model model)
	{
		System.out.println("in m2()");
		model.addAttribute("mickey-id", "Hello, Mickey");
		model.addAttribute("snoopy-id", "Hello, Snoopy");
	}
	
}
