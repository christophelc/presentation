```julia
function myplus(x,y)
    x+y
end
```




    myplus (generic function with 1 method)




```julia
code_llvm(myplus, (Int64, Int64))
```

    
    ;  @ In[9]:2 within `myplus'
    define i64 @julia_myplus_17726(i64, i64) {
    top:
    ; ┌ @ int.jl:53 within `+'
       %2 = add i64 %1, %0
    ; └
      ret i64 %2
    }



```julia
code_llvm(myplus, (Int64, Float64))
```

    
    ;  @ In[9]:2 within `myplus'
    define double @julia_myplus_17727(i64, double) {
    top:
    ; ┌ @ promotion.jl:311 within `+'
    ; │┌ @ promotion.jl:282 within `promote'
    ; ││┌ @ promotion.jl:259 within `_promote'
    ; │││┌ @ number.jl:7 within `convert'
    ; ││││┌ @ float.jl:60 within `Float64'
           %2 = sitofp i64 %0 to double
    ; │└└└└
    ; │ @ promotion.jl:311 within `+' @ float.jl:401
       %3 = fadd double %2, %1
    ; └
      ret double %3
    }



```julia

```
