# MMO Inventory Extension
![Java Version](https://img.shields.io/badge/Java-21-orange)
![Build Status](https://img.shields.io/badge/build-passing-brightgreen)
![Target](https://img.shields.io/badge/Target-Paper%20/%20Folia%20/%20BTC--CORE-blue)
**MMO Inventory Extension** is a specialized integration module for **TypeWriter**, engineered for **BTC Studio** infrastructure. It bridges the gap between [MMOInventory](https://docs.phoenixdevt.fr/mmoinventory/) and the TypeWriter engine, allowing mechanics to interact with custom equipment slots and artifacts.
---
## 🚀 Key Features
### 🎒 Slot Awareness
- **Custom Equipment Detection**: Hook into non-vanilla slots such as accessories, capes, and artifacts.
- **Dynamic Equipment Logic**: Trigger actions or gate features based on what a player is currently wearing.
### 🔍 MMOItem Integration
- **Type & ID Filtering**: Identify specific MMOItems with precision to ensure accurate logic execution.
- **Equipment Criteria**: Use equipped status as a prerequisite for quests, dialogue, or world interactions.
---
## ⚙️ Configuration
MMO Inventory Extension configuration is managed via TypeWriter's manifest system.
## 🛠 Building & Deployment
Requires **Java 21**.
```bash
# Clone the repository
git clone https://github.com/RenaudRl/TypeWriter-MmoInventoryExtension.git
cd TypeWriter-MmoInventoryExtension
# Build the project
./gradlew clean build

## Documentation

Full documentation available at [BTC Studio Docs](https://docs.borntocraftstudio.net/extensions/free/mmo-inventory/).

---

## 📜 Licence

**GNU General Public License v3.0 or later** — [LICENSE](LICENSE) — with a
**linking exception** for the Typewriter engine — [LICENSE-EXCEPTION.md](LICENSE-EXCEPTION.md).

| | |
|---|---|
| You may | Run it anywhere, **including on a monetised server**. Study it, modify it, use it as a base, and redistribute it — **even for a fee**. GPLv3 §4 explicitly allows charging for a copy. |
| You must | Publish the complete corresponding source of your version under GPLv3, preserve the copyright notices, and **state that you modified it and when** (§5(a)). |
| You may not | Ship a closed-source or proprietary version, relicense under stricter terms, or strip the attribution and present this work as your own — §8 terminates your rights automatically. |
| Marks | **"Born To Craft"** and **"BTC Studio"** are **not** covered by the GPL. Fork it freely, sell your fork if you like — but **rebrand it**. |

> Reselling this code is legally allowed and practically pointless: whoever buys a
> copy from you receives, under the GPL, the right to redistribute it for free.
> That is the protection — not a clause forbidding sale, which the GPL does not
> permit us to add.

### About Typewriter

This is a **third-party extension**. It uses the public extension API of the
[Typewriter](https://github.com/gabber235/Typewriter) engine by gabber235 and
contains none of its source. Born To Craft Studio is not affiliated with or
endorsed by the Typewriter project.

The engine itself is **not** free software — its licence forbids redistributing
it. **Get it from the Typewriter project, and never redistribute it**, including
inside a fork of this repository.

Full attribution, the statement of modifications required by §5(a), and the
trademark reservation are in **[NOTICE.md](NOTICE.md)**. Read it before
redistributing.

© 2026 Born To Craft Studio.
