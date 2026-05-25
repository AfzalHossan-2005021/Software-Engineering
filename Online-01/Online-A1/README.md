# Online-A1: File Adapter and Integer Parser

Online-A1 is a small Java exercise focused on clean interface design and file-based input processing. The code is organized around a parser abstraction, a concrete integer parser, and a driver scaffold that shows where adapter-style integration belongs.

The project is intentionally compact, which makes it useful for practicing separation of concerns, package structure, and lightweight factory-based object creation.

## What the Project Contains

- A parser contract for file-based sum calculation.
- A concrete integer parser that reads integers from a file and returns their total.
- A factory that centralizes parser creation.
- A driver that demonstrates the intended integration points.

## Design Perspective

- `Parser` defines a small, focused contract for file processing.
- `IntegerParser` is responsible only for reading integers and computing the sum.
- `ParserFactory` isolates parser construction from client code.
- `Driver` acts as the orchestration layer for experimenting with the flow.

This structure keeps behavior localized and makes it straightforward to extend the project with additional parser types later.

## Repository Layout

- `adapter_files/Driver.java` - driver scaffold and demo entry point.
- `adapter_files/adapter/parser/` - parser interface, concrete parser, and factory.
- `adapter_files/input_integers.txt` - sample integer input for sum calculation.
- `adapter_files/input.txt` - sample file used by the driver scaffold.
- `adapter_files/spec.pdf` - assignment specification.

## Input Format

- `input_integers.txt` contains whitespace-separated integers.
- `input.txt` is provided as a lightweight sample file for the driver scaffold.

Example integer input:

```text
5 6 10
```

## Build and Run

The project has no external dependencies. Any modern JDK should work.

From `Online-01/Online-A1/adapter_files` in PowerShell:

```powershell
New-Item -ItemType Directory -Force out | Out-Null
javac -d out Driver.java adapter/parser/*.java
java -cp out Driver
```

Because the driver reads files using relative paths, run it from the `adapter_files` directory.

## Usage Notes

- The current driver includes commented sample code for parser experimentation.
- If you add another parser implementation, keep the interface contract stable and extend the factory instead of hard-coding construction in the driver.
- For larger changes, keep file parsing, parser selection, and user interaction in separate layers so the code remains testable.

## Software Engineering Notes

- The code favors small, focused classes with a single responsibility.
- The factory encapsulates object creation and keeps client code decoupled from concrete implementations.
- The package structure makes the parser API explicit and easy to locate.
- The project is a good foundation for demonstrating adapter-style integration with a minimal amount of infrastructure.
