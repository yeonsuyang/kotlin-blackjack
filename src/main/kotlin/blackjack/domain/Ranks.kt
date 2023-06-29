package blackjack.domain

@JvmInline
value class Ranks(val values: Map<Participant, Rank>) {
    fun getDealerRankCounts(): Map<Rank, Int> {
        return getDealerRanks().sortedBy { it.order }.groupingBy { it }.eachCount()
    }

    private fun getDealerRanks(): List<Rank> = Rank.reverse(values.values.toList())
}
