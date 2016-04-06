
public class Sombrero extends Prenda {

		private Integer coefMS;
		
		public Integer getCoefMS() {
			return coefMS;
		}

		public void setCoefMS(Integer coefMS) {
			this.coefMS = coefMS;
		}

		public double precioBase (){
			return 150 * (1+coefMS);
		}
}
