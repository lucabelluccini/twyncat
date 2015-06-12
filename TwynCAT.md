# Introduction #

In this page we are proposing some examples and features of TwynCAT.

# Details #

```
prog get1channelFast:
       T_DCTIME BufferLatchPosEL1252ACh1, 
                diff1[1:250000],              
                diff2[1:250000], 
                diff3[1:250000], 
                diff4[1:250000], 
                diff5[1:16000]
       bool first = True, different
       udint skip = 1000
       # Inizializzazione
       if skip != 0:
              BufferLatchPosEL1252ACh1 = LatchPosEL1252ACh1
              skip = skip - 1
       else:
              # Cerco se il timestamping e' differente dal precedente
              # Non serve testare la parte alta se il periodo e' inferiore a 4 secondi
              if (LatchPosEL1252ACh1.dwLowPart != BufferLatchPosEL1252ACh1.dwLowPart):
                     different = True
              else:
                     different = False
              udint cnt = 0,
                    nexp = 1016000,
                    array_num = 0
              if cnt < (nexp + 1):
                     if different:
                            case array_num:
                                   0: 
                                          diff1[cnt] = LatchPosEL1252ACh1;
                                   1:
                                          diff2[cnt-250000] = LatchPosEL1252ACh1;
                                   2:
                                          diff3[cnt-500000] = LatchPosEL1252ACh1;
                                   3:
                                          diff4[cnt-750000] = LatchPosEL1252ACh1;
                                   4:
                                          diff5[cnt-1000000] = LatchPosEL1252ACh1;
                                   default:
                            array_num = cnt / 250000
                            cnt = cnt + 1

              # Tengo traccia di quando e' stato fatto il vecchio cambiamento di fronte
              if different:
                     BufferLatchPosEL1252ACh1 = LatchPosEL1252ACh1
```

## Data definitions ##

Can be declared within statements.
Variables must be already declared or just declared at first usage.
They'll be in the scope of the current functional block (program or function).
More than 1 variables of the same type will be accepted in a single line.

```
{in | out | inout}?.{<sdt> | <udt> } <variable name> # variable
{in | out | inout}?.<sdt> <variable name>[<lower limit>:<up limit>] # 1-dim array
{in | out | inout}?.{retain | persistent | constant}.<sdt> <variable name>
```

```
enum <enumeration name> : {enum { = <initialization> }? }+
```

```
pointer {<data type> | <function block name>} <pointer name>
```

```
subrange <sdt> <subrange name> <lower limit>:<up limit>
```

```
structure <structure name>:
    <Declaration of Variable 1> 
    . 
    . 
    <Declaration of Variable n>
```

```
{in | out | mem}.location <memory location alias> @ <location> {bit | byte | word | dword | config} 
```

### Error checking ###

Will be checked:
  * Indent / Dedent structure
  * Syntax errors
  * Type checking (strong typed on the left side of the assignment)

### Functional blocks ###

For each Twyncat file, will be allowed:
  * Global variables
  * 0 or more Function Blocks
  * No procedures
  * A program Blocks

### Statements ###

All the statements of Twincat are supported also in Twyncat, but with a slightly different syntax.
Function calls will check for correct arguments, correct number of arguments and type.

### Standard Library ###
Types, variables, constants defined in Std Lib will be added using external text files.
The user will be warned of not declared stuff during translation.

### Constants ###
```
True                    # Boolean True
False                   # Boolean False
14                      # Decimal Number
7.4                     # Decimal Number
1.64e+009               # Decimal Number
b!10010011              # Binary Number
o!67                    # Octal Number
h!1AF6                  # Hexadecimal Number
\$                      # Dollar signs
\'                      # Single quotation mark
\l                      # Line feed
\n                      # New line
\p                      # Page feed
\r                      # Line break
\t                      # Tab
t!1d23h59m59s999ms      # Time
tod!99:98:97.654        # Time of Day
d!2012-02-06            # Date
dt!1986-08-05-10:30     # Date and Time
```