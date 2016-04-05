package lt.employees.domain.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Abstract enitity class.
 */
@MappedSuperclass
public class AbstractEntity implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}
}
