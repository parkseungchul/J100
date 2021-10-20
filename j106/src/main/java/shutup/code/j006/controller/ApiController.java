package shutup.code.j006.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shutup.code.j006.config.ResultDto;

@RequestMapping("/api")
@RestController
public class ApiController {
	
	@PostMapping("/test")
	public ResultDto test() {
		return new ResultDto(true, "test ok!", null);
	}
	

}
