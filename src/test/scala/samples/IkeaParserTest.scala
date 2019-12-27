package samples

import ScalaCatFriendlyPlants.Parsers.{Plant, SafePlant}
import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import org.junit.Assert._
import org.junit._
import ScalaCatFriendlyPlants.Parsers.IkeaParser
import net.ruippeixotog.scalascraper.model._
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._

import scala.collection.mutable

@Test
class IkeaParserTest {
    @Test
    def TestLib(): Unit = {
        var ikeaParser = new IkeaParser()
        var parsedItems = ikeaParser.parse()

        assert(parsedItems.length > 0);
        assert(parsedItems.filter(elem => elem.name.equals("DYPSIS LUTESCENS")).length > 0);
        assert(parsedItems.filter(elem => elem.name.equals("CYCLAMEN")).length > 0);
    }


}


