import io.gatling.http.Predef._
import io.gatling.core.Predef._

class BasicSimulation extends Simulation {

  val httpConf = http.baseUrl("https://www.mockapi.io")

  val scn = scenario("Basic Simulation")
    .exec(http("Teste_Rodrigo")
      .get("/"))
    .pause(5)

  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)

}