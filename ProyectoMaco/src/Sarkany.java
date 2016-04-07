
public class Sarkany implements Marca{
		public double coefMarca(double precio){
		if (precio > 500){
			return 1.35;
		}else{
				return  1.10;
			}
			}

	}