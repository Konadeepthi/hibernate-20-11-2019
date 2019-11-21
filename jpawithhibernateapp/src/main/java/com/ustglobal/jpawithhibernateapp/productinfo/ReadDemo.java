package com.ustglobal.jpawithhibernateapp.productinfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ustglobal.jspwithhibernateapp.dto.Product;

public class ReadDemo {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("test");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Product productDetail=entityManager.find(Product.class, 101);
		System.out.println("Id is "+productDetail.getPid());
		System.out.println("name is "+productDetail.getPname());
		System.out.println("quantity is "+productDetail.getQuantity());
	}

}
