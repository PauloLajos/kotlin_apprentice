data class Privilege(val id: Int, val name: String)
open class User(val username: String, private val id: String, protected var age: Int)
class PrivilegedUser(username: String, id: String, age: Int): User(username, id, age) {
  private val privileges = mutableListOf<Privilege>()
  fun addPrivilege(privilege: Privilege) {
    privileges.add(privilege)
  }
  fun hasPrivilege(id: Int): Boolean {
    return privileges.map { it.id }.contains(id)
  }
  fun about(): String {
    //return "$username, $id" // Error: id is private
    return "$username, $age" // OK: age is protected
  }
}
fun main() {
  val privilegedUser = PrivilegedUser(username = "sashinka", id = "1234", age = 21)
  val privilege = Privilege(1, "invisibility")
  privilegedUser.addPrivilege(privilege)
  println(privilegedUser.about()) // > sashinka, 21
}