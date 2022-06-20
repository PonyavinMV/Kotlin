package lab4

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class ToDoTest {

    val toDo :  ToDo = ToDo()
    @Test
    fun addItem() {
        var testaddItem = ToDoItem("Сходить на каток", Status.ACTIVE)
        toDo.addItem(testaddItem)
        toDo.addItem(ToDoItem("Почитать книгу", Status.DONE))
        assertTrue(toDo.find("Сходить на каток")!! == testaddItem, "add" )

    }

    @Test
    fun deleteItem() {
        toDo.addItem(ToDoItem("Помыть машину", Status.ACTIVE))
        toDo.addItem(ToDoItem("Почитать книгу", Status.DONE))
        toDo.deleteItem("Помыть машину")
        assertTrue(toDo.find("Помыть машину") == null, "del")

    }

    @Test
    fun deleteActive() {
        toDo.addItem(ToDoItem("Помыть машину", Status.ACTIVE))
        toDo.addItem(ToDoItem("Почитать книгу", Status.DONE))
        toDo.deleteActive()
        assertTrue(toDo.find("Помыть машину") == null, "del")
    }

    @Test
    fun deleteDone() {
        toDo.addItem(ToDoItem("Помыть машину", Status.ACTIVE))
        toDo.addItem(ToDoItem("Почитать книгу", Status.DONE))
        toDo.deleteDone()
        assertTrue(toDo.find("Почитать книгу") == null, "del")
    }

    @Test
    fun deleteAll() {
        toDo.addItem(ToDoItem("Помыть машину", Status.ACTIVE))
        toDo.addItem(ToDoItem("Почитать книгу", Status.DONE))
        toDo.deleteAll()
        assertTrue(toDo.find("Почитать книгу") == null, "del")
        assertTrue(toDo.find("Помыть машину") == null, "del")

    }

    @Test
    fun find() {
        var testfindItem = ToDoItem("Почитать книгу", Status.DONE)
        toDo.addItem(testfindItem)
        assertTrue(toDo.find("Почитать книгу") !! == testfindItem, "oh")
    }

    @Test
    fun changeItemDescription() {
        var testchangeItem = ToDoItem("Почитать книгу", Status.DONE)
        toDo.addItem(testchangeItem)
        toDo.changeItemDescription("Почитать книгу", "Сходить на каток", Status.ACTIVE)
        assertTrue(toDo.find("Сходить на каток",)!!.description.equals("Сходить на каток"), "chen")
    }

    @Test
    fun addTags() {
        var testaddTags = Tags("Учёба")
        toDo.addTags(testaddTags)
        assertTrue(toDo.findTags("Учёба")!! == testaddTags, "add")
    }

    @Test
    fun findTags() {
        var testfindTags = Tags("Дом")
        toDo.addTags(testfindTags)
        assertTrue(toDo.findTags("Дом") !! == testfindTags, "find")
    }

    @Test
    fun deleteTags() {
        toDo.addTags(Tags("Учёба"))
        toDo.deleteTags("Учёба")
        assertTrue(toDo.findTags("Учёба") == null, "del")
    }
}
