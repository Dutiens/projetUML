# SalleOp (Projet UML)
ASI 3.2 - 2016

---

## Prérequis
 * Maven (mvn)
 
 ---
 
## Première exécution
Lors de la première execution il est nécessaire d'installer les différentes 
dépendances nécessaires à l'exécution de ce projet.
Pour celà il suffit de lancer la commande suivante :

    mvn install
    
---

## Exécution
Après avoir installé les différentes dépendances, il est nécessaire de lancer le serveur.
Pour celà il est nécessaire d'exécuter la commande suivante :

    mvn jetty:run
    
---
    
## Utilisation
Sur une machine en local, l'accès se fait à l'aide du navigateur web à l'adresse suivante:

[localhost:8080?id=1](http://localhost:8080?id=1)

Avec **id** l'identifiant de la page 'Annonce' à charger.

__Attention :__ Tout identifiant incorrect amènera à une page d'exception dans l'état actuel du projet. 
Ici, seul les identifiants __1__ et __2__ sont disponibles.

---

## Auteurs
**Equipe :** Les DUTiens
 * Martin Florian
 * Théologien Thibault
 * Zerhouni Youssef
