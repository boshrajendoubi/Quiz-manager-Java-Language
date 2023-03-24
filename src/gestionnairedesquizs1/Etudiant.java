/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionnairedesquizs1;

import java.util.*;

/**
 *
 * @author DELL
 */
public class Etudiant extends Personne {
    
    private  ArrayList<Quiz> quizPasse;
    private  ArrayList< Float> LScore;
    private int Groupe;
    private ArrayList<Boolean> ReponseOptions;
    private ArrayList StockReponses = new ArrayList();

    

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
        final Etudiant other = (Etudiant) obj;
        if (this.Groupe != other.Groupe) {
            return false;
        }
        return true;
    }


   public boolean egal(Etudiant e)
   {
        return (this.Groupe==e.Groupe)&&((this.getNom()).equals(e.getNom()))&&(this.getPrenom().equals(e.getPrenom()))&&(this.getCin().equals(e.getCin()));
   }
    
    
    
    
    
    public Etudiant()
    {
      Groupe=0;
      quizPasse = new ArrayList<>();
      ReponseOptions= new ArrayList<Boolean>();
       LScore=new ArrayList<> ();
     
      
    }
     public Etudiant(int Groupe, String nom, String prenom, String cin) {
        super(nom, prenom, cin);
        this.Groupe = Groupe;
        quizPasse = new ArrayList<>();
        ReponseOptions= new ArrayList<>(4);
        LScore=new ArrayList<> ();
    }
   
    public void setGroupe(int Groupe) {
        this.Groupe = Groupe;
    }
    
    
    
    
    public void setQuizPasse(ArrayList<Quiz> quizPasse) {
        this.quizPasse = quizPasse;
    }
    public void setLScore(ArrayList<Float> LScore) {
        this.LScore = LScore;
    }
    public void setReponseOptions(ArrayList<Boolean> ReponseOptions) {
        this.ReponseOptions = ReponseOptions;
    }

    public  ArrayList<Boolean> getReponseOptions() {
        return ReponseOptions;
    }
     public int getGroupe() {
        return Groupe;
    }
 public  ArrayList<Quiz> getQuizPasse() {
        return quizPasse;
    }
    

    public  ArrayList<Float> getLScore() {
        return LScore;
    }

  
    
    public void  Saisir()
    { Scanner s= new Scanner(System.in);
       super.saisir();
       do{
       System.out.println("Groupe: ");
       Groupe=s.nextInt();
       }while( Groupe<=0); 
       
    }
    
    public void afficher()
    {
      super.afficher();
      System.out.println("Groupe: "+Groupe);
    }

   
    public void quizpasse(Quiz Q)
    {  if (LScore.get(quizPasse.indexOf(Q))>=0)
       quizPasse.add(Q);
    }
    public void afficherQuizPasse()
    {
       if (quizPasse.isEmpty()) {
            System.out.println("Ensemble vide ");
        } else {
            for (int i = 0; i < quizPasse.size(); i++) {
                System.out.println("Quiz n° "+(i+1)+": ");
                (quizPasse.get(i)).Afficher();
            }
        }
        
    }
    
    public void initscore(int taille)
    {
      for(int i=0;i<taille;i++)
      {
        LScore.add(i,(float)(-1));
      }
    }
     
            
    public void passer(Quiz Q)
    {   
        int score=0;
        this.initscore(0);
        ReponseOptions= new ArrayList<Boolean>(4);
       Enseignant E=new Enseignant(Q.getEnseignant(),"","");
        int choix;
    Scanner s=new Scanner(System.in);
    for(int i=0;i<Q.getLQcm().size();i++)
    {
      
      ((Q.getLQcm()).get(i)).afficherSansCorrec();
      do{
      System.out.println("Tapez votre choix ");
      choix=s.nextInt();
      }while(choix<1 || choix>4);
      
       switch(choix)
       {
           case 1:
           {
             ReponseOptions.add(0, true);
             ReponseOptions.add(1, false);
             ReponseOptions.add(2, false);
             ReponseOptions.add(3, false); 
            score+= Q.getLQcm().get(i).ScoreQcm(this);
            System.out.println(score);
            
           break;
           }
           case 2:
           {
             ReponseOptions.add(0, false);
             ReponseOptions.add(1, true);
             ReponseOptions.add(2, false);
             ReponseOptions.add(3, false);  
             score+= Q.getLQcm().get(i).ScoreQcm(this);
             System.out.println(score);
           break;
           }
           case 3:
           {
             ReponseOptions.add(0, false);
             ReponseOptions.add(1, false);
             ReponseOptions.add(2, true);
             ReponseOptions.add(3, false);
             score+= Q.getLQcm().get(i).ScoreQcm(this);
             System.out.println(score);
           break;
           }
           case 4:
           {
             ReponseOptions.add(0, false);
             ReponseOptions.add(1, false);
             ReponseOptions.add(2, false);
             ReponseOptions.add(3, true);
             score+= Q.getLQcm().get(i).ScoreQcm(this);
             System.out.println(score);
           break;
           }
           default: System.out.println("choix erroné");
           break;
       
       
       
       }
    }
       quizPasse.add(Q);
       System.out.println("votre score est: "+score);
      LScore.add((float)score);
      StockReponses.add(ReponseOptions); //stocker les réponses d'un étudiant pour un quiz 
      E.ajouterHashMap(Q, this);
   
      
    }
    
             
   public void afficherreponse()
   {
     for (int i=0;i<ReponseOptions.size();i++)
     {
       System.out.println(ReponseOptions.get(i));
     }
   }
   
   public void afficherscore()
   {
    if (LScore.isEmpty()) {
            System.out.println("Ensemble vide ");
        } else {
            for (int i = 0; i < LScore.size(); i++) {
                System.out.println(" le score pour le Quiz n° "+(i+1)+": ");
                System.out.println(LScore.get(i));
            }
        }
   }
   
    
}
