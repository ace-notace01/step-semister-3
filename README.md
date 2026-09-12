<div align="center">

# 🚀 STEP — Semester 3

### Object-Oriented Programming • Data Structures & Algorithms

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&size=24&pause=1000&color=58A6FF&center=true&vCenter=true&width=800&lines=15+Classes.+One+Repository.+One+Journey.;Learning+Java+%7C+OOP+%7C+DSA;Code.+Debug.+Learn.+Repeat.+%F0%9F%94%A5" alt="Typing SVG" />

<br><br>

<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
<img src="https://img.shields.io/badge/OOP-Concepts-6A5ACD?style=for-the-badge" />
<img src="https://img.shields.io/badge/DSA-Learning-2E8B57?style=for-the-badge" />
<img src="https://img.shields.io/badge/Git-GitHub-181717?style=for-the-badge&logo=github&logoColor=white" />
<img src="https://img.shields.io/badge/VS%20Code-007ACC?style=for-the-badge&logo=visualstudiocode&logoColor=white" />

<br><br>

![Repository Status](https://img.shields.io/badge/Status-In%20Progress-yellow?style=flat-square)
![STEP Classes](https://img.shields.io/badge/STEP%20Classes-5%2F15-blue?style=flat-square)
![Primary Language](https://img.shields.io/badge/Primary%20Language-Java-orange?style=flat-square)

</div>

---

# 👋 About This Repository

Welcome to my **STEP Semester 3** repository.

This repository documents my journey through **15 STEP classes**, covering Java programming, Object-Oriented Programming, Data Structures & Algorithms, assignments, and practice problems.

The repository is organized using Git branches so that every week's work remains independent, structured, and easy to navigate.

> ### 💡 Learn → Practice → Build → Debug → Improve → Repeat 🔁

---

# 📊 STEP Progress

## Overall Progress

```text
5 / 15 Classes Completed

███████░░░░░░░░  33.3%
```

### 📚 Class-by-Class Progress

| Class | Progress | Status |
|:---:|:---:|:---:|
| 🟢 **Week 01** | `███████████████` 100% | ✅ Complete |
| 🟢 **Week 02** | `███████████████` 100% | ✅ Complete |
| 🟢 **Week 03** | `███████████████` 100% | ✅ Complete |
| 🟢 **Week 04** | `███████████████` 100% | ✅ Complete |
| 🟢 **Week 05** | `███████████████` 100% | ✅ Complete |
| ⚪ **Week 06** | `░░░░░░░░░░░░░░░` 0% | 🔜 Upcoming |
| ⚪ **Week 07** | `░░░░░░░░░░░░░░░` 0% | 🔜 Upcoming |
| ⚪ **Week 08** | `░░░░░░░░░░░░░░░` 0% | 🔜 Upcoming |
| ⚪ **Week 09** | `░░░░░░░░░░░░░░░` 0% | 🔜 Upcoming |
| ⚪ **Week 10** | `░░░░░░░░░░░░░░░` 0% | 🔜 Upcoming |
| ⚪ **Week 11** | `░░░░░░░░░░░░░░░` 0% | 🔜 Upcoming |
| ⚪ **Week 12** | `░░░░░░░░░░░░░░░` 0% | 🔜 Upcoming |
| ⚪ **Week 13** | `░░░░░░░░░░░░░░░` 0% | 🔜 Upcoming |
| ⚪ **Week 14** | `░░░░░░░░░░░░░░░` 0% | 🔜 Upcoming |
| ⚪ **Week 15** | `░░░░░░░░░░░░░░░` 0% | 🔜 Upcoming |

---

# 🧠 Concepts Learned So Far

## ☕ Object-Oriented Programming

The OOP foundation developed so far includes:

```text
                     OBJECT-ORIENTED PROGRAMMING
                               │
          ┌────────────────────┼────────────────────┐
          │                    │                    │
          ▼                    ▼                    ▼
     Classes &            Encapsulation        Inheritance
      Objects
          │                    │                    │
          └────────────────────┼────────────────────┘
                               │
                               ▼
                         Polymorphism
                               │
                    ┌──────────┴──────────┐
                    ▼                     ▼
               Overloading           Overriding
                    │                     │
                    └──────────┬──────────┘
                               ▼
                          Abstraction
                               │
                    ┌──────────┴──────────┐
                    ▼                     ▼
             Abstract Classes        Interfaces
```

### OOP Topics

- [x] Classes
- [x] Objects
- [x] Constructors
- [x] Methods
- [x] Method Overloading
- [x] Encapsulation
- [x] Inheritance
- [x] Method Overriding
- [x] Polymorphism
- [x] `instanceof`
- [x] Abstract Classes
- [x] Interfaces
- [x] Access Modifiers
- [x] `this` keyword
- [x] `super` keyword
- [x] Object References
- [x] Basic Exception Handling

---


# 📚 Week 05 — Practice Problems

Week 5 focused on **Java visibility, inheritance, encapsulation, JavaBeans, immutability, and defensive programming**.

### 🔐 Problem 1 — Membership Field Reach Checker

- Classified accessibility for `private`, default/package-private, `protected`, and `public`.
- Tested access from same class, same package, different package, and subclass contexts.
- Added modifier-wise summaries of allowed and denied attempts.

### 🏛️ Problem 2 — Reference Desk Subclass Reach

- Extended access-control logic to subclass behavior across packages.
- Focused on the special `protected` cross-package rule.
- Distinguished the subclass's own type from the parent type.
- Implemented **first-denial** scanning that stops at the first denied attempt.

### 📚 Problem 3 — Book Copy Circulation Guard

- Encapsulated inventory state using private fields.
- Implemented validated `checkOut()` and `checkIn()` methods.
- Prevented copies from becoming negative.
- Prevented check-ins beyond the total inventory.
- Exposed availability through `getCopiesAvailable()`.

### ☕ Problem 4 — LibraryMember JavaBean & Security Answer Property

- Added a public no-argument constructor.
- Used JavaBean `getX()` / `setX()` naming conventions.
- Implemented the boolean `isPremiumMember()` convention.
- Made `membershipId` a **write-once** property.
- Made `securityAnswer` **write-only**.
- Applied a deterministic one-way transformation to the security answer.

### 🔒 Problem 5 — Immutable Loan Receipt & Nightly Circulation Ledger

- Used final fields for immutable receipt state.
- Applied defensive copying to the `bookIds` array.
- Used a with-style method to create a new receipt when correcting a book ID.
- Added one-time class-level initialization with a static block.
- Handled reference-only receipts separately.
- Processed null entries safely during nightly circulation.
- Used `instanceof` to distinguish reference-only and regular receipts.

> **Week 5 takeaway:** Java's access modifiers, inheritance rules, JavaBean conventions, encapsulation, immutability, and defensive copying all work together to control how objects can be accessed and modified.

---

# 🧩 Data Structures & Algorithms

The DSA foundation is being developed alongside Java and OOP.

## 📦 Data Structures

- [x] Arrays
- [x] Strings
- [x] Basic object-based data handling
- [ ] ArrayList
- [ ] Linked Lists
- [ ] Stacks
- [ ] Queues
- [ ] Hashing
- [ ] Trees
- [ ] Graphs

## ⚡ Algorithms & Problem Solving

- [x] Conditional Logic
- [x] Loops & Iteration
- [x] Array Traversal
- [x] String Manipulation
- [x] Basic Searching
- [x] Basic Problem-Solving Patterns
- [ ] Linear Search
- [ ] Binary Search
- [ ] Sorting Algorithms
- [ ] Recursion
- [ ] Time Complexity
- [ ] Space Complexity
- [ ] Tree Algorithms
- [ ] Graph Algorithms

> 📝 Topics will be updated as they are introduced during STEP.

---

# 📈 Learning Progress

```text
JAVA
████████████░░░░░░░░  Developing

OOP
██████████████░░░░░░  Strong Foundation

DSA
███████░░░░░░░░░░░░░  Building Foundation

PROBLEM SOLVING
████████████░░░░░░░░  Developing

GIT & GITHUB
██████████████░░░░░░  Comfortable
```

---

# 🌿 Branch Architecture

This repository follows a **feature-branch workflow**.

```text
                              ┌─────────────────┐
                              │      main       │
                              │   README only   │
                              └────────┬────────┘
                                       │
          ┌────────────┬───────────────┼───────────────┬────────────┐
          │            │               │               │            │
          ▼            ▼               ▼               ▼            ▼
   feature/week1  feature/week2  feature/week3  feature/week4  feature/week5
          │            │               │               │            │
          ▼            ▼               ▼               ▼            ▼
       Week 1       Week 2          Week 3          Week 4       Week 5
          │            │               │               │            │
      ┌───┴───┐    ┌───┴───┐       ┌───┴───┐      ┌───┴───┐    ┌───┴───┐
      ▼       ▼    ▼       ▼       ▼       ▼      ▼       ▼    ▼       ▼
  Assignment Practice Assignment Practice Assignment Practice ...   ...
```

### 🔒 Branch Rule

Each weekly feature branch is created **directly from `main`**.

This keeps every week's work independent:

```text
feature/week1 → Week 1 only
feature/week2 → Week 2 only
feature/week3 → Week 3 only
feature/week4 → Week 4 only
feature/week5 → Week 5 only
```

> **No mixing weeks. No accidental carry-over. Clean history.**

---

# 🗂️ Project Organization

Every week's branch follows the same structure:

```text
WeekX/
│
├── AssignmentProblems/
│   ├── Problem01.java
│   ├── Problem02.java
│   ├── Problem03.java
│   └── ...
│
└── PracticeProblems/
    ├── Problem01.java
    ├── Problem02.java
    ├── Problem03.java
    └── ...
```

Assignments and practice problems are kept separately for easier navigation and evaluation.

---

# 🛠️ Tech Stack

<div align="center">

<img src="https://skillicons.dev/icons?i=java,git,github,vscode" />

</div>

| Tool | Purpose |
|:---|:---|
| ☕ **Java** | Primary Programming Language |
| 🧠 **OOP** | Object-Oriented Programming |
| 🧩 **DSA** | Data Structures & Algorithms |
| 🔧 **Git** | Version Control |
| 🐙 **GitHub** | Repository & Branch Management |
| 💻 **VS Code** | Development Environment |

---

# 🧪 Weekly Workflow

```text
                 ┌──────────────┐
                 │  STEP CLASS  │
                 └──────┬───────┘
                        │
                        ▼
                    📖 LEARN
                        │
                        ▼
                    💻 CODE
                        │
                        ▼
                   🧩 PRACTICE
                        │
                        ▼
                    🐛 DEBUG
                        │
                        ▼
                   📝 COMMIT
                        │
                        ▼
                    🚀 PUSH
                        │
                        ▼
                   🔁 NEXT WEEK
```

---

# 📅 Semester Roadmap

```text
Week 01  ━━━━━━━━━━━━━━━━━━━━ ✅
Week 02  ━━━━━━━━━━━━━━━━━━━━ ✅
Week 03  ━━━━━━━━━━━━━━━━━━━━ ✅
Week 04  ━━━━━━━━━━━━━━━━━━━━ ✅
Week 05  ━━━━━━━━━━━━━━━━━━━━ ✅
Week 06  ──────────────────── 🔜
Week 07  ──────────────────── 🔜
Week 08  ──────────────────── 🔜
Week 09  ──────────────────── 🔜
Week 10  ──────────────────── 🔜
Week 11  ──────────────────── 🔜
Week 12  ──────────────────── 🔜
Week 13  ──────────────────── 🔜
Week 14  ──────────────────── 🔜
Week 15  ──────────────────── 🔜
```

---

# 🎯 Semester Goals

- [ ] Complete all **15 STEP classes**
- [ ] Build strong Java fundamentals
- [ ] Master core OOP concepts
- [ ] Develop DSA fundamentals
- [ ] Improve problem-solving skills
- [ ] Write clean and maintainable code
- [ ] Become comfortable with Git & GitHub
- [ ] Build projects using OOP & DSA concepts

---

# 🔥 Current Milestone

<div align="center">

## `05 / 15`

### STEP Classes Completed

```text
███████░░░░░░░░

33.3%
```

### 🏆 Weeks 1–5 Complete

**Next Target → Week 6 🚀**

</div>

---

# 💭 Development Philosophy

<div align="center">

```text
┌─────────────────────────────────────────────┐
│                                             │
│       "Don't just make the code work.       │
│        Understand why it works."            │
│                                             │
└─────────────────────────────────────────────┘
```

</div>

Every error is another concept understood.

Every solved problem is another step forward.

Every commit is a record of progress.

---

# 🗺️ The Journey

```text
              01
              │
              ▼
          FUNDAMENTALS
              │
              ▼
          JAVA + OOP
              │
              ▼
             DSA
              │
              ▼
        PROBLEM SOLVING
              │
              ▼
           PROJECTS
              │
              ▼
       🚀 SEMESTER COMPLETE
```

---

<div align="center">

## 🚀 5 / 15 — The Journey Continues

### Made with ☕ Java, 🧠 curiosity & a lot of debugging.

<br>

<img src="https://capsule-render.vercel.app/api?type=waving&color=gradient&height=120&section=footer" />

</div>
