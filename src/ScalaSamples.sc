import scala.annotation.tailrec

//1-
//Could you flatten this nested list structure?
val coolList = List(List(1,2), List(3,4))



//2-
// Find the last but one element of a list. (penultimate)
//scala> penultimate(List(1, 1, 2, 3, 5, 8))
//res0: Int = 5

def penultimate[A](l:List[A]):A = {
 l.reverse(2)
}

penultimate(List(1, 1, 2, 3, 5, 8))



//3-
// Find out whether a list is a palindrome.
// hint: reversal should be equals !
//scala> isPalindrome(List(1, 2, 3, 2, 1))
//res0: Boolean = true
val palindrome = List(1, 2, 3, 2, 1)

@tailrec
def isPalindrome[A](l: List[A]):Boolean = l match {
  case Nil => true
  case List(a) => print(a); true
  case list => list.head == list.last && isPalindrome(list.tail.init)
}


palindrome.head
palindrome.last
palindrome.tail.init
palindrome.tail



isPalindrome(List(1, 2, 3, 2, 1))
isPalindrome(List(1, 2, 3, 4, 1))


//4 -
// Eliminate consecutive duplicates of list elements.
// If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.

val repElements = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)


def compress[A](l: List[A]):List[A] = l.foldLeft(List[A]()) {
  case (List(), e) => ???
  case (ls, e) if (ls.last == e) => ???
  case (ls, e) => ???
}

//compress(repElements)


case class TestCaseClass ()

val listOfLists = List(List(1, 1), 2, List(3, List(5, 8)))

val listOfLists2 = List(List(1, 1), "a", TestCaseClass,  List(3, List(5, 8)))


val listOfL = List(List(1, 1), List(5, 8))

listOfL.flatten



def myFlatten(l: List[Any]): List[Any] = l flatMap {
  case ls: List[_] => myFlatten(ls)
  case h => List(h)
}

myFlatten(listOfLists2)


def flattenX(l: List[Any]): List[Any] = l match {
  case Nil => Nil
  case (h:List[_])::tail => flattenX(h):::flattenX(tail)
  case h::tail => h::flattenX(tail)
}

flattenX(listOfLists2)


val items = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)


def pack[A](l: List[A]): List[List[A]] = {
  @tailrec
  def _pack(res: List[List[A]], rem: List[A]):List[List[A]] = rem match {
    case Nil => res
    case h::tail if res.isEmpty || res.last.head != h => _pack(res:::List(List(h)), tail)
    case h::tail => _pack(res.init:::List(res.last:::List(h)), tail)
  }
  _pack(List(),l)
}

val ele = List(List('c),List('a,'b))

ele.init



def sum (first: Int, second: Int) = first + second

sum(2,3)

def sumC (first: Int) (second: Int) = first + second

val p = sumC(3)_

val z = p(2)


val sumL = List (2,3)


def name = "TestElement"
name

val mName = "TestElement2"

lazy val mNamel = "TestElement3"


()