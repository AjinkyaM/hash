package org.aj.hash.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HashController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping("/hash")
	public String hash(final HttpServletRequest request) {
		String text = request.getParameter("text");
		String sha256hex = null;
		if(null != text) {
			sha256hex = org.apache.commons.codec.digest.DigestUtils.sha256Hex(text);
		}else {
			sha256hex = org.apache.commons.codec.digest.DigestUtils.sha256Hex("Hello world");
		}
		return sha256hex;
	}
	
	@RequestMapping(path="/temp",produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> getTemperature() {
		Map<String, String> metrixMap = new HashMap<>();
		metrixMap.put("temperature", Integer.toString(new Random().nextInt(5)+28));
		return metrixMap;
	}
	
	@RequestMapping(path="/humidity",produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> getHumidity() {
		Map<String, String> metrixMap = new HashMap<>();
		metrixMap.put("humidity", Integer.toString(new Random().nextInt(50)+50));
		return metrixMap;
	}
	
	@RequestMapping(path="/wind",produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> getWind() {
		Map<String, String> metrixMap = new HashMap<>();
		metrixMap.put("wind", Integer.toString(new Random().nextInt(10)+10));
		return metrixMap;
	}

}
