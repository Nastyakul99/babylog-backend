package kulav.babylog.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kulav.babylog.aspects.authentication.Signed;
import kulav.babylog.models.Baby;
import kulav.babylog.models.dto.BabyDTO;
import kulav.babylog.models.dto.BabySignedRequest;
import kulav.babylog.models.dto.SignedRequestImpl;
import kulav.babylog.models.dto.SubIdRequest;
import kulav.babylog.services.BabyService;

@RestController
@RequestMapping({"/babies"})
public class BabyController {
	
	private final BabyService babyService;
	
	public BabyController(BabyService babyService) {
		this.babyService = babyService;
	}
	
	@Signed
	@PostMapping()
	public BabyDTO create(@RequestBody BabySignedRequest request) {
		return map(babyService.create(request.getBaby(), request.getUserId()));
	}
	
	@Signed
	@PutMapping()
	public BabyDTO update(@RequestBody BabySignedRequest request) {
		return map(babyService.update(request.getBaby()));
	}
	
	//TODO: исправить
	@Signed
	@GetMapping()
    public BabyDTO getById(SubIdRequest request) {
    	return map(babyService.getById(request.getSubId()));
    }
	
	@Signed
	@GetMapping("/person")
	public List<BabyDTO> getByPersonVkId(SignedRequestImpl request) {
		return babyService.getByPersonVkId(request.getUserId())
				.stream().map(this::map).toList();
	}
	
	@Signed
	@DeleteMapping()
    public List<BabyDTO> delete(@RequestBody SubIdRequest request) {
    	return babyService.delete(request.getSubId())
    	.stream().map(this::map).toList();
    }
	
	private BabyDTO map(Baby b) {
		return BabyDTO.create(b);
	}

};
