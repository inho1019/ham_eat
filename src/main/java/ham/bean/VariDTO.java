package ham.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="vari")
@Getter
@Setter
public class VariDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long variSeq;
	
	@Column(name="name",nullable = false)
	private String name;
	
	@Column(name="valu",nullable = true)
	private String valu;	
}
