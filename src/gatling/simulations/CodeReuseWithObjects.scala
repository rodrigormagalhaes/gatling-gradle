import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

class CodeReuseWithObjects extends BaseSimulation {

  //  val scn = scenario("Video Game DB")
  //
  //    .exec(http("Get All Video Games")
  //      .get("videogames")
  //      .check(status.is(200)))
  //
  //    .exec(http("Get Specific game")
  //      .get("videogames/1")
  //      .check(status.in(200 to 210)))
  //
  //    .exec(http("Get All Video Games")
  //      .get("videogames")
  //      .check(status.is(200)))

  def getAllVideoGames(): ChainBuilder = {
    repeat(3) {
      exec(http("Get All Video Games")
        .get("videogames")
        .check(status.is(200)))
    }
  }

  def getSpecificVideoGame(): ChainBuilder = {
    repeat(5) {
      exec(http("Get Specific game")
        .get("videogames/1")
        .check(status.in(200 to 210)))
    }
  }

  val scn = scenario("Video Game DB")
    .exec(getAllVideoGames())
    .pause(5)
    .exec(getSpecificVideoGame())
    .pause(5)
    .exec(getAllVideoGames())

  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)


}
