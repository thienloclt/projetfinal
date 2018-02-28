package monprojet.framework.model;

public interface View {
	
	public static interface Common{}
	
	public static interface FormationJSON extends Common{}
	public static interface MatiereJSON extends Common{}
	public static interface SalleJSON extends Common{}
	public static interface FormateurJSON extends Common{}
	public static interface MaterielJSON extends Common{}
	public static interface StagiaireJSON extends Common{}
	public static interface GestionnaireJSON extends Common{}
	public static interface OrdinateurJSON extends Common{}
	
	public static interface FormationWithEveythingJSON extends MatiereJSON, SalleJSON, FormateurJSON, MaterielJSON, StagiaireJSON, GestionnaireJSON{}
	public static interface MatiereWithEveythingJSON extends FormationJSON, FormateurJSON{}
	public static interface SalleWithEveythingJSON extends FormationJSON{}
	public static interface MaterielWithEveythingJSON extends FormationJSON{}
	public static interface FormateurWithEveythingJSON extends FormationJSON, MatiereJSON{}
	public static interface StagiaireWithEveythingJSON extends FormationJSON, OrdinateurJSON{}
	public static interface GestionnaireWithEveythingJSON extends FormationJSON{}
	public static interface OrdinateurWithEveythingJSON extends MatiereJSON, StagiaireJSON{}
	
}
