import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestFormation {
    String m1;
    String m2;
    Formation formation;

    @BeforeEach
    public void init() {
        formation = new Formation("info");
        m1 = "Qualité Dev";
        m2 = "Anglais";

    }

    @Test
    public void testAjouterMatiereGetCoeff() {
        //initialisation
        formation.ajouterMatiere(m1, 2.5);

        assertEquals(2.5, formation.getCoefMatiere(m1));
    }

    @Test
    public void supprimerMatiereinexistante() {
        formation.ajouterMatiere(m2, 10.0);
        try {
            formation.supprimerMatiere("info");
            fail();

        } catch (IllegalArgumentException e) {
        }


    }

    @Test
    public void supprimerMatiereexistaneIsMatierePresente() {
        formation.ajouterMatiere(m2, 10.0);

        formation.supprimerMatiere(m2);
        boolean x =formation.isMatierePresente(m2);
        assertEquals(false,x);


    }



}
