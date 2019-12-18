package ScalaCatFriendlyPlants.Parsers

trait Parser[T <: SafePlant] {
  def parse(): List[T];
}
