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