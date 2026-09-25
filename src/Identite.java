public class Identite {
    private String nom;
    private String prenom;
    private String NIP;

    public Identite(String n,String p,String Nip){
        this.nom=n;
        this.prenom=p;
        this.NIP=Nip;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getNIP() {
        return this.NIP;
    }
}
