# 일정 관리 서비스 API

## 프로젝트 개요 
본 프로젝트는 Spring Boot와 Spring Data JPA를 사용하여 일정 관리 어플리케이션을 구현하는 실습 프로젝트입니다.   
3 Layer Architecture(Controller, Service, Repository)를 기반으로 설계되었으며, 일정에 대한 필수 CRUD 기능을 제공합니다.

## 학습 목표
본 프로젝트를 통해 다음과 같은 핵심 목표를 달성하는 것을 목표로 합니다.    

**1. 3 Layer 아키텍처 이해 및 적용**    
- Controller, Service, Repository 계층의 역할과 책임 범위를 명확히 분리하고, 각 계층의 목적에 맞는 로직을 설계 및 구현합니다.   

**2. Spring Data JPA를 활용한 영속성 관리**    
- JPA를 활용하여 일정 및 댓글 엔티티를 정의하고, 필수 CRUD 기능을 데이터베이스에 연결하여 구현합니다.   
- JPA Auditing을 활용한 createdAt 및 modifiedAt 자동 관리를 사용해봅니다.

**3. 비즈니스 로직 및 인증 구현**   
- 일정 생성, 수정, 삭제 시 필요한 핵심 규칙과 검증 로직을 구현합니다.   
- 일정/댓글 수정 및 삭제 시 비밀번호 일치 여부를 검증하는 인증 로직을 구현합니다.    

## 개발 환경
- 언어 Java 17
- 프레임워크 Spring Boot
- 데이터베이스 MySQL
- ORM Spring Data JPA

## 프로젝트 구조 
```
📦schedule
 ├── 📂controller
 │    ├── ScheduleController.java        // 일정 CRUD 요청 처리
 │    └── CommentController.java         // 댓글 생성 요청 처리
 │
 ├── 📂entity
 │    ├── Schedule.java                  // 일정 엔티티
 │    └── Comment.java                   // 댓글 엔티티
 │
 ├── 📂dto
 │    ├── CreateCommentRequest.java        // 일정 생성 요청 DTO
 │    ├── CreateCommentResponse.java       // 댓글 생성 응답 DTO
 │    ├── CreateScheduleRequest.java       // 일정 생성 요청 DTO
 │    └── CreateScheduleResponse.java      // 일정 생성 응답 DTO
 │
 ├── 📂repository
 │    ├── ScheduleRepository.java        // 일정 DB 접근
 │    └── CommentRepository.java         // 댓글 DB 접근
 │
 └── 📂service
      ├── ScheduleService.java           // 일정 비즈니스 로직
      └── CommentService.java            // 댓글 비즈니스 로직
```

## API 명세서 작성하기    
[API 명세서](https://documenter.getpostman.com/view/27301593/2sB3QNpU4u#4bab3e1b-8803-40f3-a0ed-ff16106bb095)

## ERD 작성하기   
<img width="184" height="394" alt="image" src="https://github.com/user-attachments/assets/f379e75f-3d73-465d-abb2-709902a2d42d" />

## 실행 결과 
| createSchedule | getScheduleById |
|---|---|
| <img width="500" height="300" alt="image" src="https://github.com/user-attachments/assets/de0536db-90e9-4707-a0e3-00b90f3469c0" /> | <img width="500" height="300" alt="image" src="https://github.com/user-attachments/assets/40a27e80-eac4-4b6c-96fa-06125cfdeb1d" />|

|getAllScheduleByAuthor |updateSchedule|
|---|---|
| <img width="500" height="300" alt="image" src="https://github.com/user-attachments/assets/bfa842d7-d467-49f0-b396-2f281cadbd25" /> | <img width="500" height="300" alt="image" src="https://github.com/user-attachments/assets/07df0d35-3701-4343-a19d-d3682b1df853" />

|deleteSchedule - 올바른 비밀번호 입력 시 |deleteSchedule - 저장된 비밀번호와 다른 값 입력 시|
|---|---|
| <img width="500" height="300" alt="image" src="https://github.com/user-attachments/assets/6f2a43eb-8551-400a-aeb0-fcd1470c27ab" /> | <img width="500" height="300" alt="image" src="https://github.com/user-attachments/assets/e0b5df72-501c-4a3d-bead-5684bb6623bc" /> |

|createComment | 
|---|
| <img width="500" height="300" alt="image" src="https://github.com/user-attachments/assets/091d21de-711c-4e51-91c6-2bee0ec2b380" /> | <> |

