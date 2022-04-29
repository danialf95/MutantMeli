# Challenge Mutant Meli
## _Author Daniel Alfaro_
 - Celular :3044523641
 - Email : danialf95@gmail.com
 - Linkedin : https://www.linkedin.com/in/danielalejandroalfarourrea/

# Badges

- *Coverage Code*
[![CoverStatus](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)
- *Quality And Security*
 [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=danialf95_MutantMeli&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=danialf95_MutantMeli)
- *Perfromance And Stress Test* 
[![CoverStatus](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

Esta aplicacion fue desarrollada como una prueba de ingreso a Meli en lenguaje Java.

Tabla de contenido

 -
 -
 -
 -

## Entorno

- Base de datos: Postgres SQL
- Lenguaje: JAVA
- Framework: Spring Boot 2.6.6
- Gestor de dependencias: Gradle 7.4
- Servidor: Tomcat – (Incrustado desde el Framework)
- IDE : Eclipse
- Pruebas Unitarias : Junit 4.5
- Cobertura Codigo : JaCoCo 0.8.5

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

## Solución

La solucion trabajada se penso, buscando la forma mas optima en la cual se pudiera recorrer la matriz con la menor comlejidad posible, buscando el patron descrito en el desafio, para ello se trabajo en dos conceptos en los cuales se baso el analisis, diseño e implementacion del algoritmo :

  - Divide y Venceras.
    - Se fragmento el desafio original en problemas mas pequeños, donde se busco dividir las busquedas de patrones en metodos especificos para cada       direccion, cada metodo se encargara de abstraer el problema y la solucion. Con ello en vez de hacer recorridos innecesarios, se identifica la direccion de busqueda donde existe una posiblidad de encontrar el patron y se le cede la busqueda del patron al metodo que de acuerdo a la direccion esta en la capacidad de buscar el patron mediane recursion.
  - Recursion.
     - Debido a que el problema requiere de implementar busquedas inteligentes u optimizadas para reducir la complejidad algoritmica del desarrollo         y la carga operativa de buscar coincidencias, se penso en una solucion que implementara recursion a la hora de buscar el patron en una            direccion especifica, para ello se utilizo la siguiente firma que es invocada de manera recursiva hasta encontrar la cantidad de coincidencias        esperadas.
 >  public boolean search(char caracter,Vector<char[]> data, int i,int j,Direction dir,Integer Coincidence,Integer minCoincidence);
     Este metodo retorna un booleano indicando si en la direccion donde se presume hay coincidencia se encontro el patron esperado o no,la busqueda      se realiza solo sobre los campos del array de los cuales sospechamos hay coincidencia, y no tenemos que recorrer todo el array mediante un for u      otro tipo de iterador que puede aumentar la complejidad algoritmica. Por ejemplo en caso de que en la busqueda se encuentre un caracter que      daña el patron , se acaba la recursion y no seguimos buscando en esa direccion.

De cara al desarrollo se trabajo de la mano de 2 patrones de diseño que facilitaron la implementacion del algoritmo, adicionalmente permiten que la aplicacion sea esclaable y adaptable, y facilmente testeable estos patrones son :

   - SOLID
   - MVC

### Algoritmo

A continuacion se desgloza el algoritmo implementado para el ejercicio

1. Por cada posicion del arreglo, se revisa si el campo en la posicion I J es el origen de algun patron de mutacion genetica , esto se hace buscando     los campos vecinos de dicha posicion que conforman un cuadrante de  8 posiciones.
  
 Imagen 1

2. Cada vecino tendra unas coordenadas I J que en caso de ser invalidas seran eliminadas y no se har ala busqueda en ellas esto pasa en casos como por ejemplo coordenadas negativas o cordenadas fuera de la matriz de busqueda
  
 Imagen 2

3. Una vez detectados los cuadrantes y los vecinos con coincidencia, se procede a evaluar en cada direccion detectada, el patron de 4 caracteres consecutivos mediante recursion para confirmar una mutacion genetica. 
 Imagen 3
4. En caso de que se encuentre algun caracter diferente que impida el cumplimiento del patron inmediatamente se termina la busqueda en esa direcciony se continua  con las otras direccioneshacia las cuales exista alguna coincidencia
 Imagen 4
5. Se repiten nuevamente los pasos anteriores por cada posicion del arreglo hasta que se encuentra mas de una mutacion, donde el algoritmo se detiene deja de iterar y brindara la respuesta final.

### Base de Datos
Cumpliendo con el punto 3 del desafio y teniendo en cuenta la necesidad definida en la prueba, se opta por utilizar una base de datos relacional (PostgreSql) debido a que los datos a almacenar tienen una estructura acotada, no son complejos y el modulo de persintecia mediante JPA  ya esta optimizado para la alta demanda que requiere esta aplicacion. A continuación Adjunto el script DDL de creacion :

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

## Aplicacion(Hosteada)



## Instalacion local

# Gradle

## Api






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
