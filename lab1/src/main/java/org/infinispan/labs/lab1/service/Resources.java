package org.infinispan.labs.lab1.service;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.infinispan.cdi.ConfigureCache;
import org.infinispan.labs.lab1.transactions.JBoss7TransactionManagerLookup;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.configuration.cache.CacheMode;

/**
 * Cache definitions
 *
 * @author Kevin Pollet <pollet.kevin@gmail.com> (C) 2011
 */
public class Resources {

   /**
    * <p>This producer defines the ticket allocation cache configuration.</p>
    * 
    */
   @TicketAllocationCache
   @ConfigureCache("ticketAllocationCache")
   @Produces
   public Configuration configureCache() {
      return new ConfigurationBuilder()
            .clustering().cacheMode(CacheMode.LOCAL)
            .transaction().transactionManagerLookup(new JBoss7TransactionManagerLookup())
            .jmxStatistics()
            .build();
   }
   
   @Produces
   public Logger getLogger(InjectionPoint ip) {
      return Logger.getLogger(ip.getMember().getDeclaringClass().getName());
   }
   
}