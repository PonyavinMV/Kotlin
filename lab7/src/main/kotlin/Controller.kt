package lab7

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller{

    val ctx : AnnotationConfigApplicationContext = AnnotationConfigApplicationContext(ToDoConfig::class.java)

    var toDo: ToDo = ctx.getBean(ToDo::class.java)

    @RequestMapping("/show", method = [RequestMethod.GET])
    fun show():String{
        return toDo.printToDoConsole().toString()

    }


    @RequestMapping("/addnewitem {name}", method = [RequestMethod.GET])
    fun addNewItem(@PathVariable("name") name : String):String?{
        toDo.addItem(ToDoItem(name, Status.ACTIVE))
        return show()

    }

    @RequestMapping("/deleteitem {name}", method = [RequestMethod.GET])
    fun delete(@PathVariable("name") name: String):String?{
        toDo.deleteItem(name)
        return show()
    }

    @RequestMapping("/addtags {name}", method = [RequestMethod.GET])
    fun addnewTag(@PathVariable("name") name: String) : String?{
        toDo.addTags(Tags(name))
        return show()

    }

    @RequestMapping("/deleteTag {name}", method = [RequestMethod.GET])
    fun deleteTag(@PathVariable("name") name: String):String?{
        toDo.deleteTags(name)
        return show()
    }
}

