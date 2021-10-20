package shutup.code.j004.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import shutup.code.j004.domain.Dept;

public interface DeptRepository extends CrudRepository<Dept, Long>{

	/**
	 * 부서명 검색
	 * @param dname
	 * @return
	 */
	List<Dept> findByDnameContaining(String dname);
	
	/**
	 * 부서명 검색, 올림차순
	 * @param dname
	 * @return
	 */
	List<Dept> findByDnameContainingOrderByDnameAsc(String dname);
	
	/**
	 * 부서명 검색, 내림차순
	 * @param dname
	 * @return
	 */
	List<Dept> findByDnameContainingOrderByDnameDesc(String dname);
	
	/**
	 * 부서명 검색 결과 갯수
	 * @param dname
	 * @return
	 */
	Long countByDnameContaining(String dname);
	
	/**
	 * 부서명 검색, 페이징
	 * @param dname
	 * @param pageable
	 * @return
	 */
	List<Dept> findByDnameContaining(String dname, Pageable pageable);
	
	
	
	
	@Query("SELECT D FROM Dept D INNER JOIN Emp E ON D.deptno = E.dept.deptno WHERE D.deptno =:deptno")
	public Dept getDeptDeptno(Long deptno);
	
	
}
