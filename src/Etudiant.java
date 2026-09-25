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
        if(!this.notesMatiere.containsKey(matiere)){
            this.notesMatiere.put(matiere, new ArrayList<>());
        }
        this.notesMatiere.get(matiere).add(note);
    }

    public Double moyenneMatiere(String matiere){
        if (!this.notesMatiere.containsKey(matiere))
            throw new IllegalArgumentException("Matiere inexistente");
        if (this.notesMatiere.get(matiere).isEmpty())
            throw new NoteInexistantException("Pas de notes");
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
        for (String matiere : this.notesMatiere.keySet()) {
            Double coefMatiere = this.formation.getCoefMatiere(matiere);
            try {
                moy += moyenneMatiere(matiere) * coefMatiere;
                nb+=coefMatiere;
            }catch (NoteInexistantException e){
            }
        }
        return moy/nb;
    }

    Identite getIdentite(){
        return this.identite;
    }

}
