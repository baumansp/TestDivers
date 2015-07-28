package com.et.imp;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.et.GestionDeStock;
import com.et.jpa.Produit;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class GestionDeStockBean implements GestionDeStock {

   @PersistenceContext
   EntityManager em;

   public void ajouter(Produit produit) {
      em.persist(produit);
   }

   public Produit rechercherProduit(String id) {
      return em.find(Produit.class, id);
   }

   public List<Produit> listerTousLesProduits() {
      return em.createQuery("SELECT p FROM Produit p ORDER BY p.quantiteEnStock").getResultList();
   }

}