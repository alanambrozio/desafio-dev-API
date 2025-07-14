## Desafio API DIO Santander 2025

<img width="1910" height="1021" alt="image" src="https://github.com/user-attachments/assets/8ea9e2a0-a9a5-4444-bc17-90250d6c86d5" />
Página inicial
<img width="1913" height="1024" alt="image" src="https://github.com/user-attachments/assets/f55a9f79-e8c2-459d-9865-5ad82a3a8617" />
Get mangá
<img width="1804" height="1017" alt="image" src="https://github.com/user-attachments/assets/e3dc2618-3d64-4237-ab4c-e29bb85cde61" />
Post mangá

```mermaid

classDiagram
    class Manga {
        +string id
        +string title
    }

    class Info {
        +string author
        +string status
        +List~string~ genres
        +int startYear
        +int endYear
    }

    class Reading {
        +int currentChapter
    }

    Manga --> Info : has
    Manga --> Reading : has


```
