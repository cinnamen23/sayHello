package org.zerock.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.persistence.TimeDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})  //경로 지정하는거 와스 안띄우고 테스트하는 방법  경로안에 있는거를 가지고 테스트를 하겠다 . 
public class ConnectionTest2 {

	
	private static Logger logger
	=Logger.getLogger(ConnectionTest2.class);
	
	@Inject
	private DataSource ds;
	
	@Inject
	ApplicationContext ctx;  
	
	
	@Inject
	SqlSessionFactory sqlFactory;
	
	@Inject
	TimeDAO dao;
	
	
	@Test
	public void testGetTime(){
		logger.info("111111=================================");
		logger.info(dao.getTime());
		logger.info("=================================");
	}
	
	
	
	@Test   //DB가 진짜 연결되는지 확인하는 테스트 
	public void testSession(){
		
		SqlSession sess= sqlFactory.openSession();
		
		logger.info(sess);
		
		String time = sess.selectOne("org.zerock.TimeMapper.getTime");
		
		logger.info("------------------------");
		logger.info(time);
		logger.info("------------------------");
		sess.close();  //DB 닫아주는거 
		
	}
	
	
	
	@Test
	public void testCtx(){
		logger.info(ctx);
		
		Object obj = ctx.getBean("sqlSessionFactory");
		
		logger.info(obj);
		
	}
	
	
	
	@Test
	public void testLoading(){
		logger.info("test loading");
		logger.info(ds);
	
		try(Connection con = ds.getConnection()){
			
			logger.info(con);
		}catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	
}
