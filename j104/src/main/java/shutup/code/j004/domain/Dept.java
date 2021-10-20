package shutup.code.j004.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "empList")
@Entity
@Table(name = "dept")
public class Dept {
	
	public Dept() {}
	public Dept(Long deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
	@Id
	private Long deptno;
	
	private String dname;
	
	private String  loc;
	
    @OneToMany(mappedBy = "dept", cascade  = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Emp> empList;

}
