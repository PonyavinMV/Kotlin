import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement
import java.net.HttpURLConnection
import java.net.URL

@Serializable
data class Project(
    val id : Int = 0,
    val videoUrl : String = "null",
    val title : String = "null",
    val speaker : String = "null"
)

fun fetchvideo(id: Int) : Project {
    var response: Project = Project()
    try {
        val url: URL = URL("https://my-json-server.typicode.com/kotlin-hands-on/kotlinconf-json/videos/$id")
        val connect: HttpURLConnection = url.openConnection() as HttpURLConnection
        connect.connectTimeout = 5000
        connect.readTimeout = 5000
        println(connect)
        println(connect.responseCode)
        println(connect.responseMessage)

        val readcon = connect.inputStream.reader()
        var json = readcon.readText()
        readcon.close()
        connect.disconnect()

        var encode: JsonElement = Json.parseToJsonElement(json)
        println(encode)
        response = Json.decodeFromJsonElement(encode,)
        println(response)

    } catch (e: Exception) {
        e.printStackTrace()
    }
    return response
}
fun main() {
    var lists : MutableList<Project> = mutableListOf<Project>()
    var video = fetchvideo(1)
    println(video)
    lists.add(video)

}