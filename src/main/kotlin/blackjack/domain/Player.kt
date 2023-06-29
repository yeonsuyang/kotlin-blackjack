package blackjack.domain

class Player(name: String, cards: Cards = Cards()) : Participant(name, cards) {

    private var isTurnFinished: Boolean = false
    fun finishedTurn() {
        isTurnFinished = true
    }

    fun canProceedTurn() = !isTurnFinished && score() <= BlackJack.BLACKJACK_MAX_SCORE
}
