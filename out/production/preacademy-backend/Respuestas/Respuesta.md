# Respuestas!
---

## 🔹 Preguntas sobre Java

1. ¿Cuál es la diferencia entre una clase y un objeto en Java? 
   La principal diferencia es que la clase define atributos y metodos que un grupo de objetos tendrá, mientras que el objeto es una instancia de una clase.  

2. ¿Por qué en Java todo debe estar dentro de una clase?
    Porque responde a los fundamentos del POO y al encapsulamiento. Incluso el main esta dentro de una clase. 
3. ¿Qué significa que Java sea un lenguaje *fuertemente tipado*?
    Esto significa que es muy importante como definimos cada variable ya que es el tipo de dato que tendra durante toda la ejecucion, en otros lenguajes se puede cambiar en tiempo de ejecucion el tipo de dato, cosa que en Java no ocurre
4. ¿Qué función cumple el método `main()` en una aplicación Java?
    El metodo main es el que permite ejecutar a nuestra aplicacion, ahi debe estar todo lo necesario y relaciones necesarias para que compile, si toda la logica esta en una clase sin main, no se ejecutara al runear la aplicacion
5. ¿Qué diferencias notás entre Java y otros lenguajes que hayas usado anteriormente? (por ejemplo Python, JavaScript, etc.)
    Si comparo con Javascript noto que Java es mucho mas insistente con respetar los tipos de datos, con definir que es cada variable, el orden de las cosas que utilizamos. Sin embargo, si comparo con C el manejo y creacion de las estructuras de datos es muchisimo mas facil en Java

---

## 🔹 Preguntas sobre Programación Orientada a Objetos (POO)

6. ¿Qué es la **encapsulación** y por qué es importante?
    La encapsulacion es la forma de dar seguridad a nuestros atributos en las clases y controlar los accesos, esto es importante porque define quienes pueden acceder y modificar a ciertos atributos, siendo public el de menor proteccion y private el de mayor.
7. ¿Qué ventajas tiene crear métodos *getter* y *setter* en lugar de acceder directamente a los atributos?
    Que justamente se respeta el encapsulamiento, no modifica el usuario directamente el atributo, sino que se accede a la clase y desde la clase se modifican los atributos, donde puede haber validaciones, verificaciones y demas
9. ¿Qué es un **constructor** y para qué se usa?
    Un constructor es un metodo que sirve para "construir" una instancia de la clase, indica en sus parametros que valores debe recibir y luego con los parametros, o lo que hayamos codificado en su logica de negocio se le asignan atributos a las variables de la clase, para el objeto determinado que instancia  esa clase
10. ¿Podés explicar con tus palabras qué es un **método** y cómo se relaciona con los objetos?
    Un metodo es todo comportamiento valido que puede tener un objeto, estos se definen en la clase (o interfaz) y responden a si misma. Tambien pueden ser heredados para que se use en otras clases y modificados con un @Override. Una clase perro puede tener sus atributos como nombre,raza y su metodo como por ejemplo ladrar(). Estos metodos pueden devolver valores, como no .
11. ¿Cuál es el beneficio de tener más de una clase en un programa?
    El beneficio es la modularidad y la claridad en el codigo gracias a la delegacion de problemas. Hacer una clase animal para representar a todos los animales generaria metodos inutiles en algunos animales, ejemplo un gato no ladra, y en animales habria que considerar el ladrido como el maullar como metodos validos, en cambio si dividimos en dos clases que heredan los atributos generales de los animales, pero con atributos propios de su especie, un gato no tendria el metodo innecesario de ladrar. 

---

## 🔹 Ejercicio reflexivo

11. Imaginá que estás programando un videojuego. ¿Qué clases podrías crear para representar los elementos del juego?  
    ¿Qué atributos y métodos tendrían esas clases?
 
//Lo pense como el tipico juego de anuncio del stickman
Clases: Personaje - Mapa - Enemigo - Consumible - Tienda

Personaje: atributos: alto, ancho, vida, dinero, skin, nivel metodos: /* No se bien el manejo de listeners en java, pero supongo que el metodo sera necesario */ mover(direccion), comprar(consumible), recibir_daño(cantidad), atacar(enemigo), pasarNivel()
Mapa: atributos: alto, ancho,nivel, List(elementos) /* Enemigos presentes, consumibles */ metodo: cargarMundo(), mostrar() , actualizar()
Enemigo: atributos: ancho, alto, vida metodos: atacar(personaje), recibir_daño(cantidad)
Consumible: atributos: nivelMin, rareza, potenciadorAncho, potenciadorAlto, metodos: aplicar(personaje) , es_valido_para(mapa)
Tienda: atributos: precio, beneficio, nivelMin metodos: mostrar_items() vender(personaje,beneficio)
---
