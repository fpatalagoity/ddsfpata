
public class Zapato extends Prenda {
	private double talle;
	
	public double getTalle() {
		return talle;
	}

	public void setTalle(double talle) {
		this.talle = talle;
	}

	public double precioBase (){
		return 400 + 5 * talle;
	}
	
}
