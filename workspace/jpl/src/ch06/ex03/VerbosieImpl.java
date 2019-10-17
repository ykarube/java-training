package ch06.ex03;

public class VerbosieImpl implements Verbose{

	private Verbosity local = Verbosity.NORMAL;

	@Override
	public void setVerbosity(Verbosity level) {
		this.local = level;

	}

	@Override
	public int getVerbosity() {
		System.out.println(this.local);
		return 0;
	}

	public static void main(String[] args) {
		VerbosieImpl v = new VerbosieImpl();
		System.out.println(v.getVerbosity());
		v.setVerbosity(Verbosity.SILENT);
		System.out.println(v.getVerbosity());
	}

}
