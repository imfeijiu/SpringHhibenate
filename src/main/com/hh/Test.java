package com.hh;

import com.hh.entity.Cups;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class Test {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private Cups cups;
    @RequestMapping(value = "get",method = RequestMethod.GET)
    public String get(){
        return "asdfsadfa";
    }
    @RequestMapping(value = "savecups",method = RequestMethod.GET)
    public void select(){
        Session session=sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Cups cups=new Cups();
            Cups cups1=new Cups();
            cups.setName("狗头杯");
            cups.setId(2);
            cups1.setId(3);
            cups1.setName("杯子头");
            session.save(cups);
            int a=1/0;
            session.save(cups1);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }


    }
}
