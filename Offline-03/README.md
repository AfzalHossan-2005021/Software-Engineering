# Offline-03: Structural Design Patterns in Java

Offline-03 contains two console-based Java exercises that demonstrate classic structural design patterns.

- Problem I uses the Adapter pattern to present an imposter-facing API on top of an existing crewmate system.
- Problem II uses the Composite pattern to model a file system with drives, folders, and files.

The code is intentionally small and focused, which makes it a good reference for separation of concerns, interface-driven design, and object composition.

## Problem I: Adapter Pattern

The first problem adapts a crewmate workflow so that an imposter can interact with the same underlying system through a different interface. The adapter translates the shared operations while preserving the original crewmate behavior.

### Main Classes

- `Application` - interactive entry point and command dispatcher.
- `CrewmateSystem` - base implementation for the crewmate workflow.
- `ImposterSystemAdapter` - adapter that wraps the crewmate system.
- `CrewmateSystemInterface` and `ImposterSystemInterface` - contracts for the two views of the same behavior.

### Commands

- `login crew` - start a crewmate session.
- `login imp` - start an imposter session through the adapter.
- `repair` - perform the repair action.
- `work` - perform the work or sabotage action.
- `logout` - end the current session.
- `exit` - terminate the program.

## Problem II: Composite Pattern

The second problem models a tree-structured file system where a composite node can contain other composites or files. The root is a singleton, and operations are exposed through a uniform interface for navigation, inspection, creation, and deletion.

### Main Classes

- `FileSystem` - interactive entry point and command dispatcher.
- `Root` - singleton root node of the file system.
- `Drive` - top-level composite node under the root.
- `Folder` - nested composite node.
- `File` - leaf node containing size and metadata.
- `Component` and `Composite` - shared base types for the hierarchy.

### Commands

- `mkdrive <name>` - create a new drive at the root level.
- `mkdir <name>` - create a folder inside the current drive or folder.
- `touch <name> <size>` - create a file inside the current drive or folder.
- `cd ~` - jump to the root.
- `cd ../` - move to the parent directory.
- `cd <name>` - move into a drive or folder.
- `ls <name>` - show details of a specific child component.
- `list` - list all direct children of the current directory.
- `delete <name>` - delete a file or an empty composite.
- `delete -r <name>` - recursively delete a composite and its contents.
- `exit` - terminate the program.

## Build and Run

The project has no external dependencies. Any modern JDK should work.

### Problem I

From `Offline-03/2005021/Problem_I/src` in PowerShell:

```powershell
New-Item -ItemType Directory -Force out | Out-Null
javac -d out *.java
java -cp out Application
```

### Problem II

From `Offline-03/2005021/Problem_II/src` in PowerShell:

```powershell
New-Item -ItemType Directory -Force out | Out-Null
javac -d out *.java
java -cp out FileSystem
```

Both programs are interactive and respond to the commands listed above.

## Project Layout

- `2005021/Problem_I/src` - Adapter pattern implementation
- `2005021/Problem_II/src` - Composite pattern implementation
- `2005021/Problem_1.pdf` - problem statement for the adapter exercise
- `2005021/Problem_2.pdf` - problem statement for the composite exercise
- `2005021/CSE308_Structural_Design_Pattern.pdf` - assignment brief

## Software Engineering Notes

- The adapter example shows how to preserve an existing contract while presenting a different client-facing API.
- The composite example shows how to treat leaf and container objects uniformly through shared abstractions.
- The design keeps behavior localized to the responsible abstraction, which makes each exercise easy to extend without rewriting the whole flow.
