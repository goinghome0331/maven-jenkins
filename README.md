# MAVEN JENKINS

## 소개
JENKINS가 자동으로 빌드 및 배포할 때 이용하는 저장소

## Maven project 내용
+ Springboot로 작성된 간단한 웹 애플리케이션
+ 간단한 MVC 테스트도 있다.

## github 설정
```
+ deploy key 등록하기
 1. ssh-keygen을 통해 공개키 개인키 생성
 2. settings -> deploy keys -> adddeploy key에서 공개키를 복사후 붙여넣기한다.
 3. jenkins의 configure에서 github credential 등록시 ssh를 방법을 선택한다.
 4. 이 때 개인키를 여기에 등록한다.
+ webhook 등록하기
 1. settings -> webhooks -> Add Webhook에서 payload URL에 http://(jenkins실행하는 서버 주소)/github-webhook/ 입력
 2. Which events would you like to trigger this webhook?에서 Just the push event. 선택
 3. Active 체크 후 등록
```
## Jenkins 설정
```
+ new Item 선택 -> 이름 입력 -> Maven project 선택 후 OK
+ General
 1. Discard old builds와 Github project 선택
 2. Discard old builds에서 임의의 제한 값을 입력
 3. Github project에서 Project url과 Display name 입력
+ Source Code Management
 1. Git 선택
 2. Repository URL에서 git 저장소 주소입력 ex) https://github.com/goinghome0331/maven-jenkins.git
 3. Crendential ssh방식 인증하는 것을 선택한다.
 4. Branch Specifier은 특별한 게 없으면 master로 한다.
+ Build Triggers
 1. github에 push 될때마다 jenkins가 빌드하기 위해 GitHub hook trigger for GITScm polling를 선택
+ Build Environment
 1. 특정 서버에 배포하기 위해 Send files or execute commands over SSH before the build starts를 선택
 2. SSH 서버와 경로를 등록해야한다.(참고로 아직 못함)
+ Build
 1. Root POM -> pom.xml
 2. Goals and options 에 clean package
```

## 주의 사항
```
+ 저장소의 root 경로에 pom.xml이 있어야 Jenkins가 빌드할 수 있다. 아니면 오류가 발생한다. -> 다른 방법은 못찾음
+ Webhook 등록할 때 payload URL에 http 주소로 등록해야한다.(https는 오류 발생)
+ MAVEN Project가 없으면 Manage Jenkins -> Manage Plugin -> Available Tab -> Unleash Maven Plugin을 다운받는다.
```