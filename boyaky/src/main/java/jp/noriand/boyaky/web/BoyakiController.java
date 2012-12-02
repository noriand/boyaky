package jp.noriand.boyaky.web;

import javax.validation.Valid;

import jp.noriand.boyaky.biz.domain.Boyaki;
import jp.noriand.boyaky.biz.service.BoyakiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoyakiController {

	@Autowired
	private BoyakiService boyakiService;

	@RequestMapping(value = "/boyaki", method = RequestMethod.GET)
	public String showBoyakiList(Model model) {

		model.addAttribute("boyaki", new Boyaki());
		model.addAttribute("boyakiList", boyakiService.getBoyakiList());

		return "boyaki";
	}

	@RequestMapping(value = "/boyaki", method = RequestMethod.POST)
	public String createBoyaki(@Valid Boyaki boyaki, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			model.addAttribute("boyakiList", boyakiService.getBoyakiList());
			return "boyaki";
		}

		System.out.println("boyaku start");

		if (boyaki != null)
			boyakiService.persist(boyaki);

		model.addAttribute("boyaki", new Boyaki());
		model.addAttribute("boyakiList", boyakiService.getBoyakiList());

		return "boyaki";
	}

}