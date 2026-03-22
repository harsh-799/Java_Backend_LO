## 🔥 Why caching even exists?

👉 Problem:
Every time you hit DB → slow + expensive

👉 Solution:
Store data in memory → reuse → fast 🚀

## 🧠 Two levels in Hibernate
| Cache    | Scope                |
| -------- | -------------------- |
| L1 Cache | Session level        |
| L2 Cache | SessionFactory level |


### 🔥 1. L1 Cache (First Level Cache)
👉 Default in Hibernate (always ON)

👉 Scope: Per Session

####  🧠 Why?

👉 Hibernate stores object in session memory

⚠️ Important points  
- Automatically enabled  
- Cannot disable  
- Cleared when session closes  


### 🔥 2. L2 Cache (Second Level Cache)

👉 NOT enabled by default ❌  
👉 Scope:
Across sessions

👉 Without L2:
DB hit again ❌ (Across session)

👉 With L2:
No DB hit ✅ (Across Session)

⚠️ Important  

You must:
- Enable L2 cache
- Use provider (Ehcache, etc.)

## 🔥 L1 vs L2 (INTERVIEW GOLD)
| Feature                | L1 Cache | L2 Cache       |
| ---------------------- | -------- | -------------- |
| Scope                  | Session  | SessionFactory |
| Default                | ✅ Yes    | ❌ No           |
| Shared across sessions | ❌ No     | ✅ Yes          |
| Config required        | ❌ No     | ✅ Yes          |


## 🔥 Hidden Interview Trap

👉 Question:
Does Hibernate check L2 before L1?

❌ NO

👉 Order:

- L1 Cache
- L2 Cache
- Database

## ⚠️ Very Important Limitation

👉 L1 & L2 cache store data by ID only

❌ Not for queries like:

find by name
find all users