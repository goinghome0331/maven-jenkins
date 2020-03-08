# MAVEN JENKINS

## �Ұ�
JENKINS�� �ڵ����� ���� �� ������ �� �̿��ϴ� �����

## Maven project ����
+ Springboot�� �ۼ��� ������ �� ���ø����̼�
+ ������ MVC �׽�Ʈ�� �ִ�.

## github ����
```
+ deploy key ����ϱ�
 1. ssh-keygen�� ���� ����Ű ����Ű ����
 2. settings -> deploy keys -> adddeploy key���� ����Ű�� ������ �ٿ��ֱ��Ѵ�.
 3. jenkins�� configure���� github credential ��Ͻ� ssh�� ����� �����Ѵ�.
 4. �� �� ����Ű�� ���⿡ ����Ѵ�.
+ webhook ����ϱ�
 1. settings -> webhooks -> Add Webhook���� payload URL�� http://(jenkins�����ϴ� ���� �ּ�)/github-webhook/ �Է�
 2. Which events would you like to trigger this webhook?���� Just the push event. ����
 3. Active üũ �� ���
```
## Jenkins ����
```
+ new Item ���� -> �̸� �Է� -> Maven project ���� �� OK
+ General
 1. Discard old builds�� Github project ����
 2. Discard old builds���� ������ ���� ���� �Է�
 3. Github project���� Project url�� Display name �Է�
+ Source Code Management
 1. Git ����
 2. Repository URL���� git ����� �ּ��Է� ex) https://github.com/goinghome0331/maven-jenkins.git
 3. Crendential ssh��� �����ϴ� ���� �����Ѵ�.
 4. Branch Specifier�� Ư���� �� ������ master�� �Ѵ�.
+ Build Triggers
 1. github�� push �ɶ����� jenkins�� �����ϱ� ���� GitHub hook trigger for GITScm polling�� ����
+ Build Environment
 1. Ư�� ������ �����ϱ� ���� Send files or execute commands over SSH before the build starts�� ����
 2. SSH ������ ��θ� ����ؾ��Ѵ�.(����� ���� ����)
+ Build
 1. Root POM -> pom.xml
 2. Goals and options �� clean package
```

## ���� ����
```
+ ������� root ��ο� pom.xml�� �־�� Jenkins�� ������ �� �ִ�. �ƴϸ� ������ �߻��Ѵ�. -> �ٸ� ����� ��ã��
+ Webhook ����� �� payload URL�� http �ּҷ� ����ؾ��Ѵ�.(https�� ���� �߻�)
+ MAVEN Project�� ������ Manage Jenkins -> Manage Plugin -> Available Tab -> Unleash Maven Plugin�� �ٿ�޴´�.
```