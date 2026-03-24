# 🔥 Hibernate Cascade Types

## 📌 What is Cascade?

Cascade defines how operations performed on a parent entity are automatically applied to its related child entities.

> 👉 “Cascade propagates operations from parent to child”

---

## 🚀 Why do we need Cascade?

Without cascade:

* We must manually persist/update/delete related entities ❌
* Easy to forget → leads to errors ❌

With cascade:

* Hibernate handles related entities automatically ✅
* Cleaner and safer code ✅

---

## 🔑 Types of Cascade

### 1. CascadeType.PERSIST

> 👉 When parent is saved → child is also saved

```java
@ManyToMany(cascade = CascadeType.PERSIST)
```

✔ Saves new related entities automatically
❌ Without it → "transient object reference" error

---

### 2. CascadeType.MERGE

> 👉 When parent is updated → child is also updated

```java
@ManyToMany(cascade = CascadeType.MERGE)
```

✔ Updates related entities
❌ Without it → child changes not saved

---

### 3. CascadeType.REMOVE

> 👉 When parent is deleted → child is also deleted

```java
@ManyToMany(cascade = CascadeType.REMOVE)
```

⚠️ Dangerous in ManyToMany

---

### 4. CascadeType.REFRESH

> 👉 Reloads entity state from DB (overwrites changes)

---

### 5. CascadeType.DETACH

> 👉 Removes entity from persistence context

---

### 6. CascadeType.ALL

> 👉 Applies ALL operations

```java
cascade = CascadeType.ALL
```

Includes:

* PERSIST
* MERGE
* REMOVE
* REFRESH
* DETACH

---

## ⚠️ Important Warning (Very Important)

### ❌ Never use REMOVE in ManyToMany

Why?

Because entities are usually shared.

Example:

```
emp1 ↔ project1  
emp2 ↔ project1  
```

If emp1 is deleted:

❌ project1 should NOT be deleted
✔ Only relation should be removed

---

## ✅ Recommended Cascade for ManyToMany

```java
cascade = {CascadeType.PERSIST, CascadeType.MERGE}
```

✔ Safe
✔ Prevents accidental deletion
✔ Handles save + update

---

## 🧠 What happens on delete (ManyToMany)

```java
session.remove(emp);
```

Hibernate does:

1. Delete from join table
2. Delete parent entity
3. DOES NOT delete child entities

---

## 🔥 Key Rules

* Cascade works from **owner side**
* Cascade is applied on **relationship annotations** (`@ManyToMany`, `@OneToMany`, etc.)
* Do NOT put cascade inside `@JoinTable`

---

## 🎯 One-Line Summary

> 👉 "Cascade controls how operations on parent affect child entities"

---

## 💡 Interview Points

* CascadeType.ALL is risky in ManyToMany
* REMOVE should be used carefully
* PERSIST + MERGE is safest combination
* Cascade reduces boilerplate code

---

## 🚀 Example

```java
@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
@JoinTable(
    name = "emp_project_relation",
    joinColumns = @JoinColumn(name = "emp_id"),
    inverseJoinColumns = @JoinColumn(name = "project_id")
)
List<Project> projects;
```

---

## 🧠 Final Takeaway

> 👉 Use cascade for convenience, but always understand its impact on data.
