package taxipark

/*
 * Task #1. Найти всех водителей, которые не совершили ни
 * одной поездки
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> = allDrivers.toList().toSet() - trips.map { it.driver }.toSet()


/*
 * Task #2. Найти всех пассажиров, которые совершили заданное
 * или большее количество поездок
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> =  TODO()
/*    var ind = 0
    var cicleFor = 0
    val c = mutableMapOf<Passenger, Int>()

    while (trips.size - 2 >= ind) {
        for (i in trips[cicleFor].passengers) {
            var ci = 1
            for (y in trips.subList(1, trips.size).map { it.passengers }) {
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
    return c.filter { it.value >= minTrips }.map { it.key }.toSet()*/




/*
 * Task #3. Найти всех пассажиров, которых два и более раз
 * вез заданный водитель
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
    TODO()

/*
 * Task #4. Найти всех пассажиров, которые большую часть своих
 * поездок ездили со скидкой (trip.discount != null)
 *
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> = TODO()

/*
 * Task #5.
 * Найти наиболее частое время поездки из минутных интервалов 0..9, 10..19, 20..29 и т.п.
 * Вернуть этот интервал или null
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? = TODO()

