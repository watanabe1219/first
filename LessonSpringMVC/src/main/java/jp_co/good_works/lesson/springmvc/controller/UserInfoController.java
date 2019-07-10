package jp_co.good_works.lesson.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp_co.good_works.lesson.springmvc.form.ProductForm;

@controller
public class UserInfoController {
	private List<UserForm>userinfo = new ArrayList<UserForm>();
	@RequestMapping(value = "/userinfo",method = RequestMethod.GET)
	public String user (Model model) {
		UserForm form = new UserForm();
		model.addAttribute("message","ユーザー情報を入力してください");
		model.addAttribute("ｕｓｅｒForm",form);
		return "userinfo";
	}
	@RequestMapping(value = "/userinfo", method = RequestMethod.POST)
public String product (Model model ,@Validated @ModelAttribute ProductForm form,BindingResult result) {
		
		if (result.hasErrors()) {
			model.addAttribute("message","ユーザー情報が入力されていません");
		}else{
			model.addAttribute("message","ユーザー情報が入力されました");
			productList.add(form);
		}
		model.addAttribute("userForm",form);
		model.addAttribute("userList",usertList);
		return "userinfo";
	}
}
