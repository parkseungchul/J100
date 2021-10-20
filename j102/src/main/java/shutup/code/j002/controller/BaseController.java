package shutup.code.j002.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BaseController {
	
	@RequestMapping("/")
	public String index() {
		InetAddress local; 
		try { 
			local = InetAddress.getLocalHost(); 
			String ip = local.getHostAddress(); 
			log.debug("Call IP[한글 테스트]: " + ip);
			} catch (UnknownHostException e1) { 
				e1.printStackTrace(); 
		}
		return "index";
	}
}
