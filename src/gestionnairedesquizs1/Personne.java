
package gestionnairedesquizs1;

import static java.lang.Character.isDigit;
import java.util.*;
import java.util.regex.Pattern;


/**
 *
 * @author DELL
 */
public  class Personne {
    private String nom;
    private String prenom;
    private String cin;
    
    
 public Personne(){
     nom = "";
     prenom="";
     cin ="";
 }
  public Personne(String nom, String prenom, String cin) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
    }
    @Override
    public String toString() {
        return "Personne{" + "nom=" + nom + ", prenom=" + prenom + ", cin=" + cin ;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personne other = (Personne) obj;
        if (this.cin != other.cin) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return Objects.equals(this.prenom, other.prenom);
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCin() {
        return cin;
    }

   

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

  public boolean isAlpha(String s)
   {
if (Pattern.matches("[a-zA-Z]+",s)) { 
    System.out.println("Yes, string contains letters only");
  return true;
  
}else{
  System.out.println("Nope, Other characters detected");  
return false;  
}
   }
  
  
 public static boolean isNumeric(String str)
{
    for (char c : str.toCharArray())
    {
        if (!Character.isDigit(c)) return false;
    }
    return true;
}
    
    
    public void saisir()
            
    { Scanner s=new Scanner(System.in);
    
    do { 
    System.out.println("Nom: ");
      nom=s.next();
    }while(! isAlpha(nom));
    do{
      System.out.println("prenom: ");
      prenom=s.next();
      }while(! isAlpha(prenom));
      do
      {
      System.out.println("Cin: ");
      cin=s.next();
      }while ((!isNumeric(cin)) || ((cin.charAt(0)!='0') && (cin.charAt(0)!='1')) ||( cin.length()!=8));      
      
      
      
    }
    
    public void afficher()
    {
    
    System.out.println("Nom: "+nom+" Prenom: "+prenom+" Cin: "+cin);
    }
}
