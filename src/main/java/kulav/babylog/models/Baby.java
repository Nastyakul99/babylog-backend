package kulav.babylog.models;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import kulav.babylog.models.dto.BabyDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@EqualsAndHashCode(of = "id")
@ToString
public class Baby {
	
	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private LocalDate birthDate;
	
	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="family_id")
	private Family family;
	
	public Baby update(BabyDTO dto) {
		this.name = dto.getName();
		this.birthDate = dto.getBirthDate();
		this.gender = dto.getGender();
		return this;
	}

}
