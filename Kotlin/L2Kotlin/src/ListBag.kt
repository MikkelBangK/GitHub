class ListBag<E : Any> : Bag<E> {
    private val elements: MutableList<E> = mutableListOf()
    override fun add(item: E): Boolean {
        elements.add(item)
        if (elements.contains(item)) {
            return true
        } else {
            return false
        }
    }

    override fun remove(): E? {
        return if (elements.isNotEmpty()) {
            elements.removeAt(elements.size - 1)
        } else {
            null
        }
    }

    override fun clear() {
        elements.clear()
    }

    override fun remove(item: E): Boolean {
        return elements.remove(item)
    }

    override fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

    override fun contains(item: E): Boolean {
        return elements.contains(item)
    }

    override fun countOf(item: E): Int {
        return elements.count { it == item }
    }

    override fun toArray(): Array<Any> {
        return elements.toTypedArray()
    }
}
fun main() {
    val bag = ListBag<Int>()

    bag.add(1)
    bag.add(2)
    bag.add(3)
    println("Bag: ${bag.toArray().joinToString()}")
    println(bag.remove())
    println(bag.remove(1))
    bag.clear()
    println("Bag: ${bag.toArray().joinToString()}")
    bag.isEmpty()
    println(bag.isEmpty())
    bag.add(1)
    bag.add(2)
    bag.add(2)
    bag.add(3)
    bag.add(3)
    bag.add(3)
    println(bag.countOf(1))
    println(bag.countOf(2))
    println(bag.countOf(3))
    println(bag.contains(3))
    println(bag.toArray().joinToString())
}
