package me.berkeozgen.bday.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

import me.berkeozgen.bday.Database;

@Controller
public class GenerateController {

	@RequestMapping("/api/generate")
	public String generate(@RequestParam(value = "to", required = true) String to,
						   @RequestParam(value = "birthday-message", required = true) String bdaymsg,
						   @RequestParam(value = "message", defaultValue = "") String msg) {
		String path = Database.saveToDB(to, bdaymsg, msg);
		return "redirect:/" + path;
	}

}
