package servlet;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Seguro;
import dominio.SeguroDAO;

@WebServlet("/ServletSeguro")
public class ServletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletSeguro() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnAceptar")!=null) {
			
			Seguro unNuevoSeguro = new Seguro();
			unNuevoSeguro.setDescripcion(request.getParameter("tboxDescripcion"));
			unNuevoSeguro.setCostoContratacion(Double.parseDouble(request.getParameter("tboxCostoContratacion")));
			unNuevoSeguro.setCostoAsegurado(Double.parseDouble(request.getParameter("tboxCostoMaximo")));
			unNuevoSeguro.setIdTipo(Integer.parseInt(request.getParameter("TipoSeguro")));
			SeguroDAO Seguro = new SeguroDAO();
			Seguro.AgregarSeguro(unNuevoSeguro);		
					
		}		
	}

}
