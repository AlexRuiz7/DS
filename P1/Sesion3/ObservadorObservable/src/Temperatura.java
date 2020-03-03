
import java.util.Observable;

public class Temperatura extends Observable {

	private double temperatura;

	public double getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

}