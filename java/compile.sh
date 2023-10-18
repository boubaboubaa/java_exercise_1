#!/bin/bash

# Répertoire source des fichiers .java
src_dir="src"

# Répertoire de destination pour les fichiers .class
bin_dir="bin"

# Créer le répertoire de destination s'il n'existe pas
mkdir -p "$bin_dir"

# Compiler tous les fichiers .java du répertoire source
find "$src_dir" -name "*.java" | xargs javac -d "$bin_dir"

