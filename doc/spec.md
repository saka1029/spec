# spec

## 文法

# 大域変数

```
instructions : { instruction }
instruction  : symbol | integer | quote
             | list | procedure
symbol       : ALPHA { ALPHA | DIGIT }
integer      : [ "+" | "-" ] DIGIT { DIGIT }
DIGIT        : "0" - "9"
quote        : "'" instruction
list         : "(" instructions ")"
procedure    : "[" symbols [ "-" symbols ]
                ":" instructions "]"
symbols      : { symbol }
```