# Test Automation Framework
Setup in IntelliJ IDEA

Clone the repo:
```plaintext
git clone <repo-url>
```
Open in IntelliJ as a Maven project

Set Project SDK = JDK 11+

4.Run tests via Maven/Run Configurations (JUnit/TestNG)

# Framework structure
```plaintext
src/main/java – Core Framework
└── com.WEAre.pages          
└── com.WEAre.utils          
├─ TestDataGenerator   
└─ WebElementUtils   
└── com.WEAre.testframework  
├─ core  
├─ enums 
├─ config 
└─ logging

src/test/java – Test Layer
└── wearetests.core    → BaseWebTest, TestContext
└── wearetests.enums   → Test-specific enums
└── wearetests.web     → Feature tests (login, registration, posts)
└── wearetests.suites  → Grouped test suites

src/test/resources – Configurations
└── config.properties       
└── dev-config.properties   

```
