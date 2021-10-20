package shutup.code.j004.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import shutup.code.j004.domain.Dept;

@RunWith(SpringRunner.class)
@Slf4j
@Commit
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class T002_DEPT_CRUD {
	
	@Autowired
	private DeptRepository deptRepository;

	@Test
	public void A001_부서명_검색() {
		deptRepository.findByDnameContaining("A").forEach(dept -> {
			log.debug(dept.toString());
		});
	}
	
	@Test
	public void A002_부서명_검색_올림차순() {
		deptRepository.findByDnameContainingOrderByDnameAsc("A").forEach(dept -> {
			log.debug(dept.toString());
		});
	}
	
	@Test
	public void A003_부서명_검색_내림차순() {
		deptRepository.findByDnameContainingOrderByDnameDesc("A").forEach(dept -> {
			log.debug(dept.toString());
		});
	}
	
	@Test
	public void A004_부서명_검색_갯수() {
		Long cnt = deptRepository.countByDnameContaining("A");
		log.debug(String.valueOf(cnt));

	}
	
	@Test
	public void A005_페이징_테스트를_위한_부서번호_대량_입력() {
		
		List<Dept> deptList = new ArrayList<Dept>();
		
		for(Long i = 9000L; i< 9999L; i++) {
			Dept dept = new Dept();
			dept.setDeptno(i);
			dept.setDname(String.valueOf(i));
			deptList.add(dept);
		}
		deptRepository.saveAll(deptList);
		
	}
	
	@Test
	public void A006_부서명칭_단순검색_페이징() {
		String searchDname = "9";
		
		// 페이지마다 사이즈
		int pageSize = 10;
		
		// 총 검색 결과를 알고 있어야 페이징 가능
		Long cnt = deptRepository.countByDnameContaining(searchDname);
		
		int pageCnt = (int)(cnt/pageSize);
		
		for(int i=0; i<pageCnt + 1; i++) {
			log.debug("==========> ["+(i+1)+"] Page");
			Pageable pageable = PageRequest.of(i, pageSize, Sort.Direction.ASC, "dname");
			
			deptRepository.findByDnameContaining(searchDname, pageable).forEach(dept -> {
				log.debug(dept.toString());
			});
		}
		
		
		
		
		
		
		
	}
}
