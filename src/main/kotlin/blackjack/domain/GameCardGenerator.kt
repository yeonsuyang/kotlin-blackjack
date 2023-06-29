package blackjack.domain

object GameCardGenerator {
    fun crete(): MutableList<Card> = getAllCards().shuffled().toMutableList()

    private fun getAllCards(): List<Card> = Shape.values().flatMap { shape ->
        Character.values().map { char -> Card(shape, char) }
    }
}
