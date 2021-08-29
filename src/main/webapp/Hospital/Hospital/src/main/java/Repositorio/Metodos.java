package Repositorio;

import java.util.ArrayList;

import Control.AccionesPaciente;
import Modelo.Paciente;
import Modelo.Personal;

public class Metodos {
	
	public ArrayList<Personal> getNombreyApellidoPer(String nombre, String apePatPer) {
		AccionesPaciente repository = new AccionesPaciente();
		return repository.getNombreyApellidoPer(nombre, apePatPer);
	}
	
	public ArrayList<Paciente> getPerfilPaciente(int nss, String nombre_pac, String appat_pac, String apmat_pac, String fechanac_pac, String CURP,
			String DOireccion, String user, String pass, String tel_pac, String Tipo_genero){
		AccionesPaciente repository = new AccionesPaciente();
		return repository.getPerfilPaciente(nss, nombre_pac, appat_pac, apmat_pac, fechanac_pac, CURP, DOireccion, user, pass, tel_pac, Tipo_genero);    
	}
	
	
	
	public ArrayList<Paciente> getHistorialC(int nss,String nombre_pac, String appat_pac , String apmat_pac, String fechanac_pac){
		AccionesPaciente repos = new AccionesPaciente();
		return repos.getHistorialC(nss, nombre_pac, appat_pac, apmat_pac, fechanac_pac);
		 
}
}
