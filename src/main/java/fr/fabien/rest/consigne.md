# TP Validation des acquis (ultime) :

Passsage des groupes à 16h00 (un quart d'heure chacun).

Création d’un CRM simplifié - WebServices

## Introduction
Ce TP vise à créer une des webservices pour le CRM

Fonctionnalités attendues :
- Il est attendu que le serveur réponde aux requêtes suivantes :
  - orders
    - GET /orders : récupère toutes les commandes.
    - GET /orders/id :récupère une commande par son identifiant.
    - POST /orders :sauvegarde une commande.
    - DELETE /orders/id :supprime une commande par son identifiant.
  - clients
    - GET /clients: récupère tous les clients.
    - GET /clients/id :récupère un client par son identifiant.
    - GET /clients/id/orders :récupère toutes les commandes d’un client.
    - POST /clients:sauvegarde un client.
    - DELETE /clients/id :supprime un client par son identifiant.

La validation des corps des requêtes POST est demandée.