package lab7

data class Tags(var title : String){

    fun changeTitle(newTitle: String){
        this.title = newTitle
    }
}