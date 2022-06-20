package lab4

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.CommandLineRunner

@SpringBootApplication
class ToDoApplication : CommandLineRunner {

    var logger : Logger = LoggerFactory.getLogger(ToDoApplication::class.java)

    override fun run(vararg args: String?){
        logger.info("EXECUTING : command line runner")
        val toDo = ToDo()
        while(true){
            println("Введите команду")
            println("1- добавить дело; 2- добавить тег; 3 - удалить активные; 4 - удалить выполненые; 5 - показать список; 6 - выход")
            when(readLine()!!.toString()) {
                "1" -> {
                    println("Введите описание")
                    toDo.addItem(ToDoItem(readLine()!!.toString(), Status.ACTIVE))
                }
                "2" -> {
                    println("Введите описание")
                    toDo.addTags(Tags(readLine()!!.toString()))
                }
                "3" -> {
                    toDo.deleteActive()
                }
                "4" -> {
                    toDo.deleteDone()
                }
                "5" -> {
                    toDo.printToDoConsole()
                }
                "6" -> {
                    break
                }
                else -> continue
            }
        }
    }
}
fun main(args: Array<String>) {
    runApplication<ToDoApplication>(*args)

}
