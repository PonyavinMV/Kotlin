package lab4

class ToDo (private var toDoList: MutableList<ToDoItem> = mutableListOf(), var taglist : MutableList<Tags> = mutableListOf()){

    fun addItem(item: ToDoItem): Boolean = toDoList.add(item)
    fun deleteItem(description: String): Boolean = toDoList.removeIf { it.description.equals(description) }
    fun deleteActive(): Boolean = toDoList.removeIf { it.status.equals(Status.ACTIVE) }
    fun deleteDone(): Boolean = toDoList.removeIf { it.status.equals(Status.DONE) }
    fun deleteAll() = toDoList.clear()
    fun find(description: String): ToDoItem? = toDoList.find { it.description.equals(description) }
    fun changeItem(description: String, status: Status): Boolean {
        var item = find(description)
        if (item != null) {
            toDoList.set(toDoList.indexOf(item), item.apply { this.status.equals(status) })
            return true
        } else
            return false
    }

    fun changeItemDescription(descriptionOld: String, descriptionNew: String, statusNew: Status): Boolean {
        var item = find(descriptionOld)
        if (item != null && descriptionNew != null) {
            toDoList.set(toDoList.indexOf(item), item.apply { this.description = descriptionNew })
            return true
        } else
            return false
    }

    fun filterStatus(status: Status): List<ToDoItem> = when (status) {
        Status.ACTIVE -> toDoList.filter { it.status.equals(Status.ACTIVE) }
        Status.DONE -> toDoList.filter { it.status.equals(Status.DONE) }
        else -> toDoList
    }
    fun printToDoConsole() {
        for (item in toDoList) {
            println(item.toString())
        }
    }

    fun addTags(tag: Tags): Boolean = taglist.add(tag)
    fun findTags(NameTag: String): Tags? = taglist.find { it.title.equals(NameTag) }

    fun deleteTags(NameTag: String): Boolean {
        var tag = findTags(NameTag)
        if (NameTag != null) {
            taglist.remove(tag)
            return true
        } else
            return false
    }
}