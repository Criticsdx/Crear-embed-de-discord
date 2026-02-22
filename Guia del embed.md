# Guía para crear los putos embeds

Escribe en cualquier canal donde esté el bot:

```
#embed titulo | descripción | #color
```

| Parte         | ¿Qué es?                        | ¿Es obligatorio? |
|---------------|----------------------------------|-------------------|
| `titulo`      | El título grande del embed       |  Sí             |
| `descripción` | El texto debajo del título       |  No             |
| `#color`      | Color del borde (en hexadecimal) /  No           |

> **Nota:** Separa cada parte con el símbolo `|`

## Ejemplos Paso a Paso

### Ejemplo 1: Solo título
```
#embed Bienvenidos al server
```
> Resultado: Un embed azul con el título "Bienvenidos al server"

### Ejemplo 2: Título + descripción
```
#embed Reglas | 1. Sé respetuoso 2. No spam 3. Diviértete
```
> Resultado: Un embed azul con título "Reglas" y las reglas abajo

### Ejemplo 3: Título + descripción + color
```
#embed Anuncio | Hoy hay evento a las 8pm | #FF5733
```
> Resultado: Un embed **rojo/naranja** con el anuncio

### Ejemplo 4: Color verde
```
#embed Sorteo | Reacciona para participar | #2ECC71
```

### Ejemplo 5: Color morado
```
#embed Actualización | Nueva versión disponible | #9B59B6
```

---

##  Colores Populares

| Color          | Código  | Ejemplo de uso          |
|----------------|---------|-------------------------|
| Rojo        | `#FF0000` | Alertas, urgente        |
| Verde       | `#2ECC71` | Aprobado, éxito         |
| Azul        | `#3498DB` | Info, noticias          |
| Amarillo    | `#F1C40F` | Advertencias            |
| Morado      | `#9B59B6` | Actualizaciones         |
| Naranja     | `#FF5733` | Anuncios                |
| Negro       | `#000000` | Elegante                |
| Rosa        | `#FF69B4` | Divertido               |

> Si quieres mas colores ve a https://htmlcolorcodes.com/es/

---

## Preguntas Frecuentes

**¿Quién puede hacer embeds?**
Cualquier persona en el servidor.

**¿Y si no pongo color?**
Se usa azul (Discord Blurple) por defecto.

**¿Se borra mi mensaje después?**
Sí, el bot intenta borrar tu comando para que solo se vea el embed.

**¿Puedo usar emojis en el título o descripción?**
Si, ejemplo:iesta | Todos están invitados | #FF69B4`
