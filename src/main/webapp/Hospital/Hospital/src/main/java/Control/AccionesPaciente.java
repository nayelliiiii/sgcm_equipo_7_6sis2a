package Control;

import Modelo.Paciente;
import Modelo.Personal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class AccionesPaciente {
    private static final Logger LOG = Logger.getLogger(AccionesPaciente.class.getCanonicalName());
    
 
	//CONSULTAR PERFIL
	public ArrayList<Paciente> getPerfilPaciente(int nss, String nombre_pac, String appat_pac, String apmat_pac, String fechanac_pac, String CURP,
			String DOireccion, String user, String pass, String tel_pac, String Tipo_genero) {
		DBConnection db = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<Paciente> response = null;
		Connection cnn = null;
		try {
			db = new DBConnection();
			db.setDbname("medicos");
			db.setUser("root");
			db.setPassword("ingeneria1999N");
			db.setDriver("com.mysql.jdbc.Driver");
			db.setUrl("jdbc:mysql://localhost:3306/");
			db.openDB();
			cnn = db.getConnection();
			
			LOG.info("select nss, nombre_pac, appat_pac, apmat_pac, fechanac_pac, CURP, DDireccion_id_dir, tel_pac, user_pac, pass_pac, CGenero_id_gen"
					+ " from MPaciente where nss = \"" + nss +"\" ");
					
			stm = cnn.prepareStatement("select nss, nombre_pac, appat_pac, apmat_pac, fechanac_pac, CURP, DDireccion_id_dir, tel_pac, user_pac, pass_pac, CGenero_id_gen from MPaciente where nss = ?");
			stm.setInt(1, nss);
			stm.execute();
			rs = stm.getResultSet();
			
			response = new ArrayList<Paciente>();
			while(rs.next()) {
				Paciente aux = new Paciente();
				aux.setNss(rs.getInt(1));
				aux.setNombre_pac(rs.getString(2));
				aux.setAppat_pac(rs.getString(3));
				aux.setApmat_pac(rs.getString(4));
				aux.setFechanac_pac(rs.getString(5));
				aux.setCURP(rs.getString(6));
				aux.setDOireccion(rs.getString(7));
				aux.setTel_pac(rs.getString(8));
				aux.setUser(rs.getString(9));
				aux.setPass(rs.getString(10));
				aux.setTipo_genero(rs.getString(11));
				response.add(aux);
			}
			stm.close();
			rs.close();
			db.closeDB();
			return response;
		} catch (Exception ex) {
			LOG.log(Level.SEVERE, "Error in getPerfilPaciente", ex);
			return new ArrayList<Paciente>();
		} finally {
			db = null;
			rs = null;
			response = null;
			cnn = null;
		}
	}
	
	//CONSULTAR CITA PACIENTE
	/*public  int ConsultarCP(Paciente e) {
		int status=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
   		 conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/medicos", "root", "$baga$2");
   		 set = conexion.createStatement();
			String q = "insert into MCita(nss, fecha_cita, hora_cita)"
					+ "values(?,?,?)";
			
			PreparedStatement ps = conexion.prepareStatement(q);
			
		    ps.setInt(1, e.getId_usuario());
			ps.setString(2, e.getFecha_cita());
            ps.setString(3, e.getHora_cita());
            
            status = ps.executeUpdate();
            System.out.println("Registro Exitoso del Empleado");
            conexion.close();
            
			
		}catch(Exception ed) {
			 System.out.println("Error al registrar la cita del paciente");
	            System.out.println(ed.getMessage());
		}
		return status;	
	}*/
	
	//CONSULTAR HISTORIAL PACIENTE
	public ArrayList<Paciente> getHistorialC(int nss, String nombre_pac, String appat_pac , String apmat_pac, String fechanac_pac) {
		//
		DBConnection db = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<Paciente> response = null;
		Connection cnn = null;
		try {
			db = new DBConnection();
			db.setDbname("medicos");
			db.setUser("root");
			db.setPassword("ingeneria1999N");
			db.setDriver("com.mysql.jdbc.Driver");
			db.setUrl("jdbc:mysql://localhost:3306/");
			db.openDB();
			cnn = db.getConnection();
			
			LOG.info("select nss, nombre_pac, appat_pac, apmat_pac, fechanac_pac from MPaciente where nss = \"" + nss + "\""); 
					//
			
			stm = cnn.prepareStatement("select nss, nombre_pac, appat_pac, apmat_pac, fechanac_pac from MPaciente where nss = ?");
					
			stm.setInt(1, nss);
			
			stm.execute();
			rs = stm.getResultSet();
			
			response = new ArrayList<Paciente>();
			while(rs.next()) {
				Paciente aux = new Paciente();
				aux.setNss(rs.getInt(1));
				aux.setNombre_pac(rs.getString(2));
				aux.setAppat_pac(rs.getString(3));
				aux.setApmat_pac(rs.getString(4));
				aux.setFechanac_pac(rs.getString(5));
				response.add(aux);
			}
			stm.close();
			rs.close();
			db.closeDB();
			return response;
		} catch (Exception ex) {
			LOG.log(Level.SEVERE, "Error en getHistorialC", ex);
			return new ArrayList<Paciente>();
		} finally {
			db = null;
			rs = null;
			response = null;
			cnn = null;
		}
	}
	
		//CONSULTAR MEDICOS
	public ArrayList<Personal> getNombreyApellidoPer(String nombre, String apePatPer) {
		DBConnection db = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<Personal> response = null;
		Connection cnn = null;
		try {
			db = new DBConnection();
			db.setDbname("medicos");
			db.setUser("root");
			db.setPassword("ingeneria1999N");
			db.setDriver("com.mysql.jdbc.Driver");
			db.setUrl("jdbc:mysql://localhost:3306/");
			db.openDB();
			cnn = db.getConnection();
			
			LOG.info("select nombre_per, appat_per from MPersonal where nombre_per = \"" + nombre +"\" "
					+ "and appat_per = \"" + apePatPer + "\"");
			stm = cnn.prepareStatement("select nombre_per, appat_per from MPersonal where nombre_per = ? and appat_per = ?");
			stm.setString(1, nombre);
			stm.setString(2, apePatPer);
			stm.execute();
			rs = stm.getResultSet();
			
			response = new ArrayList<Personal>();
			while(rs.next()) {
				Personal aux = new Personal();
				aux.setNombrePer(rs.getString(1));
				aux.setApePatPer(rs.getString(2));
				response.add(aux);
			}
			stm.close();
			rs.close();
			db.closeDB();
			return response;
		} catch (Exception ex) {
			LOG.log(Level.SEVERE, "Error en getNombreyApellidoPer", ex);
			return new ArrayList<Personal>();
		} finally {
			db = null;
			rs = null;
			response = null;
			cnn = null;
		}
	}

}
