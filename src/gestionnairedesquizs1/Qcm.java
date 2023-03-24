
package gestionnairedesquizs1;
import java.util.* ;

public class Qcm {
    private int NumQues;
    private String Description;
    private  ArrayList<Option> LOption;
    private float score;

    public Qcm() {
        NumQues=0;
        Description="";
        LOption=new ArrayList<Option>(4);
    }

    public Qcm(int NumQues, String Description, ArrayList<Option> LOption) {
        this.NumQues = NumQues;
        this.Description = Description;
        this.LOption = LOption;
    }

    public int getNumQues() {
        return NumQues;
    }

    public String getDescription() {
        return Description;
    }

    public ArrayList<Option> getLOption() {
        return LOption;
    }

    public void setNumQues(int NumQues) {
        this.NumQues = NumQues;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setLOption(ArrayList<Option> LOption) {
        this.LOption = LOption;
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
        final Qcm other = (Qcm) obj;
        if (this.NumQues != other.NumQues) {
            return false;
        }
        if (!Objects.equals(this.Description, other.Description)) {
            return false;
        }
        if (!Objects.equals(this.LOption, other.LOption)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Qcm{" + "NumQues=" + NumQues + ", Description=" + Description + ", LOption=" + LOption + '}';
    }
    
    public void vider() {
        LOption.clear();
    }

    public void afficher() {
        if (LOption.isEmpty()) {
            System.out.println("Ensemble vide ");
        } else {
            System.out.println("Qcm n° "+NumQues+"  "+Description);
            for (int i = 0; i < LOption.size(); i++) {
                 LOption.get(i).afficher();
            }
        }
    }
    
    public void afficherSansCorrec()
    {
      if (LOption.isEmpty()) {
            System.out.println("Ensemble vide ");
        } else {
            System.out.println("Qcm n° "+NumQues+"  "+Description);
            for (int i = 0; i < LOption.size(); i++) {
                 LOption.get(i).afficherSansCorrec();
            }
        }
    
    }

      public int appartient(Option O){
        int pos=-1,i=0;
        while((pos==-1)&&(i< LOption.size())){
            if( LOption.get(i).equals(O) )
                pos=i;
            else 
            i++;
        }
        return pos;
    }

    public void ajout(Option O) {
        if(LOption.isEmpty())
        {
            LOption.add(O); 
        }
        else  if(appartient(O)!=-1)
      {
        System.out.println(" Option déjà existante ");
       }
     else 
       { LOption.add(O); }
        
    }
    public void retirer(Option O) {
		if (LOption.isEmpty())
			System.out.println("Ensemble vide !!!");
		else {
			if (!LOption.remove(O))
                            System.out.println("Option inexistante");
			else
                            System.out.println(" Option supprimee !!!");
		}

	}
 
  public void SaisirQcm()
    {    Option O;
        Scanner s=new Scanner(System.in);
        do 
        {
             System.out.println("Donner le numéro du QCM");
              NumQues=s.nextInt();
        } while (NumQues<=0);
       
      System.out.println("Donner la description du QCM ");
        Description=s.next();
       for(int i=0;i<4;i++)
       { System.out.println("saisir l'option num° "+(i+1)+" et donner son type");
         O= new Option();
         O.SaisirOption();
         LOption.add(O);
          
          
       }
    }  
    
     public void modifier()
   {   boolean modifoption;
       boolean modifdescription;
       int j;
       Scanner s=new Scanner(System.in);
       System.out.println("donner le nouveau numéro du Qcm");
       NumQues=s.nextInt();
       System.out.println("Voulez-vous modifier la description du Qcm? ");
       System.out.println("Taper 'True' si oui et 'false' sinon");
       modifdescription=s.nextBoolean();
       if(modifdescription)
       {
           System.out.println("Donnez la nouelle description du Qcm: ");
           Description=s.next();
           System.out.println(" modification de la description du qcm effectuée avec succés");
           
       }
       else 
       {
           System.out.println(" modification du numéro de ques effectuée avec succés");
           
       }
       System.out.println("Avez-vous des options à modifier?");
       System.out.println("Taper 'True' si oui et 'false' sinon");
       modifoption=s.nextBoolean();
       if (modifoption==true)
       {
         do
       {
           afficher();
           System.out.println("donner le numéro de l'option à modifier");
           j=s.nextInt();
           (LOption.get(j)).modifier();
           System.out.println("Avez vous encore des options à modifier?");
           System.out.println("Taper 'True' si oui et 'false' sinon");
           modifoption=s.nextBoolean();
           if (!modifoption)
             System.out.println("la modification est effectuée avec succés");
       }
         while(modifoption);
         
      
       }
       else 
           System.out.println("modification effectuée avec succés");
           
   }
    
    public float ScoreQcm(Etudiant e)
    {   
          boolean verif=true; 
          int i=0;
          while( (i<LOption.size()) && verif)
          {
            if (!((LOption.get(i).isType())==e.getReponseOptions().get(i)))
                verif=false;
            else i++;
          }
          if(!verif)
              score=0;
          else
              score=(float)2.0;
          return score;
       
    }   
    
    
}
