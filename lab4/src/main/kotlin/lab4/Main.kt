package lab4

import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main() {
    val ctx: ApplicationContext = AnnotationConfigApplicationContext(ToDoConfig::class.java)
    var toDo: ToDo = ctx.getBean(ToDo::class.java)
    toDo.addItem(ToDoItem("Помыть полы", Status.ACTIVE))
    toDo.addItem(ToDoItem("Сходить на магаз", Status.ACTIVE))
    toDo.addItem(ToDoItem("Сделать на учёбу", Status.DONE))
    toDo.addItem(ToDoItem("Отдых", Status.ACTIVE))

    toDo.addTags(Tags("Учёба"))
    toDo.addTags(Tags("Дом"))
    toDo.addTags(Tags("Работа"))
    println("Вывод списка")
    toDo.printToDoConsole()
    //toDo.deleteActive()
    //toDo.printToDoConsole()
    //toDo.deleteDone()
    //toDo.printToDoConsole()

    while(true){
        println("Введите команду")
        println("1- добавить дело; 2- добавить тег; 3 - удалить активные; 4 - удалить выполненые; 5 - показать список; 6 - выход")
        when(readLine()!!.toString()){
            "1" -> {
                println("Введите описание")
                toDo.addItem(ToDoItem(readLine()!!.toString(),Status.ACTIVE))
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