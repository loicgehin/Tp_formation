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

    public Etudiant getEtudiant(String nom, String prenom){
        for (Etudiant e : this.etudiants)
            if (e.getIdentite().getNom().equals(nom) && e.getIdentite().getPrenom().equals(prenom))
                return e;
        throw new EtudiantNonPresentException("Etudiant non present dans le groupe");
    }

    public Etudiant getEtudiant(String nip){
        for(Etudiant e : this.etudiants)
            if(e.getIdentite().getNIP().equals(nip))
                return e;
        throw new EtudiantNonPresentException("Etudiant non present dans le groupe");
    }

    public Formation getFormation(){
        return this.formation;
    }

    public double moyenneMatiere(String matiere){
        double moyenne=0;
        for (Etudiant e : this.etudiants)
            moyenne+=e.moyenneMatiere(matiere);
        return moyenne/this.etudiants.size();
    }

    public double moyenneGenerale(){
        double moyenne=0;
        for (Etudiant e : this.etudiants)
            moyenne+=e.moyenneGenerale();
        return moyenne/this.etudiants.size();
    }
}
