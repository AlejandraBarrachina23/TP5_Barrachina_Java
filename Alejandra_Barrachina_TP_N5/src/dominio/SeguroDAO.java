package dominio;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Statement;

public class SeguroDAO {

	private String host = "jdbc:mysql://localhost:3306/";  
	private String user = "root";
	private String password = "";
	private String dbName = "segurosgroup?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	Connection Conexion = null;
	
	public Connection ConectarBaseDatos() {
		
		
		Connection Conexion = null;
		
		 
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Conexion = DriverManager.getConnection(host+dbName,user,password);		
			
		} 
		
		catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return Conexion;
	}
	
	public ArrayList<String> ListadoTipoSeguro() throws SQLException{
		
		ArrayList<String> ListadoTipoSeguro = new ArrayList<String>();
	    String Consulta = "SELECT * FROM tiposeguros";
	    java.sql.Statement EstablecerConsulta = ((java.sql.Connection) ConectarBaseDatos()).createStatement();
	    ResultSet TablaResultados = EstablecerConsulta.executeQuery(Consulta);		
		
		while(TablaResultados.next()) {
			
			ListadoTipoSeguro.add(TablaResultados.getString("descripcion"));
		}
		
		return ListadoTipoSeguro;
	}
	
	public int NuevoId() throws SQLException {
		
		 String Consulta = "SELECT COUNT(*) FROM seguros";
		 int CantidadFilas = 1;
		 java.sql.Statement EstablecerConsulta = ((java.sql.Connection) ConectarBaseDatos()).createStatement();
		 ResultSet TablaResultados = EstablecerConsulta.executeQuery(Consulta);		
		 if(TablaResultados.next()) {
		       
		        CantidadFilas= TablaResultados.getInt(1);
		     }
		 return CantidadFilas+1;
	}
	

	public void AgregarSeguro(Seguro unNuevoSeguro) {
		
		try {
			  
			  CallableStatement StoredProcedureAgregarMascota = ConectarBaseDatos().prepareCall("CALL AgregarSeguro(?,?,?,?)");
			  StoredProcedureAgregarMascota.setString(1,unNuevoSeguro.getDescripcion());
			  StoredProcedureAgregarMascota.setDouble(2,unNuevoSeguro.getCostoContratacion());
			  StoredProcedureAgregarMascota.setDouble(3,unNuevoSeguro.getCostoAsegurado());
			  StoredProcedureAgregarMascota.setInt(4,unNuevoSeguro.getTipoSeguro().getIdTipo());
			  StoredProcedureAgregarMascota.execute();

		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}  	
	}
	
	public ArrayList<TipoSeguro> ListarTipoSeguro() throws SQLException {
		
		ArrayList<TipoSeguro> ListadoTipoSeguro = new ArrayList<TipoSeguro>();
	    String Consulta = "SELECT * FROM TipoSeguros";
	    java.sql.Statement EstablecerConsulta = ConectarBaseDatos().createStatement();
	    ResultSet TablaResultados = EstablecerConsulta.executeQuery(Consulta);		
		
		while(TablaResultados.next()) {
			
			TipoSeguro unTipoSeguro = new TipoSeguro();
			unTipoSeguro.setIdTipo(TablaResultados.getInt("idTipo"));
			unTipoSeguro.setDescripcion(TablaResultados.getString("descripcion"));
			ListadoTipoSeguro.add(unTipoSeguro);
		}
		
	return ListadoTipoSeguro;
	
	}

	

public ArrayList<Seguro> ListarSeguros() throws SQLException {
		
		ArrayList<Seguro> ListadoSeguros = new ArrayList<Seguro>();
	    String Consulta = "SELECT * FROM Seguros INNER JOIN TipoSeguros ON Seguros.idTipo = TipoSeguros.idTipo";
	    java.sql.Statement EstablecerConsulta = ConectarBaseDatos().createStatement();
	    ResultSet TablaResultados = EstablecerConsulta.executeQuery(Consulta);		
		
		while(TablaResultados.next()) {
			
			Seguro unSeguro = new Seguro();
			TipoSeguro unTipoSeguro = new TipoSeguro();
			
			unSeguro.setIdSeguro(TablaResultados.getInt("idSeguro"));
			unSeguro.setDescripcion(TablaResultados.getString("seguros.descripcion"));
			unTipoSeguro.setIdTipo(TablaResultados.getInt("TipoSeguros.idTipo"));
			unTipoSeguro.setDescripcion(TablaResultados.getString("TipoSeguros.descripcion"));
			unSeguro.setTipoSeguro(unTipoSeguro);
			unSeguro.setCostoContratacion(TablaResultados.getDouble("costoContratacion"));
			unSeguro.setCostoAsegurado(TablaResultados.getDouble("costoAsegurado"));
			ListadoSeguros.add(unSeguro);
		}
		
	return ListadoSeguros;
	
	}


public ArrayList<Seguro> ListarSegurosPorTipo(int CodigoTipo) throws SQLException {
	
	ArrayList<Seguro> ListadoSeguros = new ArrayList<Seguro>();
    String Consulta = "SELECT * FROM Seguros INNER JOIN TipoSeguros ON Seguros.idTipo = TipoSeguros.idTipo WHERE Seguros.idTipo = " + CodigoTipo;
    java.sql.Statement EstablecerConsulta = ConectarBaseDatos().createStatement();
    ResultSet TablaResultados = EstablecerConsulta.executeQuery(Consulta);		
	
	while(TablaResultados.next()) {
		
		Seguro unSeguro = new Seguro();
		TipoSeguro unTipoSeguro = new TipoSeguro();
		
		unSeguro.setIdSeguro(TablaResultados.getInt("idSeguro"));
		unSeguro.setDescripcion(TablaResultados.getString("seguros.descripcion"));
		unTipoSeguro.setIdTipo(TablaResultados.getInt("TipoSeguros.idTipo"));
		unTipoSeguro.setDescripcion(TablaResultados.getString("TipoSeguros.descripcion"));
		unSeguro.setTipoSeguro(unTipoSeguro);
		unSeguro.setCostoContratacion(TablaResultados.getDouble("costoContratacion"));
		unSeguro.setCostoAsegurado(TablaResultados.getDouble("costoAsegurado"));
		ListadoSeguros.add(unSeguro);
	}
	
return ListadoSeguros;

}
	
}
