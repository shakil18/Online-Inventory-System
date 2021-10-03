## Table of Contents

- [Online Inventory System <a name = "about_the_project"></a>](#online-inventory-system-)
  - [Directory Structure <a name = "directory_structure"></a>](#directory-structure-)
  - [Requirements <a name = "requirements"></a>](#requirements-)
  - [Contact <a name = "contact"></a>](#contact-)
---

<!-- ABOUT THE PROJECT -->
# Online Inventory System <a name = "about_the_project"></a>

This GitHub repository is about to deploy a JavaEE based web-application. The web application is about an online inventory system. The inventory system stores all information into the SQL database. The system is developed by following [MVC](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller) approach. 


<!-- DIRECTORY STRUCTURE -->
## Directory Structure <a name = "directory_structure"></a>

Here's a project's directory structure:

```text
Online-Inventory-System
├── build
│   └── classes
│       ├── adapters
│       ├── controllers
│       └── models
├── Database
│   └── inventory.sql                   # pre-existed Database
├── README.md
├── src
│   ├── adapters                        # drivers
│   │   ├── ConnectionAdapters.java
│   │   └── DataAccess.java
│   ├── controllers                     # controllers of the system
│   │   ├── addNewProduct.java
|   |   |       ...
│   │   └── StockEdit.java
│   └── models                          # models of the system
│       ├── Category.java
|       |       ...
│       └── Stock.java
└── WebContent
    ├── META-INF
    │   └── MANIFEST.MF
    └── WEB-INF
        ├── lib
        ├── views                       # views of the system
        │   ├── addNewProduct_view.jsp
        │   ├──     ...
        │   └── stock_view.jsp
        └── web.xml
```

<!-- REQUIREMENTS  -->
## Requirements <a name = "requirements"></a>

- [JavaEE <a href="https://www.oracle.com/java/technologies/ee8-install-guide.html"> </a>](java_ee_download)
- [Eclipse IDE <a href="hhttps://www.eclipse.org/downloads/"> </a>](eclipse_download)


<!-- CONTACT -->
## Contact <a name = "contact"></a>

**Azizul Hakim Shakil** - [@ShakilAzizul](https://twitter.com/ShakilAzizul) - azizulhakim.shakil18@gmail.com

Project Link: [https://github.com/shakil18/Online-Inventory-System](https://github.com/shakil18/Online-Inventory-System)