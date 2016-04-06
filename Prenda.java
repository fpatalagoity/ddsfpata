
public abstract class Prenda {

	private Origen origen;
	private Marca marca;
	public Origen getOrigen() {
		return origen;
	}

	public void setOrigen(Origen origen) {
		this.origen = origen;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	private double ValorFijo;
	
	public double getValorFijo() {
		return ValorFijo;
	}

	public void setValorFijo(double valorFijo) {
		ValorFijo = valorFijo;
	}

	public  double precioFinal (Origen origen, Marca marca){
		return (ValorFijo+this.precioBase()) * this.origen.tasaImportacion() * this.marca.coefMarca(this.precioBase());		
	}

	public abstract double precioBase();
	
}
