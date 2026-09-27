import java.util.Set;
import java.util.TreeSet;

public class Groupe {
    private Set<Etudiant> etudiants;
    private Formation formation;

    public Groupe(Formation f){
        this.formation=f;
        this.etudiants=new TreeSet<>();
    }

    public void ajouterEtudiant(Etudiant e){
        if (!this.formation.estEgal(e.getFormation()))
            throw new FormationDifferenteException("L'etudiant n'est pas dans la bonne formation");
        this.etudiants.add(e);
    }

    public void supprimerEtudiant(Etudiant e){
        this.etudiants.remove(e);
    }
    public Set<Etudiant> getEtudiants(){
        return this.etudiants;
    }
}
