# Build
FROM gradle:8.8-jdk21-alpine AS builder
WORKDIR /app

# settings.gradle.kts와 build.gradle.kts 먼저 복사 (캐시 유지 목적)
COPY settings.gradle.kts ./
COPY build.gradle.kts ./
COPY gradle.properties ./
COPY gradle ./gradle
COPY buildSrc ./buildSrc

# 개별 모듈의 build.gradle.kts 복사 (변경 시 최소 레이어 invalidation)
COPY core/build.gradle.kts core/
COPY core-domain/build.gradle.kts core-domain/
COPY utils/build.gradle.kts utils/

# 먼저 dependencies만 resolve
RUN gradle dependencies --no-daemon

# 실제 소스 복사
COPY . .

# 애플리케이션 모듈 빌드
RUN gradle :core:clean :core:bootJar --no-daemon

# Run
FROM openjdk:21-jdk-slim AS runner
WORKDIR /app
COPY --from=builder /app/core/build/libs/*.jar multimodule.jar
ENV TZ=Asia/Seoul
ENTRYPOINT ["java", "-jar", "multimodule.jar"]
