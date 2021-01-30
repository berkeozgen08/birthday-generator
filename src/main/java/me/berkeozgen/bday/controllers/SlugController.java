package me.berkeozgen.bday.controllers;

import org.bson.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.berkeozgen.bday.Database;
import me.berkeozgen.bday.Generate;
import me.berkeozgen.bday.SlugNotFoundException;

@Controller
public class SlugController {
	
	@RequestMapping("/{slug:[^.]+}")
	@ResponseBody
	public String getGenerated(@PathVariable String slug) {
		Document document = Database.findSlug(slug);
		if (document == null) {
			throw new SlugNotFoundException();
		}
		String to = document.getString("to");
		String bdaymsg = document.getString("bdaymsg");
		String msg = document.getString("msg");
		return Generate.generate(to, bdaymsg, msg);
	}

}
