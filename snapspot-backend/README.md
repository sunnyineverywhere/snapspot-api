# Snapspot Backend

Spring Boot 기반 백엔드 애플리케이션입니다.

## 사전 요구사항

- Docker

## Docker를 사용한 실행 방법

### 스크립트를 사용한 실행 (권장)

가장 간단한 방법은 제공된 스크립트를 사용하는 것입니다.

#### 로컬 개발 환경

```bash
# snapspot-backend 디렉토리에서 실행
cd snapspot-backend

# 애플리케이션 실행
./scripts/docker-run-local.sh

# 로그 확인
docker logs -f snapspot-backend-local

# 중지 및 삭제
./scripts/docker-stop-local.sh
```

#### 프로덕션 환경

```bash
# snapspot-backend 디렉토리에서 실행
cd snapspot-backend

# 애플리케이션 실행
./scripts/docker-run-prod.sh

# 로그 확인
docker logs -f snapspot-backend-prod

# 중지 및 삭제
./scripts/docker-stop-prod.sh
```

### Docker 명령어 직접 사용

#### 로컬 개발 환경

```bash
# snapspot-backend 디렉토리에서 실행
cd snapspot-backend

# 이미지 빌드
docker build -f docker/Dockerfile.local -t snapspot-backend:local .

# 컨테이너 실행
docker run -d \
  --name snapspot-backend-local \
  -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=local \
  snapspot-backend:local

# 로그 확인
docker logs -f snapspot-backend-local

# 중지 및 삭제
docker stop snapspot-backend-local
docker rm snapspot-backend-local
```

#### 프로덕션 환경

```bash
# snapspot-backend 디렉토리에서 실행
cd snapspot-backend

# 이미지 빌드
docker build -f docker/Dockerfile.prod -t snapspot-backend:prod .

# 컨테이너 실행
docker run -d \
  --name snapspot-backend-prod \
  -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=prod \
  --restart always \
  snapspot-backend:prod

# 로그 확인
docker logs -f snapspot-backend-prod

# 중지 및 삭제
docker stop snapspot-backend-prod
docker rm snapspot-backend-prod
```

## 접속 정보

애플리케이션이 실행되면 다음 주소로 접속할 수 있습니다:

- **애플리케이션**: http://localhost:8080
- **H2 Console** (로컬 환경): http://localhost:8080/h2-console

## 유용한 Docker 명령어

### 이미지 확인
```bash
docker images | grep snapspot
```

### 실행 중인 컨테이너 확인
```bash
docker ps | grep snapspot
```

### 컨테이너 내부 접속
```bash
# 로컬
docker exec -it snapspot-backend-local sh

# 프로덕션
docker exec -it snapspot-backend-prod sh
```

### 컨테이너 리소스 사용량 확인
```bash
docker stats snapspot-backend-local
docker stats snapspot-backend-prod
```

### 이미지 및 컨테이너 정리
```bash
# 중지된 컨테이너 삭제
docker container prune

# 사용하지 않는 이미지 삭제
docker image prune -a

# 특정 이미지 삭제
docker rmi snapspot-backend:local
docker rmi snapspot-backend:prod
```

## 환경 변수

다음 환경 변수를 설정할 수 있습니다:

- `SPRING_PROFILES_ACTIVE`: Spring 프로파일 (local, prod)
- `JAVA_OPTS`: JVM 옵션 (필요시)

예시:
```bash
docker run -d \
  --name snapspot-backend-local \
  -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=local \
  -e JAVA_OPTS="-Xmx512m -Xms256m" \
  snapspot-backend:local
```

## 문제 해결

### 포트가 이미 사용 중인 경우
다른 포트로 매핑:
```bash
docker run -d \
  --name snapspot-backend-local \
  -p 8081:8080 \
  snapspot-backend:local
```

### 빌드 캐시 무시하고 재빌드
```bash
# snapspot-backend 디렉토리에서 실행
cd snapspot-backend
docker build --no-cache -f docker/Dockerfile.local -t snapspot-backend:local .
```

### 컨테이너 로그 확인
```bash
docker logs snapspot-backend-local
docker logs snapspot-backend-prod
```

