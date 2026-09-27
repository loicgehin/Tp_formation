import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestGroupe {
    Groupe g1;
    Formation f1;
    Formation f2;
    Identite i1;
    Identite i2;
    Etudiant e1;
    Etudiant e2;
    String m1;
    String m2;

    @BeforeEach
    public void init(){
        f1 = new Formation("info");
        i1 =new Identite("Jean-Pierre","Dupont","1234");
        e1 =new Etudiant(i1, f1);
        m1="qualité dev";
        m2="math";
        f1.ajouterMatiere(m1,2.5);
        f1.ajouterMatiere(m2,3.0);
        g1 =new Groupe(f1);
        f2 = new Formation("com");
        f2.ajouterMatiere(m1,5.5);
        i2 =new Identite("Jean-Michel","Dupont","5678");
        e2 =new Etudiant(i2, f2);
    }

    @Test
    public void testAjouterSupprimerEtudiant(){
        //ajout etudiant
        g1.ajouterEtudiant(e1);
        assertTrue(g1.getEtudiants().contains(e1));
        //suppression etudiant
        g1.supprimerEtudiant(e1);
        assertFalse(g1.getEtudiants().contains(e1));

        //ajout étudiant pas dans la meme formation
        try{
            g1.ajouterEtudiant(e2);
            fail();
        }catch(FormationDifferenteException e){}

        //ajout 2 fois le meme etudiant
        g1.ajouterEtudiant(e1);
        g1.ajouterEtudiant(e1);
        assertEquals(1, g1.getEtudiants().size());

    }
}
