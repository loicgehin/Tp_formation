import java.util.Map;

public class Formation {
    private Map<String,Double> CoefMatieres;
    private String id;

    public Formation(Map<String,Double> cM, String id){
        this.CoefMatieres=cM;
        this.id=id;
    }

    public Double getCoefMatiere(String matiere){
        if (!this.CoefMatieres.containsKey(matiere))
            throw new IllegalArgumentException("Matiere inexistante");
        return this.CoefMatieres.get(matiere);
    }

    public boolean isMatierePresente(String matiere){
        return this.CoefMatieres.containsKey(matiere);
    }

}
