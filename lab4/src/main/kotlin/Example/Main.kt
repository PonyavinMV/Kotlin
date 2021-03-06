package Example

import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main() {
    val ctx: ApplicationContext = AnnotationConfigApplicationContext(ToDoConfig::class.java)
    var toDo : ToDo = ctx.getBean(ToDo::class.java)
    toDo.add(ToDoItem("Помыть пол", Status.ACTIVE))
    toDo.add(ToDoItem("Сходить в магаз", Status.ACTIVE))
    toDo.add(ToDoItem("Сходить на учёбу", Status.Done))
    toDo.add(ToDoItem("Отдых", Status.ACTIVE))

    toDo.listOutPut()
    toDo.deleteDone()
    toDo.listOutPut()
    }

