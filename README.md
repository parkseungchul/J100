# Spring Boot 기초
 - [강의 목록 링크](https://www.youtube.com/playlist?list=PLogzC_RPf25E-mfrKvl6jWHU8r1jxCZgq)

### J101. Spring Boot 개발 환경 만들기
 - [강의 링크](https://www.youtube.com/watch?v=xEBrbDvYX-c&list=PLogzC_RPf25E-mfrKvl6jWHU8r1jxCZgq&index=1) 
 - 소스 없음
 - 내용
   - JAVA8 설치  
   - MAVEN 설치
   - STS 설치
   - STS MAVEN 설정  
# <hr>

### J102. Spring Boot 빌드하고 WEB 띄우기
 - [강의 링크](https://www.youtube.com/watch?v=NZ--iB740JM&list=PLogzC_RPf25E-mfrKvl6jWHU8r1jxCZgq&index=2)
 - [소스 링크](https://github.com/parkseungchul/J100/tree/master/j102)
 - Spring Boot 프로젝트 만들기
 - 내용
   - 컨트롤러 만들기
   - Html 만들기
   - 포트 변경하기
   - STS 에서 웹 기동 -> intelJ 로 변경
   - 빌드 이후 명령어로 웹 서버 기동
# <hr>

### J103. Docker 로 MYSQL, ORACLE 테스트 DB 구성
 - [강의 링크](https://www.youtube.com/watch?v=ndamp6u3dCA&list=PLogzC_RPf25E-mfrKvl6jWHU8r1jxCZgq&index=3)
 - [소스 링크](https://github.com/parkseungchul/J100/tree/master/j103)
 - 내용
   - Docker MYSQL Container 설치와 사용자 만들기 
   - STS DBeaver Plug-in 설치와 MYSQL 접속해서 확인하기
   - Docker ORACLE Container 설치와 사용자 만들기  
   - ORACLE 접속해서 확인하기
<code>
 - WINDOW    
 docker run -d --name mysqlDB ^
     -e MYSQL_DATABASE=j100^
     -e MYSQL_USER=user01 ^
     -e MYSQL_PASSWORD=user01 ^
     -e MYSQL_ROOT_PASSWORD=password ^
     -p 3306:3306 ^
     -v D:\docker\mysql:/var/lib/mysql ^
     mysql

D:\Github\parkseungchul>docker exec -it mysqlDB bash
bash-4.4# mysql -u root -p
Enter password:
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 10
Server version: 8.0.33 MySQL Community Server - GPL

Copyright (c) 2000, 2023, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mType 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> create schema j103;
Query OK, 1 row affected (0.01 sec)

mysql> grant all privileges on j103.* to 'user01'@'%';
Query OK, 0 rows affected (0.00 sec)
</code>
# <hr>

### J104_1. Spring Boot JPA 기본 CRUD
 - [강의 링크](https://www.youtube.com/watch?v=Mps7InyQKaQ&list=PLogzC_RPf25E-mfrKvl6jWHU8r1jxCZgq&index=4)
 - [소스 링크](https://github.com/parkseungchul/J100/tree/master/j104)
 - 내용
   - Spring Boot 프로젝트 만들기 
   - DB 연결 정보 만들기
   - JPA DB 만들기
   - JUnit DB CRUD
# <hr>

### J104_2. Spring Boot JPA DEPT-EMP
 - [강의 링크](https://www.youtube.com/watch?v=FwrhqK7P4Gc&list=PLogzC_RPf25E-mfrKvl6jWHU8r1jxCZgq&index=5)
 - [소스 링크](https://github.com/parkseungchul/J100/tree/master/j104)
 - 내용
   - EMP 만들기
   - DEPT 수정하기 
   - 테이블 구조 확인
   - JUnit DEPT, EMP CRUD 
# <hr>

### J104_3. Spring Boot JPA 검색과 페이징 처리
 - [강의 링크](https://www.youtube.com/watch?v=ePCeuiIJbBI&list=PLogzC_RPf25E-mfrKvl6jWHU8r1jxCZgq&index=6)
 - [소스 링크](https://github.com/parkseungchul/J100/tree/master/j104)
 - 내용
   - Repository Method 만들기
   - 부서명 검색
   - 부서명 오름차순 검색
   - 부서명 검색 결과 개수
   - 부서명 검색 페이징을 위한 데이터 입력
   - 부서명 검색 페이징 처리
# <hr>

### J105. Spring Boot UI Thymeleaf Layout
 - [강의 링크](https://www.youtube.com/watch?v=sGHFYBQ5sc4&list=PLogzC_RPf25E-mfrKvl6jWHU8r1jxCZgq&index=7)
 - [소스 링크](https://github.com/parkseungchul/J100/tree/master/j105)
 - 내용
   - 단일 화면
   - 단일 데이터 / 복수 데이터 표현
   - Layout 적용하기
# <hr>

### J106_1. Spring Boot Security
 - [강의 링크](https://www.youtube.com/watch?v=ry2pRoAnrIc&list=PLogzC_RPf25E-mfrKvl6jWHU8r1jxCZgq&index=8)
 - [소스 링크](https://github.com/parkseungchul/J100/tree/master/j106)
 - 내용
   - Spring Boot Project 만들기
   - Security 기본 
   - Security Customizing
   - Security Customizing Test
   - 사용자 정보 화면에 나오게 하기
   - 권한별로 화면 보여주기
   - 세션에서 사용자 정보 보기
# <hr>

### J106_2. Spring Boot Security + REDIS
 - [강의 링크](https://www.youtube.com/watch?v=QgzyQRNGPjI&list=PLogzC_RPf25E-mfrKvl6jWHU8r1jxCZgq&index=9)
 - [소스 링크](https://github.com/parkseungchul/J100/tree/master/j106)
 - 내용
   - Spring Boot Project 빌드
   - 포트 8080 기동 후 로그인
   - 포트 8081 기동 후 로그인 세션 공유 안 됨 확인 
   - REDIS Docker 설치  
   - Spring Boot REDIS 설정
   - Spring Boot Project 빌드
   - 포트 8080 기동 후 로그인
   - 포트 8081 기동 후 로그인 세션 공유 확인
# <hr>

### J106_3. Spring Boot Security + Security + JWT
 - [강의 링크](https://www.youtube.com/watch?v=8qrcM3Pm-Lk&list=PLogzC_RPf25E-mfrKvl6jWHU8r1jxCZgq&index=10)
 - [소스 링크](https://github.com/parkseungchul/J100/tree/master/j106)
 - 내용
   - pom.xml 라이브러리 추가
   - Token 사용 상수 정의
   - JwtService 정의
   - UserDetailServiceImple 수정
   - JwtHandlerInterceptor 구현
   - SecurityConfig 수정
   - 리턴 값에 사용하는 ResultDTO 생성
   - ApiController 정의
# <hr>

### [J107. Spring Boot SSL 인증서 무료로 적용하기]
 - [강의 링크](https://www.youtube.com/watch?v=v0ArVjGwqAU&list=PLogzC_RPf25E-mfrKvl6jWHU8r1jxCZgq&index=11)
 - [소스 링크](https://github.com/parkseungchul/J100/tree/master/j107) 
 - 내용
   - Spring Boot Project 생성
   - https://www.sslforfree.com/ 도메인으로 인증서 요청
   - 도메인 인증을 위한 인증파일 다운로드
   - 서버에 인증파일 업로드 후 웹에서 인증하고 인증서 다운로드 
   - OpenSSL 설치
   - OpenSSL 이용하여 인증서 변환  
   - application.yml 인증서 등록 
   - 서버에서 빌드 이후 접속 후에 https 확인
<pre><code>openssl pkcs12 -export -in certificate.crt -inkey private.key -out springcloud.pfx

openssl pkcs12 -in springcloud.pfx -clcerts -nokeys -out springcloud.crt

keytool -import -alias springcloud -file springcloud.crt -keystore trust.jks</code></pre>
# <hr>

### J108. JPA 다중 데이터 베이스
 - [강의 링크](https://www.youtube.com/watch?v=G9_MFg6Cclw&list=PLogzC_RPf25E-mfrKvl6jWHU8r1jxCZgq&index=12)
 - [소스 링크](https://github.com/parkseungchul/J100/tree/master/j108)
# <hr>