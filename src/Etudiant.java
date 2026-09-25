import java.util.*;

public class Etudiant{
    private Map<String,List<Double>> notesMatiere;
    private Identite identite;
    private Formation formation;

    public Etudiant(Identite i){
        this.identite=i;
        this.notesMatiere = new TreeMap<>();
    }

    public void ajouterNote(String matiere,Double note){
        if (note<0 || note>20)
            throw new IllegalArgumentException("Note invalide");


        if (this.formation.isMatierePresente(matiere) == false)
            throw new IllegalArgumentException("Matiere non presente dans la formation");


        if(!this.notesMatiere.containsKey(matiere)){
            this.notesMatiere.put(matiere, new ArrayList<>());
        }
        this.notesMatiere.get(matiere).add(note);
    }

    public Double moyenneMatiere(String matiere){
        //si matiere n'existe pas, on ne peut pas calculer la moyenne
        if (!this.notesMatiere.containsKey(matiere))
            throw new IllegalArgumentException("Matiere inexistente");

        //si matiere n'a pas de note, on ne peut pas calculer la moyenne
        if (this.notesMatiere.get(matiere).isEmpty())
            throw new NoteInexistantException("Pas de notes");

        //si matiere n'est pas dans la formation, on ne peut pas calculer la moyenne
        if(this.formation.isMatierePresente(matiere) == false)
            throw new IllegalArgumentException("Matiere non presente dans la formation");

        //calcul de la moyenne
        double somme=0;
        int nb=0;
        for (Double note : this.notesMatiere.get(matiere)) {
            nb++;
            somme+=note;
        }
        return somme/nb;
    }

    public Double moyenneGenerale(){
        double moy=0;
        int nb=0;
        //parcourt des matieres de la formation pour calculer la moyenne
        for (String matiere : this.notesMatiere.keySet()) {
            Double coefMatiere = this.formation.getCoefMatiere(matiere);
            //try catch pour gerer les exceptions comme on le desir
            try {
                moy += moyenneMatiere(matiere) * coefMatiere;
                nb+=coefMatiere;
            }catch (NoteInexistantException e){
                //on ignore si l'etudiant n'a pas de note dans une matiere
            }catch (IllegalArgumentException e){
                //normalement ne peut pas arrive mais verifie si la matiere est bien dans la formation
                throw new IllegalArgumentException("Matiere non presente dans la formation");
            }
        }
        return moy/nb;
    }

    Identite getIdentite(){
        return this.identite;
    }

}
