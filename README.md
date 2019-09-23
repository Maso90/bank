# bank

***테이블 정의서***

1. DEVICES

|COLUMN     |TYPE        |NN|KEY|DESCRIPTION         |
|-----------|------------|--|---|--------------------|
|device_id  |varchar(25) |NN|PK |디바이스 식별 아이디|
|device_name|varchar(255)|NN|   |디바이스 이름       |

2. USAGE
|COLUMN|TYPE|NN|KEY|DESCRIPTION|
|------|----|--|---|-----------|
|device_id|varchar(25)|NN|PK|디바이스 식별 아이디|
|year|varchar(255)|NN|PK|기간|
|rate|double(4)| | |디바이스 이용률|


***API 기능명세***

**1. 데이터 파일(서울시 인터넷뱅킹 이용률 및 이용기기 통계 데이터)에서 각 레코드를 데이터베이스에 저장하는 코드를 구현하세요.**

hms\src\main\java\com\hms\HmsApplication.java

**2. 인터넷뱅킹 서비스 접속 기기 목록을 출력하는 API 를 개발하세요.**

[Get] http://localhost/devices/list

Result
[{"device_id":"DEVICE1","device_name":"스마트폰"},{"device_id":"DEVICE2","device_name":"데스크탑 컴퓨터"},{"device_id":"DEVICE3","device_name":"노트북 컴퓨터"},{"device_id":"DEVICE4","device_name":"기타"},{"device_id":"DEVICE5","device_name":"스마트패드"}]

**3. 각 년도별로 인터넷뱅킹을 가장 많이 이용하는 접속기기를 출력하는 API 를 개발하세요.**

[Get] http://localhost/usage/year/list

Result
[{"device_name":"데스크탑 컴퓨터","device_id":"DEVICE2","year":2011,"rate":95.1},{"device_name":"데스크탑 컴퓨터","device_id":"DEVICE2","year":2012,"rate":93.9},{"device_name":"데스크탑 컴퓨터","device_id":"DEVICE2","year":2013,"rate":67.1},{"device_name":"스마트폰","device_id":"DEVICE1","year":2014,"rate":64.2},{"device_name":"스마트폰","device_id":"DEVICE1","year":2015,"rate":73.2},{"device_name":"스마트폰","device_id":"DEVICE1","year":2016,"rate":85.1},{"device_name":"스마트폰","device_id":"DEVICE1","year":2017,"rate":90.6},{"device_name":"스마트폰","device_id":"DEVICE1","year":2018,"rate":90.5}]

**4. 특정 년도를 입력받아 그 해에 인터넷뱅킹에 가장 많이 접속하는 기기 이름을 출력하세요.**

[Get] http://localhost/usage/year/{year}

Result - year=2018
{"device_name":"스마트폰","device_id":"DEVICE1","year":2018,"rate":90.5}

**5. 디바이스 아이디를 입력받아 인터넷뱅킹에 접속 비율이 가장 많은 해를 출력하세요.**

[Get] http://localhost/usage/device/{device_id}

Result - device_id = DEVICE1
{"device_name":"스마트폰","device_id":"DEVICE1","year":2017,"rate":90.6}
