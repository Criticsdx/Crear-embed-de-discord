# Discord Embed Bot (JDA)

Este proyecto es un bot de Discord desarrollado en Java utilizando la librería JDA (Java Discord API). Su función principal es permitir que cualquier usuario cree (Embeds) con comandos sencillos.

## Características
* **Generador de Embeds:** Permite personalizar títulos, descripciones y colores en tiempo real.
* **Gestión de colores:** Soporte para códigos hexadecimales personalizados.
* **Comandos de utilidad:** Incluye funciones para verificar latencia (ping) e información del sistema.
* **Auto-limpieza:** El bot intenta eliminar el mensaje del comando original para mantener el orden en los canales.

## Requisitos
* Java 11 o superior.
* Maven (opcional, para gestión de dependencias).
* Un token de bot obtenido desde el [Discord Developer Portal](https://discord.com/developers/applications).

## Instalación y Ejecución

### Configuración del Token
El bot busca una variable de entorno llamada `DISCORD_BOT_TOKEN`. Si no se encuentra, se puede configurar manualmente en la clase principal:

```java
// DiscordBot.java
String token = "TU_TOKEN_AQUI";
