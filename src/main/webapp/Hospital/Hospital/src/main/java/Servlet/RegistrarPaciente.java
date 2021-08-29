package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class RegistrarPaciente
 */
@WebServlet("/RegistrarPaciente")
public class RegistrarPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public RegistrarPaciente() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	private java.sql.Connection con;
	private Statement set;
	private ResultSet rs;
    
    public void init(ServletConfig cfg) throws ServletException{
        //el constructor nos va ayudar a conectarnos con l bd
        
        String url = "jdbc:mysql:3306//localhost/medicos";
                    //tipodriver:gestorbd:puerto//IP/nombrebd
                    
        String userName = "root";
        String password = "ingeneria1999N";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");

            url = "jdbc:mysql://localhost/medicos";
            con = DriverManager.getConnection(url, userName, password);
            set = con.createStatement();
            
            System.out.println("Conexion Exitosa");
        
        }catch(Exception e){
            
            System.out.println("Conexion no Exitosa");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        
        }
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		try (PrintWriter out = response.getWriter()){
			
			String nom, appat, apmat, tel, fecn, curp, regis, alergia;
			String tsan, estad, ocup,  gen, user, pass, dic;
			int al, id;
			
			id = Integer.parseInt(request.getParameter("folio"));
			nom = request.getParameter("nombre");
			appat = request.getParameter("appat");
			apmat = request.getParameter("apmat");
			tel = request.getParameter("tele");
			fecn = request.getParameter("fech");
			curp = request.getParameter("curp");
			regis = request.getParameter("fregis");
			alergia = request.getParameter("alerg");
			tsan = request.getParameter("tsangre");
			estad = request.getParameter("estadoc");
			ocup = request.getParameter("ocupa");
			al = Integer.parseInt(request.getParameter("alta"));
			gen = request.getParameter("gene");
			user = request.getParameter("use");
			pass = request.getParameter("pass");
			dic = request.getParameter("dic");
			
			
			
			try {
				
				String q = "insert into mpaciente "
						+ "(nss, nombre_pac, appat_pac, apmat_pac, tel_pac, fechanac_pac, CURP, alta_pac, CAlergia_id_alergia, CTiposangre_id_tiposan, CEstadoCivil_id_edoci, COcupacion_id_ocu, DPaciente_id_dpaciente, CGenero_id_gen, user_pac, pass_pac, DDireccion_id_dir)"
						+"values "
						+"('"+id+"','"+nom+"', '"+appat+"', '"+apmat+"', '"+tel+"', '"+fecn+"', '"+curp+"', '"+regis+"', '"+alergia+"', '"+tsan+"', '"+estad+"', '"+ocup+"', '"+al+"', '"+gen+"', '"+user+"', '"+pass+"', '"+dic+"')";
				
				set.executeUpdate(q);
				System.out.println("Registro en la tabla");
				
	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title></title>");            
	            out.println("</head>");
	            out.println("<body>"
	            		+"<header>"
	                    +"<div class='Menu'>"
	                    +"<ul class='Moviemiento'>"    
	                    +"<a href='Index.html'>Inicio</a>"
	                    
	                    +"<a href='NuestrosDoctores.html'>Buccar doctor</a>"
	                          
	                    
	                    +"<a href=''>Cita</a>"         
	                    
	                    +"<a href='Registrarse.html'>Registrarse</a>"  
	                    
	                    +"<a href='CPerfil.html'>Iniciar sesion</a>"
	                    
                        +"<input type='button' value='Buscar'> <input type='text'>"
                        
	                    +"</ul>"
	                    +"</div>"
	                    +"</header>"
	            		+"<div>"
	            	    +"<img src='Imagenes/logotipo.jepg'>"
	            	    +"<h1>Iniciar Sesion</h1>"
	            	    +"<form name='formulario2' method='post' action='IniciarSesion'>"
	            	    +"<label>Usuario</label>"
	            	    +"<input type='email' placeholder='Ingresar Usuario' name='use'>"
	            	    +"<label for='password'>Contrasena</label>"
	            	    +"<input type='password' placeholder='Ingresar Contrasena' name='pass'>"
	            	    +"<input type='submit' value='Iniciar'>"
	            	    +"<br>"
	            	    +"<a href='#'>Olvidaste tu Contrasena?</a>"
	            	    +"<br>"
	            	    +"<a href='Registrarse.html'>Registrarse</a>"
	            	    +"</form>"
	            	    +"</div>");
	            out.println("</body>");
	            out.println("</html>");
	            
				
			}catch(Exception e){
				System.out.println("Error al registrar en la tabla");
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
				
				
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Registro</title>");            
                out.println("</head>");
                out.println("<body>"
                		+"<h1>Registro No Encontrado</h1>"
                        + "<br>");
                out.println("</body>");
                out.println("</html>");
			}
			
		}
		
	}

}
