package ScalaCatFriendlyPlants.Parsers

class Plant (
              name: String,
              description: String,
              var price: Float
            )
  extends SafePlant(name, description)

