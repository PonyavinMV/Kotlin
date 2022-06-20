import org.junit.jupiter.api.Assertions.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
internal class ProjectKtTest {

    @Test
    fun fetchvideo() {
        var video = fetchvideo(1)
        assertTrue(video.videoUrl == "https://www.youtube.com/watch?v=PsaFVLr8t4E", "Error")
    }

    @Test
    fun main() {
        var lists : MutableList<Project> = mutableListOf<Project>()
        var video = fetchvideo(1)
        println(video)
        lists.add(video)
        assertTrue(lists.size == 1, "Error")
    }
}