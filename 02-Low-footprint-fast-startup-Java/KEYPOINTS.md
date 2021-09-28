- Plate-forme Java particulièrement puissante pour des processus de longue durée avec des performances de pointe
- Mais des processus de plus courte durée peuvent souffrir d'un temps de démarrage plus long et d'une utilisation de la mémoire relativement élevée

- Intro compilation AOT/native image
- Similaire au fonctionnement de gcc

- exécutable topten: librairies standard seulement, n'a pas besoin de JVM

- Java pour microservices/FAAS
- Concurrence avec Go
- Démarrage rapide, empreinte mémoire réduite

Restrictions:
- Toutes les classes doivent être disponibles à la compilation / pas de chargement de classes à l'exécution
- Reflection
