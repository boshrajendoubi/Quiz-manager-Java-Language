/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionnairedesquizs1;

import java.util.*;
import java.util.HashMap;
import java.util.regex.Pattern;

/**
 *
 * @author DELL
 */
public class Enseignant extends Personne {

    private ArrayList<Quiz> tabQuiz;
    private HashMap<Quiz, EnsEtudiant> Quizpasse;

    public Enseignant() {
        Quizpasse = new HashMap<>();
        tabQuiz= new ArrayList<>();
    }
    

    public Enseignant(String nom, String prenom, String cin) {
        super(nom, prenom, cin);
        this.tabQuiz = new ArrayList<>();
        this.Quizpasse= new HashMap<Quiz,EnsEtudiant>();

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

    public void afficherQuizliste() {
        if (tabQuiz.isEmpty()) {
            System.out.println("Ensemble vide ");
        } else {
            for (int i = 0; i < tabQuiz.size(); i++) {
                System.out.println("tab[" + i + "]:" + tabQuiz.get(i));
            }
        }
    }
    
    public boolean egal(Enseignant e)
   {
        return (((this.getNom()).equals(e.getNom()))&& ((this.getPrenom()).equals(e.getPrenom()))&& ((this.getCin())).equals(e.getCin()));
   }
    

     public int appartient(Quiz Q){
        int pos=-1,i=0;
        while((pos==-1)&&(i<tabQuiz.size())){
            if( tabQuiz.get(i).equals(Q) )
                pos=i;
            else
            i++;
        }
        return pos;
    }

    public void ajout(Quiz q) {
        if (appartient(q) != -1) {
            System.out.println("Quiz existante");

        } else {
            tabQuiz.add(q);
        }
    }

    public void retirer(Quiz q) {
        if (tabQuiz.isEmpty()) {
            System.out.println("Ensemble vide !!!");
        } else {
            if (tabQuiz.remove(q)) {
                System.out.println("quiz supprimee !!!");
            } else {
                System.out.println("quiz inexistant");
            }
        }

    }

    public void ajouterHashMap(Quiz Q, Etudiant e) {
        EnsEtudiant Ens = new EnsEtudiant();
        Ens.ajout(e);
        Quizpasse.put(Q, Ens);

    }
    public void afficherHashmap(Quiz Q)
    { 
        if(Quizpasse.isEmpty())
            System.out.println("Ensemble vide");
     if (Quizpasse.containsKey(Q))
     {
        for( int i=0;i<(Quizpasse.get(Q)).taille();i++)
        {
           (Quizpasse.get(Q)).getArrayList().get(i).afficherscore();
           (Quizpasse.get(Q)).getArrayList().get(i).afficher();
        }
        
     }    
        
    }

    public ArrayList<Quiz> getTabQuiz() {
        return tabQuiz;
    }

    public HashMap<Quiz, EnsEtudiant> getQuizpasse() {
        return Quizpasse;
    }

    public void setTabQuiz(ArrayList<Quiz> tabQuiz) {
        this.tabQuiz = tabQuiz;
    }

    public void setQuizpasse(HashMap<Quiz, EnsEtudiant> Quizpasse) {
        this.Quizpasse = Quizpasse;
    }
    
    
       

}
