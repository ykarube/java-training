package ch03.ex06;

public abstract class EnergySource {

	abstract boolean empty();

	abstract void charge( int energy );

	abstract boolean run();

}
