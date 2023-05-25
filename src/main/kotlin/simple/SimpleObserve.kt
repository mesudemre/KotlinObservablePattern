package simple

class SimpleObserve: IObservable {

    override val observers: ArrayList<IObserver> = ArrayList()

    var foo = ""
        set(value) {
            println("Mevcut Değer : ${field}")
            field = value
            println("Yeni Değer : ${value}")
            sendUpdateEvent()
        }
}