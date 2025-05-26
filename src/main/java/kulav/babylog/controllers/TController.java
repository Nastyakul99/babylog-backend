package kulav.babylog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kulav.babylog.models.request.SignedRequestImpl;
import kulav.babylog.services.sign.SignGenImpl;


@RestController
@RequestMapping({"/t"})
public class TController {
	
	@Autowired
	private SignGenImpl signGenImpl;
	//http://localhost:8080/t/test?sign=1&param1=value1&param2=value2&ts=1748093535&userId=382798664
	@GetMapping("/test")
	public String get(SignedRequestImpl data) {
		String str = signGenImpl.generate(data);
		return str;
	}
	//ZjYxNDM2YmU0MWEwMTkwZmQwZGYyYWYxOTc2ZDJmYTM2ZTk4MjA4OTYwNmNhNTk0MTY0NWFjY2E4M2Q0ZjYwYg
	/**
	 * 
{
    "sign": "4JxwK2xXIei0G9QwoH2ZJPkGjkoCrst6BFBfzGMo39A",
    "ts": 1748093535,
    "payload": "param1=value1;2=value2"
}
	 */
}
