package jp_co.good_works.lesson.springmvc.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp_co.good_works.lesson.springmvc.form.UserInfoForm;

@Controller

public class UserInfoController {
	private List<UserInfoForm>userinfoList = new ArrayList<UserInfoForm>();
	@RequestMapping(value = "/userinfo",method = RequestMethod.GET)
	public String userinfo (Model model) {
		UserInfoForm form = new UserInfoForm();
		model.addAttribute("UserInfoForm",form);
	
	List<String> genders = new ArrayList<String>();
	List<String> favoriteLangs = new ArrayList<String>();
	List<String> birthplace = new ArrayList<String>();
	
		genders.add("’j");
		genders.add("—");
		model.addAttribute("genders",genders);

		favoriteLangs.add("Java");
		favoriteLangs.add("C#");
		favoriteLangs.add("C/C++");
		favoriteLangs.add("PHP");
		favoriteLangs.add("Perl");
		favoriteLangs.add("Ruby");
		favoriteLangs.add("Python");
		model.addAttribute("favoriteLang",favoriteLangs);

		birthplace.add("");
		birthplace.add("–kŠC“¹");
		birthplace.add("“Œ–k");
		birthplace.add("ŠÖ“Œ");
		birthplace.add("’†•”");
		birthplace.add("‹ß‹E");
		birthplace.add("’†‘");
		birthplace.add("l‘");
		birthplace.add("‹ãB");
		model.addAttribute("birthplace",birthplace);

		model.addAttribute("massage","“ü—Í‚µ‚Ä‚­‚¾‚³‚¢");
		model.addAttribute("userInfoForm",form);
		return "userinfo";
	}
	@RequestMapping(value = "/userinfo", method = RequestMethod.POST)
public String userinfo (Model model ,@Validated @ModelAttribute UserInfoForm form,BindingResult result) {
		List<String> genders = new ArrayList<String>();
		List<String> birthplaces = new ArrayList<String>();
		List<String> langs = new ArrayList<String>();
		
		genders.add("’j");
		genders.add("—");
		model.addAttribute("genders",genders);
		
		birthplaces.add("");
		birthplaces.add("–kŠC“¹");
		birthplaces.add("“Œ–k");
		birthplaces.add("ŠÖ“Œ");
		birthplaces.add("’†•”");
		birthplaces.add("‹ß‹E");
		birthplaces.add("’†‘");
		birthplaces.add("l‘");
		birthplaces.add("‹ãB");
		model.addAttribute("birthplaces",birthplaces);
		
		langs.add("Java");
		langs.add("C#");
		langs.add("C/C++");
		langs.add("Perl");
		langs.add("PHP");
		langs.add("Ruby");
		langs.add("Python");
		model.addAttribute("langs",langs);
		
		
		if (result.hasErrors()) {
			model.addAttribute("message","ƒ†[ƒU[î•ñ‚ª“ü—Í‚³‚ê‚Ä‚¢‚Ü‚¹‚ñ");
		}else{
			model.addAttribute("message","ƒ†[ƒU[î•ñ‚ª“ü—Í‚³‚ê‚Ü‚µ‚½");
			userinfoList.add(form);
		}
		model.addAttribute("UserInfoForm",form);
		model.addAttribute("userinfoList",userinfoList);
		return "userinfo";
	}
}
