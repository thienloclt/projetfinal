package monprojet.framework.model;

public interface View {
	
	public static interface Common{}
	public static interface Common1a extends Common{}
	public static interface Common2a extends Common1a{}
	public static interface Common1b extends Common{}
	public static interface Common2b extends Common1b{}
	
	public static interface FormationJSON extends Common{}
	public static interface MatiereJSON extends Common{}
	public static interface SalleJSON extends Common{}
	public static interface FormateurJSON extends Common{}
	public static interface MaterielJSON extends Common{}
	public static interface StagiaireJSON extends Common{}
	public static interface GestionnaireJSON extends Common{}
	public static interface OrdinateurJSON extends Common{}
	public static interface ProgrammeJSON extends Common{}
	public static interface EnseignementJSON extends Common{}
	//public static interface AllocationJSON extends Common{}
	public static interface ProjecteurJSON extends Common{}
	
	public static interface ProgrammeWithEveythingJSON extends FormationJSON, FormateurJSON, MatiereJSON{}
	public static interface MatiereWithEveythingJSON extends ProgrammeJSON, EnseignementJSON{}
	public static interface FormateurWithEveythingJSON extends ProgrammeJSON, EnseignementJSON{}
	public static interface EnseignementWithEveythingJSON extends FormateurJSON, MatiereJSON{}
	public static interface GestionnaireWithEveythingJSON extends FormationJSON{}
	public static interface SalleWithEveythingJSON extends FormationJSON{}
	public static interface ProjecteurWithEveythingJSON extends FormationJSON{}
	public static interface OrdinateurWithEveythingJSON extends FormationJSON{}
	public static interface StagiaireWithEveythingJSON extends FormationJSON{}
	//public static interface AllocationWithEveythingJSON extends FormationJSON, StagiaireJSON, OrdinateurJSON{}
	public static interface FormationWithEveythingJSON extends ProgrammeJSON, SalleJSON, ProjecteurJSON, GestionnaireJSON, OrdinateurJSON{}
}
