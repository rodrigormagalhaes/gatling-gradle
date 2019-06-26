## Load Test com Gatling

- **Pré requisitos**
  - > Descrever config IntelliJ -> plugin scala
  - > App teste

- Iniciar app para testes

- Executar testes por linha de comando:
    - ./gradlew gatlingRun-nomeDaClasse
    
```
./gradlew gatlingRun-CustomFeeder
```

- Executar testes por linha de comando com parâmetros:
    - Considera parâmetros definidos na classe RuntimeParameters
    
```
./gradlew gatlingRun-RuntimeParameters -DUSERS=3 -DRAMPDURATION=5 -DDURATION=30
```

- Relatórios.........

#### Referências

- [Gatling](https://gatling.io/)
- [Gatling Plugin for Gradle](https://github.com/lkishalmi/gradle-gatling-plugin)