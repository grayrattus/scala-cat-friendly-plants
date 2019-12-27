package ScalaCatFriendlyPlants.Parsers
import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.model._
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._

import scala.collection.mutable

class IkeaParser extends Parser[Plant] {
  val browser = JsoupBrowser()

  override def parse(): List[Plant] = {
    val parsed: mutable.MutableList[List[Plant]] = mutable.MutableList()
    parsed += this.parseIkeaLink("https://www.ikea.com/gb/en/cat/plants-10779/")

    for (i <- 2 until 6) {
      parsed += this.parseIkeaLink("https://www.ikea.com/gb/en/cat/plants-10779/page-"+ i + "/")
    }

    parsed.flatten.toList
  }

  private def parseIkeaLink(link: String): List[Plant] = {
    val doc2 = browser.get(link)
    val items = doc2 >> elementList(".product-compact")
    return items.map(e => {
      var name = e >> element(".product-compact__name") >> allText
      var price = (e >> element(".product-compact__price__value") >> allText)
        .replace("£", "")
        .toFloat

      new Plant(name, "", price)
    })

  }
}
