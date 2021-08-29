package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Paciente;
import Repositorio.Metodos;


@WebServlet("/HistorialClinico")


public class HistorialClinico extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	//vamos a crear el metodo constructor
    public void init(ServletConfig cfg) throws ServletException{}
           
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//atributos
			int nss = 0;
			String nombre_pac;
			String appat_pac;
			String apmat_pac;
			String fechanac_pac;
			
			
			PrintWriter out = response.getWriter();
			try {
				nss=Integer.parseInt(request.getParameter("nss"));
				nombre_pac = request.getParameter("nombre_pac");
				appat_pac = request.getParameter("appat_pac");
				apmat_pac = request.getParameter("apmat_pac");
				fechanac_pac = request.getParameter("fechanac_pac");
				metodo = new Metodos();
				responseDB = metodo.getHistorialC(nss, nombre_pac, appat_pac, apmat_pac, fechanac_pac);
		
				if(responseDB.isEmpty()) {
					response(response, "No se encontraron registros");
				} else {
					out.println("<html>");
					out.println("<body>");
					for(int i = 0; i < responseDB.size(); i++) {
						out.println("<t1>" +responseDB.get(i).getNss() + ""
								+ responseDB.get(i).getNombre_pac() + " "
									+ responseDB.get(i).getAppat_pac() + ""
									+ responseDB.get(i).getApmat_pac()+ ""
									+ responseDB.get(i).getFechanac_pac() + "</t1>");
					}
					out.println("</body>");
					out.println("</html>");
				}
			} catch (Exception ex) {
				System.out.println("Error en la conexion");
				Logger.getLogger(HistorialC.class.getCanonicalName()).log(Level.SEVERE, null, ex);
				response(response, "Ocurrio un error: " + ex.getLocalizedMessage());
			}
	}
	private void response(HttpServletResponse response, String msg) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>" + msg + "</t1>");
		out.println("</body>");
		out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}