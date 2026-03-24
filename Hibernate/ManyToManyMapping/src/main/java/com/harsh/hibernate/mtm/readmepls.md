You suggested:

empId | empName | projectId
50    | Harsh   | 101
50    | Harsh   | 102

👉 Yes, this can store the relation, BUT:

❌ Problems (very important)
1. Data duplication
   Harsh repeated again and again
   Waste of space ❌
2. Update nightmare (Anomaly)

If name changes:

Harsh → Harsh Anand

👉 You must update every row

If you miss one → inconsistent data ❌

3. No proper identity

Without PK:

Rows are not uniquely identifiable ❌
DB integrity breaks ❌
4. Violates normalization (big interview point)

👉 This breaks 2NF / 3NF rules

✅ Why join table is correct

Instead we do:

Employee table
empId | empName
50    | Harsh
Project table
pid | projectName
101 | AI Chatbot
Join table
empId | pid
50    | 101
50    | 102
🔥 What this solves

✔ No duplication
✔ Clean structure
✔ Easy updates
✔ Proper PK possible (empId + pid)
✔ Follows normalization

🎯 Final simple truth

👉 Your idea = works logically but bad database design
👉 Join table = correct, scalable, industry standard

⚡ One killer line

👉 “We don’t remove PK to support ManyToMany, we introduce a join table to maintain normalization.”