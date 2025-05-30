# 📍 Pontos de Interesse - Desafio Backend-BR

Este projeto é uma API REST desenvolvida em Java com Spring Boot, como solução para o desafio proposto pela [Comunidade Backend-BR]([https://github.com/backend-br/desafios/blob/master/points-of-interest/PROBLEM.md]). A aplicação permite cadastrar, listar e buscar pontos de interesse com base em coordenadas cartesianas e uma distância máxima definida pelo usuário.

---

## 🧩 Sobre o desafio

O objetivo é criar uma API que gerencie **pontos de interesse (POIs)** de uma cidade, oferecendo as seguintes funcionalidades:

- ✅ Cadastro de novos pontos com nome e coordenadas X/Y
- ✅ Listagem de todos os pontos cadastrados
- ✅ Busca de pontos próximos a uma coordenada informada, considerando uma distância máxima

A distância entre dois pontos é calculada usando a fórmula da **distância euclidiana**.

---

## 🛠️ Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Flyway (migrations)
- Lombok
- Validation
- Maven

---

## 🗃️ Estrutura da API

### 📌 Modelo

```java
PointOfInterest {
  Long id;
  String name;
  Integer coordinateX;
  Integer coordinateY;
  LocalDateTime created;
  LocalDateTime updated;
}
```

---

## 🚀 Endpoints disponíveis

### ➕ Cadastrar ponto de interesse
**POST** `/points-of-interest`

```json
{
  "name": "Churrascaria",
  "coordinateX": 28,
  "coordinateY": 2
}
```

---

### 📋 Listar todos os pontos
**GET** `/points-of-interest`

Retorna todos os pontos cadastrados.

---

### 📍 Buscar pontos por proximidade
**GET** `/points-of-interest/search?coordinateX=20&coordinateY=10&maximumDistance=10`

Parâmetros:
- `coordinateX`: Coordenada X de referência (obrigatório)
- `coordinateY`: Coordenada Y de referência (obrigatório)
- `maximumDistance`: Distância máxima para filtrar pontos (obrigatório)

---

## 🧪 Dados iniciais inseridos via Flyway

```sql
INSERT INTO points_of_interest (name, coordinate_x, coordinate_y) VALUES 
  ('Lanchonete', 27, 12),
  ('Posto', 31, 18),
  ('Joalheria', 15, 12),
  ('Floricultura', 19, 21),
  ('Pub', 12, 8),
  ('Supermercado', 23, 6),
  ('Churrascaria', 28, 2);
```

---

## 🧑‍💻 Como rodar o projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/phlimadev/points-of-interest.git
   cd points-of-interest
   ```

2. Configure o banco de dados MySQL (exemplo: `test_db`) e atualize o `application.properties`.

3. Rode o projeto com Maven:
   ```bash
   ./mvnw spring-boot:run
   ```

As migrations do Flyway serão aplicadas automaticamente.

---

## 📦 Requisitos

- Java 17 ou superior
- Maven 3.8+
- MySQL 8+

---

## 📄 Licença

Este projeto está sob a licença MIT. Sinta-se à vontade para usar e contribuir!

---

## 🤝 Autor

Desenvolvido por **Pedro Lima**  
💼 [LinkedIn](https://www.linkedin.com/in/phlimadev) | 🐙 [GitHub](https://github.com/phlimadev)
