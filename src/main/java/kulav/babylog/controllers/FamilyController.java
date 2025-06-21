package kulav.babylog.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kulav.babylog.aspects.authentication.Signed;
import kulav.babylog.models.dto.AddToFamilyRequest;
import kulav.babylog.models.dto.PersonDTO;
import kulav.babylog.models.dto.SignedRequestImpl;
import kulav.babylog.services.FamilyService;

@RestController
@RequestMapping({"/families"})
public class FamilyController {
	
	private final FamilyService familyService;
	
	public FamilyController(FamilyService familyService) {
		this.familyService = familyService;
	}

	@Signed
	@PostMapping()
	public List<PersonDTO> addToFamily(@RequestBody AddToFamilyRequest addToFamilyRequest) {
		long vkId = addToFamilyRequest.getUserId();
		long memberVkId = addToFamilyRequest.getNewMemberId();
		return familyService.addToFamilyDTO(vkId, memberVkId);
	}
	
	@Signed
	@GetMapping()
	public List<PersonDTO> findByVKId(SignedRequestImpl request) {
		return familyService.findByVKId(request.getUserId())
				.stream()
				.map(PersonDTO::create)
				.toList();
	}
}
