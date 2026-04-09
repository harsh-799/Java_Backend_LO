# 📘 Spring Data JPA Query Keywords — Cheat Sheet

> **General Format:**
> ```
> findBy + FieldName + Keyword
> ```

---

## 🔹 1. Basic Matching

```java
findByName(String name)       // WHERE name = ?
findByEmail(String email)     // WHERE email = ?
```

---

## 🔹 2. AND / OR Conditions

```java
findByNameAndEmail(String name, String email)   // WHERE name = ? AND email = ?
findByNameOrEmail(String name, String email)    // WHERE name = ? OR email = ?
```

---

## 🔹 3. Comparison Operators

### 👉 Greater / Less

```java
findByAgeGreaterThan(int age)
findByAgeLessThan(int age)
findByAgeGreaterThanEqual(int age)
findByAgeLessThanEqual(int age)
```

### 👉 Between

```java
findByAgeBetween(int start, int end)
```

---

## 🔹 4. LIKE / Search Operations 🔥

```java
findByNameContaining(String name)     // %value%
findByNameStartingWith(String name)   // value%
findByNameEndingWith(String name)     // %value
findByNameLike(String name)           // Manual LIKE
```

---

## 🔹 5. NULL Checks

```java
findByEmailIsNull()
findByEmailIsNotNull()
```

---

## 🔹 6. Boolean Conditions

```java
findByActiveTrue()
findByActiveFalse()
```

---

## 🔹 7. NOT / Negation

```java
findByNameNot(String name)
```

---

## 🔹 8. IN / NOT IN

```java
findByNameIn(List<String> names)
findByNameNotIn(List<String> names)
```

---

## 🔹 9. Ordering 🔥

```java
findByNameOrderByAgeAsc(String name)
findByNameOrderByAgeDesc(String name)
```

---

## 🔹 10. Ignore Case

```java
findByNameIgnoreCase(String name)
```

---

## 🔹 11. TOP / LIMIT

```java
findTop3ByName(String name)
findFirstByOrderByIdDesc()
```

---

## 🔹 12. EXISTS

```java
existsByEmail(String email)   // returns true / false
```

---

## 🔹 13. COUNT

```java
countByName(String name)
```

---

## 🔹 14. DELETE

```java
deleteByName(String name)
```

---

## 🧠 Combined Examples (Very Important)

```java
findByNameAndAgeGreaterThan(String name, int age)
findByEmailContainingAndActiveTrue(String email)
findByAgeBetweenAndNameStartingWith(int a, int b, String name)
```

---

## 🧠 Rule You Must Remember

> **Method name = Query**
> Spring Data JPA reads the method name and automatically generates the SQL query. No manual SQL writing needed! ✅

---

## ⚠️ Important Notes

- 👉 Field names must match entity variables exactly
- 👉 Case matters in method naming
- 👉 No SQL writing needed — Spring handles it all

---

## 🎯 Viva Questions

| Question | Hint |
|---|---|
| What are derived query methods? | Methods whose query is derived from the method name |
| How does Spring generate queries? | Parses method name keywords and builds JPQL |
| Difference between `Containing` and `Like`? | `Containing` auto-wraps with `%`, `Like` is manual |
| What is `findTop`? | Limits the number of results returned |

---

## 🧠 Final Memory Block

```
findBy        →  start the query
And / Or      →  combine conditions
GreaterThan / LessThan  →  compare values
Containing    →  search inside string
OrderBy       →  sort results
```

---

> 💡 **Pro Tip:** Combine multiple keywords to build powerful queries without writing a single line of SQL!