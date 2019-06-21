import io.gatling.http.Predef._
import io.gatling.core.Predef._

class BasicSimulation extends Simulation {

  // 1 - Common HTTP Configuration
  val httpConf = http
    .baseUrl("http://localhost:8080/app/")
    .header("Accept", "application/json")


  // 2 - Scenario Definition
  val scn = scenario("First Test")
    .exec(http("Get All Games")
    .get("videogames"))

  // 3 - Load Scenario
  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)

}