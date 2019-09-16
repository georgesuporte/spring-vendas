#!/usr/bin/env bash

# Verifica se o arquivo .env existe
if [ -f ../.env ]; then
  VALUE=$(<../.env)

  # Remove os comentarios.
  SPLIT_NOW=$(awk '{print $01}' <<< "${VALUE}" | grep -o '^[^#]*')

  # Percorre as linhas do arquivo e transforma o conteudo das variaveis em array.
  while read -r line; do
    SPLIT+=("$line")
  done <<< "$SPLIT_NOW"

  # Percorre o Array e verifica se a variavel NAME_NETWORK não esta vazia.
  for ((i = 0 ; i < ${#SPLIT[@]} ; i++)); do
    RESULT=$(echo "${SPLIT[$i]}" | grep NAME_NETWORK |  cut -d'=' -f2)
    if [[ -n "$RESULT" ]]; then
      docker network rm $(echo "$RESULT")
    fi
  done
fi
