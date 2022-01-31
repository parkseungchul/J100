package com.psc.spring.j108.service;

import com.psc.spring.j108.db1.domain.Dept1;
import com.psc.spring.j108.db1.repository.DeptRepository1;
import com.psc.spring.j108.db2.repository.DeptRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    DeptRepository1 deptRepository1;

    @Autowired
    DeptRepository2 deptRepository2;


    @Override
    @Transactional
    public void tranXATest() {
        Dept1 dept50 = new Dept1(50, "CCCC", "CCCC");
        deptRepository1.save(dept50); // 세이브가 되면 안됨...
        deptRepository2.deleteAll(); // 여기서 무조건 에러 발생 !!!


    }

    @Override
    public void tranNonXATest() {
        Dept1 dept50 = new Dept1(50, "CCCC", "CCCC");
        deptRepository1.save(dept50); // 세이브가  됨
        deptRepository2.deleteAll(); // 여기서 무조건 에러 발생 !!!
    }
}
