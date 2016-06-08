package externos;

import java.util.List;

public class ServicioDTO {
	private String nombreServicio;
	private List<Integer[]> rangosServicioDTO;

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public List<Integer[]> getRangosServicioDTO() {
		return rangosServicioDTO;
	}

	public void setRangoServicioDTO(List<Integer[]> rangoServicioDTO) {
		this.rangosServicioDTO = rangoServicioDTO;
	}
}
