# Spring Boot Learning Notes

---
## What is JWT
 - JWT Stands for JSON Web Token. Its simple digitally signed token.
---
**Structure:**
```css
header.payload.signature
```
**Payload contains three things**
- username
- role
- expiry time
Server signed it with secret key. If someone edit it then signature breaks and token will be rejected.
---
To use JWT we need below three dependencies
```xml
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.11.5</version>
</dependency>

<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.11.5</version>
    <scope>runtime</scope>
</dependency>

<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId>
    <version>0.11.5</version>
    <scope>runtime</scope>
</dependency>
```
## Summary of 30 Days Learning
---
***Layered Architecture***
- Controller
- Services
- Repository
- DTO vs Entity
- Exception Handing via controller service

***Transactions***
- Rollback rules
- Propagation(Required, Requires_new)
- isolation awareness
- Optimistic locking
- Pessimistic Locking

***Performance***
- N+1 problem
- Lazy vs Eager
- Fetch joins
- Basic catching

***Security***
- Basic auth
- Stateless JWT
- Custom Filter
- SecurityFilter Chain Config
- Weak Key Handling
- Role based accessed