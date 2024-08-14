# spec

## 文法

# 大域変数

```
instructions : { instruction }
instruction  : variable | integer | quote | list | global | local | procedure
variable     : ALPHA { ALPHA | DIGIT }
integer      : [ '+' | '-' ] digits [ '.' digits ]
digits       : DIGIT { DIGIT }
DIGIT        : '0' - '9'
quote        : '''' instruction
list         : '(' instructions ')'
global       : 'global' variable instruction
local        : 'local' variable instruction
procedure    : 'proc' ARGS '->' RETURNS ':' instruction
```