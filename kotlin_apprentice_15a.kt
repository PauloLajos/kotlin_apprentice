data class Grade(val letter: Char, val points: Double, val credits:
  Double)

open class Person(var firstName: String, var lastName: String) {
  fun fullName() = "$firstName $lastName"
}
/*
class Student(firstName: String, lastName: String, var grades: MutableList<Grade> = mutableListOf<Grade>()): Person(firstName, lastName) {
  fun recordGrade(grade: Grade) {
    grades.add(grade)
  }
}
*/

/*
class Person(var firstName: String, var lastName: String) {
  fun fullName() = "$firstName $lastName"
}
class Student(var firstName: String, var lastName: String, var grades: MutableList<Grade> = mutableListOf<Grade>()) {
  fun recordGrade(grade: Grade) {
    grades.add(grade)
  }
}
*/

open class Student(firstName: String, lastName: String, var grades: MutableList<Grade> = mutableListOf<Grade>()): Person(firstName, lastName) {
  open fun recordGrade(grade: Grade) {
    grades.add(grade)
  }
}
open class BandMember(firstName: String,lastName: String): Student(firstName, lastName) {
  open val minimumPracticeTime: Int
  get() {
    return 2
  }
}
class OboePlayer(firstName: String, lastName: String): BandMember(firstName, lastName) {
  // This is an example of an override, which we’ll cover soon.
  override val minimumPracticeTime: Int = super.minimumPracticeTime * 2
}

fun phonebookName(person: Person): String {
  return "${person.lastName}, ${person.firstName}"
}

class StudentAthlete(firstName: String, lastName: String): Student(firstName, lastName) {
  var failedClasses = mutableListOf<Grade>()
  override fun recordGrade(grade: Grade) {
    var newFailedClasses = mutableListOf<Grade>()
    for (grade in grades) {
      if (grade.letter == 'F') {
        newFailedClasses.add(grade)
      }
    }
    failedClasses = newFailedClasses
    super.recordGrade(grade)
  }
  /*
  override fun recordGrade(grade: Grade) {
    super.recordGrade(grade)
    if (grade.letter == 'F') {
      failedClasses.add(grade)
    }
  }
  */
  val isEligible: Boolean
  get() = failedClasses.size < 3
}

fun main() {
  val john = Person(firstName = "Johnny", lastName = "Appleseed")
  val jane = Student(firstName = "Jane", lastName = "Appleseed")
  john.fullName() // Johnny Appleseed
  //jane.fullName() // Jane Appleseed

  val history = Grade(letter = 'B', points = 9.0, credits = 3.0)
  jane.recordGrade(history)
  // john.recordGrade(history) // john is not a student!

  val person = Person(firstName = "Johnny", lastName = "Appleseed")
  val oboePlayer = OboePlayer(firstName = "Jane", lastName = "Appleseed")
  phonebookName(person) // Appleseed, Johnny
  phonebookName(oboePlayer) // Appleseed, Jane

  val math = Grade(letter = 'B', points = 9.0, credits = 3.0)
  val science = Grade(letter = 'F', points = 9.0, credits = 3.0)
  val physics = Grade(letter = 'F', points = 9.0, credits = 3.0)
  val chemistry = Grade(letter = 'F', points = 9.0, credits = 3.0)
  val dom = StudentAthlete(firstName = "Dom", lastName = "Grady")
  dom.recordGrade(math)
  dom.recordGrade(science)
  dom.recordGrade(physics)
  println(dom.isEligible) // > true
  dom.recordGrade(chemistry)
  println(dom.isEligible) // > false
}