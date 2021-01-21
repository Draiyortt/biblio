package fr.pgah.java.unbrco.model.bibliotheque;

import java.util.ArrayList;
import java.util.List;
import fr.pgah.java.unbrco.model.livre.Livre;

public class Bibliotheque {

  private Bibliothecaire gerant;
  private String nom;
  private List<Bibliotheque> branches;
  private List<Livre> livresReference;
  private List<Livre> livresRomans;
  private List<Livre> livresBiographie;
  private List<Livre> livresManuels;
  private List<Livre> livreCuisine;

  public Bibliotheque(String nom, Bibliothecaire gerant) {
    this.nom = nom;
    this.gerant = gerant;
    branches = new ArrayList<>();
    livresReference = new ArrayList<>();
    livresRomans = new ArrayList<>();
    livresBiographie = new ArrayList<>();
    livresManuels = new ArrayList<>();
    livreCuisine = new ArrayList<>();

  }

  public String getNom() {
    return nom;
  }

  public Bibliothecaire getGerant() {
    return gerant;
  }

  // PREREQUIS : livre != null
  // MODIFIE : this
  // EFFETS : stocke livre dans la collection appropriée de cet objet
  public void enregistrerLivre(Livre livre) {
    if(livre != null){
      switch (livre.getGenre()) {
        case BIBLIOGRAPHIE:
          livresBiographie.add(livre);
          break;
        case CUISINE:
          livreCuisine.add(livre);
          break;
        case MANUEL:
          livresManuels.add(livre);
          break;
        case REFERENCE:
          livresReference.add(livre);
          break;
        case ROMAN:
          livresRomans.add(livre);
          break;
        default:
          break;
      
      }
    }
  }

  // PREREQUIS : livre != null
  // RENVOIE : vrai si livre est dans le catalogue de cette bibliothèque
  // (qu'il soit actuellement emprunté ou non)
  public boolean estDansCatalogue(Livre livreDemande) {

    if(livreDemande != null){
      for( Livre livre : livresBiographie ){
        if (livre == livreDemande){
          return true;
        }
      }
      for( Livre livre : livresReference ){
        if (livre == livreDemande){
          return true;
        }
      }
      for( Livre livre : livresManuels ){
        if (livre == livreDemande){
          return true;
        }
      }
      for( Livre livre : livresRomans ){
        if (livre == livreDemande){
          return true;
        }
      }
      for( Livre livre : livreCuisine ){
        if (livre == livreDemande){
          return true;
        }
      }
      return false;
    }else{
      return false;
    }
    

  }

  // PREREQUIS: livre != null
  // RENVOIE : vrai si livre est disponible à l'emprunt
  public boolean peutEtreEmprunte(Livre livre) {
    if (livre != null) {
      if (livre.estSorti()) {
        return false;
      }
      return true;
      
    }
    return false;
  }

  // PREREQUIS : livre != null
  // RENVOIE : vrai si livre est dans le catalogue de cette bibliotheque
  // ou dans celui de l'un de ses branches
  public boolean estDansCatalogueEtendu(Livre livre) {
    return false;
  }

  // PREREQUIS : livre != null
  // MODIFIE : this
  // EFFETS : enregistre le fait que livre est maintenant emprunté (si possible)
  // RENVOIE : vrai si l'opération est un succès
  public boolean enregistrerSortie(Livre livre) {
    if (livre != null) {
      livre.enregistrerSortie();
      return true;
    }
    return false;
  }

  // PREREQUIS : livre != null
  // MODIFIE : this
  // EFFETS : enregistre le fait que livre est revenu (si possible)
  // RENVOIE : vrai si l'opération est un succès
  public boolean enregistrerRetour(Livre livre) {
    if (livre != null) {
      livre.enregistrerRetour();
      return true;
    }
    return false;
    
  }

  // PREREQUIS : gerant != null
  // MODIFIE : this
  // EFFETS : set le nouveau gérant
  // RENVOIE : vrai si l'opération est un succès
  public boolean engagerGerant(Bibliothecaire bibliothecaire) {
    return false;
  }


  // EFFETS : affiche le catalogue de cette bibliothèque
  // (toutes les informations de chaque livre)
  public void afficherCatalogue() {
  }
}
