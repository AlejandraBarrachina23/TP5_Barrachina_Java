package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import dominio.Seguro;
import dominio.SeguroDAO;
import dominio.TipoSeguro;

@WebServlet("/ServletSeguro")
public class ServletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletSeguro() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Seguro>ListadoSeguros = new ArrayList<Seguro>();
		
		if(request.getParameter("btnFiltrar")!=null) {
			
			SeguroDAO unSeguro = new SeguroDAO();	
			
			try {
				
				ListadoSeguros = unSeguro.ListarSegurosPorTipo(Integer.parseInt(request.getParameter("TipoSeguro")));
				
			} catch (NumberFormatException e) {	
				
				e.printStackTrace();
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
						
		}
		
		request.setAttribute("ListadoSeguros", ListadoSeguros);
		RequestDispatcher Request = request.getRequestDispatcher("ListarSeguros.jsp");
		Request.forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnAceptar")!=null) {
			
			Seguro unNuevoSeguro = new Seguro();
			TipoSeguro unTipoSeguro = new TipoSeguro();
			unNuevoSeguro.setDescripcion(request.getParameter("tboxDescripcion"));
			unNuevoSeguro.setCostoContratacion(Double.parseDouble(request.getParameter("tboxCostoContratacion")));
			unNuevoSeguro.setCostoAsegurado(Double.parseDouble(request.getParameter("tboxCostoMaximo")));
			unTipoSeguro.setIdTipo(Integer.parseInt(request.getParameter("TipoSeguro")));
			unNuevoSeguro.setTipoSeguro(unTipoSeguro);
			SeguroDAO Seguro = new SeguroDAO();
			Seguro.AgregarSeguro(unNuevoSeguro);		
					
		}
		
		RequestDispatcher Request = request.getRequestDispatcher("AgregarSeguro.jsp");
		Request.forward(request, response);
	}

}
