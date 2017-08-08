package com.h066it.test;

import javax.persistence.*;

import com.h066it.dto.Member;

import java.util.List;

public class test {

	public static void main(String[] args) {

		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("JPA_training");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			logic(em);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
	
	private static void logic(EntityManager em) {
		String id = "id1";
		
		Member member = new Member();
		
		member.setId(id);
		member.setUsername("ม๖วั");
		member.setAge(2);
		
		//create
		em.persist(member);
		
		//update
		member.setAge(20);
		
		//read
		Member findMember = em.find(Member.class, id);
		System.out.println("findMember = " + findMember.getUsername() + 
			", age = " + findMember.getAge());
		
		//read all
		List<Member> members =
			em.createQuery("SELECT m FROM Member m", Member.class).getResultList();
		System.out.println("member.size = " + members.size());
		
		//delete
		em.remove(member);
	}
}
