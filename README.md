# Java SE 11 Programmer 2 Exam - Concurrency Examples

This repository contains Java concurrency examples demonstrating different synchronization approaches for the Java SE 11 Programmer 2 certification exam.

## Projects

### SynchronizedCounter
- Uses `synchronized` methods for thread-safe counter operations
- Demonstrates intrinsic locking with method-level synchronization
- Tracks distance in kilometers and miles

### ExtrinsicLock
- Uses separate lock objects for fine-grained synchronization
- Demonstrates extrinsic locking with `synchronized` blocks
- Uses different locks for different operations to improve concurrency

## Running the Examples

Each project can be run independently:

```bash
# SynchronizedCounter
cd concurrency/SynchronizedCounter
javac -d . src/com/company/SynchronizedCounter.java
java com.company.SynchronizedCounter

# ExtrinsicLock
cd concurrency/ExtrinsicLock
javac -d . src/com/company/DistanceTracker.java
java com.company.DistanceTracker
```

Both examples use `ExecutorService` with a fixed thread pool to demonstrate concurrent access patterns.
