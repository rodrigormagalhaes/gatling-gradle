import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class CsvFeeder extends BaseSimulation {

  val csvFeeder = csv("gameCsvFile.csv").circular

  def getSpecificVideoGame = {
    repeat(10) {
      feed(csvFeeder).
        exec(http("Get Specific Video Game")
        .get("videogames/${gameId}")
        .check(jsonPath("$.name").is("${gameName}"))
        .check(status.is(200)))
        .pause(1)
    }
  }

  val scn = scenario("Video Game DB")
    .exec(getSpecificVideoGame)

  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)

}
