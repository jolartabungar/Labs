
public class Automobile extends Vehicle implements Motorized {
	private String make;
	private String model;
	protected String motor;

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public void setMake(String string) {
		make = string;
	}

	public void setModel(String string) {
		model = string;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String string) {
		motor = string;
	}
}