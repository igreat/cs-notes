## Type of Memory 
- RAM: Random Access Memory. Volatile
- ROM: Read Only Memory. Non-volatile
- EEPROM: Erasable Programmable Read Only. Non-volatile
- Flash Memory: Non-volatile but can easily re-written many times (to a limited extent)
- Cache Memory: Very fast, but expensive and limited capacity

![[Screenshot 2024-05-03 at 3.36.35 PM.png]]
## Buses
- **Control Bus**: Interrupts, read/write signals, status, enable/disable
- **Address Bus**: Memory address to read/write data
- **Data**: carry data to/from CPU, memory and devices 

![[Screenshot 2024-05-03 at 6.32.36 PM.png]]

## C Program Address Space
![[Screenshot 2024-05-03 at 6.32.57 PM.png]]
## Stack
- Calling a function creates a new stack frame
- The frame memory is deallocated when the function returns 
- If stack grows too large, memory will be exhausted (stack overflow)
- The stack frame is where local and parameter values are stored (hence local variables are stored in stack)
## Virtual Memory 
**Processes**:
- For complex OS (Unix/Windows), a process is allocated to run each program
- Many processes can co-exist
- Can run concurrently on a multi-core machine, but interleaved when more processes than cores
- All processes share the same physical **RAM**

|                                                                                                                                                                                                                                                                                                                                                                                        |                                              |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------- |
| **Virtual Memory**:<br>○ Memory is divided into *pages* Each process is given an ideal **virtual memory space**, made up of contiguous virtual pages<br><br>○ The virtual space is mapped onto the physical memory<br><br>○ A process need only worry about its own virtual memory space, the rest is taken care of by the OS/MMU (Memory Management Unit, which is hardware actually) | ![[Screenshot 2024-05-03 at 6.49.34 PM.png]] |
|                                                                                                                                                                                                                                                                                                                                                                                        |                                              |
**Paging**:
- All processes combined will have many more virtual pages than available physical pages (e. g., 16 GByte physical, 50 GByte virtual)
- Thus, virtual memory allows processes to use more memory than is physically present in main memory
- Pages not currently needed will be swapped to disk (swap memory), and reloaded when needed. This can lead to performance overhead and potentially thrashing

**Mapping**:
- A **page table** maps from a *virtual page* to a *physical page*
- But typically the mapping isn't a single operation, but is multi-level

**C Pointer**:
*Virtual memory address*, not physical memory number.
Example address format:

| Status bits | PTL1 | PTL2 | PTL3 | Offset |
| ----------- | ---- | ---- | ---- | ------ |
- PTL1, 2 and 3 are indexes into the top level, 2nd level and 3rd level page tables. These eventually identify a physical memory page
- Offset is the location within the physical page being accessed
- Status bits include, read, write, execute, valid/invalid, swapped out.
![[Screenshot 2024-05-03 at 7.02.53 PM.png]]
- Incrementing past the last location in a page returns the page offset to zero and increments to the next virtual address.
	- This gives the illusion of a linear address space, a pointer can access every location in sequence up to the last location in the address space.

## Root, OS and Device Drivers
![[Screenshot 2024-05-03 at 7.14.55 PM.png]]

## Threads
A sequence of control. A sequence of function calls in C.

C programs can be multi-threaded.
- Multiple sequences of control within the **same** process
- All threads share the **same** memory space
	- Race conditions big pain
- Threads can run concurrently on multi-core machine (like the POTIX Threads or Pthreads C libraries)

 