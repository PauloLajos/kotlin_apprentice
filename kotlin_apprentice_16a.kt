import java.util.Calendar
import java.util.Date

enum class DayOfTheWeek {
  // more code goes here
  Monday,
  Tuesday,
  Wednesday,
  Thursday,
  Friday,
  Saturday,
  Sunday
}

enum class DayOfTheWeek2(val isWeekend: Boolean) {
  Monday(false),
  Tuesday(false),
  Wednesday(false),
  Thursday(false),
  Friday(false),
  Saturday(true),
  Sunday(true);
}

enum class DayOfTheWeek3(val isWeekend: Boolean = false) {
  Monday,
  Tuesday,
  Wednesday,
  Thursday,
  Friday,
  Saturday(true),
  Sunday(true);

  companion object {
    fun today(): DayOfTheWeek3 {
      // Code goes here
      // 1
      val calendarDayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
      // 2
      var adjustedDay = calendarDayOfWeek- 2
      // 3
      val days = DayOfTheWeek3.values()
      if (adjustedDay < 0) {
        adjustedDay += days.count()
      }
      // 4
      val today = days.first {
        it.ordinal == adjustedDay
      }
      return today
    }
  }

  fun daysUntil(other: DayOfTheWeek3) : Int {
    if (this.ordinal < other.ordinal) {
      // 1
      return other.ordinal- this.ordinal // 2
    } else {
      return other.ordinal- this.ordinal + DayOfTheWeek3.values().count() //3
    }
  }
}



fun main() {
  for (day in DayOfTheWeek.values()) {
    println("Day ${day.ordinal}: ${day.name}")
  }
  println()
  val dayIndex = 0
  val dayAtIndex = DayOfTheWeek.values()[dayIndex]
  println("Day at $dayIndex is $dayAtIndex")

  println()
  for (day in DayOfTheWeek2.values()) {
    println("Day ${day.ordinal}: ${day.name}, is weekend: ${day.isWeekend}")
  }

  println()
  for (day in DayOfTheWeek3.values()) {
    println("Day ${day.ordinal}: ${day.name}, is weekend: ${day.isWeekend}")
  }

  println()
  val today = DayOfTheWeek3.today()
  val isWeekend = "It is${if (today.isWeekend) "" else " not"} the weekend"
  println("It is $today. $isWeekend.")

  println()
  val secondDay = DayOfTheWeek3.Friday
  val daysUntil = today.daysUntil(secondDay)
  println("It is $today. $isWeekend. There are $daysUntil days until $secondDay.")

  println()
  when (today) {
    DayOfTheWeek3.Monday -> println("I don't care if $today's blue")
    DayOfTheWeek3.Tuesday -> println("$today's gray")
    DayOfTheWeek3.Wednesday -> println("And $today, too")
    DayOfTheWeek3.Thursday -> println("$today, I don't care 'bout you")
    DayOfTheWeek3.Friday -> println("It's $today, I'm in love")
    DayOfTheWeek3.Saturday -> println("$today, Wait...")
    DayOfTheWeek3.Sunday -> println("$today always comes too late")
  }
  when (today) {
    DayOfTheWeek3.Monday -> println("I don't care if $today's blue")
    DayOfTheWeek3.Tuesday -> println("$today's gray")
    DayOfTheWeek3.Wednesday -> println("And $today, too")
    DayOfTheWeek3.Thursday -> println("$today, I don't care 'bout you")
    DayOfTheWeek3.Friday -> println("It's $today, I'm in love")
    DayOfTheWeek3.Saturday -> println("$today, Wait...")
    DayOfTheWeek3.Sunday -> println("$today always comes too late")
  }
}

