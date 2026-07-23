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
