package kulav.babylog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kulav.babylog.aspects.authentication.Signed;
import kulav.babylog.models.request.SignedRequestImpl;
import kulav.babylog.services.sign.SignGenImpl;


@RestController
@RequestMapping({"/t"})
public class TController {
	
	@Autowired
	private SignGenImpl signGenImpl;
	//http://localhost:8080/t/test?sign=xitO8VKKj6tlK9p5GhfWO-TbLtwCfA8EDkyq2SHEtG4&param1=value1&param2=value2&ts=1748093535&userId=382798664
	@Signed
	@GetMapping("/test")
	public Boolean get(SignedRequestImpl data) {
		String str = signGenImpl.generate(data);
		return data.getSign().equals(str);
	}
	//ZjYxNDM2YmU0MWEwMTkwZmQwZGYyYWYxOTc2ZDJmYTM2ZTk4MjA4OTYwNmNhNTk0MTY0NWFjY2E4M2Q0ZjYwYg
	/**
	 * 
{
    "sign": "xitO8VKKj6tlK9p5GhfWO-TbLtwCfA8EDkyq2SHEtG4",
    "ts": 1748093535,
    "payload": "param1=value1;2=value2"
}
	 */
}
