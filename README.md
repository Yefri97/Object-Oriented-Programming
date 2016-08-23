# OBJECT ORIENTED PROGRAMMING
## Style programming code
### Summary Google C++ Style Guide
* **Header files**
* **Scoping**
* **Classes**
* **Functions**
* **Naming:** The style of a name immediately informs us what sort of thing the named entity is: a type, a variable, a function, a constant, a macro, etc., without requiring us to search for the declaration of that entity. 
  - ***Names should be descriptive,*** Avoid abbreviation.
    ```C++
	int price_count_reader; // OK
	int pc_reader; 			// Bad
    ```
  - ***File Names*** should be all lowercase and can include underscores (_) or dashes (-).
	```C++
	my_useful_class.cc
    myusefulclass.cc
	```
  - ***Type names*** should start with a capital letter and have a capital letter for each new word. No underscores.
    ```C++
    // classes and structs
    class UrlTable { ...
    class UrlTableTester { ...
    struct UrlTableProperties { ...
    ```
  - ***Variable names*** are all lowercase, with underscore between words.
    ```C++
    string table_name;  // OK
    string tableName;   // Bad
    ```
    Data members of **classes**, are named like ordinary nonmember variables, but with a trailing underscore.
    ```C++  
    class TableInfo {
       ...
      private:
        string table_name_;
    };
    ```
    Data members of **structs**, are named like ordinary nonmember variables.
  - ***Constant names*** are with a leading "k" followed by mixed case.
    ```C++
    const int kDaysInAWeek = 7;
    ```
  - ***Function names*** have mixed case
    ```C++
    AddTableEntry()
    OpenFileOrDie()
    ```
    "**Cheap**" functions may use lower case with underscores. A canonical example is an inline method that just returns one of the class's member variables.
    ```C++
    class MyClass {
      public:
       ...
        bool is_empty() { return num_entries_ == 0; }
      private:
        int num_entries_;
    };
6. **Comments**
7. **Formatting**