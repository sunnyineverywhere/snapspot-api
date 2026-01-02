#!/bin/bash

# 프로덕션 환경에서 Docker로 애플리케이션 실행

set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_DIR="$(cd "$SCRIPT_DIR/.." && pwd)"

cd "$PROJECT_DIR"

IMAGE_NAME="snapspot-backend:prod"
CONTAINER_NAME="snapspot-backend-prod"

echo "🔨 Docker 이미지 빌드 중..."
docker build -f docker/Dockerfile.prod -t "$IMAGE_NAME" .

# 기존 컨테이너가 실행 중이면 중지 및 삭제
if [ "$(docker ps -q -f name=$CONTAINER_NAME)" ]; then
    echo "🛑 기존 컨테이너 중지 중..."
    docker stop "$CONTAINER_NAME"
fi

if [ "$(docker ps -aq -f name=$CONTAINER_NAME)" ]; then
    echo "🗑️  기존 컨테이너 삭제 중..."
    docker rm "$CONTAINER_NAME"
fi

echo "🚀 컨테이너 실행 중..."
docker run -d \
  --name "$CONTAINER_NAME" \
  -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=prod \
  --restart always \
  "$IMAGE_NAME"

echo "✅ 애플리케이션이 실행되었습니다!"
echo "📍 접속 주소: http://localhost:8080"
echo "📋 로그 확인: docker logs -f $CONTAINER_NAME"
echo "🛑 중지: docker stop $CONTAINER_NAME"

