package com.ltts.project.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ltts.project.model.Complaint;
import com.ltts.project.model.Member;

@Repository
public class ComplaintDao {

	@Autowired
	private EntityManager em;
	
	@Autowired
	private SessionFactory sf;
	
	
	public boolean InsertComplaint(Complaint c) {
		boolean b=false;
		Session s=null;
		try {
			s=sf.openSession();
			s.beginTransaction();
			
			s.save(c);
			//System.out.println(st);
			s.getTransaction().commit();
			
		}
		catch(Exception e) {
			System.out.println("Exception "+e);
			b=true;
		}
		finally {
			sf.close();
		}
		
		return b;
	}
	
	
	/*
	 * public List<Member> getMembers(){ List }
	 */
	
     public Complaint getComplaintById(String comid) {
    	 Complaint c = (Complaint)sf.openSession().get(Complaint.class,comid);
		//Complaint c=new Complaint();
		
		
		return c;
	}
     public List<Complaint> getAllComplaint(){
 		Session session=sf.openSession();
         session.beginTransaction();
         
         List<Complaint> li=sf.openSession().createCriteria(Complaint.class).list();
         //List<ProductsModel> product=sessionFactory.openSession().createCriteria(ProductsModel.class).list();
         
         session.getTransaction().commit();
      
 		return li;
 		
 	}
	
}
