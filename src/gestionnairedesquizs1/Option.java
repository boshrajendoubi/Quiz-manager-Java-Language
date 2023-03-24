
package gestionnairedesquizs1;

import java.util.* ;

/**
 *
 * @author DELL
 */
public class Option {
    private String Description;
    private boolean type;
   
    public Option(String Description, boolean type) {
        this.Description = Description;
        this.type = type;
    }

    public Option() {
        Description="";
        type=false;
    }

    public String getDescription() {
        return Description;
    }

    public boolean isType() {
        return type;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setType(boolean type) {
        this.type = type;
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
        final Option other = (Option) obj;
        if (this.type != other.type) {
            return false;
        }
        if (!Objects.equals(this.Description, other.Description)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Option{" + "Description=" + Description + ", type=" + type + '}';
    }
    
    public void SaisirOption()
    { 
        Scanner s=new Scanner(System.in);
      System.out.println("Donner la description de l'option");
        Description=s.next();
       System.out.println("Donner le type de l'option"); 
        type=s.nextBoolean();  
    }
    
  

    public void afficher() {
                if (type==false)
                {
                    System.out.println("Option: "+Description+" :Option fausse");
                }
                else 
                {
                     System.out.println("Option: "+Description+" :Option Valide");
                }
    }
    
    public void afficherSansCorrec()
    {
      System.out.println("Option: "+Description);
    }
    
    
    public int modifier()
    {   Scanner s= new Scanner(System.in);
        System.out.println("donner la nouvelle description de l'option");
        Description=s.next();
        System.out.println("donner la nouveau type de l'option");
        System.out.println("Tapez false si la réponse est fausse ");
        System.out.println("Tapez true si la réponse est valide ");
        type=s.nextBoolean();
        System.out.println(" la modification de l'option est effectuée avec succés");
        return 1;
    }

  
    
    
    
    
    
    
    
    
}
