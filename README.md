# 🚀 PokéWiki - Full Stack Pokémon App

¡Bienvenido a mi proyecto PokéWiki! Esta es una aplicación web completa que permite buscar Pokémon y gestionar un equipo personalizado de hasta 6 integrantes. 

El proyecto demuestra la integración de un backend robusto en Java con una base de datos en la nube y un frontend moderno.

## 🔗 Demo en vivo
Puedes ver la aplicación funcionando aquí: 
👉 **[https://pokewikidex.netlify.app](https://pokewikidex.netlify.app)**

---

## 🛠️ Tecnologías Utilizadas

### **Backend**
* **Java 17** con **Spring Boot**: Framework principal para la lógica de la API.
* **Spring Data JPA / Hibernate**: Para el mapeo de objetos a la base de datos.
* **MySQL**: Base de datos relacional para almacenar el equipo Pokémon.
* **Railway**: Hosting del servidor y la base de datos.

### **Frontend**
* **HTML5 & CSS3**: Estructura y diseño "Glassmorphism" moderno y responsivo.
* **JavaScript (Vanilla)**: Gestión de peticiones asíncronas (Fetch API) y manipulación del DOM.
* **Netlify**: Hosting del frontend.

---

## 📋 Características principales
* **Búsqueda en tiempo real**: Filtra Pokémon por nombre mientras escribes.
* **Gestión de Equipo**: Añade y elimina Pokémon de tu equipo (máximo 6).
* **Persistencia de datos**: Tu equipo se guarda en una base de datos MySQL en la nube, por lo que no se pierde al cerrar el navegador.
* **Diseño Responsivo**: Adaptado para visualizarse correctamente en ordenadores y dispositivos móviles.

---

## ⚙️ Configuración del Proyecto
Si quieres ejecutar este proyecto localmente:

1. Clona el repositorio.
2. Configura los datos de tu base de datos MySQL en el archivo `src/main/resources/application.properties`.
3. Ejecuta la aplicación con Maven o desde tu IDE (IntelliJ).
4. Abre el archivo `index.html` en tu navegador.

---

¡Gracias por visitar mi repositorio! Este proyecto ha sido una excelente oportunidad para aprender sobre el despliegue de aplicaciones Full Stack.
feat: añadir información del proyecto al README
