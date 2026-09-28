import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTrieMerite {
    Formation f;
    Groupe Grp;
    Etudiant e1;
    Etudiant e2;
    Etudiant e3;
    Etudiant e4;
    @BeforeEach
    public void init(){
        f = new Formation("BUT2");
        Grp = new Groupe(f);

        e2 = new Etudiant(new Identite("C", "CC", "445"), f);
        e1 = new Etudiant(new Identite("A", "AA", "456"), f);
        e3 = new Etudiant(new Identite("B", "BB", "496"), f);
        Grp.ajouterEtudiant(e1);
        Grp.ajouterEtudiant(e3);
        Grp.ajouterEtudiant(e2);

        f.ajouterMatiere("Maths", 2.0);
        e1.ajouterNote("Maths", 10.0);
        e2.ajouterNote("Maths", 19.0);
        e3.ajouterNote("Maths", 14.0);

        e1.ajouterNote("Maths", 7.0);
        e2.ajouterNote("Maths", 12.0);
        e3.ajouterNote("Maths", 16.0);

    }

    @Test
    void testTripParMerite(){
        List<Etudiant> trie = Grp.triParMerite();
        assertEquals("C",trie.get(0).getIdentite().getNom());
        assertEquals("B",trie.get(1).getIdentite().getNom());
        assertEquals("A",trie.get(2).getIdentite().getNom());
    }

}
