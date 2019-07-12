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
	
		genders.add("男");
		genders.add("女");
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
		birthplace.add("北海道");
		birthplace.add("東北");
		birthplace.add("関東");
		birthplace.add("中部");
		birthplace.add("近畿");
		birthplace.add("中国");
		birthplace.add("四国");
		birthplace.add("九州");
		model.addAttribute("birthplace",birthplace);

		model.addAttribute("massage","入力してください");
		model.addAttribute("userInfoForm",form);
		return "userinfo";
	}
	@RequestMapping(value = "/userinfo", method = RequestMethod.POST)
public String userinfo (Model model ,@Validated @ModelAttribute UserInfoForm form,BindingResult result) {
		List<String> genders = new ArrayList<String>();
		List<String> birthplaces = new ArrayList<String>();
		List<String> langs = new ArrayList<String>();
		
		genders.add("男");
		genders.add("女");
		model.addAttribute("genders",genders);
		
		birthplaces.add("");
		birthplaces.add("北海道");
		birthplaces.add("東北");
		birthplaces.add("関東");
		birthplaces.add("中部");
		birthplaces.add("近畿");
		birthplaces.add("中国");
		birthplaces.add("四国");
		birthplaces.add("九州");
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
			model.addAttribute("message","ユーザー情報が入力されていません");
		}else{
			model.addAttribute("message","ユーザー情報が入力されました");
			userinfoList.add(form);
		}
		model.addAttribute("UserInfoForm",form);
		model.addAttribute("userinfoList",userinfoList);
		return "userinfo";
	}
}
