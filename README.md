# Spring Security OAuth2

### Dependencies Version
1. `Java: 1.8`
2. `Spring Boot: 2.1.11.RELEASE`
3. `Spring Cloud: Greenwich.SR4`

### authorization_code 模式
> 访问获取授权码
- 通过浏览器访问，授权后获取授权码code
`http://localhost:8080/oauth/authorize?client_id=client&response_type=code`
- 向服务器申请令牌
`curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d 'grant_type=authorization_code&code=1JuO6V' "http://client:secret@localhost:8080/oauth/token"
` 