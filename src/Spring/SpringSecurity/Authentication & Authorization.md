## Authentication (인증)

ex) 로그인과 같은 절차를 통해 누구인지 증명하는 것   
사용자의 인증 정보를 저장하는 저장소? 토큰? 개념    
인증 시 id와 pw를 담고 인증 검증을 위해 전달되어 사용된다.   
인증 후 최종 인증 결과 (User 객체, 권한 정보)를 담고 SecurityContext에 저장되어 전역적으로 참조가 가능하다.
- Authentication authentication = SecurityContextHolder.getContext().getAuthentication()
##### 인터페이스 구조
- principal: 사용자 아이디 혹은 User 객체를 저장
- credentials : 사용자 비밀번호
- authorities : 인증된 사용자의 권한 목록
- details : 인증 부가 정보
- Authenticated: 인증 여부 

#### 인증 flow 


+) ThreadLocal > SecurityContextHolder > SecurityContext > Authentication > User객체
- Authentication 객체가 저장되는 보관소로 필요 시 언제든지  Authentication 객체를 꺼내어 쓸 수 있도록 제공되는 클래스
- ThreadLocal(스레드에 할당된 고유 저장 장소)에 저장되어 아무 곳에서나 참조가 가능하도록 설계함
- 인증이 완료되면 HttpSession에 저장되어 어플리케이션 전반에 걸쳐 전반적인 참조가 가능 


## Authorization (인가 = 권한 부여)
- JWT
- OAuth

### 절차
1. `Authentication`을 통해 `access token` 생성
2. 