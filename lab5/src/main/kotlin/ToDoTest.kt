package lab4

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class ToDoTest {

    val toDo :  ToDo = ToDo()
    @Test
    fun addItem() {
        var testaddItem = ToDoItem("������� �� �����", Status.ACTIVE)
        toDo.addItem(testaddItem)
        toDo.addItem(ToDoItem("�������� �����", Status.DONE))
        assertTrue(toDo.find("������� �� �����")!! == testaddItem, "add" )

    }

    @Test
    fun deleteItem() {
        toDo.addItem(ToDoItem("������ ������", Status.ACTIVE))
        toDo.addItem(ToDoItem("�������� �����", Status.DONE))
        toDo.deleteItem("������ ������")
        assertTrue(toDo.find("������ ������") == null, "del")

    }

    @Test
    fun deleteActive() {
        toDo.addItem(ToDoItem("������ ������", Status.ACTIVE))
        toDo.addItem(ToDoItem("�������� �����", Status.DONE))
        toDo.deleteActive()
        assertTrue(toDo.find("������ ������") == null, "del")
    }

    @Test
    fun deleteDone() {
        toDo.addItem(ToDoItem("������ ������", Status.ACTIVE))
        toDo.addItem(ToDoItem("�������� �����", Status.DONE))
        toDo.deleteDone()
        assertTrue(toDo.find("�������� �����") == null, "del")
    }

    @Test
    fun deleteAll() {
        toDo.addItem(ToDoItem("������ ������", Status.ACTIVE))
        toDo.addItem(ToDoItem("�������� �����", Status.DONE))
        toDo.deleteAll()
        assertTrue(toDo.find("�������� �����") == null, "del")
        assertTrue(toDo.find("������ ������") == null, "del")

    }

    @Test
    fun find() {
        var testfindItem = ToDoItem("�������� �����", Status.DONE)
        toDo.addItem(testfindItem)
        assertTrue(toDo.find("�������� �����") !! == testfindItem, "oh")
    }

    @Test
    fun changeItemDescription() {
        var testchangeItem = ToDoItem("�������� �����", Status.DONE)
        toDo.addItem(testchangeItem)
        toDo.changeItemDescription("�������� �����", "������� �� �����", Status.ACTIVE)
        assertTrue(toDo.find("������� �� �����",)!!.description.equals("������� �� �����"), "chen")
    }

    @Test
    fun addTags() {
        var testaddTags = Tags("�����")
        toDo.addTags(testaddTags)
        assertTrue(toDo.findTags("�����")!! == testaddTags, "add")
    }

    @Test
    fun findTags() {
        var testfindTags = Tags("���")
        toDo.addTags(testfindTags)
        assertTrue(toDo.findTags("���") !! == testfindTags, "find")
    }

    @Test
    fun deleteTags() {
        toDo.addTags(Tags("�����"))
        toDo.deleteTags("�����")
        assertTrue(toDo.findTags("�����") == null, "del")
    }
}