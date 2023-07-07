Application CRM : première version : correction à 15h30.

L’application gère des clients, des commandes et des utilisateurs.

Un client contient :
un identifiant unique
d'autres attributs qui correspondent aux colonnes de la table 'clients' en base de données
Une commande est liée à un client (mais un client peut avoir plusieurs commandes).

Une commande contient :
un identifiant unique
d'autres attributs qui correspondent aux colonnes de la table 'orders' en base de données

Créer une application Web avec les fonctionnalités suivantes :
/clients renvoie une liste en JSON de tous les clients
/clients?id=<id> renvoie un JSON avec le client ayant l’id passé en paramètre, ou un code HTTP 404 si aucun n’est trouvé.

/orders renvoie une liste en JSON de toutes les commandes
/orders?id=<id renvoie un JSON avec la commande ayant l’id passé en paramètre, ou un  code HTTP 404 si aucune n’est trouvée.

Cette application doit utiliser Maven, des Servlets (ou JSPs).

Toute action doit être loggée, et un Dao contenant une Map doit être utilisé pour faire office de référentiel de données.
Bonus 1 : Utiliser JDBC dans le DAO pour tirer des données de la base de données.
Bonus 2 : une URL (ex /clients/csv) permet de récupérer une liste de tous les clients en CSV