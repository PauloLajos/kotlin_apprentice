enum class DayOfTheWeek {
  // more code goes here
  Monday=1,
  Tuesday,
  Wednesday,
  Thursday,
  Friday,
  Saturday,
  Sunday
}

fun main() {
  for (day in DayOfTheWeek.values()) {
    println("Day ${day.ordinal}: ${day.name}")
  }
}
