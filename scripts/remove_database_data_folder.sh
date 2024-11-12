#!/bin/bash

if [ -d '../volumes/database/data/' ]; then
    echo "O diretório existe."
    sudo rm -rf ../volumes/database/data/
    echo "Diretório removido"
else
    echo "O diretório não existe."
fi
