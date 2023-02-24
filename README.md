<p align="center">
  <a href="https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/" target="blank"><img src="https://miro.medium.com/max/500/1*AbiX4LwtSNozoyfypcKvEg.png" width="200" alt="Nest Logo" /></a>
</p>
<h1 align="center">  Mi-negocio </h1>
<p align="left">
   <img src="https://img.shields.io/badge/STATUS-EN%20DESAROLLO-green">
  <img src="https://img.shields.io/badge/JAVA-%208-green">
  <img src="https://img.shields.io/badge/SpringBootVersion-%20v2.7.5-blue">
  <img src="https://img.shields.io/badge/PostgreSQL-%20v15.1-blue">
  <img src="https://img.shields.io/badge/Docker-%20v20.10.20-blue">
</p>

# Descripcion del proyecto
Mi negocio permite registrar de manera rápida una factura a consumidor final
o cualquier otro cliente registrando los datos al momento de la facturación con un proceso 
mejorado que permite tener una base de clientes por cada empresa que utiliza el sistema, de
tal manera que al momento de facturar se pueda buscar un cliente por número de identificación
o nombre

## :hammer:Funcionalidades del proyecto
- `Funcionalidad 1`: Funcionalidad para buscar y obtener un listado de clientes.
- `Funcionalidad 2`: Funcionalidad para crear un nuevo cliente con la dirección matriz
- `Funcionalidad 3`: Funcionalidad para editar los datos del cliente
- `Funcionalidad 4`: Funcionalidad para eliminar un cliente
- `Funcionalidad 5`: Funcionalidad para registrar una nueva dirección por cliente
- `Funcionalidad 6`: Funcionalidad para listar las direcciones adicionales del cliente

## ✔️:Tecnologias utilizadas
- `Java`
- `Spring boot`
- `JPA`
- `Hibernate`
- `Docker`
- `PostgreSQL`

# Ejecutar en desarrollo
## 1. Clonar el repositorio
<br>

Configuracion Base de datos en el archivo **application.properties**

```
spring.jpa.database=POSTGRESQL
spring.datasource.url=jdbc:postgresql://localhost:5432/invoice
spring.datasource.username=unexus
spring.datasource.password=unexus2023
spring.jpa.show-sql=true
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
```
<br>
Para poder probar la aplicacion e utilizado un contenedor de Docker en la cual 
estara montada nuestra base de datos PostgresSql y esta servira para poder conectar
con la aplicacion Mi negocio.

<br>

## 2. Tener Docker instalado
## 3. Levantar la base de datos

<br>

Para levantar nuestra base de datos abriremos nuestra terminal (**cmd**)
y ejecutaremos:

<br>

Para descargar la imagen 
```
docker pull postgres
```
Para levantar el servicio
```
docker run --name unexusdb -e POSTGRES_USER=unexus -e POSTGRES_PASSWORD=unexus2023 -e POSTGRES_DB=invoice -p 5432:5432 -d postgres
```
Para revisar si nuestro servicio esta correctamente levantado
```
docker ps -a
```
## 4. Compilar el proyecto

<br>

Dentro de nuestro proyecto clonado, posicionarce dentro de la carpeta target:
**D:\Descargas\Mi-negocio-master\Mi-negocio-master\clientInvoice\target**
verificaremos que se encuentre nuestro archivo compilado **invoice-0.0.1-SNAPSHOT.jar**
posterior mente abriremos nuestro terminal (cmd) en esa ruta y ejecutaremos:

```
java -jar invoice-0.0.1-SNAPSHOT.jar
```
# Servicios api rest
- `Funcionalidad 1`: Funcionalidad para buscar y obtener un listado de clientes.
  </br>
  
   URL:
   ```
   http://localhost:8080/customer/find?identification=0107145393
   ```
   o:
   ```
   http://localhost:8080/customer/find?identification=CHRISTIAN GEOVANNY RIVERA LOJA
   ```
- `Funcionalidad 2`: Funcionalidad para crear un nuevo cliente con la dirección matriz
  </br>
  
   URL:
   ```
   http://localhost:8080/customer
   ```
   JSON:
   ```
   {
    "id": null,
    "identificationType": "CEDULA",
    "identificationNumber": "0107145393",
    "completeNames": "CHRISTIAN GEOVANNY RIVERA LOJA",
    "email": "geovanny@gmail.com",
    "phone": "0991748285",
    "branches": [
      {
        "id": null,
        "branchType": "MATRIZ",
        "province": "AZUAY",
        "city": "CUENCA",
        "address": "calle mariscal lamar"
      }
    ]
  }
   ```
- `Funcionalidad 3`: Funcionalidad para editar los datos del cliente
  </br>
  
   URL:
   ```
   http://localhost:8080/customer/1
   ```
   JSON:
   ```
  {
    "id": null,
    "identificationType": "CEDULA",
    "identificationNumber": "0107145393",
    "completeNames": "CHRISTIAN ANDRES RIVERA LOJA",
    "email": "andrest56@gmail.com",
    "phone": "0998597452"
  }
   ```
- `Funcionalidad 4`: Funcionalidad para eliminar un cliente
  </br>
  
   URL:
   ```
   http://localhost:8080/customer/1
   ```
- `Funcionalidad 5`: Funcionalidad para registrar una nueva dirección por cliente
  </br>
  
   URL:
   ```
   http://localhost:8080/customer/branch/1
   ```
   JSON:
   ```
  {
  "id": null,
  "branchType": "SUCURSAL",
  "province": "AZUAY",
  "city": "CUENCA",
  "address": "Av. loja"
  }
   ```
- `Funcionalidad 6`: Funcionalidad para listar las direcciones adicionales del cliente
  </br>
  
   URL:
   ```
   http://localhost:8080/customer/branch/1
   ```
