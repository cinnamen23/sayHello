package org.zerock.persistence;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;

public abstract class GenericDAO<E,K> { 
	
	
	
	@Inject
	protected SqlSessionTemplate sess;
	
	protected String mapper;
	
	GenericDAO(){
		
		mapper = this.getClass().getName();
		
	}


	//제네릭 쓸려고 메소드 생성 

	
	public void create(E vo){
		sess.insert(mapper+".create",vo);
	}
	
	public E read(K key){
		return sess.selectOne(mapper+".read",key);
	}
	
	public void update(E vo){
		sess.update(mapper + ".update", vo);
	}
	
	public void delete(K key){
		sess.delete(mapper + ".delete", key);
	}
	
}




