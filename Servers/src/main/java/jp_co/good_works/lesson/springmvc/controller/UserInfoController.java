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
	
		genders.add("�j");
		genders.add("��");
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
		birthplace.add("�k�C��");
		birthplace.add("���k");
		birthplace.add("�֓�");
		birthplace.add("����");
		birthplace.add("�ߋE");
		birthplace.add("����");
		birthplace.add("�l��");
		birthplace.add("��B");
		model.addAttribute("birthplace",birthplace);

		model.addAttribute("massage","���͂��Ă�������");
		model.addAttribute("userInfoForm",form);
		return "userinfo";
	}
	@RequestMapping(value = "/userinfo", method = RequestMethod.POST)
public String userinfo (Model model ,@Validated @ModelAttribute UserInfoForm form,BindingResult result) {
		List<String> genders = new ArrayList<String>();
		List<String> birthplaces = new ArrayList<String>();
		List<String> langs = new ArrayList<String>();
		
		genders.add("�j");
		genders.add("��");
		model.addAttribute("genders",genders);
		
		birthplaces.add("");
		birthplaces.add("�k�C��");
		birthplaces.add("���k");
		birthplaces.add("�֓�");
		birthplaces.add("����");
		birthplaces.add("�ߋE");
		birthplaces.add("����");
		birthplaces.add("�l��");
		birthplaces.add("��B");
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
			model.addAttribute("message","���[�U�[��񂪓��͂���Ă��܂���");
		}else{
			model.addAttribute("message","���[�U�[��񂪓��͂���܂���");
			userinfoList.add(form);
		}
		model.addAttribute("UserInfoForm",form);
		model.addAttribute("userinfoList",userinfoList);
		return "userinfo";
	}
}
