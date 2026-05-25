# Online-B1: ID Generator Integration Exercise

Online-B1 is a compact Java exercise focused on object collaboration, constructor-based dependency injection, and controlled object creation. The project centers on an `IdGenerator` abstraction that is shared by two user classes, making it a useful reference for separation of concerns and extensible design.

## What the Project Demonstrates

- A generator abstraction that hides the details of ID creation.
- Two client classes that consume IDs in different patterns.
- A concrete generator implementation with simple incremental behavior.
- A driver that shows both the shared-generator flow and the intended self-contained flow.

## Design Perspective

- `IdGenerator` defines the contract for producing IDs.
- `ConcreteIdGenerator` is the single source of generated IDs in the shared-generator path.
- `ConcreteIdUserA` and `ConcreteIdUserB` are clients that consume IDs in different batch sizes.
- `Driver` orchestrates the demonstration and makes the intended integration choices explicit.

The design is intentionally small, but it still reinforces a practical software engineering principle: keep the creation policy separate from the usage policy.

## Execution Modes

The driver includes two paths:

- `previous_main()` - creates one shared `ConcreteIdGenerator` and injects it into both users.
- `new_main()` - reserved for the alternate construction style where the users own their generator setup.

In the current entry point, `previous_main()` is active and `new_main()` is commented out. The code comments indicate where the switch is expected to happen.

## Repository Layout

- `problem_2/Driver.java` - entry point and demonstration harness.
- `problem_2/id_generator/` - ID generator abstraction and concrete implementation.
- `problem_2/id_user/` - client classes that consume generated IDs.
- `problem_2/problem_2.pdf` - assignment specification.

## Build and Run

The project has no external dependencies. Any modern JDK should work.

From `Online-01/Online-B1/problem_2` in PowerShell:

```powershell
New-Item -ItemType Directory -Force out | Out-Null
javac -d out Driver.java id_generator/*.java id_user/*.java
java -cp out Driver
```

The current driver prints ID sequences from the active path and ends with `Simulation over!`.

## Usage Notes

- `ConcreteIdUserA` pulls 5 IDs per work cycle.
- `ConcreteIdUserB` pulls 7 IDs per work cycle.
- If you complete the no-argument constructors, you can switch the driver to `new_main()` to exercise the alternate setup.
- Keep the generator API stable if you extend the exercise with more user types or alternative generation strategies.

## Software Engineering Notes

- The project keeps a narrow interface surface, which makes the collaboration easy to reason about.
- The shared generator path is a clear example of dependency injection at the constructor level.
- The no-argument constructors provide a clean extension point for future refactoring or alternate wiring strategies.
- The code remains easy to test because ID generation and ID consumption are separated into distinct responsibilities.
