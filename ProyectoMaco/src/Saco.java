
public class Saco extends Prenda{
	private Integer botones;
	
	public Integer getBotones() {
		return botones;
	}

	public void setBotones(Integer botones) {
		this.botones = botones;
	}

	public double precioBase (){
		return 300 + botones*10;
	}
	
	public Saco(){
		super();
	}

	}
