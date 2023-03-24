
package gestionnairedesquizs1;

import java.util.*;
import java.util.regex.Pattern;

public class Quiz {
    private  ArrayList<Qcm> LQcm;
    private float score; 
    private String module;
    private String enseignant;

    public Quiz(String module, String enseignant) {
        this.module = module;
        this.enseignant = enseignant;
    }

    public Quiz() {
        LQcm = new ArrayList<Qcm>(3);
        module="";
        enseignant="";
        score=-1;
    }

    public  ArrayList<Qcm> getLQcm() {
        return LQcm;
    }

    public float getScore() {
        return score;
    }

    public String getModule() {
        return module;
    }

    public String getEnseignant() {
        return enseignant;
    }

    public void setLQcm(ArrayList<Qcm> LQcm) {
        this.LQcm = LQcm;
    }

   

    public void setScore(float score) {
        this.score = score;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public void setEnseignant(String enseignant) {
        this.enseignant = enseignant;
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
        final Quiz other = (Quiz) obj;
        if (Float.floatToIntBits(this.score) != Float.floatToIntBits(other.score)) {
            return false;
        }
        if (!Objects.equals(this.module, other.module)) {
            return false;
        }
        if (!Objects.equals(this.enseignant, other.enseignant)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Quiz{" + "score=" + score + ", module=" + module + ", enseignant=" + enseignant + '}';
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
    public void saisirQuiz()
    { 
        System.out.println("saisie du quiz");
      Qcm Q;
      Scanner s=new Scanner(System.in);
      System.out.println("donner le module de ce quiz");
      module=s.next();
      do
      {
       System.out.println("donner l'auteur de ce quiz");
      enseignant=s.next();
      }while(! isAlpha(enseignant));
        for(int i=0;i<2;i++)
        {   
            System.out.println("la question n°="+(i+1));
            Q=new Qcm();
            Q.SaisirQcm();
            LQcm.add(Q);
        }
        
    }
    
        public void vider() {
        LQcm.clear();
    }

    public void Afficher() {
        if (LQcm.isEmpty()) {
            System.out.println("Ensemble vide ");
        } else {
            System.out.println("le theme de ce quiz: "+module);
            System.out.println("l'auteur de ce quiz: "+enseignant);
            
            
            for (int i = 0; i < LQcm.size(); i++) {
                LQcm.get(i).afficher();
            }
        }
    }
    
     public void AfficherSansCorrec() {
        if (LQcm.isEmpty()) {
            System.out.println("Ensemble vide ");
        } else {
            System.out.println("le theme de ce quiz: "+module);
            System.out.println("l'auteur de ce quiz: "+enseignant);
            
            
            for (int i = 0; i < LQcm.size(); i++) {
                LQcm.get(i).afficherSansCorrec();
            }
        }
    }

    
      public int appartient(Qcm Q){
        int pos=-1,i=0;
        while((pos==-1)&&(i<LQcm.size())){
            if( LQcm.get(i).equals(Q) )
                pos=i;
            else 
            i++;
        }
        return pos;
    }

    public void AjouterQcm(Qcm Q) {
        if(LQcm.isEmpty())
        {
            LQcm.add(Q); 
        }
        else if(appartient(Q)!=-1)
      {
        System.out.println(" Qcm déjà existant");
       }
     else 
       { LQcm.add(Q); }
        
    }
    public void retirer(Qcm Q) {
		if (LQcm.isEmpty())
			System.out.println("Ensemble vide !!!");
		else {
			if (!LQcm.remove(Q))
                            System.out.println("Qcm inexistante");
			else
                            System.out.println("Qcm supprimee !!!");
		}

	}

    
    
    public void modifier()
    { 
       Scanner s=new Scanner(System.in);
        int modifqcm;
      Afficher();
      System.out.println("donner le numéro du qcm à modifier");
      modifqcm=s.nextInt();
      LQcm.get(modifqcm).modifier();
      System.out.println("modification effectuée avec succés");   
    }
    
    public float  scorequiz( Etudiant e)
    {  score=0;
      for (int i=0;i<LQcm.size();i++)
      {
         score= score + (LQcm.get(i)).ScoreQcm(e);
      }
      
      return score;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
