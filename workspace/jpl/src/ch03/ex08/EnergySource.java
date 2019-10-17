package ch03.ex08;

public abstract class EnergySource implements Cloneable{

	abstract boolean empty();

	abstract void charge( int energy );

	abstract boolean run();

	protected EnergySource clone() throws CloneNotSupportedException {
		return (EnergySource)super.clone();
	}
}
