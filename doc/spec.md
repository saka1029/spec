# spec

## 文法

# 大域変数

```
instructions : { instruction }
instruction  : symbol | integer | quote | list | procedure
symbol       : ALPHA { ALPHA | DIGIT }
integer      : [ '+' | '-' ] digits [ '.' digits ]
digits       : DIGIT { DIGIT }
DIGIT        : '0' - '9'
quote        : '''' instruction
list         : '(' instructions ')'
procedure    : 'proc' args [ '->' returns ] ':' instruction
args         : { symbol }
returns      : { symbol }
```