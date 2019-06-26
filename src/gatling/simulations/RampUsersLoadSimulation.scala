import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._
import scala.concurrent.duration.DurationInt

class RampUsersLoadSimulation extends BaseSimulation {

  def getAllVideoGames(): ChainBuilder = {
    exec(http("Get All Video Games")
      .get("videogames")
      .check(status.is(200))
    )
  }

  def getSpecificVideoGame(): ChainBuilder = {
    exec(http("Get Specific Video Game")
      .get("videogames/2")
      .check(status.is(200))
    )
  }

  val scn = scenario("Video Game DB")
    .exec(getAllVideoGames())
    .pause(5)
    .exec(getSpecificVideoGame())
    .pause(5)
    .exec(getAllVideoGames())

  setUp(
    scn.inject(
      nothingFor(5 seconds),
     // constantUsersPerSec(10) during (10 seconds) //Add 10 users a cada 10 seconds = 100 users no total
      rampUsersPerSec(1) to (5) during(20 seconds) // Start by adding 1 new user per second. Then increase that to 5 new users per second, over a period over 20 seconds
    ).protocols(httpConf.inferHtmlResources())
  )


}
