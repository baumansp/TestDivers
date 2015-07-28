package com.et;

//C:\dev\workspaces\Testing\.metadata\.plugins\org.eclipse.wst.server.core\tmp1
//IntroEJB3/build/classes

import java.util.List;

import javax.ejb.Remote;

import com.et.jpa.Produit;

@Remote
public interface GestionDeStock {
   public void ajouter(Produit produit);
   public Produit rechercherProduit(String id);
   public List<Produit> listerTousLesProduits();
}