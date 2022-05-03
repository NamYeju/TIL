Token ? Session? Cookie?

HTTP의 Stateless한 특징 때문에 서버로부터 클라이언트의 정보를 가지고있기 위해 세션 쿠키 등을 사용한다?

그러면 애초에 HTTP가 Stateful했으면 됐지 않을까?

왜 HTTP는 Stateless 할까?

<상황 1> Stateful한 하나의 서버만 존재할 때   
client : 상품 조회    
A server: 상품 내용 응답    
client :  2개 구매   
A server : 카카오페이 결제? 핸드폰 결제?   
client : 카카오페이!   
A server: OK!

=> 평상시 사람들의 대화같은 흐름 

<상황 2> Stateful한 여러대의 서버
client : 상품 조회    
A server: 상품 내용 응답         
client :  2개 구매   
B server : ???? 뭘 2개 구매할건데? 카카오페이 결제? 핸드폰 결제?   
client : 카카오페이!   
C server: ??? 뭘 결제할건데

=> 단점: 서버를 확장 (scale out)할 시, 각 서버들은 client의 요청에 대응하기가 어렵다

<상황 3> Stateless한 서버   
client : 상품 조회       
A server: 상품 내용 응답       
client :  마들렌을 2개 구매   
A server : 카카오페이 결제? 핸드폰 결제?   
client : 마들렌 2개를 카카오페이!    
A server: OK!   

=> 단점: 보내야 할 정보가 많아질 수록 과부화 걸릴 수도 있다

### 쿠키     
set-cookie: 서버가 클라이언트에게 보내는 쿠키    
cookie: 클라이언트가 요청할 때 보낼 쿠키  
