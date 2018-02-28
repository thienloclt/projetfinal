package monprojet.framework.model;

public interface View {
	
	public static interface Common{}
	
	public static interface Formation extends Common{}
	public static interface Matiere extends Common{}
	
	public static interface FormationWithEveything extends Matiere{}
	public static interface MatiereWithFormation extends Formation{}
}
