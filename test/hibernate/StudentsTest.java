package hibernate;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;
import java.util.zip.InflaterInputStream;

import javax.imageio.stream.FileImageInputStream;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class StudentsTest {
	
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	@Before
	public void init(){
		//配置对象
		Configuration config=new Configuration().configure();
		//服务注册对象
		org.hibernate.service.ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//创建回话工厂
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		//创建会话对象
		session =sessionFactory.openSession();
		//开启事务
		transaction=session.beginTransaction();
		
		
	}
	@After
    public void destory(){
		transaction.commit();//提交事务
		session.close();  //关闭会话
		sessionFactory.close(); //关闭会话工厂
	}

	
	@Test
	public void testSaveStudents(){
		Students s=new Students();
		s.setBiirthday(new Date());
		s.setName("孙悟空2");
		Address  address= new Address("深圳市","730073","13109324");
		s.setAddress(address);
		session.save(s);
	}
	@Test
	  public void TestSessionUseOpenSession() throws Exception{
		Students s=new Students();
		s.setBiirthday(new Date());
		s.setName("孙悟空2");
		
		//获得照片文件。
		File f=new File("D:"+File.separator+"test.png");
		//获得照片文件的输入流
	    InputStream input=new FileInputStream(f);
	    //创建一个Blob对象
	           Blob image=Hibernate.getLobCreator(session).createBlob(input,input.available());
	    // Blob  image =Hibernate.getLobCreator(session).createBlob(input,input.available());
		//设置照片属性
	    s.setPicture(image);
		session.save(s);
}
	@Test
	public void TestReadBlob() throws Exception{ //从数据库中读出保存进去的image
		Students s=(Students) session.get(Students.class, 0);//主键是0,主键要与数据库里面相对应
		//获得blob对象
		Blob image=s.getPicture();
		//获得照片的输入流
		InputStream input=image.getBinaryStream();
		//获得输出流
		File f=new File("d:"+File.separator+"success.png");
		// 获得输出流
		OutputStream output=new FileOutputStream(f);
		byte buff[]=new byte[input.available()];
		input.read(buff);
		output.write(buff);
		input.close();
		output.close();
		
	}
}