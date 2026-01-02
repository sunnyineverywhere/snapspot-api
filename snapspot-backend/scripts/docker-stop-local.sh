#!/bin/bash

# 로컬 개발 환경 컨테이너 중지 및 삭제

set -e

CONTAINER_NAME="snapspot-backend-local"

if [ "$(docker ps -q -f name=$CONTAINER_NAME)" ]; then
    echo "🛑 컨테이너 중지 중..."
    docker stop "$CONTAINER_NAME"
    echo "✅ 컨테이너가 중지되었습니다."
else
    echo "ℹ️  실행 중인 컨테이너가 없습니다."
fi

if [ "$(docker ps -aq -f name=$CONTAINER_NAME)" ]; then
    echo "🗑️  컨테이너 삭제 중..."
    docker rm "$CONTAINER_NAME"
    echo "✅ 컨테이너가 삭제되었습니다."
fi

