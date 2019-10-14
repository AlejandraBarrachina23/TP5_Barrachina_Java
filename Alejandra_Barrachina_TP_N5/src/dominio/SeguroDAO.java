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
	private String dbName = "segurosgroup";
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
	

	public void AgregarSeguro(Seguro unNuevoSeguro) {
		
		try {
			  
			  CallableStatement StoredProcedureAgregarMascota = ConectarBaseDatos().prepareCall("CALL AgregarSeguro(?,?,?,?)");
			  StoredProcedureAgregarMascota.setString(1,unNuevoSeguro.getDescripcion());
			  StoredProcedureAgregarMascota.setDouble(2,unNuevoSeguro.getCostoContratacion());
			  StoredProcedureAgregarMascota.setDouble(3,unNuevoSeguro.getCostoAsegurado());
			  StoredProcedureAgregarMascota.setInt(4,unNuevoSeguro.getIdTipo());
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
	
	
	
/*	
	public void EliminarMascota(Mascota MascotaEliminar) throws SQLException {
			  
		  CallableStatement StoredProcedureEliminarMascota = ConectarBaseDatos().prepareCall("CALL EliminarMascota(?)");
		  StoredProcedureEliminarMascota.setInt(1,MascotaEliminar.getID());
		  StoredProcedureEliminarMascota.execute(); 
	}
	 
	
	
	

	*/

}
