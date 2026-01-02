#!/bin/bash

# 로컬 개발 환경에서 Docker로 애플리케이션 실행

set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_DIR="$(cd "$SCRIPT_DIR/.." && pwd)"

cd "$PROJECT_DIR"

IMAGE_NAME="snapspot-backend:local"
CONTAINER_NAME="snapspot-backend-local"

echo "🔨 Docker 이미지 빌드 중..."
docker build --no-cache -f docker/Dockerfile.local -t "$IMAGE_NAME" .

# 기존 컨테이너가 실행 중이면 중지 및 삭제
if [ "$(docker ps -q -f name=$CONTAINER_NAME)" ]; then
    echo "🛑 기존 컨테이너 중지 중..."
    docker stop "$CONTAINER_NAME"
fi

if [ "$(docker ps -aq -f name=$CONTAINER_NAME)" ]; then
    echo "🗑️  기존 컨테이너 삭제 중..."
    docker rm "$CONTAINER_NAME"
fi

# logs 디렉토리 생성
mkdir -p logs

echo "🚀 컨테이너 실행 중..."
docker run -d \
  --name "$CONTAINER_NAME" \
  -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=local \
  -v "$PROJECT_DIR/logs:/app/logs" \
  "$IMAGE_NAME"

echo "✅ 애플리케이션이 실행되었습니다!"
echo "📍 접속 주소: http://localhost:8080"
echo ""
echo "📋 로그를 실시간으로 확인합니다 (Ctrl+C로 종료 가능)..."
echo "🛑 중지: docker stop $CONTAINER_NAME"
echo ""

# 로그를 실시간으로 출력
docker logs -f "$CONTAINER_NAME"

