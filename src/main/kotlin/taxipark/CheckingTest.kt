package taxipark


data class TaxiPark1(
    val allDrivers: Set<Driver1>,
    val allPassengers: Set<Passenger1>,
    val trips: List<Trip1>
)

data class Driver1(val name: String)
data class Passenger1(val name: String)

data class Trip1(
    val driver: Driver1,
    val passengers: Set<Passenger1>,
    // the trip duration in minutes
    val duration: Int,
    // the trip distance in km
    val distance: Double,
    // the percentage of discount (in 0.0..1.0 if not null)
    val discount: Double? = null
) {
    // the total cost of the trip
    val cost: Double
        get() = (1 - (discount ?: 0.0)) * (duration + distance)
}


fun main() {

    val driver1 = setOf(Driver1("Oleg"), Driver1("Kirill"))
    val passenger1 = setOf(Passenger1("Nikita"), Passenger1("Olga"), Passenger1("Petr"), Passenger1("Venom"))
    val passenger2 = setOf(Passenger1("Olga"), Passenger1("Nikita"))
    val passenger3 = setOf(Passenger1("Olga"), Passenger1("Venom"))
    val trip1 =
        listOf(
            Trip1(driver1.elementAt(0), passenger3, 15, 1.5),
            Trip1(driver1.elementAt(1), passenger1, 15, 1.5),
            Trip1(driver1.elementAt(1), passenger2, 15, 1.5)
        )
    val taxiPark1 = TaxiPark1(driver1, passenger1, trip1)

    var ind = 0
    var cicleFor = 0
    var c = mutableMapOf<Passenger1, Int>()

    while (taxiPark1.trips.size - 2 >= ind) {
        for (i in taxiPark1.trips[cicleFor].passengers) {
            var ci = 1
            //    println("------------ $i")
            for (y in taxiPark1.trips.subList(1, taxiPark1.trips.size).map { it.passengers }) {
                //     println("************$y")
                for (x in y) {
                    if (x == i) {
                        ci++
                        c[x] = ci
                    }
                }
            }
        }
        cicleFor++
        ind++
    }
    println(
        c.filter { it.value >= 1 }
    )
}
/*    var count = 0
    for (i in taxiPark1.trips.map { it.passengers.map { it.name } }) {
        for (y in i) {
            if (y == "Nikita") count++
        }
    }
    //     println(count)

    //  println(taxiPark1.trips[1].passengers.elementAt(0).name)

    val setPassenger = arrayListOf<Pair<Passenger1, Int>>()

    for (i in taxiPark1.trips) {
        var d = 0
        for (y in i.passengers) {
            d += 1
            setPassenger.add(Pair(y, d))

        }
        //  println(setPassenger)
    }
    //   println(setPassenger)

    val numbers = mutableListOf(4, 5, 10, 6)

    val sumDoubled = numbers.fold(0) { sum, element -> sum + element * 2 }
    //  println(sumDoubled) // 50

    val simpleSum = numbers.reduce { sum, element -> sum + element }
    //  println(simpleSum) // 46


    val ar = mutableListOf("C", "A", "B", "B", "G", "A", "C", "H", "A", "F", "F", "F", "C", "F")

*//*    println(
        ar.groupingBy { it }.aggregate { key, accumulator: Result?, element, first ->
            when {
                first -> Result(key, mutableListOf())
                else -> accumulator!!.apply { argVar.add(element) }
            }!!
        }.values.filter { it.argVar.isNotEmpty() }
    )*//*


}


data class Result(var ovr: String, var argVar: MutableList<String>)*/
//            for (x in 1 until taxiPark1.trips.size){
//               println("3 ${taxiPark1.trips[i].passengers.elementAt(x).name}")
//            }


/*
fun TaxiPark1.findFaithfulPassengers(minTrips: Int): Set<Passenger>{
    this.trips.forEach{ it }
    return
}*/

