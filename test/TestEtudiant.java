import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestEtudiant {

    Etudiant etudiant;
    Formation formation;
    Identite identite;
    String m1;
    String m2;
    double n1;
    double n2;
    double n3;

    @BeforeEach
    public void init(){
        formation = new Formation("info");
        identite=new Identite("Jean-Pierre","Dupont","1234");
        etudiant=new Etudiant(identite,formation);
        m1="qualité dev";
        m2="math";
        formation.ajouterMatiere(m1,2.5);
        formation.ajouterMatiere(m2,3.0);
        n1=10.0;
        n2=15.0;
        n3=20.0;
    }
    @Test
    public void testAjouterNoteGetNotesSupprimerNote(){
        //ajout note normale
        etudiant.ajouterNote(m1,n1);
        etudiant.ajouterNote(m1,n1);
        assertEquals(n1,etudiant.getNotes(m1).get(0));
        assertEquals(n1,etudiant.getNotes(m1).get(1));

        //ajout note impossible
        try {
            etudiant.ajouterNote(m1,21.0);
            fail();
        }catch(IllegalArgumentException e){

        }

        //ajout matiere non presente
        try {
            etudiant.ajouterNote("a",n1);
            fail();
        }catch(MatiereInexistanteException e){
        }

        //supprimer note
        etudiant.supprimerNote(m1,n1);
        assertEquals(1,etudiant.getNotes(m1).size());
    }

    @Test
    public void testMoyennes(){
        //moyenne matiere
        etudiant.ajouterNote(m1,n1);
        etudiant.ajouterNote(m1,n3);
        etudiant.ajouterNote(m2,n2);
        assertEquals(15.0,etudiant.moyenneMatiere(m1));
        assertEquals(15.0,etudiant.moyenneMatiere(m2));

        //moyenne generale, resultat 15 logique car les 2 moyennes sont a 15
        assertEquals(15.0,etudiant.moyenneGenerale());
    }
}
