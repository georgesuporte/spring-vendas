#!/usr/bin/env bash

# Inicializar container docker.

cd -
docker-compose up -d --build && \
docker ps