package Dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;


import Dto.Tienda;
import Util.Conexion;

public class TiendaDao implements Serializable {

	private Tienda tienda;
	private List<Tienda> tiendas= new ArrayList(); 
	
	EntityManager em=null;
	
	public TiendaDao () {
		
		em = Conexion.getEm();
	}
	
	public void registrar(Tienda tienda) {

		try {
			em.getTransaction().begin();
			 em.persist(tienda);
			 em.getTransaction().commit();
			 } catch (Exception e) {
			 e.printStackTrace();
			 }finally {
			 //em.close();
			 }
	}
	
	public void actualizar (Tienda tienda) {
		 try {
			 em.getTransaction().begin();
			 em.merge(tienda);
			 em.getTransaction().commit();
			 } catch (Exception e) {
			 e.printStackTrace();
			 }finally {
			// em.close();
			 }
	}	
}
