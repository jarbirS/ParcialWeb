package Dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import Dto.Servicio;
import Util.Conexion;


public class ServicioDao implements Serializable {

	private Servicio servicio;
	private List<Servicio> servicios= new ArrayList(); 
	
	EntityManager em=null;
	
	public ServicioDao () {
		
		em = Conexion.getEm();
	}
	
	public void registrar(Servicio servicio) {

		try {
			em.getTransaction().begin();
			 em.persist(servicio);
			 em.getTransaction().commit();
			 } catch (Exception e) {
			 e.printStackTrace();
			 }finally {
			 //em.close();
			 }
	}
	
}
