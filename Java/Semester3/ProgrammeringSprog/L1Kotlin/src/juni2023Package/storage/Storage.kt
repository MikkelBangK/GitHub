package juni2023Package.storage

import juni2023Package.model.Bane
import juni2023Package.model.Kategori
import juni2023Package.model.Spiller

object Storage {

    private val _alleSpillere: MutableList<Spiller> = mutableListOf()
    val alleSpillere: List<Spiller>
        get() = _alleSpillere
    fun addSpiller(spiller: Spiller) = _alleSpillere.add(spiller)

    private val _alleBaner: MutableList<Bane> = mutableListOf()
    val alleBaner: List<Bane>
        get() = _alleBaner
    fun addBane(bane: Bane) = _alleBaner.add(bane)

    private val _alleKategorier: MutableList<Kategori> = mutableListOf()
    val alleKategori: List<Kategori>
        get() = _alleKategorier
    fun addKategori(kategori: Kategori) = _alleKategorier.add(kategori)
}