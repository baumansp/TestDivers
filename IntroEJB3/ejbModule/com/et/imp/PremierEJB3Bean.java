package com.et.imp;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.et.GestionDeStock;
import com.et.PremierEJB3;
import com.et.jpa.Produit;

@Stateless
public class PremierEJB3Bean implements PremierEJB3 {

	@EJB
	private GestionDeStock stock;

	private static final Logger logger = Logger
	        .getLogger("PremierEJB3Bean");
	public String ditBonjour(String aQui) {

		return "Bonjour " + aQui + " ! ";
	}

	public String compteStock() {
		int count = 0;

		List<Produit> produits = stock.listerTousLesProduits();
		for (Iterator<Produit> iter = produits.iterator(); iter.hasNext();) {
			Produit eachProduit = (Produit) iter.next();
			logger.log(Level.FINE, eachProduit.toString());
			count += 1;
		}

		return " Il y a " + count + " produit(s) en db";

	}

}