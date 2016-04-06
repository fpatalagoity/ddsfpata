import java.util.List;
public class Macowins {

	private double ValorFijo;
	public double getValorFijo() {
		return ValorFijo;
	}

	public void setValorFijo(double valorFijo) {
		ValorFijo = valorFijo;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}
		private List<Venta> ventas;
	
	public void vender (Prenda prenda, Integer cantidad, String fecha){
		Venta venta = new Venta (prenda, cantidad, fecha);
		this.ventas.add(venta);
	}
	public double gananciasDe (String fecha) {
		 return this.ventas
				.stream()
				.filter( venta -> venta.getFecha() == fecha)
				.map(venta -> venta.ganancia())
				.reduce(0.0, Double::sum);
	}
}

