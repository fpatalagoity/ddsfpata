
public class Venta {

	private Prenda prenda;
	private Integer cantidad;
	private String fecha;
	
	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Venta(Prenda prenda, Integer cantidad, String fecha) {
		this.prenda=prenda;
		this.cantidad=cantidad;
		this.fecha=fecha;
	}
	
	public double ganancia(){
		return this.getCantidad()*this.prenda.precioBase();
	}
}
