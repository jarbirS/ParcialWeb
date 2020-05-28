package Dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import Dto.Cliente;
import Dto.Servicio;
import Util.Conexion;

public class ClienteDao implements Serializable {

	private Cliente cliente;
	private List<Cliente> clientes= new ArrayList(); 
	
	EntityManager em=null;
	
	public ClienteDao () {
		
		em = Conexion.getEm();
	}
	
	public void registrar(Cliente cliente) {

		try {
			em.getTransaction().begin();
			 em.persist(cliente);
			 em.getTransaction().commit();
			 } catch (Exception e) {
			 e.printStackTrace();
			 }finally {
			 //em.close();
			 }
	}
	
}

