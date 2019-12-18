package samples

import ScalaCatFriendlyPlants.Parsers.{Plant, SafePlant}
import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import org.junit.Assert._
import org.junit._
import net.ruippeixotog.scalascraper.model._
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._

@Test
class IkeaParserTest {
    @Test
    def TestLib(): Unit = {
        val browser = JsoupBrowser()
        val doc2 = browser.get("https://www.ikea.com/pl/pl/cat/rosliny-doniczkowe-i-sukulenty-10779/?page=5")
        val items = doc2 >> elementList(".product-compact")
        var parsedItems = items.map(e => {
            var name = e >> element(".product-compact__name") >> allText
            var price = (e >> element(".product-compact__price__value") >> allText)
              .replace(',','.')
              .replace(".-", "")
              .toFloat

            new Plant(name, "", price)
        })
        parsedItems.foreach(println)
    }

}


