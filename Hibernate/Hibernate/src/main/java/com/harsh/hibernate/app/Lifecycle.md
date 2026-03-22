# 🧠 Entity Lifecycle in Hibernate

An object in Hibernate can be in **4 states**:

**Transient → Persistent → Detached → Removed**

---

## 1️⃣ Transient State

👉 Object is just created using `new`
👉 NOT connected to Hibernate
👉 NOT saved in DB

```java
Student s = new Student();
s.setsName("Harsh");
```

✔️ Exists only in memory
❌ No DB interaction

### 🧠 Key point

Hibernate doesn’t even know this object exists

---

## 2️⃣ Persistent State (🔥 MOST IMPORTANT)

👉 Object is now connected to Hibernate session

```java
Student s = session.get(Student.class, 1);
```

**OR**

```java
session.persist(s);
```

### 🔥 What makes it powerful?

👉 Hibernate tracks every change

```java
s.setsName("Updated Name");
```

👉 You don’t call `update()` ❌
👉 Hibernate auto updates on commit ✅

### 🧠 Key concept

This is called **Dirty Checking**

### ⚡ Internal flow

Persistent object → change detected → commit → `UPDATE` query

---

## 3️⃣ Detached State

👉 Object was persistent, but session is closed

```java
session.close();
```

Now:

```java
s.setsName("New Name");
```

❌ Hibernate does NOT track this

### 🧠 Key point

Object exists, but Hibernate is not watching it

### 🔥 How to fix?

```java
session.merge(s);
```

👉 Reattaches object

---

## 4️⃣ Removed State

👉 Object marked for deletion

```java
session.remove(s);
```

👉 On commit:

```sql
DELETE FROM student WHERE id = ?
```

---

## 🧠 Full Lifecycle Flow

```
new → Transient  
persist/get → Persistent  
session.close → Detached  
remove → Removed  
```

---

## 🔥 Real Example (connect everything)

```java
Session session = factory.openSession();
Transaction tx = session.beginTransaction();

Student s = session.get(Student.class, 1); // Persistent

s.setsName("Harsh Updated"); // Dirty checking

tx.commit(); // UPDATE happens automatically

session.close(); // Detached
```

---

## ⚡ Visual Analogy

Think of Hibernate like a **CCTV camera 📹**

| State      | Meaning                |
| ---------- | ---------------------- |
| Transient  | Not in camera view     |
| Persistent | Under camera (tracked) |
| Detached   | Camera turned off      |
| Removed    | Marked to delete       |

---

## 🚀 Why this is IMPORTANT

This explains:

* Why `update()` is not needed
* Why `merge()` exists
* Why changes auto-save
* Why session matters

---

## ⚡ Interview Answer

In Hibernate, an entity can be in **Transient, Persistent, Detached, or Removed state**.
Hibernate tracks changes only in the **Persistent state** and automatically synchronizes them with the database during transaction commit.

---

## 🧠 Golden line (remember this)

🔥 **Hibernate only works automatically when object is in Persistent state**
