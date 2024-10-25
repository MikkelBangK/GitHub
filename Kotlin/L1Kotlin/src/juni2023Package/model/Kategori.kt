package juni2023Package.model

class Kategori(val navn: String, val prisKrSingle: Int, val prisKrDouble: Int) {
    override fun toString(): String {
        return "Kategori(navn='$navn')"
    }
}