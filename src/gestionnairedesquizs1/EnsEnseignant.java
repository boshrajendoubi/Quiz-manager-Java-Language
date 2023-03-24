/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionnairedesquizs1;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class EnsEnseignant {
    private static ArrayList<Enseignant> tabEn;
   

    public EnsEnseignant() {
        tabEn = new ArrayList<Enseignant>();
    }

    public ArrayList<Enseignant> getArrayList() {
        return tabEn;
    }

    public static void setTabEn(ArrayList<Enseignant> tabEn) {
        EnsEnseignant.tabEn = tabEn;
    }

    public void vider() {
        tabEn.clear();
    }

    public void afficher() {
        if (tabEn.isEmpty()) {
            System.out.println("Ensemble vide ");
        } else {
            for (int i = 0; i < tabEn.size(); i++) {
                System.out.println("tab[" + i + "]:" + tabEn.get(i));
            }
        }
    }

   
    
     public int appartient(Enseignant e){
        int pos=-1,i=0;
        while((pos==-1)&&(i<tabEn.size())){
            if((tabEn.get(i)).egal(e)) 
                pos=i;
            else 
                i++;
        }
        return pos;
    }

    public void ajout(Enseignant e) {
        if (appartient(e) != -1) {
            System.out.println("Enseignant existant");

        } else {
            tabEn.add(e);
        }
    }

    public void retirer(Enseignant e) {
        if (tabEn.isEmpty()) {
            System.out.println("Ensemble vide !!!");
        } else {
            if (!tabEn.remove(e)) {
                System.out.println("Enseignant inexistant");
            } else {
                System.out.println("Enseignant supprimee !!!");
            }
        }

    }
}
