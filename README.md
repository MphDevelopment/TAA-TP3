# TAA-TP3 (Partie 1)

Ce projet implémente un système Client, Store, Provider, Bank à l'aide de Spring ainsi qu'un service de monitoring permettant de 
vérifier lors d'un transfert d'argent que le compte émetteur possède assez de fonds. 

Il est possible d'exécuter le projet en exécutant la classe `tp3/Application.Java` qui appelle la méthode `run` de la classe `tp3/client/Client.java` exécutant le scénario suivant : Un client achète 2 pains en 'achat rapide' puis essaie d'acheter 3 autres pains en les ajoutants à son panier, mais il ne possède pas assez de fonds et la banque refuse la paiement.

# Implémentation
Le projet est implémenté de la manière suivante :
- Lorsqu'un client paie, la bank accepte ou refuse le paiment par le biais du service de monitoring. Si le paiement est accepté le magasin mets à jour ses stocks puis vérifie s'il doit restocker. S'il doit restocker il contacte le provider qui rempli automatiquement le stock du magasin.
