fun main() {
    var tree = BinaryTree()
    tree.InsertNode(4)
    tree.InsertNode(2)
    tree.InsertNode(3)
    tree.InsertNode(4)
    tree.InsertNode(5)
    tree.InsertNode(6)

    println("����� ������� ������")
    println(tree.printNode(tree.root))

    println("������ ����� �������� ���������")
    println(tree.DeleteNode(4))
    println(tree.DeleteNode(6))
    println(tree.printNode(tree.root))

    println("�������� �� ������� ���������")
    println(tree.containsNode(tree.root, 3))
}