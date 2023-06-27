package blackjack.view

import blackjack.domain.BlackJack
import blackjack.domain.Cards
import blackjack.domain.Dealer
import blackjack.domain.Player

object ResultView {

    private const val DEALER_CARD_STRING = "\n딜러는 16이하라 한장의 카드를 더 받았습니다."
    private const val START_STRING = "에게 2장의 나누었습니다."

    private const val CARD_STRING = "카드:"

    private const val SCORE_STRING = "- 결과:"

    fun printCards(player: Player) {
        println("${player.name}$CARD_STRING ${getPrintCardString(player.cards)}")
    }

    private fun printDealerCards(dealer: Dealer) {
        println("${dealer.name}$CARD_STRING ${getPrintCardString(dealer.cards)}")
    }


    fun printFirstCards(game: BlackJack) {
        println("\n${game.players.joinToString { it.name }}$START_STRING")
        printDealerCards(game.dealer)
        game.players.forEach { printCards(it) }
        println()
    }

    fun printResult(game: BlackJack) {
        println()
        printDealerScore(game.dealer)
        game.players.forEach { printScore(it) }
    }

    private fun printDealerScore(dealer: Dealer) {
        println("${dealer.name}$CARD_STRING ${getPrintCardString(dealer.cards)} $SCORE_STRING ${dealer.score()}")
    }

    private fun printScore(player: Player) {
        println("${player.name}$CARD_STRING ${getPrintCardString(player.cards)} $SCORE_STRING ${player.score()}")
    }

    private fun getPrintCardString(cards: Cards) = cards.value.joinToString { it.character.value + it.shape.value }
    fun printAddDealerCard() {
        println(DEALER_CARD_STRING)
    }
}
