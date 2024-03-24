# Gestión de Recursos Humanos. Luis Díaz y Ricardo Plazas

El proyecto se encarga de proporcionar funciones CRUD (Create, Read, Update, Delete) para la gestión de recursos humanos. Esto incluye desde la adición de un nuevo empleado a la empresa hasta la gestión de sus respectivas habilidades y roles que desempeña en la misma. 

Este trabajo permite al usuario acceder y modificar la información de recursos humanos mediante un API REST, definiendo controladores RESTful y utilizando las anotaciones proporcionadas por Spring. De esta manera, es posible consultar información a través de Postman mediante las URIs correspondientes definidas para el acceso a los datos.
Para ejecutar el proyecto, es necesario inicializar Spring al correr DemoApplication. Una vez la conexión haya iniciado, será posible consultar datos de recursos humanos con operaciones CRUD que se realizan utilizando los métodos estándar de HTTP (GET, POST, PUT, DELETE) a través de Postman, indicando el puerto en el que se estableció la conexión con su respectiva URI. Adicionalmente, es posible visualizar esta información en un navegador web usando http://localhost:puerto/swagger-ui.html.

Cabe resaltar que se implementaron pruebas unitarias y de integración para verificar la correcta funcionalidad de las operaciones, verificando sus resultados con pruebas de mutación que pueden ser accionadas mediante la ejecución de build.gradle.
