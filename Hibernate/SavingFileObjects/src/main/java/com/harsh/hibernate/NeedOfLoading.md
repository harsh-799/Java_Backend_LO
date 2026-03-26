## 🔥 Next-Level Thought (important)

Right now:

byte[] images;

👉 This means:

**Every time you fetch Dog → image also loads**

## 🧪 Quick thinking

If you have:

1000 dogs
Each image = 2MB

👉 What happens if you use EAGER loading?  
- Boom it'll take so much time just to search that so there the concept of loading comes.

## 👉 Question:

- Should dog.getImages() load automatically?
- Or only when you call it?

## 🔥 This is where fetching strategies come in


## 1. ⚡ 2. EAGER Loading  

**✅ Definition:** Data is loaded immediately along with parent
```java
@Lob
@Basic(fetch = FetchType.EAGER)
private byte[] images;
```

Behavior:

```java
Dog dog = session.get(Dog.class, 1);
```

👉 Hibernate loads:

Dog ✔️  
Image ✔️ (even if you don’t use it)

### ❌ Problem:
Memory heavy  
Slow  
Unnecessary data loading


### 💣 Real danger:

If:  
1000 dogs  
Each image = 2MB  

👉 You just loaded ~2GB data 😱

## ⚡ 3. LAZY Loading  
**✅ Definition:** Data is loaded only when you access it

```java
@Lob
@Basic(fetch = FetchType.LAZY)
private byte[] images;
```

```java
Dog dog = session.get(Dog.class, 1);
```

👉 Hibernate loads:

Dog ✔️  
Image ❌ (not yet)

When you do:

dog.getImages();

👉 NOW image is loaded ✔️

## COre Differences

| Feature      | EAGER      | LAZY             |
| ------------ | ---------- | ---------------- |
| Loading time | Immediate  | On demand        |
| Performance  | Heavy      | Optimized        |
| Memory usage | High       | Low              |
| Use case     | Small data | Large/heavy data |


## 🔥 5. Default Behavior (VERY IMPORTANT)

| Relationship  | Default Fetch |
| ------------- | ------------- |
| `@ManyToOne`  | EAGER ❗       |
| `@OneToMany`  | LAZY          |
| `@ManyToMany` | LAZY          |
| `@OneToOne`   | EAGER         |
