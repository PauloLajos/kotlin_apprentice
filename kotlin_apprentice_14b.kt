fun MyMath.Companion.primeFactors(value: Int): List<Int> {
  // 1
  var remainingValue = value
  // 2
  var testFactor = 2
  val primes = mutableListOf<Int>()
  // 3
  while (testFactor * testFactor <= remainingValue) {
    if (remainingValue % testFactor == 0) {
      primes.add(testFactor)
      remainingValue /= testFactor
    } else {
      testFactor += 1
    }
  }if (remainingValue > 1) {
    primes.add(remainingValue)
  }
  return primes
}

fun main() {
  MyMath.primeFactors(81) // [3, 3, 3, 3]
}