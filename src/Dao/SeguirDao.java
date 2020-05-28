package Dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import Dto.Seguir;
import Dto.Tienda;
import Util.Conexion;

public class SeguirDao implements Serializable {

	private Seguir seguirs;
	private List<Seguir> seguir= new ArrayList(); 
	
	EntityManager em=null;
	
	public SeguirDao () {
		
		em = Conexion.getEm();
	}
	
	public void registrar(Seguir seguir) {

		try {
			em.getTransaction().begin();
			 em.persist(seguir);
			 em.getTransaction().commit();
			 } catch (Exception e) {
			 e.printStackTrace();
			 }finally {
			 //em.close();
			 }
	}
}
