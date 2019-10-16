package dominio;

public class Seguro {

	private int idSeguro;
	private String descripcion;
	private TipoSeguro tipoSeguro;
	private double costoContratacion;
	private double costoAsegurado;
	
	public int getIdSeguro() {
		return idSeguro;
	}
	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public TipoSeguro getTipoSeguro() {
		return tipoSeguro;
	}
	public void setTipoSeguro(TipoSeguro tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}
	public double getCostoContratacion() {
		return costoContratacion;
	}
	public void setCostoContratacion(double costoContratacion) {
		this.costoContratacion = costoContratacion;
	}
	public double getCostoAsegurado() {
		return costoAsegurado;
	}
	public void setCostoAsegurado(double costoAsegurado) {
		this.costoAsegurado = costoAsegurado;
	}
	
}

