# spec

## 文法

# 大域変数

```
instructions : { instruction }
instruction  : symbol | integer | quote | list
             | set | global | local | procedure
symbol       : ALPHA { ALPHA | DIGIT }
integer      : [ '+' | '-' ] digits [ '.' digits ]
digits       : DIGIT { DIGIT }
DIGIT        : '0' - '9'
quote        : '''' instruction
list         : '(' instructions ')'
set          : 'set' symbol
global       : 'global' variable instruction
local        : 'local' variable instruction
procedure    : 'proc' args '->' returns ':' instruction
args         : { symbol }
returns      : { symbol }
```