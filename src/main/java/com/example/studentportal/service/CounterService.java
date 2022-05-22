package com.example.studentportal.service;

import com.example.studentportal.dao.CounterDao;
import com.example.studentportal.model.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CounterService {
    @Autowired
    private CounterDao counterDao;

    public int getStudentId(){
        Counter c = counterDao.getId();
        int id = c.getStudentId();
        updateStudentId(id,id+1);
        return id;
    }

    public int getTeacherId(){
        Counter c = counterDao.getId();
        int id = c.getTeacherId();
        updateTeacherId(id,id+1);
        return c.getTeacherId();
    }

    public void updateStudentId(int oid,int nid){
        counterDao.updateStudentId(oid,nid);
    }

    public void updateTeacherId(int oid,int nid){
        counterDao.updateTeacherId(oid,nid);
    }
}
