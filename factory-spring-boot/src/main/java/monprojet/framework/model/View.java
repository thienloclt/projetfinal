package monprojet.framework.model;

public interface View {
	
	public static interface Common{}
	
	public static interface Cheval extends Common{}
	public static interface CentreEquestre extends Common{}
	
	public static interface ChevalWithCentreEquestre extends CentreEquestre{}
	public static interface CentreEquestreWithCheval extends Cheval{}
}
