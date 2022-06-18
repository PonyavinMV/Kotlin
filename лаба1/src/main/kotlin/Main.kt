fun main(args: Array<String>) {
    println("Hello World!")

    println("Program arguments: ${args.joinToString()}")
    var myPhone = MobilePhone(89953345667)
    myPhone.addNewContact(Contact("Semen",89543456781))
    println(myPhone.contactlist.get(0).title)
    println(myPhone.contactlist.get(0).phoneNumber)
}
class Contact(var title: String, var phoneNumber: Long){
}

class MobilePhone(var phonenumber: Long, var contactlist : MutableList<Contact> = mutableListOf<Contact>()){

    fun addNewContact(NewPhoneContact: Contact = Contact("name", 8005553535)){
        contactlist.add(NewPhoneContact)
    }

    fun updateContact(OldUpdatePhoneContact: Contact = Contact("name",8005553535 ),
                      NewPhoneContact : Contact = Contact("name", 8005553535) ): Int {
        var objNomer = 0
        var ansCode = -1
        for (contacts in contactlist){
            if ((contacts == (OldUpdatePhoneContact)) && (objNomer == 0)){
                contacts.title = NewPhoneContact.title
                contacts.phoneNumber = NewPhoneContact.phoneNumber
                objNomer = 0
                ansCode = 1
            }
        }
        return ansCode
    }

    fun removeContact(RemovedContact : Contact = Contact("name", 8005553535)) : Int{
        if (contactlist.contains(RemovedContact)){
            println("Контакт успешно удален " + contactlist.remove(RemovedContact))
            return 0 
        }
        else{
            println("Контакт не удален " + contactlist.remove(RemovedContact))
            return -1 
        }
    }

    fun findContact(PhoneContact: Contact = Contact("name", 8005553535)): Int {
        if (contactlist.contains(PhoneContact)){
            return contactlist.indexOf(PhoneContact)
        }
        else {
            return -1
        }
    }

    fun queryContact(findquery : String): String {
        var question = "null"
        for (item in contactlist){
            if (findquery == item.title && question == "null" ){
                question = item.toString()
            }
            else{
                return continue
            }
        }
        return question
    }
}


class Node(
    private var value: Int,
    private var left: Node? = null,
    private var right: Node? = null
) {
    fun value() = value

    fun changeValue(value: Int) {
        this.value = value
    }

    fun changeLeft(left: Node?) {
        this.left = left
    }

    fun changeRight(right: Node?) {
        this.right = right
    }
    fun leftNode() = left
    fun rightNode() = right
}

class BinaryTree {
    private var root: Node? = null

    fun add(value: Int) {
        fun addRec(current: Node?, value: Int) : Node {
            if (current == null) {
                return Node(value)
            }
            if (value < current.value()) {
                current.changeLeft(addRec(current.leftNode(), value))
            } else if (value > current.value()) {
                current.changeRight(addRec(current.rightNode(), value))
            }
            return current
        }

        root = addRec(root, value)
    }

    fun isEmpty() = root == null
    fun remove(value: Int) {
        fun smallestValue(root: Node) : Int {
            return if (root.leftNode() == null) root.value() else smallestValue(root.leftNode()!!)
        }

        fun removeRec(current: Node?, value: Int) : Node? {
            if (current == null) {
                return null
            }
            if (value == current.value()) {
                if (current.leftNode() == null && current.rightNode() == null) {
                    return null
                }
                if (current.leftNode() == null) {
                    return current.rightNode()
                }
                if (current.rightNode() == null) {
                    return current.leftNode()
                }
                val smallestValue = smallestValue(current.rightNode()!!)
                current.changeValue(smallestValue)
                current.changeRight(removeRec(current.rightNode(), smallestValue))
                return current
            }
            if (value < current.value()) {
                current.changeLeft(removeRec(current.leftNode(), value))
            } else {
                current.changeRight(removeRec(current.rightNode(), value))
            }
            return current
        }
        root = removeRec(root, value)
    }

    fun contains(value: Int) : Boolean {
        fun containsRec(current: Node?, value: Int) : Boolean {
            if (current == null) {
                return false
            }
            if (value == current.value()) {
                return true
            }
            return if (value < current.value()) containsRec(current.leftNode(), value) else containsRec(current.rightNode(), value)
        }

        return containsRec(root, value)
    }

    fun traverseInOrder() : List<Int> {
        fun traverseInOrderRec(node: Node?, nodes: MutableList<Int>) {
            if (node != null) {
                traverseInOrderRec(node.leftNode(), nodes)
                nodes.add(node.value())
                traverseInOrderRec(node.rightNode(), nodes)
            }
        }

        return mutableListOf<Int>().apply {
            traverseInOrderRec(root, this)
        }
    }

    fun traversePreOrder() : List<Int> {
        fun traversePreOrderRec(node: Node?, nodes: MutableList<Int>) {
            if (node != null) {
                nodes.add(node.value())
                traversePreOrderRec(node.leftNode(), nodes)
                traversePreOrderRec(node.rightNode(), nodes)
            }
        }

        return mutableListOf<Int>().apply {
            traversePreOrderRec(root, this)
        }
    }

    fun traversePostOrder() : List<Int> {
        fun traversePostOrderRec(node: Node?, nodes: MutableList<Int>) {
            if (node != null) {
                traversePostOrderRec(node.leftNode(), nodes)
                traversePostOrderRec(node.rightNode(), nodes)
                nodes.add(node.value())
            }
        }

        return mutableListOf<Int>().apply {
            traversePostOrderRec(root, this)
        }
    }

    fun traverseLevelOrder() : List<Int> {
        val root = this.root ?: return listOf()

        val queue = java.util.LinkedList<Node>()
        queue.add(root)

        val items = mutableListOf<Int>()

        while (queue.isNotEmpty()) {
            val node = queue.remove()
            items.add(node.value())
            if (node.leftNode() != null) {
                queue.add(node.leftNode()!!)
            }
            if (node.rightNode() != null) {
                queue.add(node.rightNode()!!)
            }
        }

        return items
    }

}
