import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestTrieEtu {

    Formation f;
    Groupe Grp;
    Etudiant e1;
    Etudiant e2;
    Etudiant e3;
    Etudiant e4;
    @BeforeEach
    public void init() {
        f = new Formation("BUT2");
        Grp = new Groupe(f);

        e4 = new Etudiant(new Identite("C", "CC", "444"), f);
        e2 = new Etudiant(new Identite("C", "CC", "445"), f);
        e1 = new Etudiant(new Identite("A", "AA", "456"), f);
        e3 = new Etudiant(new Identite("B", "BB", "496"), f);
        Grp.ajouterEtudiant(e1);
        Grp.ajouterEtudiant(e3);
        Grp.ajouterEtudiant(e2);
    }
    @Test
    void TesttriAlpha() {
        List<Etudiant> trie = Grp.triAlpha();
        assertEquals("A",trie.get(0).getIdentite().getNom());
        assertEquals("B",trie.get(1).getIdentite().getNom());
        assertEquals("C",trie.get(2).getIdentite().getNom());

    }

    @Test
    void TesttriAntiAlpha() {
        List<Etudiant> trie = Grp.triAntiAlpha();
        assertEquals("C",trie.get(0).getIdentite().getNom());
        assertEquals("B",trie.get(1).getIdentite().getNom());
        assertEquals("A",trie.get(2).getIdentite().getNom());

    }

    @Test
    void TestTriMemeNom(){
        Grp.ajouterEtudiant(e4);
        List<Etudiant> trie = Grp.triAlpha();
            assertEquals("A",trie.get(0).getIdentite().getNom());
            assertEquals("B",trie.get(1).getIdentite().getNom());
            assertEquals("C",trie.get(2).getIdentite().getNom());
            assertEquals("C",trie.get(3).getIdentite().getNom());


    }
}