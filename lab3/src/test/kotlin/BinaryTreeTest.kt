import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BinaryTreeTest {
    var tree = BinaryTree()
    @Test
    fun insertNode() {
        tree.InsertNode(1)
        tree.InsertNode(2)
        tree.InsertNode(3)
        tree.InsertNode(4)
        tree.InsertNode(5)
        tree.InsertNode(6)
        tree.InsertNode(7)
        tree.InsertNode(8)
        tree.InsertNode(9)
        tree.InsertNode(10)

        assertTrue(tree.containsNode(tree.root, 1))
        tree.printNode(tree.root)
    }

    @Test
    fun removeNode() {
        tree.removeNode(tree.root, 5)
        tree.removeNode(tree.root, 9)
        tree.removeNode(tree.root, 2)

        assertFalse(tree.containsNode(tree.root, 9))

        tree.printNode(tree.root)

    }
}