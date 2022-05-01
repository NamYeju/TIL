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

## Authorization (인가 = 권한 부여)
- JWT
- OAuth

### 절차
1. `Authentication`을 통해 `access token` 생성

* security는 filter기반으로 인증, 인가 과정이 처리된다. 근데 filter는 spring container 기반이 아니기 때문에 
* 스프링에 injection이 안되는데 Spring에서 filter를 어떻게 사용할 수 있을까?
* `DelegationFilterProxy`를 통해서 servlet container에 존재하는 filter지만 spring filter bean에게 위임한다.
* = SpringSecurityFilterChain (FilterChainProxy)

#### spring security flow 
<img src="https://user-images.githubusercontent.com/39649034/166148206-792e79a8-ee7e-4d1c-9ec0-1f912de8cff2.png"/>

1. 사용자가 로그인 정보와 함께 인증 요청 (`HttpRequest`)
2. AuthenticationFilter가 요청을 가로채고 UsernamePasswordAuthenticationToken을 통해 Authentication 객체 생성
   (ex. principal: userIdentity credentials: pw Authorities: - , Authenticated: False)
3. AuthenticaitonManager(인터페이스)의 구현체인 ProviderManager를 통해 토큰 전달
& 인증 객체를 가지고 인증처리 (성공시 같은 구조의 Authentication 객체 생성 )
4. AuthenticationProvider에 토큰 전달 
5. 실제 DB로부터 사용자 인증 정보를 가져오는 UserDetailService에 사용자 정보를 넘겨줌 
6. 넘겨받은 정보를 통해 DB에서 찾은 사용자 정보인 UserDetails 객체를 생성 
7. AuthenticationProvider는 Userdetails객체와 사용자가 입력한 로그인 정보 비교 
8. 인증이 완료되면 권한과 사용자 정보를 담은 Autentication 객체가 반환한다.
   (ex. principal: userIdentity credentials: pw Authorities: USER , Authenticated: true)
9. Filter까지 다시 되돌아가서 Authentication 정보를 전달한다.
10. Authentication 객체를 SecurityContext에 저장한다. 

+) ThreadLocal > SecurityContextHolder > SecurityContext > Authentication > User객체
- Authentication 객체가 저장되는 보관소로 필요 시 언제든지  Authentication 객체를 꺼내어 쓸 수 있도록 제공되는 클래스
- ThreadLocal(스레드에 할당된 고유 저장 장소)에 저장되어 아무 곳에서나 참조가 가능하도록 설계함
- 인증이 완료되면 HttpSession에 저장되어 어플리케이션 전반에 걸쳐 전반적인 참조가 가능 


## UsernamePasswordAuthenticationFilter : Login Form 인증 필터

요청 발생 → UsernamePasswordAuthenticationFilter

→ AnyPathRequestMatcher(/login)클래스 를 통해 요청정보가 매칭되는지 확인

→ if no: chain.doFilter

→ if yes: Authentication 객체 (인증객체)를 생성하여 요청이 들어온 username과 password를 저장

→AuthenticationManager가 객체를 받아 인증 처리를 하게 됨

(매니저는 AuthenticationProvider에 위임

→ 인증이 성공한다면 인증객체를 생성하여 정보 저장 후 매니저에 다시 리턴하고, 최종적인 인증 객체를 필터에 반환

→ 인증이 실패한다면 AuthenticationException 예외처리를 발생시킨 후 필터가 후작업 실행)

→ 필터는 최종적인 인증 객체 (Authentication = User + Authorities)를 전달받은 후 SecurityContext에 저장 (세션에도 함께 저장됨)

→ SuccessHandler (성공 후작업)

