def name = () => "TestElement"

def nameX = {
  println("name!")
  () => "testName"
}

def other (item: ()=>String) = {
  println("1")
  lazy val example = item
  println("2")
  example()
  println("3")
}


println("about to execute!")
val myName = other(nameX)
println("end...")



def item = ""



def itemx = (i: Int) => i.toString





val range = List(1 to 1000)

//val aa = range.map(itemx)


val a = range.flatMap(x => x)

val mList = List (1,2,3,4,5)

val items= List(1 to 1000).flatten.map(itemx)


mList map itemx
