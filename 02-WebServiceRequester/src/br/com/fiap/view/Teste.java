package br.com.fiap.view;

import java.rmi.RemoteException;
import java.util.GregorianCalendar;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.ClienteBOStub;
import br.com.fiap.bo.ClienteBOStub.Cadastrar;
import br.com.fiap.bo.ClienteBOStub.Cliente;

public class Teste {

	public static void main(String[] args) {
		try {
			ClienteBOStub stub = new ClienteBOStub();
			
			Cliente cliente = new Cliente();
			
			cliente.setCodigo(0);
			cliente.setDataNascimento(new GregorianCalendar(2017, 1, 17));
			cliente.setEmail("Fernandatupam@gmail.com");
			cliente.setNome("Fernanda");
			
			Cadastrar params = new Cadastrar();
			
			params.setCli(cliente);
			
			stub.cadastrar(params);
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
