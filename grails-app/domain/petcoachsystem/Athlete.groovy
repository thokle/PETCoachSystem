package petcoachsystem

class Athlete  extends User {
String firstname
String lastname
static belongsTo = User
    static constraints = {
    }
}
