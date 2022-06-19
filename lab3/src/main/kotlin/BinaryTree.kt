class BinaryTree {
    var root : Node? = null

    fun addNodeValue(value : Int = 0, current : Node? = null): Node {
        if (current == null){
            return Node(value)
        }
        if (value < current.value) {
            current.left = addNodeValue(value, current.left)
        }
        else if(value > current.value){
            current.right = addNodeValue(value, current.right)
        }
        else return current
        return current
    }

    fun containsNode(current: Node?, value: Int): Boolean{
        if (current == null){
            return false
        }
        else {
            if (current.value == value) {
                return true
            }
        }
        return if (value < current.value) containsNode(current.left, value) else containsNode(current.right, value)
    }

    fun searchNode(root : Node?) : Int{
        if (root?.left    == null){
            return root!!.value
        }
        else{
            searchNode(root.left)
        }
        return 0

    }

    fun InsertNode(value: Int = 0){
        root = addNodeValue(value, root)
    }

    fun removeNode(root: Node?, value: Int): Node?{
        if (root == null){
            return null
        }
        if (value == root.value){
            if (root.left == null && root.right == null){
                return null
            }
            else if (root.left != null && root.right == null){
                return root.left
            }
            else if(root.left == null && root.right != null){
                return root.right
            }
            else{
                val minvalue = searchNode(root.right)
                root.value = minvalue
                root.right = removeNode(root.right, minvalue)
                return root
            }

        }
        if(value < root.value){
            root.left = removeNode(root.left, value)
            return root
        }
        else{
            root.right = removeNode(root.right, value)
            return root
        }

    }

    fun DeleteNode(value: Int = 0){
        root = removeNode(root, value)
    }
    fun printNode(startNode: Node?) {
        val nodes =  mutableListOf<Int>()
        if (startNode != null) {
            nodes.add(startNode.value.toInt())
            printNode(startNode.left)
            print(" $nodes")
            printNode(startNode.right)
        }
    }
}