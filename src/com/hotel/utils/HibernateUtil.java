package com.hotel.utils;

import java.util.List;

public interface HibernateUtil {
	/*ͳһ���޸ĺ�ɾ��(���� hql)*/
	public void executeUpdate(String hql,String []parameters);
	//ͳһ����ӷ���
	public void save(Object obj);
	//�ṩһ��ͳһ�Ĳ�ѯ����(����ҳ) hql ��ʽ from �� where ����=��
	//pageSize��ÿҳ��ʾ��������
	//pageNow:��ʾ�ڼ�ҳ
	public List executeQueryByPage(String hql,String [] parameters,int pageSize,int pageNow);
	//�ṩһ��ͳһ�Ĳ�ѯ���� hql ��ʽ from �� where ����=��
	public List executeQuery(String hql,String [] parameters );
	//�ж��Ƿ��������
	public int isExist(String hql,String [] parameters);
}
