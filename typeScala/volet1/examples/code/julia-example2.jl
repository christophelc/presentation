function myplus(x,y)
    x+y
end

code_llvm(myplus, (Int64, Int64))

code_llvm(myplus, (Int64, Float64))


