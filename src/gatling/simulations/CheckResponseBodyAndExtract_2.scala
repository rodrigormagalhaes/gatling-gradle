import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._


class CheckResponseBodyAndExtract_2 extends BaseSimulation {

  val scn = scenario("Video Game DB")

    .exec(http("Get All Video Games - 1st call")
      .get("videogames/1")
      .check(jsonPath("$.name").is("Resident Evil 4")))

    .exec(http("Get All Video Games - 2nd call")
        .get("videogames")
        .check(jsonPath("$[1].id").saveAs("gameId")))
        .exec { session => println(session); session }

    .tryMax(5) {
        exec(http("Get Specific Game")
          .get("videogames/${gameId2}")
          .check(jsonPath("$.name").is("Gran Turismo 3"))
          .check(bodyString.saveAs("responseBody"))
          .check(currentLocation.saveAs("url")))
          .exec {
            session =>
              println(session("responseBody").as[String]);
              println(session("url").as[String]);
            session
          }
    }.exitHereIfFailed

    .exec(http("Get All Video Games - 3nd call")
      .get("videogames")
      .check(jsonPath("$[1].id").saveAs("gameId")))
    .exec { session => println(session); session }


  setUp(
    scn.inject(rampUsers(3) during 3)
  ).protocols(httpConf)

}
