package samples

import ScalaCatFriendlyPlants.Parsers.SafePlant
import ScalaCatFriendlyPlants.Parsers.AspcParser
import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL._
import org.junit._

@Test
class AspcParserTest {
    @Test
    def TestLib(): Unit = {
      var aspcParser = new AspcParser()
      var parserPlants = aspcParser.parse()

      assert(parserPlants.length > 0);
      assert(parserPlants.filter(elem => elem.name.equals("Achira")).length > 0);
    }

}


