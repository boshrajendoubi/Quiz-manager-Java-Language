/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionnairedesquizs1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DELL
 */


public class NewMain {

    public static void main(String[] args) {
         Scanner s=new Scanner(System.in);
         EnsEtudiant Ens=new EnsEtudiant(); 
         EnsEnseignant EnsEn= new EnsEnseignant();
         Etudiant e4= new Etudiant(4,"boshra","jendoubi","14250148");
         Etudiant e1= new Etudiant(4,"Nassim","salhi","14506980");
         Etudiant e2= new Etudiant(4,"nidhal","Tijani","12345678");
         Etudiant e3= new Etudiant(4,"Hend","Aloui","12345678");
         Enseignant E3= new Enseignant("abir","zawali","09898301");
         Enseignant E1= new Enseignant("imen","oueslati","09898301");
         Enseignant E2= new Enseignant("amira","ghribi","09898301");
        
         EnsEn.ajout(E3);
         EnsEn.ajout(E2);
         EnsEn.ajout(E1);
         
         Ens.ajout(e4);
         Ens.ajout(e1);
         Ens.ajout(e2);
         Ens.ajout(e3);
         ArrayList<Module> LModule=new ArrayList(4);
         Module m1= new Module("bd");
         Module m2= new Module("poo");
         Quiz Q= new Quiz();
       /*  Q.saisirQuiz();*/
         m1.AjouterQuiz(Q);
         Quiz Q4= new Quiz();
        /* Q4.saisirQuiz();*/
         m2.AjouterQuiz(Q4);
         LModule.add(m2);
         LModule.add(m1);
         
         for(int p=0;p<LModule.size();p++)
         {
           LModule.get(p).Afficher();
         }
         
         
         
                             
        /* m1.Afficher();
         m1.getLQuiz().get(0).Afficher();*/
        /* Quiz Q1= new Quiz();
         Q1.saisirQuiz();
         m2.AjouterQuiz(Q1);*/
         
        
        /* Quiz Q= new Quiz();
        Q.saisirQuiz();
        e.passer(Q); 
        e.afficherreponse();*/
         /*
         Ens.ajout(e1);
         Ens.afficher();
        /*  e1.afficher();
         e1.Saisir();
         Option o=new Option();
         o.SaisirOption();
        Qcm Q=new Qcm();
        Q.SaisirQcm();
        Q.afficherSansCorrec();
        System.out.println("ajout de o");
        Q.ajout(o);
        Q.afficher();
        System.out.println("suppression de o");
        Q.retirer(o);
        Q.afficher();
        Q.appartient(o);
        Q.afficher();
        System.out.println("modification du qcm ");
        Q.modifier();
        Q.afficher();*/
       
       /* Q.Afficher();
        Q.AfficherSansCorrec();
         Qcm ques=new Qcm();
         ques.SaisirQcm();*/
         
        
       
       int choixE,choix,choixpersonne,choixEn; 
       
       do
       { 
           Etudiant e=new Etudiant();
           Enseignant E=new Enseignant();
            System.out.println("1--S'identifier");
          System.out.println("2--S'inscrire");
          System.out.println("3--Quitter");
          do
          {
          System.out.println("Saisir votre choix");
          choix=s.nextInt();
          }while(choix<1 || choix>3);
          switch(choix)
          {
              case 1,2:
              {
                  do
                  {
          System.out.println("Etes-vous un étudiant ou un enseignant?");
          System.out.println("Taper 1 si étudiant Taper 2 si enseignant");
          choixpersonne=s.nextInt();
                  } while(choixpersonne<1 || choixpersonne>2);
          if(choixpersonne==1)//espace etudiant
        {
             if(choix==1)//s'identifier
              {
                System.out.println("S'identifier");
                do {
                 System.out.println("Saisir vos coordonnées");
                 e.Saisir();
                }
                  while(Ens.appartient(e) != -1);
                
              }
              if (choix==2) //s'inscrire
              {
              System.out.println("S'inscrire");//s'inscrire
               e.Saisir();
               if(Ens.appartient(e)==-1)
               Ens.ajout(e);
               else System.out.println("etudiant existant");
              }
                
           do //menu étudiant
           {
                      System.out.println("1--Afficher la liste des quizs passés et non passés");
                      System.out.println("2--Passer un quiz");
                      System.out.println("3--Consulter les scores pour les quizs déjà passés");
                      System.out.println("4--Consulter la correction d'un quiz");
                      System.out.println("5--Quitter");
                      do
                      {
                      choixE=s.nextInt(); 
                      } while(choixE<1 || choixE>5);
                     switch( choixE )
                     {
                         case 1://Afficher la liste des quizs passés et non passés
                         {
                             System.out.println("les quizs deja passés");
                             e.afficherQuizPasse();
                             System.out.println("les quizs non passés");
                             for(int i=0;i<LModule.size();i++)
                             {
                               for(int j=0;j<LModule.get(i).getLQuiz().size();j++)
                               {
                                 if (!(e.getQuizPasse().contains(LModule.get(i).getLQuiz().get(j))))
                                     
                                     LModule.get(i).getLQuiz().get(j).Afficher();
                               }
                             }
                            
                         break;
                         }
                         case 2: //Passer un quiz
                         {  /* boolean test= false;
                              int j=0;
                              Module m;
                             String nomM;
                             int numM=-1;
                             for (int i=0;i<LModule.size();i++)
                             {
                               LModule.get(i).Afficher();
                             }
                             System.out.println("donner le nom du module du quiz que vous voulez passer");
                             nomM=s.next();
                             m=new Module(nomM);
                             while((numM==-1) && (j<LModule.size()))
                             {
                              if ((LModule.get(j)).equals(m))
                              {
                               numM=j;
                              }
                              else j++;    
                             }
                             if(test) 
                             {
                               System.out.println("passage du quiz: ");
                               e.passer(LModule.get(numM).getLQuiz().get(0));
                             
                             
                             }
                             else System.out.println("module inexistant");*/
                              int numQ,pos=-1,i=0;
                              
                              String nomM;
                              System.out.println("donner le module pour lequel vois voulez visualiser le quiz");
                              nomM=s.next();
                              
                              while(  (pos==-1) && (i<LModule.size()))
                              {
                                if((E.getTabQuiz().get(i).getModule()).equals(nomM))
                                {pos=i;
                                System.out.println("module trouve !!");
                                }
                                else 
                                    i++;
                              }
                              if(pos>=0 )
                              {
                                  LModule.get(pos).AfficherSansCorrec();
                                System.out.println("saisir le num du quiz à passer");
                                 numQ=s.nextInt();
                                 e.passer(LModule.get(pos).getLQuiz().get(numQ));
                              }
                              
                             
                          break;
                         }
                         case 3://Consulter les scores pour les quizs déjà passés
                         { 
                             System.out.println("les scores: ");
                             e.afficherscore();
                             System.out.println("case3");
                          break;
                         }
                         case 4://Consulter la correction d'un quiz
                         {   Module m;
                             String nomM;
                             int numQ,i=0;
                             int pos=-1;
                             System.out.println("donner le nom du module de ce quiz ");
                             nomM=s.next();
                             m=new Module(nomM); 
                             while((pos==-1) && (i<LModule.size()))
                             {
                              if(LModule.get(i).equals(m))
                              {
                                pos=i;
                              }
                              else i++;
                             }
                             LModule.get(pos).Afficher();
                             System.out.println("donner le num de quiz que vous voulez consulter la correction");
                             numQ=s.nextInt();
                             LModule.get(pos).getLQuiz().get(numQ).Afficher();
                           break;
                         }
                         case 5:
                         {  
                             System.out.println("Au revoir cher étudiant! ");
                             
                           break;
                         }
                         default: System.out.println("donnee erronée");
                             break;
                     }
       
       
       
       
       }
       while(choixE!=5);
          
        }
              
              
          else //espace enseignant
          { 
              if(choix==1)//s'identifier
              {
                System.out.println("S'identifier");
                do {
                 System.out.println("Saisir vos coordonnées");
                 E.saisir();
                }
                while(EnsEn.getArrayList().contains(E));
                
              }
              if (choix==2) //s'inscrire
              {
              System.out.println("S'inscrire");//s'inscrire
              E.saisir();
               if(EnsEn.appartient(E)==-1)
               EnsEn.ajout(E);
               else System.out.println("enseignant existant");
              }
              
              do { //espace enseignant
                     System.out.println("1--Créer un quiz");
                      System.out.println("2--Visualiser le quiz d'un module donné");
                      System.out.println("3--Supprimer le quiz d'un module donné");
                      System.out.println("4--Modifier le quiz d'un module donné");
                      System.out.println("5--Visualiser la liste des étudiants ayant passé le quiz d'un module avec leurs scores ");
                      System.out.println("6--Visualiser pour un quiz d'un module et pour toute question ,le taux de réponse justes et fausses");
                      System.out.println("7--Quitter");
                      do 
                      {
                          System.out.println("saisir votre choix");
                      choixEn=s.nextInt(); 
                      } while(choix<1 || choix>7);
              
                      switch(choixEn)
                      {
                          case 1://Créer un quiz
                          { 
                              
                              int i=0;
                              Quiz Q1= new Quiz();
                              Q1.saisirQuiz();
                              Q1.setEnseignant(E.getNom());
                              E.ajout(Q1);
                              String ch=Q1.getModule();
                              
                              Module m= new Module(ch);
                              m.AjouterQuiz(Q1);
                              LModule.add(m);
                              
                             
                           System.out.println("1");
                              break;}
                          case 2://Visualiser le quiz d'un module donné
                          {
                              String nomM;
                              System.out.println("donner le module pour lequel vois voulez visualiser le quiz");
                              nomM=s.next();
                              for(int i=0;i<E.getTabQuiz().size();i++)
                              {
                                if((E.getTabQuiz().get(i).getModule()).equals(nomM))
                                    E.getTabQuiz().get(i).Afficher();
                              }
                         
                          
                              break;}
                          case 3://Supprimer le quiz d'un module donné
                          {
                             String nomM;
                              System.out.println("donner le module pour lequel vois voulez visualiser le quiz");
                              nomM=s.next();
                              for(int i=0;i<E.getTabQuiz().size();i++)
                              {
                                if((E.getTabQuiz().get(i).getModule()).equals(nomM))
                                    E.retirer(E.getTabQuiz().get(i));
                              }  
                             
                              break;}
                          case 4://Modifier le quiz d'un module donné
                          {
                               String nomM;
                              System.out.println("donner le module pour lequel vois voulez visualiser le quiz");
                              nomM=s.next();
                              for(int i=0;i<E.getTabQuiz().size();i++)
                              {
                                if((E.getTabQuiz().get(i).getModule()).equals(nomM))
                                    E.getTabQuiz().get(i).modifier();
                              }  
                              
                           
                              break;}
                          case 5://Visualiser la liste des étudiants ayant passé le quiz d'un module avec leurs scores
                          {
                              String nomM;
                              System.out.println("donner le module pour lequel vois voulez visualiser les étudiants avec leur scores ");
                              nomM=s.next();
                              for(int i=0;i<E.getTabQuiz().size();i++)
                              {
                                if((E.getTabQuiz().get(i).getModule()).equals(nomM))
                                    E.afficherHashmap(E.getTabQuiz().get(i));
                                
                                   
                              }  
                           
                              break;}
                          case 6://Visualiser pour un quiz d'un module et pour toute question ,le taux de réponse justes et fausses
                          { 
                              
                              System.out.println("6");
                          
                          
                          
                              break;}
                          case 7:
                          { System.out.println("7");
                           
                            System.out.println("Au revoir cher Enseignant !");
                          
                              break;}
                          default: 
                          {
                          System.out.println("donnees erronees");
                          break;}
                      
                      
                      
                      }
          }while(choixEn!=7);
                      
                      
                      
                      
                      
                      
                      
                      
                      
                      
                      
                      
                      
          }
              break;
              }
              case 3:
              {
                System.out.println("Au revoir!");
              break;}
              default:
              {
                  break;}
          
          
          }
              
           
           
                
       }
       while(choix!=3);
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
 
    
       
        
        
                 
       
        
        
      
        
        
          
         
        
        
        
        
    }
    
}
