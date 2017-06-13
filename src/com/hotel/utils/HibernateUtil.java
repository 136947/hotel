package com.hotel.utils;

import java.util.List;

public interface HibernateUtil {
	/*统一的修改和删除(批量 hql)*/
	public void executeUpdate(String hql,String []parameters);
	//统一的添加方法
	public void save(Object obj);
	//提供一个统一的查询方法(带分页) hql 形式 from 类 where 条件=？
	//pageSize：每页显示几条数据
	//pageNow:显示第几页
	public List executeQueryByPage(String hql,String [] parameters,int pageSize,int pageNow);
	//提供一个统一的查询方法 hql 形式 from 类 where 条件=？
	public List executeQuery(String hql,String [] parameters );
	//判断是否存在数据
	public int isExist(String hql,String [] parameters);
}
