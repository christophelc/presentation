# Example: compilation of function with abstract type


```julia
x=rand(1000);
x
```




    1000-element Array{Float64,1}:
     0.8553875562959803
     0.9928685232713945
     0.5442902361131767
     0.7005492531433313
     0.19643895201585893
     0.039754097203334116
     0.11292214642435017
     0.4723143830424512
     0.4055466191810473
     0.010118656450587515
     0.609435226208046
     0.009786023497698748
     0.05656247380029722
     ⋮
     0.8422282389870097
     0.32075911022100256
     0.996155827195266
     0.2534013229485057
     0.8850184281066522
     0.9454349967187798
     0.42549314277583195
     0.4260337010885398
     0.46760464650828215
     0.2927150340065636
     0.1588004626722146
     0.8633050248258685




```julia
function sum_global()
           s = 0.0
           for i in x
               s += i
           end
           return s
       end;
```


```julia
@time sum_global()
```

      0.005957 seconds (3.65 k allocations: 79.766 KiB)





    504.34926687237623




```julia
@time sum_global()
```

      0.000057 seconds (3.49 k allocations: 70.156 KiB)





    504.34926687237623



On the first call (@time sum_global()) the function gets compiled. (If you've not yet used @time in this session, it will also compile functions needed for timing.) You should not take the results of this run seriously. For the second run, note that in addition to reporting the time, it also indicated that a significant amount of memory was allocated. We are here just computing a sum over all elements in a vector of 64-bit floats so there should be no need to allocate memory (at least not on the heap which is what @time reports).


```julia
function sum_arg(x)
           s = 0.0
           for i in x
               s += i
           end
           return s
       end;
```


```julia
time_sum(x) = @time sum_arg(x);
```


```julia
time_sum(x)
```

      0.000001 seconds





    504.34926687237623



# Abstract type


```julia
function myplus(x,y)
    x+y
end
```




    myplus (generic function with 1 method)



An important point to note is that there is no loss in performance if the programmer relies on a function whose arguments are abstract types, because it is recompiled for each tuple of argument concrete types with which it is invoked. (There may be a performance issue, however, in the case of function arguments that are containers of abstract types; see Performance Tips.)


```julia
myplus(3,4)
```




    7




```julia
myplus(3.4,4.2)
```




    7.6




```julia
function myplus(x::Int,y::Int)
    x+y
end
```




    myplus (generic function with 2 methods)




```julia

```

# Type union


```julia
IntOrString = Union{Int,AbstractString}
```




    Union{Int64, AbstractString}




```julia
1 :: IntOrString
```




    1




```julia
"Hello!" :: IntOrString
```




    "Hello!"



# Parametric composite type


```julia
 struct Point{T}
           x::T
           y::T
       end
```


```julia
Point{Float64}
```




    Point{Float64}




```julia
Point{Float64} <: Point
```




    true




```julia
Point{Float64} <: Point{Real}
```




    false



=> Type invariant

# Tuple


```julia
struct Tuple2{A,B}
    a::A
    b::B
end
```


```julia
Tuple{Int,AbstractString} <: Tuple{Real,Any}
```




    true



# Multiple dispatch


```julia
f(x::Number, y::Number) = 2x - y
```




    f (generic function with 1 method)




```julia
f(2.0, 3)
```




    1.0




```julia

```
