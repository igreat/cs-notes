## `scanf`
**Input With `scanf`**:
```c
int scanf ( const char * format, ... );
```
Reads data from `stdin` and stores them to parameters according to the `format` specified, and returns *the number of fields which were successfully converted and assigned*.

**Caveats With `scanf`**:
- `scanf` upon being called will wait for the input buffer to be filled with something and then it will try to match whatever is in there with the format. 
- If it fails, it will leave whatever is in the input buffer as is.
- If we call another `scanf`, it will NOT wait for input as the input buffer is NOT empty, and that might lead to a propagating failing `scanf`s

**Solutions**:
- Don't use `scanf` and opt for `fgets`, and then parse the string as a separate step but this actually still has a similar issue in that buffer isn't cleared if input is larger than `fgets`s size argument
- Always check if the `scanf` was successful, and if not clear the buffer and try again. But generally always clear the buffer after `scanf` is called as follows:

```c
void clear_buffer() {
	int c;
	while ((c = getchar()) != '\n' && c != EOF);
}
```

## `fgets`
**Input with `fgets`**:
```c
char * fgets ( char * str, int num, FILE * stream );
```
Reads character from `stream` (could be `stdin`) and stores them as a C string into `str` until (`num - 1`) characters have been read or either a `'\n'` or `EOF` is reached, whichever happens first.
Return value is essentially `NULL` (the null pointer) if a failure occurred or the `str` itself if success.

**Caveats with `fgets`**:
- The `'\n'` will end up in the string when it's the termination condition, so I have to always remember to replace it with `'\0'` using `str[strlen(str) - 1] = '\0'.
- If input given is larger than `num`, the rest of the input is gonna stay in input buffer and must be cleared or it can also cause propagating unpredictable behaviour.

## Convenience Library Functions 
```c
long int strtol (const char* str, char** endptr, int base);
```
Converts a string `str` to a **long**. `endptr` is the pointer to the first character after the number.

```c
float strtof (const char* str, char** endptr);
```
Converts a string `str` to a **float**. `endptr` is the pointer to the first character after the number.

```c
double strtod (const char* str, char** endptr);
```
Converts a string `str` to a **double**. `endptr` is the pointer to the first character after the number.

```c
char * strtok ( char * str, const char * delimiters );
```
Splits `str` by the `delimiters`.

```c
/* strtok example */
#include <stdio.h>
#include <string.h>

int main() {
    char str[] = "- This, a sample string.";
    char* pch;
    printf("Splitting string \"%s\" into tokens:\n", str);
    pch = strtok(str, " ,.-");
    while (pch != NULL) {
        printf("%s\n", pch);
        // when given NULL, strtok knows to go to next token from the previous string
        pch = strtok(NULL, " ,.-");
    }
    return 0;
}
```