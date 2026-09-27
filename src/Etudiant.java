import java.util.*;

public class Etudiant implements Comparable<Etudiant>{
    private Map<String, List<Double>> notesMatiere;
    private Identite identite;
    private Formation formation;

    public Etudiant(Identite i, Formation f) {
        this.identite = i;
        this.formation = f;
        this.notesMatiere = new TreeMap<>();
    }

    public void ajouterNote(String matiere, Double note) {
        if (note < 0 || note > 20)
            throw new IllegalArgumentException("Note invalide");


        if (!this.formation.isMatierePresente(matiere))
            throw new MatiereInexistanteException("Matiere non presente dans la formation");


        if (!this.notesMatiere.containsKey(matiere)) {
            this.notesMatiere.put(matiere, new ArrayList<>());
        }
        this.notesMatiere.get(matiere).add(note);
    }

    public Double moyenneMatiere(String matiere) {
        //si matiere n'existe pas, on ne peut pas calculer la moyenne
        if (!this.notesMatiere.containsKey(matiere))
            throw new MatiereInexistanteException("Matiere inexistente");

        //si matiere n'a pas de note, on ne peut pas calculer la moyenne
        if (this.notesMatiere.get(matiere).isEmpty())
            throw new NoteInexistantException("Pas de notes");

        //calcul de la moyenne
        double somme = 0;
        int nb = 0;
        for (Double note : this.notesMatiere.get(matiere)) {
            nb++;
            somme += note;
        }
        return somme / nb;
    }

    public Double moyenneGenerale() {
        double moy = 0;
        double nb = 0;
        //parcourt des matieres de la formation pour calculer la moyenne
        for (String matiere : this.notesMatiere.keySet()) {
            Double coefMatiere = this.formation.getCoefMatiere(matiere);
            //try catch pour gerer les exceptions comme on le desir
            try {
                moy += this.moyenneMatiere(matiere) * coefMatiere;
                nb += coefMatiere;
            } catch (NoteInexistantException e) {
                //on ignore si l'etudiant n'a pas de note dans une matiere
            } //ne catch pas matiere Inexistante car ne devrait pas arrivé et si arrive le programme doit s'arreter
        }
        return moy / nb;
    }

    public void supprimerNote(String m, Double n) {
        List<Double> matiere;
        //try catch pour prendre l'erreur si la matiere n'existe pas pour cet eleve
        //pas besoin de verifier si la matiere est bien dans la formation car on a verifier avant
        try {
            matiere = this.notesMatiere.get(m);
        } catch (NullPointerException e) {
            throw new MatiereInexistanteException("matiere inexistante");
        }
        //ne previens pas si la note n'existe pas mais la supprime si elle existe
        matiere.remove(n);
    }

    public Identite getIdentite() {
        return this.identite;
    }

    public Formation getFormation() {
        return this.formation;
    }

    public List<Double> getNotes(String matiere) {
        if (!this.formation.isMatierePresente(matiere))
            throw new IllegalArgumentException("Matiere non presente dans la formation");

        return this.notesMatiere.get(matiere);
    }

    public int compareTo(Etudiant e) {
        return identite.getNIP().compareTo(e.getIdentite().getNIP());
    }

}
