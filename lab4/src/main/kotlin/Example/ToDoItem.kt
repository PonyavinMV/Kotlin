package Example

data class ToDoItem(var description: String, var status: Status){

}
enum class Status{
    Done, ACTIVE
}