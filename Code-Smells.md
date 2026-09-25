# Conceptual Definition

## Long Method
A code smell referring to a method that has become excessively long or contains multiple logical responsibilities, making it more difficult to understand and maintain (Fowler et al., 1999; Zhang & Kishi, 2023). The same study by Fowler describes Extract Method as a refactoring technique that separates a logical portion of a method into a new method with a meaningful name, which is then called from the original method.

## Duplicated Code
A code smell referring to the presence of the same or substantially similar code in more than one location within a program (Fowler et al., 1999). The same paper describes **Extract Method** as one refactoring technique that can be used to consolidate duplicated code into a single method that can be called from multiple locations.

## Poor Identifier Name
A code-quality problem involving an inappropriate or misleading name assigned to a program identifier, such as a variable or function, which can make the code more difficult to understand (Řechtáčková et al., 2025). It can be addressed by **renaming the identifier** to use a more descriptive and appropriate name.

## Deeply Nested Structure
A code smell characterized by excessive nesting of control structures, particularly present in conditional statements and loops, which can make source code more difficult to understand and maintain (JetBrains, 2017; PMD, n.d.). (should be foundaional definition hehe)
https://blog.jetbrains.com/idea/2017/08/code-smells-deeply-nested-code/


# Operational Definition
## Deeply Nested Structure
According to PMD, they have a rule called "AvoidDeeplyNestedIfStmts" that has a default value of 3.
https://pmd.github.io/pmd/pmd_rules_java_design.html#avoiddeeplynestedifstmts

code sample:
```
public class Foo {
  public void bar(int x, int y, int z) {
    if (x>y) {
      if (y>z) {
        if (z==x) {
         // !! too deep
        }
      }
    }
  }
}
```

## Long Method
A method is classified as a Long Method when it contains **more than 30 statements**. Methods containing **15 to 30 statements are treated as borderline cases requiring manual evaluation**, while methods containing fewer than 15 statements are treated as having a low possibility of being a Long Method. (Zhang and Kishhi 2023)
https://www.jstage.jst.go.jp/article/ipsjjip/31/0/31_469/_pdf

questions proposed by zhang and kishi to identify long methods:
- Is the method difficult to read?
- Does it access too many attributes or methods in a way that may hurt maintainability?
- Does it contain multiple functions or too many parameters that may reduce reusability?

code sample:
```
public void calculateGrades() {
    int total = 0;                    // 1
    int count = 0;                    // 2

    for (int i = 0; i < grades.length; i++) {  // 3
        if (grades[i] >= 75) {                 // 4
            total += grades[i];                // 5
            count++;                            // 6
        }

        // ... more statements ...
    }

    // ... more statements ... basta hanggang 30 muahaha
}
```

## Duplicated Code
Quradaa et al. 2024 defines duplicated code (or code clones) with four types:
- **Type I** — essentially identical, with minor differences such as comments/formatting
- **Type II** — syntactically identical except for things like identifiers/literals
- **Type III** — similar code with added/removed/modified statements
- **Type IV** — functionally/semantically similar code despite greater syntactic differences.
https://journals.plos.org/plosone/article?id=10.1371/journal.pone.0302333
Duplicated Code can be operationalized as the presence of similar or identical code fragments, which can be detected through code-clone analysis using representations such as ASTs.

For JCleanCode, Duplicated Code is limited to Type-I and Type-II code clones, representing duplicated Java code fragments that are identical or structurally equivalent except for non-functional differences such as formatting, comments, identifiers, and literals.

sample code:

type i:
```
// Fragment A
int total = 0;
for (int i = 0; i < 5; i++) {
    total += i;
}
return total;

// Fragment B
int total=0;
for(int i=0;i<5;i++){
    total+=i;
}
return total; // same code, different formatting/comment
```

type ii:
```
// Fragment A
int total = 0;
for (int i = 0; i < 5; i++) {
    total += i;
}
return total;

// Fragment B
int sum = 0;
for (int index = 0; index < 5; index++) {
    sum += index;
}
return sum;
```

type iii:
```
// Fragment A
int total = 0;
for (int i = 0; i < 5; i++) {
    total += i;
}
return total;

// Fragment B
int total = 0;
for (int i = 0; i < 5; i++) {
    if (i > 0) {
        total += i;
    }
}
return total;
```

type iv:
```
// Fragment A — using a loop
int total = 0;
for (int i = 0; i < 5; i++) {
    total += i;
}
return total;

// Fragment B — using a mathematical formula
return 5 * (5 - 1) / 2;
```

additional reading (although not used yet): https://www.frontiersin.org/journals/computer-science/articles/10.3389/fcomp.2024.1455860/full

## Poor Identifier Naming

Java naming convention
```
// Variable
int studentCount;

// Method
calculateAverage();

// Class
StudentRecord;

// Constant
MAX_STUDENTS;

// Package
com.example.jcleancode;
```
Identifier naming is an important aspect of source-code quality because identifier names provide information that programmers use when understanding code. Herka (2023), through a review of 33 studies, examined identifier structure, semantics, and quality measures and found that the quality and structure of identifiers can affect programmer comprehension and performance. The review also discussed identifier quality in terms of correctness, consistency, and conciseness, emphasizing that poorly chosen names may make program concepts more difficult to understand. These findings support the use of naming conventions and measurable naming rules when evaluating identifiers in source code.
https://ac-psych.org/index.php/en/download-pdf/page/26/volume/19/issue/3/id/409