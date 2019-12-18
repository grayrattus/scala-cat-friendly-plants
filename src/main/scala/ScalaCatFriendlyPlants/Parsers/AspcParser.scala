package ScalaCatFriendlyPlants.Parsers

import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._

class AspcParser extends Parser[SafePlant] {
  override def parse(): List[SafePlant] = {
    val browser = JsoupBrowser()
    val doc2 = browser.get("https://www.aspca.org/pet-care/animal-poison-control/cats-plant-list")
    val attachment = doc2 >> elementList(".view-display-id-attachment_2")
    val items = attachment >> elementList(".view-content")

    items.map(e => {
      var fieldContent = e >> element(".field-content")
      var name = fieldContent >> text("a")
      var description = fieldContent >> text("i")

      new SafePlant(name.head,description.head)
    })
  }
}
