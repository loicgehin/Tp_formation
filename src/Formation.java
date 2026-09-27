import java.util.Map;
import java.util.TreeMap;

public class Formation {
    private Map<String,Double> coefMatieres;
    private String id;

    public Formation(String id){
        this.coefMatieres = new TreeMap<>();
        this.id=id;
    }

    public boolean isMatierePresente(String matiere){
        return this.coefMatieres.containsKey(matiere);
    }

    public Double getCoefMatiere(String matiere){
        if (!this.isMatierePresente(matiere))
            throw new IllegalArgumentException("Matiere inexistante");
        return this.coefMatieres.get(matiere);
    }

    public void ajouterMatiere(String matiere,Double coef){
        this.coefMatieres.put(matiere,coef);
    }

    public void supprimerMatiere(String matiere){
        if (!this.isMatierePresente(matiere))
            throw new MatiereInexistanteException("Matiere inexistante");
        this.coefMatieres.remove(matiere);
    }

    public boolean estEgal(Formation f){
        return this.id.equals(f.id);
    }

}
