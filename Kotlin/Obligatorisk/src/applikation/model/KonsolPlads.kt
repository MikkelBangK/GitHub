package applikation.model

class KonsolPlads(
    val type: String,
    nr: Int,
    omraade: Omraade,
    private val _reservationer: MutableList<Reservation> = mutableListOf()
) : Plads(nr, omraade) {

    override fun pris(timer: Int): Double {
        val grundPris = super.pris(timer)
        val Tillæg = when (omraade) {
            Omraade.BØRNE -> 0.10
            else -> 0.25
        }
        return grundPris * (1 + Tillæg)
    }

    override fun compareTo(other: Plads): Int {
        val omraadeComparison = this.omraade.compareTo(other.omraade)
        return if (omraadeComparison != 0) {
            omraadeComparison
        } else {
            this.nr.compareTo(other.nr)
        }
    }
}