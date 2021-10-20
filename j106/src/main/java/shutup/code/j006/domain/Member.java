package shutup.code.j006.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="member")
public class Member implements Serializable{
	
	@Id
	private String id;
	
	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;
	
	private boolean enabled;
	
	private String dname;
}
