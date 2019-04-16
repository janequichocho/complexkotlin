println("UW Complex Kotlin homework")

// write a lambda using map and fold to solve "FIZZBUZZ" for the first fifteen numbers (0..15)
// use map to return a list with "", "FIZZ" or "BUZZ" as necessary
// use fold to compress the array of strings down into a single string
// the final string should look like FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ
//
var mapFoldResults = ""

var resultMap: MutableMap<Int, String> = mutableMapOf<Int, String>()

for (i in 1..15) {
    var word = ""
    if (i % 3 == 0) {
        word = "FIZZ"
    }
    if (i % 5 == 0) {
        word = word + "BUZZ"
    }
    resultMap[i] = word
}

for (i in 1..15) {
    mapFoldResults = mapFoldResults + resultMap[i]
}

// This is a utility function for your use as you choose, and as an
// example of an extension method
fun Int.times(block: () -> Unit): Unit {
    for (it in 1..this) {
        block()
    }
}

// Use this function
fun process(message: String, block: (String) -> String): String {
    return ">>> ${message}: {" + block(message) + "}"
}
var r1 = "" // call process() with message "FOO" and a block that returns "BAR"

val r2_message = "wooga"
var r2 = "" // call process() with message "FOO" and a block that upper-cases 
            // r2_message, and repeats it three times with no spaces: "WOOGAWOOGAWOOGA"

r1 = process("FOO", { _ -> "BAR"})
r2 = process("FOO", { _ -> 
    r2_message.toUpperCase() + r2_message.toUpperCase() + r2_message.toUpperCase()
})

// write an enum-based state machine between talking and thinking
enum class Philosopher(var value: Int) { 
    TALKING(0) {
        override fun toString(): String = "Allow me to suggest an idea..."
    },
    THINKING(1) {
        override fun toString(): String = "Deep thoughts...."
    };

    fun signal(): Main.Philosopher {
        if (this.value == 0) {
            return Philosopher.THINKING
        } else {
            return Philosopher.TALKING
        }
    }
}

// create an class "Command" that can be used as a function (provide an "invoke()" function)
// that takes a single parameter ("message" of type String)
// primary constructor should take a String argument ("prompt")
// when called, the Command object should return a String containing the prompt and then the message
class Command(val prompt: String) {
    operator fun invoke(message: String): String {
        return this.prompt + message
    }
}




// ================================
println("map fold test: " + if (mapFoldResults == "FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ") "." else "!")

println("r1 test: " + if (r1 == ">>> FOO: {BAR}") "." else "!")

println("r2 test: " + if (r2 == ">>> FOO: {WOOGAWOOGAWOOGA}") "." else "!")

var seneca = Philosopher.THINKING
print("Seneca, talk! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Allow me to suggest an idea...") "." else "!")
print("Seneca, think! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Deep thoughts....") "." else "!")
print("Seneca, talk! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Allow me to suggest an idea...") "." else "!")

print("Command tests: ")
print(if (Command("")("") == "") "." else "!")
print(if (Command("> ")("Hello!") == "> Hello!") "." else "!")
println("")



