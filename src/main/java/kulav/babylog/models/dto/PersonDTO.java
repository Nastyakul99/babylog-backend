package kulav.babylog.models.dto;

import kulav.babylog.models.Person;

public record PersonDTO(long id, long vkId) {

	 public static PersonDTO create(Person p) {
		return new PersonDTO(p.getId(), p.getVkId());
	}
}
