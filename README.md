## Load Test com Gatling

- **Pré requisitos**
  - > Instalar Plugin Scala no IntelliJ: Settings > Plugins > Scala
  - > Importar o projeto no IntelliJ como projeto gradle
  - > Clone da Aplicação usada nos testes: https://github.com/james-willett/VideoGameDB

- Iniciar aplicação para testes
```
./gradlew bootRun
```

- Executar testes pelo IntelliJ:
    - Na classe GatlingRunner colocar a classe a ser testada
    - Botão direito em main > Run > GatlingRunner    

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

- **Relatório html**: 
  > ./results/

#### Referências

- [Gatling](https://gatling.io/)
- [Gatling Cheat Sheet](https://gatling.io/docs/current/cheat-sheet/)
- [Gatling Plugin for Gradle](https://github.com/lkishalmi/gradle-gatling-plugin)