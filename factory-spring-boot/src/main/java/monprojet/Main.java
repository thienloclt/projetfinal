package monprojet;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import monprojet.Main.View.AllocationView;

public class Main
{

    public static void main(String[] args) {
        try {
        ObjectMapper mapper = new ObjectMapper();
        mapper
          .enable(SerializationFeature.INDENT_OUTPUT)
          .writerWithView(View.Allocation1View.class)
          .writeValue(System.out, new Allocation());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class Stagiaire
    {
        @JsonView({ View.Common.class })
        public String name = "ClassA";
        
        @JsonView({ View.AllocationView.class })
        private Allocation classA = new Allocation();
    }

    public static class Allocation
    {
        @JsonView({ View.Common.class })
        private String name = "ClassB";

        @JsonView({ View.StagiaireView.class })
        private Stagiaire classA = new Stagiaire();
    }

/*    public static class Formation
    {
        @JsonView({ View.Common.class })
        private String name = "ClassC";

        @JsonView({ View.FormationView.class })
        private Allocation classB = new Allocation();
    }*/
    
    public static interface View
    {
    	public interface Common {}
    	public interface StagiaireView extends Common {}
    	public interface AllocationView extends Common {}
    	
    	public interface Stagiaire1View extends AllocationView {}
    	public interface Allocation1View extends StagiaireView {}
    	
    	public interface FormationView extends Common, AllocationView {}
    }
}