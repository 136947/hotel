package com.hotel.interfaceimp;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.utils.HibernateUtil;




@Transactional
public class HibernateUtilsImp implements HibernateUtil {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void executeUpdate(String hql, String[] parameters) {
		// TODO Auto-generated method stub
		List list = null;
		Query query = sessionFactory.openSession().createQuery(hql);
		//线判断是否有参数要注入
		if(parameters!=null && parameters.length>0){
			for(int i=0;i<parameters.length;i++){
				query.setString(i, parameters[i]);
			}
		}
		int i = query.executeUpdate();//执行更新或删除语句
		System.out.println(i+"行受影响");

	}

	@Override
	public void save(Object obj) {
		// TODO Auto-generated method stub
		 sessionFactory.getCurrentSession().save(obj);
	}

	@Override
	public List executeQueryByPage(String hql, String[] parameters,
			int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		List list = null;
		
		Query query=sessionFactory.openSession().createQuery(hql);
		//线判断是否有参数要注入
		if(parameters!=null && parameters.length>0){
			for(int i=0;i<parameters.length;i++){
				query.setString(i, parameters[i]);
			}
		}
		query.setFirstResult((pageNow-1)*pageSize);
		query.setMaxResults(pageSize);
		list=query.list();
		return list;
	}

	@Override
	public List executeQuery(String hql, String[] parameters) {
		// TODO Auto-generated method stub
		List list = null;
		Query query=sessionFactory.openSession().createQuery(hql);
		System.out.println("11111");
		//线判断是否有参数要注入
		if(parameters!=null && parameters.length>0){
			for(int i=0;i<parameters.length;i++){
				query.setString(i, parameters[i]);
			}
		}
		list=query.list();
		
		return list;
	}
	@Override
	public int isExist(String hql,String [] parameters){
		List list = executeQuery(hql,parameters);
		if(list==null){
		    return 0;
		}
		else{
			return 1;
		}
		
	}
}
