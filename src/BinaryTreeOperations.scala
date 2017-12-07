sealed abstract class Tree[+T]

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  override def toString = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"
}

case object End extends Tree[Nothing] {
  override def toString = "."
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}

object Tree extends App{

  def cBalanced[T](n: Int, x: T) : List[Tree[T]] = {
    n match {
      case 0 => Nil
      case 1 => List(Node(x))
      case 2 => List(Node(x, Node(x), End), Node(x, End, Node(x)))
      case _ =>
        if (n % 2 == 0) {
          (for (l <- cBalanced(n/2 -1,x); r <- cBalanced(n/2,x)) yield Node(x,l,r)) ++
            (for (l <- cBalanced(n/2,x); r <- cBalanced(n/2 -1,x)) yield Node(x,l,r))
        } else {
          for (l <- cBalanced((n-1)/2,x); r <- cBalanced((n-1)/2,x)) yield Node(x,l,r)
        }

    }
  }


println(Tree.cBalanced(4, "x"))

}


abstract class BinaryTree[+A] {
  def isEmpty: Boolean
  def isValid: Boolean
}

case object EmptyTree extends BinaryTree[Nothing] {
  def isEmpty = true
  def isValid = true
}

case class NonEmptyTree[A](
                            var data: A,
                            var left: BinaryTree[A],
                            var right: BinaryTree[A])
                          (implicit ord: Ordering[A]) extends BinaryTree[A] {
  def isEmpty = false
  def isValid: Boolean = {
    import ord._
    def isValidWith(f: A => Boolean, t: BinaryTree[A]): Boolean = t match {
      case NonEmptyTree(that, _, _) => f(that) && t.isValid
      case EmptyTree => true
    }
    isValidWith(data < _, left) && isValidWith(data > _, right)
  }
}