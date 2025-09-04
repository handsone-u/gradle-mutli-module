# multi-module

Kotlin 기반 Gradle 멀티 모듈 프로젝트

### 목차
1. [Gradle](#gradle) 
2. [프로젝트 개요](#프로젝트-개요)
3. [모듈 구조](#모듈-구조)
4. [빌드 구성](#빌드-구성)
5. [실행 방법](#실행-방법)
6. [render에 docker 이미지 배포](#render에-docker-이미지-배포)

---

## Gradle

멀티 모듈 구조와 공통 설정을 효율적으로 관리하기 위해 Gradle을 선택·학습

### ⚡ 자동화 플랫폼

- 빌드 자동화 도구, 컴파일·테스트·패키징·배포 등 모든 과정을 자동화.
- 다양한 언어 지원(java, kotlin) 복잡한 빌드 과정을 효율적으로 관리하는 빌드 시스템.
- Groovy, Kotlin 기반의 언어로 빌드 로직을 자유롭게 작성 가능함.
- 기능
    - 자동화: 컴파일, 테스트, 패키징등 흐름을 자동으로 처리함
    - 의존성 관리: 여러 라이브러리의 버전·호환성을 프로젝트 수준에서 관리
    - 빠른 빌드: 증분 빌드, 병렬처리, 캐싱, 데몬 프로세스
    - 확장성과 유연성: 플러그인·자체 스크립트로 빌드 과정을 확장/변경 가능

### 파일 구성

1. gradle.properties

   프로젝트 전역에 적용할 환경 변수, 버전 정보 정의. 설정 파일

2. settings.gradle(kts)

   프로젝트의 구조와 빌드 대상 모듈을 선언하는 entry-point 파일

3. ⭐ build.gradle(kts)

   각 모듈의 빌드 플러그인, 의존성, 작업을 정의하는 빌드 스크립트 파일

4. init.gradle

   빌드 프로세스의 초기화 설정 스크립트, 사용자 정보 및 환경 초기화 등에 사용

---
## 프로젝트 개요

Kotlin 기반 Gradle 멀티 모듈 프로젝트

Spring Boot를 이용해 웹 애플리케이션을 개발하고, 모듈 분리를 통해 유지보수성과 확장성을 고려

도메인 모델(Entity)은 Java로 작성해 불변성/접근 제어를 명확히 유지하고, 애플리케이션 비즈니스 로직은 Kotlin으로 개발하여 생산성을 높이기

데모 앱을 Render에 배포

---

## 모듈 구조

```aiignore
root               # 프로젝트 전체 빌드 관리
├── core           # Spring Boot entry point
└── core-domain    # Entity, Domain 로직 모듈
```
---

## 빌드 구성

- 최상위 **build.gradle.kts**

    공통 플러그인 정의 (org.springframework.boot, kotlin("jvm") 등)

    subprojects {} 블록에서 하위 모듈 공통 설정 적용

- **buildSrc**

    공통 convention plugin 정의 (Kotlin/JVM, Java 설정 재사용)

   (단, 단순 프로젝트라면 생략해도 무방)

- **Version Catalog** (libs.versions.toml)

    Kotlin, kotlinx, Coroutine 등 의존성 버전을 중앙에서 관리

---

## 실행 방법

```aiignore
./gradlew :core:bootRun
```

---

## render에 docker 이미지 배포

1. dockerfile 작성
2. render에서 webservice, language: Docker 선택

