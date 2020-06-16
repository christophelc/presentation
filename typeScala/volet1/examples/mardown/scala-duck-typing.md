```scala
def quacker(duck: {def quack(value: String): String}) {
  println (duck.quack("Quack"))
}
```




    defined [32mfunction[39m [36mquacker[39m




```scala
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
```




    defined [32mobject[39m [36mBigDuck[39m
    defined [32mobject[39m [36mSmallDuck[39m
    defined [32mobject[39m [36mIamNotReallyADuck[39m




```scala
quacker(BigDuck)
```

    QUACK



```scala
quacker(SmallDuck)
```

    quack



```scala
quacker(IamNotReallyADuck)
```

    prrrrrp



```scala
object NoQuaker {

}
```




    defined [32mobject[39m [36mNoQuaker[39m




```scala
quacker(NoQuaker)
```

    cmd6.sc:1: type mismatch;
     found   : cmd6.this.cmd5.NoQuaker.type
     required: AnyRef{def quack(value: String): String}
    val res6 = quacker(NoQuaker)
                       ^Compilation Failed


    Compilation Failed


Also, you don’t even need to create a new type or class. You could use AnyRef to create an object with the quack method. Like this: 


```scala
val x = new AnyRef {
  def quack(value: String) = {
    "No type needed "+ value
  }
}
```




    [36mx[39m: {def quack(value: String): String} = ammonite.$sess.cmd6$Helper$$anon$1@42c876fc




```scala
quacker(x)
```

    No type needed Quack


You can also specify in the function that expects the structural type, the the parameter object must respond to more than one method. Like this: 


```scala
def quacker(duck: {def quack(value: String): String; def walk(): String}) {
  println (duck.quack("Quack"))
}
```




    defined [32mfunction[39m [36mquacker[39m




```scala

```
