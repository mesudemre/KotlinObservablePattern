package simple

class FooReader(private val simpleObserve: SimpleObserve): IObserver {

    override fun update() {
        println("Simple observer için foo : ${simpleObserve.foo}")
    }
}