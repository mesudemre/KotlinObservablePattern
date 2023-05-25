import simple.FooReader
import simple.SimpleObserve
import kotlin.properties.Delegates

fun main(args: Array<String>) {
    println("-----------SIMPLE-----------")
    var simpleObserve = SimpleObserve().apply {
        this.foo = "mesut emre"
    }
    val simpleObserver = FooReader(simpleObserve)

    simpleObserver.update()

    simpleObserve.apply {
        this.foo = "çelenk"
    }
    simpleObserver.update()

    println("-----------BUILT-IN-----------")

    var temperature: Int by Delegates.observable(0) { property, oldValue, newValue -> onChange(oldValue, newValue) }
    temperature = 10
    temperature = 8
    temperature = 8
}

private fun onChange(oldValue: Int, newValue: Int) {
    val fark = newValue - oldValue
    when (fark) {
        0 -> {
            println("Sıcaklık değişmedi...")
        }

        in 1..Int.MAX_VALUE -> {
            println("Sıcaklık artışta...")
        }

        else -> {
            println("Sıcaklık azalıyor...")
        }
    }
}