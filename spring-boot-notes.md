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
