# CustomerManager

## 주제

DB를 이용하지 않고 고객 관리 프로그램 만들기

## 개요

지난번 TodoList 프로그램을 만들면서, UI에 의존하지 않는 CRUD 프로그램을 만들어보고 싶었다. 하지만 DB는 이용하고 싶지 않았고, 순수히 자바에서 제공하는 Collection API로 만들어보고 싶었다. 그래서 선택한게 ArrayList를 이용하여 고객 관리 프로그램을 만들어보았다.

## 초기 기능정의

- 로그인
- 회원가입
- 전체회원출력
- ID 중복체크
- 비밀번호 체크

## 개발하면서 바꾼 기능정의

- 로그인
- 회원가입
- 개인정보 수정
- 회원탈퇴
- 전체회원 보기
- 종료

기능 정의를 바꾼 이유는 간단하다. 단순히 CRUD 프로그램을 만들어보자는 게 나의 1차적인 목표였고, 그 이후의 기능들은 그다음 목표였기에 개발하면서 수정하였다.

## 주요 객체

- User
- UserRepository

## 주요 객체의 역할

- User
  - ID, PW, 나이, 이름을 저장할 수 있다.
- UserRepository
  - DB의 역할을 수행하며, 유저들의 정보를 가지고 있다.
  - CRUD 기능을 제공한다.
  
## 개발하면서 잘한 부분

- 객체에서 값을 꺼내올 때 get 방식을 이용하지 않고 메시지를 보내는 방식으로 코드를 구현해봤다.
  - 이 부분은 [TDD 리펙토링 by 자바지기 박재성님](https://www.youtube.com/watch?v=bIeqAlmNRrA&t=1018s) 강의를 듣고 구현해봤다. 강의를 들으면서 저 부분은 꼭 구현해 봐야겠다 라고 생각하고 실행에 옮겼다.
- 중복되는 부분에 대해서 메소드를 따로 만들어 처리하였다.

## 개발하면서 잘못한 부분

- 일정관리를 하지 않았다.
- why? 라는 질문을 스스로에게 하지 않고 개발했다.
  
## 개발하면서 느꼈던 부분

여태껏 개발하면서 나 자신에 대한 태도를 반성하고 싶었다.
이번 프로젝트를 진행하면서 Array, ArrayList에 차이를 잘 알지 못했었다.

즉, Collection Framework에 대한 이해도가 부족했었다.

그전까진 '아 그냥 리스트 쓸까? 혹은 해시맵은 Key, Value로 저장이 되니깐 써야겠다.'라는 생각만 하고 살았다.
어느 날 불현듯 나 스스로에게 질문해봤다. Array랑 ArrayList 차이가 뭐야?라고 물었다.. 하지만 스스로에게도 답하지 못했었다.

배열의 단점을 보완하는 컬렉션 중 하나야!라고 답했으면 그래도 마음속에 죄책감은 아마 덜했을 것이다

그럼 또다시 나는 나에게 물어본다
- 배열의 단점이 뭔데? 
- 그리고 컬렉션은 뭐야? 
- 컬렉션 중 하나라고 하는데 또 다른 컬렉션도 있어?

여태껏 개발하면서 단순히 개발만 했지, 깊이 있는 학습을 하지 않았다는 뜻이다.
이번 프로젝트를 진행하면서 다시 한번 개발하는 태도에 대해서 되돌아볼 수 있었다.