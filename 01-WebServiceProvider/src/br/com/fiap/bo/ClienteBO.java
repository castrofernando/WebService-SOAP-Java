package br.com.fiap.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class ClienteBO {

	EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

	
	public void cadastrar(Cliente cli) {
		
		ClienteDAO clienteDao = new ClienteDAOImpl(em);

		clienteDao.cadastrar(cli);

		try {
			clienteDao.salvar();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	public List<Cliente> listar() {
		
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		
		List<Cliente> lista = clienteDao.listar();
		
		em.close();
		return lista;
	}
	
	public Cliente buscar(int id){
		
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		
		Cliente c = clienteDao.pesquisar(id);
		
		em.close();
		 
		return c;
	}
	
}
