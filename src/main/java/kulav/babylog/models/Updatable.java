package kulav.babylog.models;

import kulav.babylog.models.dto.DTO;

public interface Updatable<T extends DBEntity, D extends DTO> extends DBEntity {

	public T update(D dto);
}
