
class Main {

    fun runLambda(args: Map<String, String>): String {
        val name = args["name"] ?: "World"
        return "Hello $name!"
    }
}
