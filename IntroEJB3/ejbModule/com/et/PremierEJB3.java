package com.et;

import javax.ejb.Remote;

@Remote
public interface PremierEJB3 {
   public String ditBonjour(String aQui);
   public String compteStock();
}