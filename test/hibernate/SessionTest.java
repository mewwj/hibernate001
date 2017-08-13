package hibernate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

public class SessionTest {

	@Test
	public void tsetOpenSession() {
		// 获得配置对象
		Configuration config = new Configuration().configure();
		// 获得服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		// 获得SessionFactory对象
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		// 获得session对象
		Session session = sessionFactory.openSession();
		Session session2 = sessionFactory.openSession();
		System.out.println(session=session2);
		if (session != null) {
			System.out.println("ok!");
		} else
			System.out.println("default！");
	}

	@Test
	public void testGetCurrentSession() {
		// 获得配置对象
				Configuration config = new Configuration().configure();
				// 获得服务注册对象
				ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
				// 获得SessionFactory对象
				SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
				// 获得session对象
				Session session = sessionFactory.getCurrentSession();
				Session session2 = sessionFactory.getCurrentSession();
				System.out.println(session==session2);
				if (session != null) {
					System.out.println("ok!");
				} else
					System.out.println("default！");
	}
	@Test
  public void TestSessionUseOpenSession(){
		Configuration config = new Configuration().configure();
		// 获得服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		// 获得SessionFactory对象
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		// 获得session对象
		Session session = sessionFactory.openSession();
	    Transaction transaction=session.beginTransaction();
         Students s=new Students(1,"孙悟空",new Date());
         session.doWork(new Work(){
			@Override
			public void execute(Connection connection) throws SQLException {
				System.out.println("connection hsahcode:"+connection.hashCode());  
			}});
		
		session.save(s);
		transaction.commit();
		
		  Session session1 = sessionFactory.openSession();
	       transaction=session1.beginTransaction();
           s=new Students(2,"猪八戒",new Date());
         session.doWork(new Work(){
			@Override
			public void execute(Connection connection) throws SQLException {
				System.out.println("connection hsahcode:"+connection.hashCode());  
			}});
		session1.save(s);
		transaction.commit();
		
  }
	
}