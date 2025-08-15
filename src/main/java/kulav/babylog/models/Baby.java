package kulav.babylog.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import kulav.babylog.models.dto.BabyDTO;
import kulav.babylog.models.records.ActivityRecord;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@EqualsAndHashCode(of = "id")
@ToString
public class Baby implements Updatable<Baby, BabyDTO> {
	
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
	
	@Getter
	@JsonIgnore
	@OneToMany(mappedBy="baby", cascade = CascadeType.ALL)
	private List<ActivityRecord> records = new ArrayList<>();
	
	public Baby update(BabyDTO dto) {
		this.name = dto.getName();
		this.birthDate = dto.getBirthDate();
		this.gender = dto.getGender();
		return this;
	}
}
