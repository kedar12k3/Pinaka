package forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import com.pinaka.server.entities.Data;
import java.io.Serializable ;

@Entity
public class Sample implements Data{
	@Id
	private int id;
	@Column
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Sample(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Sample() {
		
	}
	@Override
	public String toString() {
		return "Sample [id=" + id + ", name=" + name + "]";
	}	
}
