import finalSimulation.VideoGameFullTest
import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

object GatlingRunner {

  def main(args: Array[String]): Unit = {

    //Classe a ser executada
    val simClass = classOf[CheckResponseBodyAndExtract].getName

    val props = new GatlingPropertiesBuilder
    props.simulationClass(simClass)

    Gatling.fromMap(props.build)
  }
}