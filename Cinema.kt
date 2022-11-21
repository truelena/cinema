package cinema

fun cinema(row: Int, col: Int, screen: MutableList<MutableList<String>>) {
    val num = col
    println("Cinema:")
    for (i in 0..num) {
        if (i == 0) {
            print("  ")
        } else {
            print("$i ")
        }
    }
    println()
    for (i in screen.indices) {
        print("${i + 1} ")
        print("${screen[i].joinToString(" ")}")
        println()
    }
    menu(row, col, screen)
    return
}
fun seat(row: Int, col: Int, screen: MutableList<MutableList<String>>): MutableList<MutableList<String>> {
    var cost = 10
    var tRow: Int = 0
    println("Enter a row number:")
    val sRow = readln().toInt()
    println("Enter a seat number in that row:")
    val sCol = readln().toInt()
    screen[sRow - 1][sCol - 1] = "B"
    if (row * col > 60) {
        if (row % 2 != 0) {
            tRow = (row - 1) / 2
        } else {
            tRow = row / 2
        }
        if (sRow > tRow) {
            cost = 8
        }
    }
    println("Ticket price: \$$cost")
    menu(row, col, screen)
    return screen
}
fun menu(row: Int, col: Int, screen: MutableList<MutableList<String>>) {
    println()
    println("1. Show the seats")
    println("2. Buy a ticket")
    println("0. Exit")
    val sel = readln()
    when (sel) {
        "1" -> cinema(row, col, screen)
        "2" -> seat(row, col, screen)
        "0" -> return
    }
}
fun main() {
    println("Enter the number of rows:")
    val row = readln().toInt()
    println("Enter the number of seats in each row:")
    val col = readln().toInt()
    val screen = MutableList<MutableList<String>>(row) {MutableList<String>(col) { "S"} }
    menu(row, col, screen)

}