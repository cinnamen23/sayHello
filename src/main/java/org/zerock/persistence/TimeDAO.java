package org.zerock.persistence;
import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;


@Repository     //이거 걸어주면 스프링의 빈으로 인식을 해야한다 . 
public class TimeDAO {

	
	@Inject      //만들어서 이거를 주입받는거 하는데 이것조차 불편하면 상속구조로 만들어내야한다.
	private SqlSessionTemplate session;

	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	public String getTime(){   //try catch 없고 
		return session.selectOne("org.zerock.TimeMapper.getTime");
		
	}
	
}
