#Cron Paser

A small program that parses a cron string and expands each field to show the times at which it will run.


This only considers the standard cron format with five time fields (minute, hour, day of
month, month, and day of week) plus a command.

It is implementing the scheme that can be found here:
http://www.baeldung.com/cron-expressions

For example given the input argument:
```
*/15 0 1,15 * 1-5 /usr/bin/find
```

The output should be:
```
minute 0 15 30 45
hour 0
day of month 1 15
month 1 2 3 4 5 6 7 8 9 10 11 12
day of week 1 2 3 4 5
command /usr/bin/find