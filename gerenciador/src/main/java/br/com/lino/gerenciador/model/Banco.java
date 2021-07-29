package br.com.lino.gerenciador.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("LinoTech");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Alura");
		empresas.add(empresa);
        empresas.add(empresa2);
        
        Usuario u1 = new Usuario();
        u1.setLogin("fabio");
        u1.setSenha("12345");
        Usuario u2 = new Usuario();
        u2.setLogin("sarah");
        u2.setSenha("12345");
        
        listaUsuarios.add(u1);
        listaUsuarios.add(u2);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.empresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.empresas;
	}

	public void removeEmpresa(Integer id) {
		
		Iterator<Empresa> it = empresas.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			
			if(emp.getId() == id) {
				it.remove();
			}
		}
//		empresas.removeIf(empresa -> empresa.getId() == id);
//		for (Empresa empresa : empresas) {
//			if(empresa.getId() == id) {
//				empresas.remove(empresa);
//			}
//		}
		
	}

	public Empresa buscaEmpresaId(Integer id) {
		
		for (Empresa empresa : empresas) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for(Usuario usuario : listaUsuarios) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}

}
