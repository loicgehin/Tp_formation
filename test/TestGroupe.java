import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestGroupe {
    Groupe g1;
    Formation f1;
    Formation f2;
    Identite i1;
    Identite i2;
    Identite i3;
    Etudiant e1;
    Etudiant e2;
    Etudiant e3;
    String m1;
    String m2;
    double n1=10.0;
    double n2=15.0;
    double n3=20.0;

    @BeforeEach
    public void init(){
        //pour le test ajout etudiant et moyenne
        f1 = new Formation("info");
        i1 =new Identite("Jean-Pierre","Dupont","1234");
        e1 =new Etudiant(i1, f1);
        m1="qualité dev";
        m2="math";
        f1.ajouterMatiere(m1,2.5);
        f1.ajouterMatiere(m2,3.0);
        g1 =new Groupe(f1);
        e1.ajouterNote(m1,n1);
        e1.ajouterNote(m2,n3);


        //pour le test ajout autre etudiant
        f2 = new Formation("com");
        f2.ajouterMatiere(m1,5.5);
        i2 =new Identite("Jean-Michel","Dupont","5678");
        e2 =new Etudiant(i2, f2);

        //pour test calcul moyenne
        i3 =new Identite("Jean-Paul","Dupont","9012");
        e3 =new Etudiant(i3, f1);
        e3.ajouterNote(m1,n2);
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

    @Test
    public void testMoyennes(){
        //initialisation
        g1.ajouterEtudiant(e1);
        g1.ajouterEtudiant(e3);
        //moyene pour m1 de 2 etudiant l'un a 15(e3) l'autre 10(e1)
        assertEquals(12.5,g1.moyenneMatiere(m1));

        //moyenne generale
        double moyenneGenerale=(e1.moyenneGenerale()+e3.moyenneGenerale())/2;
        assertEquals(moyenneGenerale,g1.moyenneGenerale());
    }
}
