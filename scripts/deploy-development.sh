#!/usr/bin/env bash

# Deploy Project development

# Verifica se o arquivo .env existe
if [ -f ../.env ]; then
  VALUE=$(<../.env)

  # Remove os comentarios.
  SPLIT_NOW=$(awk '{print $01}' <<< "${VALUE}" | grep -o '^[^#]*')
  
  # Percorre as linhas do arquivo e transforma o conteudo das variaveis em array.
  while read -r line; do
    SPLIT+=("$line")
  done <<< "$SPLIT_NOW"

  # Percorre o Array e verifica se a variavel CONTAINER_NAME_API não esta vazia.
  for ((i = 0 ; i < ${#SPLIT[@]} ; i++)); do
    RESULT=$(echo "${SPLIT[$i]}" | grep CONTAINER_NAME_API |  cut -d'=' -f2)
    if [[ -n "$RESULT" ]]; then
        # Caso TRUE realiza o Deploy.
        # @TODO Pendente terminar a lógica.
        docker exec -it "${RESULT}" 
    fi
  done
fi

