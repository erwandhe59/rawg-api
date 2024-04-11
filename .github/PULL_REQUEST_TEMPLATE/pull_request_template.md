# Description du Changement
Koin fonctionnel, application qui se lance, mais erreur lors du possage en local.

## Descriptif erreur
- [ ] Jeux qui se sauvegarde en remote, mais une fois le passage en local -> erreurs.

## Autres informations

Côté remote :
```
[GameEntity(id=28, name=Red Dead Redemption 2, backgroundImage=https://media.rawg.io/media/games/511/5118aff5091cb3efec399c808f8c598f.jpg),.......
Fetching all games from DB
Saving games to DB: 20
Games saved to DB
```

Côté local :
```
[GameEntity(id=28, name=Red Dead Redemption 2, backgroundImage=https://media.rawg.io/media/games/511/5118aff5091cb3efec399c808f8c598f.jpg),.......
Fetching all games from DB
Error fetching games: Unable to resolve host "api.rawg.io": No address associated with hostname
Saving games to DB: 0
Games saved to DB
```

