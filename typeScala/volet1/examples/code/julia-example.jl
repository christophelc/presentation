x=rand(1000);
x

function sum_global()
           s = 0.0
           for i in x
               s += i
           end
           return s
       end;

@time sum_global()

@time sum_global()

function sum_arg(x)
           s = 0.0
           for i in x
               s += i
           end
           return s
       end;

time_sum(x) = @time sum_arg(x);

time_sum(x)

function myplus(x,y)
    x+y
end

myplus(3,4)

myplus(3.4,4.2)

function myplus(x::Int,y::Int)
    x+y
end



IntOrString = Union{Int,AbstractString}

1 :: IntOrString

"Hello!" :: IntOrString

 struct Point{T}
           x::T
           y::T
       end

Point{Float64}

Point{Float64} <: Point

Point{Float64} <: Point{Real}

struct Tuple2{A,B}
    a::A
    b::B
end

Tuple{Int,AbstractString} <: Tuple{Real,Any}

f(x::Number, y::Number) = 2x - y

f(2.0, 3)


