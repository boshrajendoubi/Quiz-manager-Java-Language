
package gestionnairedesquizs1;
import java.util.* ;

/**
 *
 * @author DELL
 */
public class Module {
    private String nom;
    private  ArrayList<Quiz> LQuiz;
    private static ArrayList<Enseignant> LEns;

    public Module(String nom, ArrayList<Quiz> LQuiz, ArrayList<Enseignant> LEns ) {
        this.nom = nom;
        this.LQuiz = LQuiz;
        this.LEns=LEns;
    }
    

    public Module(String nom) {
        this.nom = nom;
        this.LQuiz = new ArrayList(10);
        this.LEns = new ArrayList(10);
    }

    public Module() {
        nom="";
        this.LQuiz = new ArrayList();
        this.LEns = new ArrayList();
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Quiz> getLQuiz() {
        return LQuiz;
    }

    public static ArrayList<Enseignant> getLEns() {
        return LEns;
    }

    public static void setLEns(ArrayList<Enseignant> LEns) {
        Module.LEns = LEns;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLQuiz(ArrayList<Quiz> LQuiz) {
        this.LQuiz = LQuiz;
    }

    @Override
    public String toString() {
        return "Module{" + "nom=" + nom + ", LQuiz=" + LQuiz + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
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
        final Module other = (Module) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }
    
    
   
    public void vider() {
        LQuiz.clear();
    }

    public void Afficher() {
        System.out.println("Nom du module: "+nom);
        if (LQuiz.isEmpty()) {
            System.out.println("Ensemble vide ");
        } else {
            for (int i = 0; i < LQuiz.size(); i++) {
                System.out.println("Quiz n°: "+ i);
                LQuiz.get(i).Afficher();
            }
        }
    }
    
     public void AfficherSansCorrec() {
        System.out.println("Nom du module: "+nom);
        if (LQuiz.isEmpty()) {
            System.out.println("Ensemble vide ");
        } else {
            for (int i = 0; i < LQuiz.size(); i++) {
                System.out.println("Quiz n°: "+ i);
                LQuiz.get(i).AfficherSansCorrec();
            }
        }
    }
    
    

      public int appartient(Quiz Q){
        int pos=-1,i=0;
        while((pos==-1)&&(i<LQuiz.size())){
            if( LQuiz.get(i).equals(Q) )
                pos=i;
            else 
            i++;
        }
        return pos;
    }

    public void AjouterQuiz(Quiz Q) {
        if(LQuiz.isEmpty())
        {
            LQuiz.add(Q); 
        }
        else if((appartient(Q)!=-1 )&&( (this.nom).equals(Q.getModule())))
      {
        System.out.println(" quiz déjà existant");
       }
        else 
       { LQuiz.add(Q); }
        
    }
    public void retirer(Quiz Q) {
		if (LQuiz.isEmpty())
			System.out.println("Ensemble vide !!!");
		else {
			if (!LQuiz.remove(Q))
                            System.out.println("Quiz inexistante");
			else
                            System.out.println("Quiz supprimee !!!");
		}

	}

   public void modifier()
   {   boolean modifquiz;
   
   
     int j;
      
       Scanner s=new Scanner(System.in);
       System.out.println("donner le nouveau nom du module");
       nom=s.next();
       System.out.println("la modification du mon du module  est effectuée avec succés");
       System.out.println(" ");
       System.out.println(" ");
       System.out.println("Avez-vous des quizs à modifier?");
       System.out.println("Taper 'True' si oui et 'false' sinon");
       modifquiz=s.nextBoolean();
       if (modifquiz)
       {
          do
       {
           Afficher();
           System.out.println("donner le numéro du quiz à modifier");
           j=s.nextInt();
           (LQuiz.get(j)).modifier();
           System.out.println("Avez vous encore des Quizs à modifier?");
           System.out.println("Taper 'True' si oui et 'false' sinon");
           modifquiz=s.nextBoolean();
           if (!modifquiz)
             System.out.println("la modification est effectuée avec succés");
       }
         while(modifquiz);
       }
       
      
   }
   
 
    


}
   
    
            
            
    
    
    
    

