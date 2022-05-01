# Challenge Mutant Meli

<h1 align="center"> Mercado Libre</h1>
<p align="center"><img src="https://github.com/danialf95/MutantMeli/blob/master/Images/mercado-libre.png"/></p> 

## _Author Daniel Alfaro_
 - Celular : +573044523641
 - Email : danialf95@gmail.com
 - Linkedin : https://www.linkedin.com/in/danielalejandroalfarourrea/

# Badges

- *Uptime*
![Uptime Robot status](https://badgen.net/uptime-robot/day/m791608176-6d18823c6ba6d82a5749d08a)
- *Quality And Security*
 [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=danialf95_MutantMeli&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=danialf95_MutantMeli)
 - *Response Time* 
![Uptime Robot status](https://badgen.net/uptime-robot/response/m791608176-6d18823c6ba6d82a5749d08a)

- *Perfromance And Stress Test* 
[![CoverStatus](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

# _Introducción_

Esta aplicación fue desarrollada como una prueba de ingreso a Meli en lenguaje Java.

Tabla de contenido

 - [Entorno](#entorno)
 - [Report Coverage](#report-coverage)
 - [Desafío](#desafío)
 - [Solución](#solución)
 - [Algoritmo](#algoritmo)
 - [Base de datos](#base-de-datos)
 - [Aplicación Hosteada](#aplicación-hosteada)
 - [Instalación Local](#instalación-local)
 - [Uso de la Api](#uso-de-la-api)

# _Entorno_

- Base de datos: Postgres SQL
- Lenguaje: JAVA
- Framework: Spring Boot 2.6.6
- Gestor de dependencias: Gradle 7.4
- Servidor: Tomcat – (Incrustado desde el Framework)
- IDE : Eclipse
- Pruebas Unitarias : Junit 4.5
- Cobertura Codigo : JaCoCo 0.8.5


# _Report Coverage_

Este reporte de cobertura fue generado con JaCoCo, con una cifra superior al 85% :

```sh
gradlew test
```

<img src="https://github.com/danialf95/MutantMeli/blob/master/Images/coverage.PNG"/>

El reultado de la ejecución lo podras encontrar en la siguiente ruta :

>  {$rootProjectDir}\build\reports\jacoco\test\html\index.html

# _Desafío_

## Introducción

Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Men.

Te ha contratado a ti para que desarrolles un proyecto que detecte si un humano es mutante basándose en su secuencia de ADN.
Para eso te ha pedido crear un programa con un método o función con la siguiente firma (En alguno de los siguiente lenguajes: Java / Golang / C-C++ / Javascript (node) / Python / Ruby):
```sh
boolean isMutant(String[] dna);
```
En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla
de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las
cuales representa cada base nitrogenada del ADN.

Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro letras iguales​, de forma oblicua, horizontal o vertical.

## Niveles Desafío
##### Nivel 1: 
Programa (en cualquier lenguaje de programación) que cumpla con el método pedido por Magneto.

##### Nivel 2:
Crear una API REST, hostear esa API en un cloud computing libre (Google App Engine,
Amazon AWS, etc), crear el servicio “/mutant/” en donde se pueda detectar si un humano es
mutante enviando la secuencia de ADN mediante un HTTP POST con un Json el cual tenga el
siguiente formato:
> POST → /mutant/
> {
> “dna”:["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
> }

En caso de verificar un mutante, debería devolver un HTTP 200-OK, en caso contrario un
403-Forbidden
##### Nivel 3:
Anexar una base de datos, la cual guarde los ADN’s verificados con la API.
Solo 1 registro por ADN.Exponer un servicio extra “/stats” que devuelva un Json con las estadísticas de las
verificaciones de ADN: 

> {“count_mutant_dna”:40, “count_human_dna”:100: “ratio”:0.4}

Tener en cuenta que la API puede recibir fluctuaciones agresivas de tráfico (Entre 100 y 1
millón de peticiones por segundo).
Test-Automáticos, Code coverage > 80%.

# _Solución_

La solución trabajada se pensó, buscando la forma más óptima en la cual se pudiera recorrer la matriz con la menor complejidad posible, buscando el patrón descrito en el desafío, para ello se trabajó en dos conceptos en los cuales se basó el análisis, diseño e implementación del algoritmo:

>  - Divide y Venceras.
    - Se fragmento el desafío original en problemas más pequeños, donde se buscó dividir las búsquedas de patrones en métodos específicos para cada dirección, cada método se encargara de abstraer el problema y la solución. Con ello en vez de hacer recorridos innecesarios, se identifica la dirección de búsqueda donde existe una posibilidad de encontrar el patrón y se le cede la búsqueda del patrón al método que de acuerdo a la dirección está en la capacidad de buscar el patrón mediante recursión.
>  - Recursión.
     - Debido a que el problema requiere de implementar búsquedas inteligentes u optimizadas para reducir la complejidad algorítmica del desarrollo y la carga operativa de buscar coincidencias, se pensó en una solución que implementara recursión a la hora de buscar el patrón en una            dirección específica, para ello se utilizó la siguiente firma que es invocada de manera recursiva hasta encontrar la cantidad de coincidencias esperadas.
```sh 
 > public boolean search(char caracter,Vector<char[]> data, int i,int j,Direction dir,Integer Coincidence,Integer minCoincidence);
```
> Este método retorna un booleano indicando si en la dirección donde se presume hay coincidencia se encontró el patrón esperado o no, la búsqueda  se realiza solo sobre los campos del array de los cuales sospechamos hay coincidencia, y no tenemos que recorrer todo el array mediante un for u otro tipo de iterador que puede aumentar la complejidad algorítmica. Por ejemplo en caso de que en la búsqueda se encuentre un carácter que daña el patrón, se acaba la recursión y no seguimos buscando en esa dirección.

De cara a la implementación del desarrollo se trabajó de la mano de 2 patrones de diseño que facilitaron la implementación del algoritmo, adicionalmente estos patrones permiten que la aplicación sea escalable, adaptable, y fácilmente testeable :


   - [SOLID](https://profile.es/blog/principios-solid-desarrollo-software-calidad/)
   - [MVC](https://desarrolloweb.com/articulos/que-es-mvc.html)

# _Algoritmo_

A continuación se desglosa el algoritmo implementado para el ejercicio

1. Por cada posición del arreglo, se revisa si el campo en la posición I J es el origen de algún patrón de mutación genética, esto se hace buscando los campos vecinos de dicha posición que conforman un cuadrante de 8 posiciones.
<p align="center">  
 <img src="https://github.com/danialf95/MutantMeli/blob/master/Images/Imagen-1.PNG"/>
</p>
2. Cada vecino tendrá unas coordenadas I J que en caso de ser invalidas serán eliminadas y no se hará la búsqueda en ellas esto pasa en casos como por ejemplo coordenadas negativas o coordenadas fuera de la matriz de búsqueda.
<div>  
 <p align="center">
<img src="https://github.com/danialf95/MutantMeli/blob/master/Images/Imagen-2.PNG" /> <img src="https://github.com/danialf95/MutantMeli/blob/master/Images/Imagen-2_1.PNG" />
 </p>
</div>
3. Una vez detectados los cuadrantes y los vecinos con coincidencia, se procede a evaluar en cada dirección detectada, el patrón de 4 caracteres consecutivos mediante recursión para confirmar una mutación genética.
 <p align="center">  
 <img src="https://github.com/danialf95/MutantMeli/blob/master/Images/Imagen-3.PNG"/> <img src="https://github.com/danialf95/MutantMeli/blob/master/Images/Imagen-3_2.PNG"/> 
 </p>
4. En caso de que se encuentre algún carácter diferente que impida el cumplimiento del patrón inmediatamente se termina la búsqueda en esa dirección y se continúa con las otras direcciones, hacia las cuales exista alguna coincidencia.
<p align="center">  
 <img src="https://github.com/danialf95/MutantMeli/blob/master/Images/Imagen-4.PNG"/>
</p>
5. Se repiten nuevamente los pasos anteriores por cada posición del arreglo hasta que se encuentra más de una mutación, donde el algoritmo se detiene por completo, deja de iterar y brindara la respuesta final.

# _Base de Datos_
Cumpliendo con el punto 3 del desafío y teniendo en cuenta la necesidad definida en la prueba, se opta por utilizar una base de datos relacional (PostgreSql) debido a que los datos a almacenar tienen una estructura acotada, no son complejos y el módulo de persistencia mediante JPA  ya está optimizado para la alta demanda que requiere esta aplicación. A continuación Adjunto el script DDL de creación:

```sh
CREATE TABLE test.logauditadn (
  ID  SERIAL NOT NULL,
  INPUT_DATA varchar NOT null,
  VERIFICATION boolean NOT null,
  TIME timestamp NOT null
);
```
Adicion de constraint :
```sh
ALTER TABLE test.logauditadn ADD PRIMARY KEY (id);
```

# _Aplicación Hosteada_

La aplicación se encuentra desplegada en la nube de IBM mediante PaaS, proporcionada por cloud foundry.

El entorno utilzado en la aplicación es el siguiente:

 - Runtime : Tomcat 8.0
 - Ram : 256MB
 - Core : 1
 - Location : Dallas
 - app-name : api.mutant
 - host-name: mutant-api
 - domain : mybluemix.net

El endpoint de la aplicación es el siguiente > https://mutant-api.mybluemix.net/

# _Instalación local_

1. Descargar el repositorio desde :
```sh
 git clone https://github.com/danialf95/MutantMeli.git
```
2. Instalar Gradle (Windows)
```sh
 Ver siguiente tutorial [Tuto](https://parzibyte.me/blog/2019/07/27/instalar-configurar-gradle/)
```
3. En caso de utilzar algun IDE de desarrollo, el proyecto debe importarse como proyecto gradle.
4. Ubicarse en el root del proyecto.
5. Ejecutar la aplicación.
```sh
gradlew bootRun
```
 - La aplicación se ejecutará y se levantara una instancia Tomcat(Embebida) en el puerto 8080
 - Para probar que este todo ok puedes consumir el siguiente endpoint http://localhost:8080/api/stats alli tendras una respuesta de las estadisticas actuales de la  api
6. Para generar el compilado escribe el siguiente comando:
```sh
gradlew build
```
 - Esto genera un artefacto tipo .war listo para desplegar que podras encontar en la ruta
   - {$rootProjectDir}/build/libs/prueba-0.0.1-SNAPSHOT.war
 - Al ejcutar el comando, no solo se genera el compilado, tambien se ejecutan las pruebas y segenera el reporte de cobertura que puede ser revisado en la siguiente ruta del proyecto
    - {$rootProjectDir}/build/reports/jacoco/test/html/index.html

7. Si se desea ejecutar solo las pruebas sin generas compilado, digitar el siguiente comando:
```sh
gradlew test
```
 - Este comando ejecutará las pruebas unitarias y posterior a ello generar el reporte de coberura con JaCoCo que se podra encontar en la ruta descrita en el punto anterior.

# _Uso de la Api_

De acuerdo a la definición del desafío se requiere disponibilizar dos servicios mediante api, a continuación se describen las propiedades de os servicios expuestos y la forma de consumirlos: 

Existen dos endpoint que puedes consumir el local en caso de ejecutar el punto anterior o el de la nube :

- Endpoint local :  http://localhost:8080
- Endpoint Servicio Nube : https://mutant-api.mybluemix.net/

## Servicio Verificación ADN
### Request

Analizar una cadena genetica para determinar si corresponde a un mutante o a un humano :

 - Metodo : `POST` 
 - Path : `api/mutant`
 - Content-Type : `Application/Json`
 - Payload :
 
 ```sh
    {
     "dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
    }
 ``` 
### Response OK
 - Status Code :  `200`
 
### Response Error 

 #### Forbidden
Este codígo se responde cuando al analizar la cadena de ADN se encuentra que no corresponde a u mutante si no a un humano.
 - Status Code : `403` 

  #### Internal Server Error
Este codígo se responde cuando ocurre algun error en la aplicación , generado entre otros por estructura genetica invalida o problemas con la BD.
 - Status Code  : `500`
 
## Servicio Estadísticas

### Request

Generar estadisticas relacionadas con el uso de api identificando cadenas genticas analizadas, de humanos y mutantes:

 - Metodo : `GET` 
 - Path : `api/stats`
 - Content-Type : `Application/Json`
 - Data required : `NO`
 
### Response OK
 - Status Code :  `200`
 - Payload Response :
 
  
 ```sh
   {
    "count_mutant_dna": 265,
    "count_human_dna": 256,
    "ratio": 0
   }
 ``` 
 
### Response Error 

  #### Internal Server Error
Este codígo se responde cuando ocurre algun error en la aplicación.
 - Status Code  : `500`


Markdown is a lightweight markup language based on the formatting conventions
that people naturally use in email.
As [John Gruber] writes on the [Markdown site][df1]

> The overriding design goal for Markdown's
> formatting syntax is to make it as readable
> as possible. The idea is that a
> Markdown-formatted document should be
> publishable as-is, as plain text, without
> looking like it's been marked up with tags
> or formatting instructions.

This text you see here is *actually- written in Markdown! To get a feel
for Markdown's syntax, type some text into the left window and
watch the results in the right.

## Tech

Dillinger uses a number of open source projects to work properly:

- [AngularJS] - HTML enhanced for web apps!
- [Ace Editor] - awesome web-based text editor
- [markdown-it] - Markdown parser done right. Fast and easy to extend.
- [Twitter Bootstrap] - great UI boilerplate for modern web apps
- [node.js] - evented I/O for the backend
- [Express] - fast node.js network app framework [@tjholowaychuk]
- [Gulp] - the streaming build system
- [Breakdance](https://breakdance.github.io/breakdance/) - HTML
to Markdown converter
- [jQuery] - duh

And of course Dillinger itself is open source with a [public repository][dill]
 on GitHub.

## Installation

Dillinger requires [Node.js](https://nodejs.org/) v10+ to run.

Install the dependencies and devDependencies and start the server.

```sh
cd dillinger
npm i
node app
```

For production environments...

```sh
npm install --production
NODE_ENV=production node app
```

## Plugins

Dillinger is currently extended with the following plugins.
Instructions on how to use them in your own application are linked below.

| Plugin | README |
| ------ | ------ |
| Dropbox | [plugins/dropbox/README.md][PlDb] |
| GitHub | [plugins/github/README.md][PlGh] |
| Google Drive | [plugins/googledrive/README.md][PlGd] |
| OneDrive | [plugins/onedrive/README.md][PlOd] |
| Medium | [plugins/medium/README.md][PlMe] |
| Google Analytics | [plugins/googleanalytics/README.md][PlGa] |

## Development

Want to contribute? Great!

Dillinger uses Gulp + Webpack for fast developing.
Make a change in your file and instantaneously see your updates!

Open your favorite Terminal and run these commands.

First Tab:

```sh
node app
```

Second Tab:

```sh
gulp watch
```

(optional) Third:

```sh
karma test
```

#### Building for source

For production release:

```sh
gulp build --prod
```

Generating pre-built zip archives for distribution:

```sh
gulp build dist --prod
```

## Docker

Dillinger is very easy to install and deploy in a Docker container.

By default, the Docker will expose port 8080, so change this within the
Dockerfile if necessary. When ready, simply use the Dockerfile to
build the image.

```sh
cd dillinger
docker build -t <youruser>/dillinger:${package.json.version} .
```

This will create the dillinger image and pull in the necessary dependencies.
Be sure to swap out `${package.json.version}` with the actual
version of Dillinger.

Once done, run the Docker image and map the port to whatever you wish on
your host. In this example, we simply map port 8000 of the host to
port 8080 of the Docker (or whatever port was exposed in the Dockerfile):

```sh
docker run -d -p 8000:8080 --restart=always --cap-add=SYS_ADMIN --name=dillinger <youruser>/dillinger:${package.json.version}
```

> Note: `--capt-add=SYS-ADMIN` is required for PDF rendering.

Verify the deployment by navigating to your server address in
your preferred browser.

```sh
127.0.0.1:8000
```

## License

MIT

**Free Software, Hell Yeah!**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

   [dill]: <https://github.com/joemccann/dillinger>
   [git-repo-url]: <https://github.com/joemccann/dillinger.git>
   [john gruber]: <http://daringfireball.net>
   [df1]: <http://daringfireball.net/projects/markdown/>
   [markdown-it]: <https://github.com/markdown-it/markdown-it>
   [Ace Editor]: <http://ace.ajax.org>
   [node.js]: <http://nodejs.org>
   [Twitter Bootstrap]: <http://twitter.github.com/bootstrap/>
   [jQuery]: <http://jquery.com>
   [@tjholowaychuk]: <http://twitter.com/tjholowaychuk>
   [express]: <http://expressjs.com>
   [AngularJS]: <http://angularjs.org>
   [Gulp]: <http://gulpjs.com>

   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
   [PlGh]: <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>
   [PlMe]: <https://github.com/joemccann/dillinger/tree/master/plugins/medium/README.md>
   [PlGa]: <https://github.com/RahulHP/dillinger/blob/master/plugins/googleanalytics/README.md>
