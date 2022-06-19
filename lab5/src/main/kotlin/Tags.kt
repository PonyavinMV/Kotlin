package lab4

data class Tags(var title : String){

    fun changeTitle(newTitle: String){
        this.title = newTitle
    }
}