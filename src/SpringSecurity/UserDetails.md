### UserDetails 

spring security에서 제공하는 Interface
> (docs 일부) UserDetails는 핵심 사용자 정보를 제공합니다.
구현은 보안 목적으로 Spring Security에서 직접 사용되지 않습니다. 
> 나중에 인증 개체(Authentication)로 캡슐화되는 사용자 정보를 저장하기만 하면 됩니다. 
> 이를 통해 보안과 관련되지 않은 사용자 정보(예: 이메일 주소, 전화번호 등)를 편리한 위치에 저장할 수 있습니다.

#### 메소드
|메소드명|리턴타입|설명|
|---|---|----|
|getAuthorities()|Collection<? extends   GrantedAuthority>|계정이 갖고있는 권한 목록
|getPassword()|String|계정 비밀번호
|getUsername()|String|계정 이름
|isAccountNonExpired()|Boolean|계정 만료 안됐는지 여부 (true = 만료안됨)
|isAccountNonLocked()|Boolean|계정이 잠겨있지 않은지 여부 (tre = 안잠김)
|isCredentialNonExpired()|Boolean|비밀번호가 만료 안 됐는지 여부 (true = 만료안됨)
|isEnabled()|Boolean|계정이 활성화인지 여부 (true = 활성화)

### UserDetailsService

DB에 저장된 비밀번호와 일치하면 UserDetails를 반환한다. 
AuthenticationProvider중 DaoAuthenticationProvider는 username을 통해 

#### 메소드
|메소드명|리턴타입|설명|
|---|---|----|
|loadUserByUsername(String username)|UserDetails|유저의 정보를 불러와서 UserDetails형태로 리턴