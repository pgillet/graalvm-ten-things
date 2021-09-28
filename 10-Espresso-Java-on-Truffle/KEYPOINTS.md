Espresso: Java sur Truffle

- Implémentation de la spec JVM pour Java SE 8 et 11
- Par dessus GraalVM en tant qu'interpréteur Truffle
- JVM minifiée, qui inclut tous les composants core d'une JVM normale, et qui réutilise tous les JARs et les bibliothèques natives de GraalVM
- Désormais Java peut être exécuté selon les mêmes principes que les autres langages de l'écosystème GraalVM (JavaScript, Ruby, Python, R)
- Java sur Trufle est une technologie expérimentale dans GraalVM, et les performances de pointe sont actuellement 2 à 3 fois plus lentes que HotSpot.