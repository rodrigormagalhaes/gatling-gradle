import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._


class CheckResponseBodyAndExtract extends BaseSimulation {

  val scn = scenario("Video Game DB")

    .exec(http("Get All Video Games - 1st call")
      .get("videogames/1")
      .check(jsonPath("$.name").is("Resident Evil 4")))

    .exec(http("Get All Video Games - 2nd call")
      .get("videogames")
      .check(jsonPath("$[1].id").saveAs("gameId")))

    .exec(http("Get Specific Game")
      .get("videogames/${gameId}")
      .check(jsonPath("$.name").is("Gran Turismo 3")))


  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)

}
