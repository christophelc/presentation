def quacker(duck: {def quack(value: String): String}) {
  println (duck.quack("Quack"))
}

object BigDuck {
  def quack(value: String) = {
    value.toUpperCase
  }
}

object SmallDuck {
  def quack(value: String) = {
    value.toLowerCase
  }
}

object IamNotReallyADuck {
  def quack(value: String) = {
    "prrrrrp"
  }
}

quacker(BigDuck)

quacker(SmallDuck)

quacker(IamNotReallyADuck)

object NoQuaker {

}

quacker(NoQuaker)

val x = new AnyRef {
  def quack(value: String) = {
    "No type needed "+ value
  }
}

quacker(x)

def quacker(duck: {def quack(value: String): String; def walk(): String}) {
  println (duck.quack("Quack"))
}


