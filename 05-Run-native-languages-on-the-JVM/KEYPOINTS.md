- GraalVM: VM "universelle"
- Supporte un grand nombre de langages
- Truffle framework: 
    - Moteur d’exécution et aussi un SDK pour le support de nouveaux langages
    - Réimplémente la syntaxe et la grammaire du langage spécifié

- Donc un langage que supporte GraalVM est le C
- Peut exécuter du C comme du JavaScript ou du Ruby

- GraalVM interprète le bytecode produit par LLVM
- LLVM utilisé dans clang (~gcc) pour C, mais aussi C++, Fortran, Rust, etc.

- Exemple:
    - Version en 1 seul fichier (1 seule unité de compilation) d'un encodeur de fichiers .ogg
    - Format de fichier audio, similaire au mp3 mais open source
    - But: convertir et compresser un fichier .wav en .ogg
    - On utilise clang standard (hors GraalVM ou celui fourni avec GraalVM) pour compiler en bytecode LLVM (parce que c'est ce que supporte GraalVM), pas en assembleur natif

    - commande lli: LLVM bytecode interpreter

- Conclusion: Les implémentations de Ruby et Python dans GraalVM utilisent cette technique pour exécuter des extensions C pour ces langages. Cela signifie que vous pouvez exécuter des extensions C à l'intérieur de la machine virtuelle, et cela nous permet de maintenir des performances élevées même tout en prenant en charge ces interfaces d'extension natives héritées.

