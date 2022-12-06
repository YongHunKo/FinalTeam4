# Eat & Out
<img src="./finalteam4/src/main/resources/static/assets/images/eLogo.png" width="400" height="">

- 팀명 : *Eat & Out*
  - 팀장 : 고용훈
  - 팀원 : 김준기, 조여송, 박시연

## 프로젝트 정보
(기획서 참고하자)
1. 프로젝트 주제
    - AI 플랫폼을 활용한 예약주문 서비스 웹 어플리케이션 개발
2. 프로젝트 목적(얘는 수정이 살짝 필요함)
    - 제주도 모범음식점현황 데이터를 이용한 제주도내 식당/다이닝/카페의 메뉴들을 예약주문할 수 있는 웹 어플리케이션 구현
      - 협업을 통해 반응형 웹사이트를 구현
      - 맛집예약 웹사이트에 맞는 화면 디자인 및 DB설계
      - 프레임워크를 이용한 동적인 화면 구현
      - DBMS를 이용하여 DB를 구축하고 Spring Container와 연결
      - Java 개발도구와 IDE 사용
      - ERD Cloud와 Notion, Github을 사용한 협업 경험
      - 식당 예약을 하는데 불편함을 개선하고 신뢰성있는 리뷰서비스 제공
3. 프로젝트 기능 구현
   1. 로그인/로그아웃/회원가입
      1. 일반로그인
      2. 카카오로그인
      3. 네이버로그인
      4. 구글로그인
      5. 회원가입
   2. 지도api를 이용한 식당위치 서비스
      1. 카카오 맵 api
   3. 검색기능
      1. 카테고리별 검색
      2. 가격 높은/낮은 순서 정렬
      3. 키워드 검색
   4. 주문 빈도에 따른 맛집랭킹 서비스
      1. Orderlist누적 DB를 이용한 실시간랭킹 서비스
      2. Review누적 DB를 이용한 오늘의 추천맛집 서비스
   5. NCP를 이용한 웹 어플리케이션 환경 구축
      1. NCP서버
      2. 챗봇을 이용한 1대1문의
      3. 웹소켓을 이용한 예약-결제 시 고객/매장 알림 서비스
      4. OCR을 이용한 영수증 리뷰
   6. 관리자 페이지 구현
4. 역할 분담(아주 상세하게)
   - 고용훈
     - 검색, 식당, 예약-주문, QA테스트, 서버관리
   - 김준기
     - 로그인/소셜로그인, 메인페이지, 전체적인 CSS
   - 조여송
     - 마이페이지, 쿠폰
   - 박시연
     - 관리자, 위시리스트, DB관리
5. 개발환경 및 수행 도구(표로 만들어볼까)
6. DB 설계(ERD와 sql을 첨부)
   ![](./finalteam4/src/main/resources/static/img/ERD.png)
7. UI 설계(Figma사용)

## 프로젝트 결과(스샷 및 동영상 넣기)
## 트러블슈팅(마지막날까지 추가하기)
- 고용훈
  - `CRUD 테스트` 중 `insert`가 안먹히는 현상 → `DTO순서`와 `DML 컬럼의 순서`가 맞지 않아서 발생한 현상→ `DTO의 순서`를 바꿔주면서 해결
  - `MyBatisSystemException` →마이바티스에서 파라메터 속성값을 잘못 설정함 → 속성에 맞게끔 수정→마이바티스 작성시 똑바로 보자
  - `search_btn`이 안먹히는 현상발생 →버튼 이벤트에 `alert`을 해줬는데도 `alert`이 안뜨는 상황→버튼에 걸려있는 `css`가 문제다 → `css`문제가 아니었고 `JQueryScript` 순서 문제여서 제일 위로 올려주며 해결
  - `search.html`에서 사진이 등록되지 않은 데이터가 나오지 않는 현상 → `INNER JOIN`을 `LEFT OUTER JOIN`으로 바꿔서 왼쪽테이블데이터를 기반으로 다 나오도록 하여 해결
  - `git pull` 하는 과정에서 `dirty_index`가 발생함→ `git stash`를 사용하여 전 단계로 돌아가고 `pull`을 하여 받고 다시 `stash`에서 `stash change`를 사용하여 `merge`를 하여 해결
  - `detail.html`에서  `reserve_btn`으로 `custid`를 넘기려고 함→`[[${session.logincust.custid}]]` 이 비로그인일때 디테일에 못들어가게됨. 해당로그인 세션이 없기 때문. → 순서를 바꿔도 소용이 없음, 주석으로 막아도 안됨 → `2중 thymeleaf` 를 줘서 `session.logincust ≠null` 일때만 `custid`값을 부여하도록 함
  - `소셜로그인 컨트롤러`를 건드리는 중 데이터 중복이 뜸 → 해당 `cust`데이터가 있는지 확인을 한 후 없으면 `register`로 데이터 등록, 있으면 `get`으로 로그인을 하도록 변경
  - `reserve.html`에서 `cnt`버튼으로 수량을 변경하고 수정을 누르면 `sql`상에서도 수량이 바뀌고 하단에 총 합계량도 변화함. 그러나 오른쪽에 `totalprice`가 안먹히는 현상이 발생함 → 즉각적으로 `totalprice`를 계산하도록 코드를 입력했고, `finaltotalprice`부분을 삭제하고 `totalprice`로 대체
  - `reserve.html`에서 데이터가 `일부` 출력되지 않는 현상이 발생함.  `sql`엔 온전히 데이터가 다 들어가있음. 새로고침을 하면 원하는 데이터가 다 출력됨 → `ajax`와 `locationhref`를 동시에 사용하여 발생한 문제 → `ajax`가 `regist`하는 중간에 페이지 이동이 되버리면서 이동 전까지 `regist`한 것만 페이지에 출력됐고 새로고침을 하면 정상적으로 다 출력 → `setTimeout`을 `0.5초`를 주어 임시로 둘이 동시에 작업되지 않도록 하였다
  - `input`으로 `date와 time`을 주어 `날짜와 시간` 을 선택하여 해당 데이터를 `orderlist`에 넣으려 하는데 데이터를 읽지 못함 → `datepicker` 값을 두개를 주어서 `SimpleDateFormat`을 이용하여 하나는 날짜, 하나는 시간 값으로 받게끔 만들어서 각각을 `orderlist`에 `insert`. 아래 사진처럼 잘 들어와있다
      
      ![](./finalteam4/src/main/resources/static/img/2022-12-06-10-26-09.png)
      
  - `결제API`를 진행하는 도중 `NullPointerException` 이 떴는데 `String.length()` 의 `text`가 `null`이라고 뜨면서 진행이 안돼는 상황 → `ajax의 url`이 잘못된 것
  - `select list is not in group by clause and contains nonaggregated column 'eatnout.s.storeid' which is not functionally dependent on columns in group by clause; this is incompatible with sql_mode=only_full_group_by` 
  해당 오류는 `group by`를 사용할 때 호환이 안돼는 오류. 
  →해당 `xml`의 문구를 수정하여 해결.
  - `wishlist`가 로그인 할때만 출력되던 현상
  → `/` 에 로그인 했을 시 id값이 들어가도록 수정하여 해결
  - `cartDB`에 쓰레기값들이 계속 누적되는 현상
  → `cart`에 `register`되기 전 `delete`를 하여 해당 `custid의 cart`를 초기화하여 해결
  - `모바일(모바일+태블릿)`에서 실행 시 결제 페이지가 제대로 작동하지 않는 현상 → 해당 현상은 `pc와 모바일`의 `결제 모듈 작동 방식`에 의한 차이로, `pc`는 모듈을 직접띄워주며 실행되는 반면 `모바일`은 `redirect`로 새창으로 이동해버려서 작동하지 않는 현상이 발생했다. `m_redirect_url`을 주어서 모바일 결제가 진행된 후 `m_redirect_url`의 `redirect페이지`로 이동하게하여 해결
  - `No 'Access-Control-Allow-Origin' header is present on the requested resource.` 에러는 `config` 에서 세팅한 `ip` 값과 `New socketJS` 에서 설정한 `ip`값이 달라서 발생한 에러→해당 ip값을 맞춰주면 `connected`
  - adminpage에 chart가 뜨지 않는 현상 → 1. 데이터를 필요한 것만 남긴다 2. 라이브러리 순서 확인
  - java.lang.IllegalArgumentException: Illegal pattern character 'I’ , java.text.ParseException: Unparseable date: "undefined”. `d.m.y h:i:s`를 `yyyy.MM.dd HH:mm` 로 바꾸는 과정에서 생긴 parsing오류 -> 먼저 php인 `d.m.y h:i` 는 `yyyy.MM.dd HH:mm` 와 숫자가 다르기 때문에 1차적으로 html에서 `d.m.y h:i → YYYY.M.D H:mm` 로 변환시켜준다. 그리고 컨트롤러로 넘기면서 `YYYY.M.D H:mm → yyyy.MM.dd HH:mm`로 `DateFormat`을 잡고 변환시켜준다. 이때 주의해야할 점은 컨트롤러 부분에서 받아들이는 `DateFormate`이 `yyyy.MM.dd HH:mm`형식 이어야한다

- 김준기
  - `Login` 기능 구현시 `input 값`을 못받아오는 현상 → `input 태그` 내의 `name 값`을 `DTO의 변수명`과 일치하게 셋팅하니을 넘겨줘서 해결.
  - `반응형 웹 템플릿` 의 주 `src` 들이 적용되지 않던 현상 → `index.html`의 `body`부분이 아닌 `head` 부분으로 옮겨주고, /설정해줌으로 해결 → 상단 `search bar` 창 호환 문제 해결완료
  - `navbar-search -style5` class로 묶여있는  `div`들  `justify-content:between` 제거 → 이유 브라우저 창이 줄어듬과 동시에 반응형 동작이 일어나는데, 블록을 잡아먹어 `search-bar` 충돌로 뭉그러짐현상이 동작되서 제거후 해결
  - `search-bar` 위치조정, 브라우저 크기 줄어들시 꺠지는현상 발생 → 위와 마찬가지로 `justyfy-content` 제거후, `position:relative` 값과 `margin-left` 값을 주어 센터에 고정후 충돌현상 해결
  - `LoginPage` 클릭시 Search-bar 부분 css 적용이 안됨 (SELECT 부분) → `플러그인` 끼리의 충돌로 인한 현상, 기존 부트스트랩 플러그인들 정리해주니 충돌현상 제거완료
  - `소셜로그인 API`  → 카카오,네이버, 구글등 API를 사용할때, 명세서를 꼼꼼히 읽자 → 네이버 로그인시 요청코드의 한 단어를 빼먹고 URL 요청 시도 → 값을 제대로 return 하지 못하여 고생했음.  → 명세서 요청 URL대로 로그인 버튼 설정후 정상기능 작동
  - `Google Login` → 구글로그인 설정시 , scope 값을 가져오는 `Google API` 서버 주소를 기본 설정값으로 설정하였더니, 정보를 가져오는 팀원과 못가져오는 팀원으로 나뉨 → 서버주소를 가져오고싶은 스코프값으로 바꿔주니 해결 → scope=email,profile
  - `NCP` 연동시 mainpage에 Logo 값을 렌더링 못하는 현상 → 서버올릴시 파일명을 체크하자 경로상 Logo7.svg로 저장되어있었으나 img 태그를 logo7.svg로설정하여 못불러옴.
  - `NCP` 연동시 카카오로그인 실행시 값을 DB에 저장못해줌 → 공인IP로 바뀌며 서버주소가 바뀌기 때문에 KakaoService 에서 redirect url도 신경써줘야함. 도메인주소 재설정후 해결

- 조여송
  - 회원정보 관련 기능들에 필요한 회원 데이터를 `session`과 `model`에 저장함에 있어 어떻게 나눌 것인가 → `session` 만으로 회원 관련 모든 기능에 쓸 수 있지만 서버에 무리를 줄 수 있으므로 `model` 객체를 사용할 것
  - 회원정보 수정 후 다시 마이페이지로 리다이렉트 되지 않음 → `attr()` 메서드 `action` 속성에 상위 맵핑 경로 작성으로 해결
  - 타임리프 파싱에러(Could not parse as each:)로 리스트를 반복으로 가져올 수 없는 현상 → `th:each = ”ex : ${example}”` 처럼 참조변수와 스페이스 구분을 확실히 줘서 해결
  - `background: url()` 이미지를 경로에서 가지오지 못함 → 모든 경로 시작부분에 파싱 `“/”` 추가해줘서 해결
  - `th:href`로 Controller 호출 시 세션 값을 원하는 메서드의 매개변수로 주지 못할 경우 → `session.getAttribute();`로 Object에 대입 후 DTO로 형변환하여 getString()로 저장
  - `<button>` 클릭시 input안의 값을 원치 않아도 가져오게 됨 → script 문법은 틀리지 않았고, `<form>` 안에 `<button>`이 작성되어있었음, 앞으로도 유심히 볼 것
  - `GROUP BY` 를 사용할 경우, 비집계 컬럼은 select 할 수 없음 → 공부 할 것
  - 제이쿼리 `<input type=”password”>` 에 값이 없는데도 null로 확인을 못함 → 전 메서드 `$.attr("disabled", **true**);` 에서 막아놓았었음 / if문 작성시 return 꼭 작성할 것
  - // 변수에 타임리프 `[[${…}]]` 로 담을때 `<script>` 에 `th:inline="javascript"` 추가해주기 → 알아서 문자열에 따옴표를 추가해주고 알아서 객체화를 해준다.
  - 
  - `[application.properties](http://application.properties)` directory 경로 뒤에 `/` 로 끝내기

- 박시연
  - `어노테이션` 문제로 `JUnit` 에러 발생 → 전부 삭제 후 다시 코딩으로 해결 (`Lombok`에러 아니었음)
  - maincenter html에 wishlist를 뿌리는 작업 중 `session`에서 id를 읽어오지 못하는 문제 발생 →
  - 위시리스트 삭제 과정에서 링크에 mypage가 중복되던 문제 → 매핑 문제. controller와 html 수정으로 해결
  - admin 메인 페이지에 chart 뿌리는 과정 중 $ajax가 정의되지 않는 문제 발생 →
