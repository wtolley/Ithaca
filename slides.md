---
theme: seriph
background: https://cover.sli.dev
class: 'text-center'
highlighter: shiki
info: |
  ## More Hashing Techniques

  Learn about probing, clustering, and double hashing.
transition: slide-left
title: "More Hashing Techniques"
mdc: true
---

# Advanced Hashing Techniques
## Probing, Clustering, and Double Hashing

<br>

### William J. Tolley
---

# Goals for Today
<br>

1. Understand probing as a method for collision resolution
2. Discuss and analyze clustering problems
3. Learn about double hashing as a solution
4. Engage in hands-on activities to apply these techniques
---


# Review: Basics of Hashing
## Why Use Hashing?
<br>

- **Purpose**: Efficiently map keys to values using a **hash function**
- **Goal**: Achieve \( O(1) \) average-case time complexity for:
  - Lookups
  - Insertions
  - Deletions
- **Challenge**: Handle collisions effectively

---

# What Is a Hash Function?
## The Foundation of Hashing
<br>

- A **hash function** maps a key to an index in a fixed-size array:
  - `index = hash(key) % table size`

**Question for Students**:  
- "If you were designing a hash function, what features would you want it to have?"

<br>

---

# What Is a Hash Function?
## The Foundation of Hashing

- **Key Features**:
  - Deterministic: Same key → Same hash value
  - Uniform Distribution: Minimize clustering
  - Efficient: Fast to compute (\( O(1) \))

---

# Hash Tables: Key Advantages
<br>

- **Efficiency**: Average-case \( O(1) \) operations
- **Scalability**: Can handle large datasets with appropriate resizing
- **Simplicity**: Provides direct mapping from keys to values

**Follow-Up Question**:  
- "What might go wrong when two keys map to the same index?"

---

# The Collision Problem
<br>

- **Definition**: A collision occurs when multiple keys map to the same index
- **Impact**: Collisions disrupt the \( O(1) \) performance promise of hash tables

**Example**:
- `hash("A") % 10 = 3`
- `hash("B") % 10 = 3`

**Discussion Prompt**:  
- "How would you resolve collisions in a hash table?"

---

# Wrapping Up the Basics
<br>

- Hash tables rely on **efficient hash functions** to map keys to indices
- Collisions are inevitable; resolving them is key to maintaining performance
- Today, we’ll explore advanced methods for handling collisions:
  - **Linear Probing**
  - **Quadratic Probing**
  - **Double Hashing**

---

# Prompt: Solving Collisions Without Extra Space
<br>

**Scenario**:
- You cannot use separate chaining (linked lists or other external structures).
- The hash table size is fixed, and you must resolve collisions within the array.

**Question for Students**:
- "How would you resolve collisions in this situation?"
- Discuss in small groups for 3 minutes.

---

# Introduction to Probing
## Resolving Collisions In-Place
<br>

- **Probing**: Search for the next available slot within the array itself.
- **Why Use Probing?**:
  - Works entirely within the hash table.
  - Avoids additional memory usage.

**Types of Probing**:
1. Linear Probing
2. Quadratic Probing
3. Double Hashing

**Follow-Up Question**:
- "What challenges might arise when searching for the next available slot?"

---

# Linear Probing
## Sequential Search for the Next Slot
<br>

- **How It Works**:
  - Start at the collision index.
  - Check the next slot sequentially (wrap around if needed).

- **Formula**:
  - `index = (hash(key) + i) % table size`

<br>

**Key Problem**:
- **Primary Clustering**: Adjacent keys form large blocks, degrading performance.

---

# Quadratic Probing
## Reducing Primary Clustering
<br>

- **How It Works**:
  - Probe at quadratic intervals:
    - `index = (hash(key) + i^2) % table size`

- **Key Benefit**:
  - Reduces primary clustering.

- **Important Note**:
  - Works best when the table size is a prime number.

---

# Double Hashing
## Breaking Clustering with Two Hash Functions
<br>

- **How It Works**:
  - Use a second hash function to determine the step size:
    - `index = (hash1(key) + i * hash2(key)) % table size`

- **Key Benefit**:
  - Minimizes clustering by varying probe patterns.

- **Key Rule**:
  - Ensure `hash2(key) != 0` to probe all slots.

---

# Activity: Comparing Probing Methods
<br>

1. Insert the following keys into a hash table of size 7:
   - `10, 20, 15, 7, 33`
2. Apply all three probing methods:
   - Linear Probing
   - Quadratic Probing
   - Double Hashing

<br>

**Questions**:
- "Which method distributed keys most evenly?"
- "Which method handled collisions most effectively?"

---

# Wrapping Up Probing Methods
<br>

- **Probing resolves collisions** without external structures.
- Each method has trade-offs:
  - **Linear Probing**: Simple but prone to clustering.
  - **Quadratic Probing**: Reduces clustering but requires careful design.
  - **Double Hashing**: Most effective but computationally expensive.


---

# What Is Clustering?
## A Performance Issue in Probing
<br>

- **Primary Clustering**:
  - Keys with the same or similar hash values create long blocks of occupied slots.
  - Occurs in **linear probing** as collisions cause sequential slot filling.

- **Secondary Clustering**:
  - Keys with the same initial hash value follow the same probe sequence.
  - Occurs in **quadratic probing** and partially in **double hashing**.

**Impact**:
- Degrades performance, turning \( O(1) \) operations into \( O(n) \).

---

# Example of Clustering
## Visualizing the Problem
<br>

1. Insert keys: `10, 20, 15, 7, 33` into a hash table of size 7.
2. **Linear Probing**:
   - `10 → index 3`
   - `20 → index 4`
   - `15 → index 5`
   - `7 → index 6`
   - `33 → index 0`

<br>

**Result**:
- A large cluster forms across indices `[3, 4, 5, 6, 0]`.

**Question**:
- "Why does clustering occur more frequently in linear probing?"

---

# Discussion: Effects of Clustering
<br>

**Small Group Question**:
- "How does clustering affect performance during insertions, lookups, and deletions?"

---

# Strategies to Address Clustering
## Key Solutions
<br>

1. **Load Factor Management**:
   - Keep the load factor below 0.75.
   - Resize the table when necessary.

2. **Quadratic Probing**:
   - Spreads out collisions by increasing probe distances.

3. **Double Hashing**:
   - Breaks deterministic patterns with a second hash function.

4. **Prime-Sized Arrays**:
   - Ensures quadratic probing covers all slots.

---

# Activity: Testing Clustering Solutions
<br>

1. Use a hash table of size 7 with the same keys: `10, 20, 15, 7, 33`.
2. Test the following solutions:
   - Reduce the load factor (resize the table).
   - Use quadratic probing.
   - Use double hashing.

<br>

**Questions**:
- "Which solution reduced clustering most effectively?"
- "What trade-offs did you observe?"

---

# Pair Programming Assignment
## Implementing Quadratic Probing with Resizing
<br>

### **Goals**:
1. Implement a hash table with **quadratic probing** for collision resolution.
2. Complete the `insert`, `search`, and `resize` methods.
3. Ensure resizing occurs when the load factor exceeds 0.75.

---

# Problem Definition
## Quadratic Probing with Resizing
<br>

- **Collision Resolution**:
  - When a collision occurs, probe at quadratic intervals:
    - `index = (hash(key) + i^2) % table size`
  - Spread out collisions to reduce clustering.

- **Resizing**:
  - Resize the table when the load factor exceeds 0.75:
    - Allocate a new table with a larger prime size.
    - Rehash all existing keys into the new table.

---

## Methods to Implement

1. **`insert(String key)`**:
   - Hash the key.
   - Use quadratic probing to find the next available slot.
   - Insert the key into the table.
   - Check the load factor after each insertion and resize if needed.

2. **`search(String key)`**:
   - Hash the key.
   - Use quadratic probing to locate the key in the table.
   - Return `true` if the key exists, `false` otherwise.

3. **`resize()`**:
   - Allocate a new table with a larger prime size.
   - Rehash all keys from the old table into the new table.

---

# Resizing Logic
## Steps for Resizing
<br>

1. **Calculate New Table Size**:
   - Choose the next prime number greater than `2 * old size`.

2. **Rehash Keys**:
   - For each key in the old table:
     - Compute the new index using the new table size.
     - Insert the key into the new table using quadratic probing.

3. **Update References**:
   - Replace the old table with the new table.

---

# Instructions for Groups
<br>

1. **Work in Pairs**:
   - Collaborate to implement `insert`, `search`, and `resize`.
   - Discuss logic before coding.
2. **Starter Code Provided**:
   - Use the Java starter code as your base.
3. **Test Your Code**:
   - Verify functionality with sample inputs.
   - Ensure resizing works correctly when the load factor exceeds 0.75.

---

# Questions to Consider
<br>

- How does resizing impact the hash table’s performance?
- Why do we use a prime-sized table after resizing?
- What trade-offs are involved in choosing when to resize?

---

# Submission Guidelines
<br>

1. **Code Submission**:
   - Submit your completed `QuadraticProbingHashTable.java` file.
2. **Test Cases**:
   - Include test cases for `insert`, `search`, and `resize` methods.
3. **Reflection**:
   - Write a brief reflection on:
     - What you learned.
     - Challenges faced.
     - How you collaborated with your partner.

---

# Time to Code!
## Pair Up and Start Working
<br>

- Focus on completing all required methods.
- Test thoroughly, especially for resizing behavior.
- Ask for help if you get stuck!