package me.berkeozgen.bday;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Slug was not found.")
public class SlugNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;	
}
