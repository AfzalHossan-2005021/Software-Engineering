# Offline-02: Shake Ordering System

Offline-02 is a console-based shake ordering application implemented in Java. It demonstrates the Builder pattern through a menu-driven ordering flow where users can compose custom shakes, add multiple items to a single order, and print the final bill.

## Overview

The application lets a user open an order, choose a shake type, optionally customize it with extra or replaceable ingredients, and then close the order to view the full summary and total price.

## Key Features

- Browse a predefined shake catalog with base prices.
- Customize shakes with optional toppings and ingredient replacement.
- Build each shake through a dedicated builder workflow.
- Collect multiple shakes into a single order.
- Print itemized order details and the final total price.

## Design Notes

- `Director` assembles the base recipe for each shake type.
- `ShakeBuilder` stores the current shake state and applies ingredient changes.
- `OrderBuilder` accumulates multiple completed items before checkout.
- `Shake` and `Order` handle the final presentation of item details and pricing.
- The structure keeps construction logic separate from representation, which makes the design easier to extend and maintain.

## Menu Flow

1. Press `o` to open a new order.
2. Choose a shake type from the catalog.
3. Optionally customize the shake.
4. Repeat the process to add more items.
5. Press `e` to close the order and print the bill.
6. Press `exit` to terminate the program.

## Shake Catalog

| Shake | Base Price |
| --- | --- |
| Chocolate Shake | Tk 230 |
| Coffee Shake | Tk 250 |
| Strawberry Shake | Tk 200 |
| Vanilla Shake | Tk 190 |
| Zero Shake | Tk 240 |

### Ingredient Options

- Replaceable ingredient: Almond Milk (+Tk 60) instead of Regular Milk.
- Optional ingredients: Candy Topping (+Tk 50), Cookies Topping (+Tk 40).

## Build and Run

The project has no external dependencies. Any modern JDK should work.

From `Offline-02/_2005021/src` in PowerShell:

```powershell
New-Item -ItemType Directory -Force out | Out-Null
javac -d out *.java
java -cp out OrderManagementSystem
```

The program is interactive. Follow the on-screen prompts to create and customize shakes.

## Project Layout

- `src` - Java source files for the ordering system
- `CSE308Offline2.pdf` - assignment brief / project specification

## Software Engineering Perspective

This implementation keeps the construction process explicit and testable. New shake recipes can be added by extending the director and enumeration set, while additional toppings or replacement ingredients can be introduced without changing the order-printing logic. The result is a small but clean example of separation of concerns, encapsulation, and builder-driven object creation.
