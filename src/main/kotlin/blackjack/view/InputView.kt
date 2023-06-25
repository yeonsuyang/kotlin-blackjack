package blackjack.view

import blackjack.domain.Player

private const val NAME_STRING = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)"

private const val PLAY_STRING = "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)"

object InputView {
    fun getNames(): List<Player> {
        println(NAME_STRING)
        return readln().split(",").map { Player(it) }
    }

    fun getAnswer(player: Player): String {
        println("${player.name}$PLAY_STRING")
        return readln()
    }
}
