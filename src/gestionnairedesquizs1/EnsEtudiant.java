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
public class EnsEtudiant {
    private static ArrayList<Etudiant> tabEt;
    

    EnsEtudiant() {
        tabEt = new ArrayList<Etudiant>();
    }


    public ArrayList<Etudiant> getArrayList() {
        return tabEt;
    }

    public static void setTabEt(ArrayList<Etudiant> tabEt) {
        EnsEtudiant.tabEt = tabEt;
    }

    public void vider() {
        tabEt.clear();
    }

    public void afficher() {
        if (!tabEt.isEmpty()) {
            for (int i = 0; i < tabEt.size(); i++) {
                System.out.println("tab[" + i + "]: " + tabEt.get(i));
            }
        } else {
            System.out.println("Ensemble vide ");
        }
    }

   public int taille()
   {
    return tabEt.size();
   }
    public int appartient(Etudiant e){
        int pos=-1,i=0;
        while((pos==-1)&&(i<tabEt.size())){
            if((tabEt.get(i)).egal(e)) 
                pos=i;
            else 
                i++;
        }
        return pos;
    }

    public void ajout(Etudiant e) {
        if (appartient(e) != -1) 
            System.out.println("Etudiant existant");

        else 
            tabEt.add(e);
        
    }

    public void retirer(Etudiant e) {
        if (tabEt.isEmpty()) {
            System.out.println("Ensemble vide !!!");
        } else {
            if (!tabEt.remove(e)) {
                System.out.println("Etudiant inexistante");
            } else {
                System.out.println("Etudiant supprimee !!!");
            }
        }

    }
    
}
