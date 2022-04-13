## Smart Sonda

Explore Planets with an Probe
Planet area is a Carthesian Plan
Data received by system should contains: Planets, Probes and Commands throught REST interface.

Examples with BDD

Given a Planet, with Size : 5x5

Scenario 1
When Probe Positon: x=1, y=2 North
And Command Sequence: LMLMLMLMM
Then Final Probe Position: x=1 y=3 North

Scenario2
When Probe Positon: x=3, y=3 East (leste)
And Command Sequence: MMRMMRMRRML
Then Final Probe Position: x=5 y=1 face para North

Command Sequence from Earth to a Sonda :
- `M` -> Moving Foward 1 position
- `L` -> Turn left (90 graus)
- `R` -> Turn right (90 graus)


Techinical Challenges
 - Levantamento de Padroes (GOF, SOLID)
 - Colocar Boas Praticas (Clean Code)
 - As responsabilidades estão bem distribuídas no código? Como melhorar?
 - Persistencia multi-database (Onion - Hexagonal)
 - Open API para documentar 
 - Decomposicao em Microservicos (Bounded Contexts): Escalabilidade, Disponibilidade e Performance

Business Challenge
Contrato Web
  Como eu cadastro mais sondas em um planeta existente?
  Como eu movo uma sonda já pousada?

### Sobre modelagem de código:
- Superfície limitada e várias sondas em movimento
  Consideracao 1
    Sondas n~ao podem ocupar mesmos pontos cartesianos
      Obs: considerando tamnaho da sonda de 1x1
  Consideracao 2
    Sondas devem se limitar ao tamanho do planeta


Outros pontos: 
- https://www.alura.com.br/artigos/nao-aprender-oo-getters-e-setters
- https://www.alura.com.br/artigos/o-que-e-modelo-anemico-e-por-que-fugir-dele

./mvnw spring-boot:run`

```bash
curl -X POST http://localhost:8080/planet-with-probes -H 'Content-Type: application/json' -d '{"width":10,"height":10,"probes":[{"x":1,"y":2,"direction":"N","commands": "LMLMLMLMM"},{"x":3,"y":3,"direction":"E","commands": "MMRMMRMRRM"}]}'
```
