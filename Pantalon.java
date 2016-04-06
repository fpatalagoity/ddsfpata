
public class Pantalon extends Prenda{

	private Integer telaUsada;
	
	public Integer getTelaUsada() {
		return telaUsada;
	}

	public void setTelaUsada(Integer telaUsada) {
		this.telaUsada = telaUsada;
	}

	public double precioBase (){
		return 250 + telaUsada;
	}
}
