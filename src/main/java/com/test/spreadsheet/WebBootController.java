package com.test.spreadsheet;

import java.util.Map;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebBootController {

	
	@RequestMapping("/web")
	public String welcome() {
		System.out.println("Inside WebBootContorller");
		//model.put("message", this.message);
		return "welcome";
	}

}