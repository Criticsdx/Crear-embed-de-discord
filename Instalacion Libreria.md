## Instalación y Ejecución
### Opción Rápida (Windows)

```bash
# 1. Descargar librería JDA y compilar
setup.bat

# 2. Ejecutar el bot
run.bat
```

### Opción con Maven

```bash
# 1. Instalar dependencias
mvn clean install

# 2. Ejecutar
mvn exec:java -Dexec.mainClass="DiscordBot"
```

##  Comandos del Bot

| Comando | Descripción |
|---------|-------------|
| `#embed titulo \| descripción \| #color` | Crea un embed personalizado |
| `#help` | Muestra los comandos disponibles |
| `#info` | Información del bot |
| `#ping` | Verifica la latencia |

##  Librería

Este bot usa **JDA (Java Discord API) v5.0.0-beta.20**

- [Documentación de JDA](https://jda.wiki/)
- [GitHub de JDA](https://github.com/discord-jda/JDA)
- [Discord Developer Docs](https://discord.com/developers/docs)

##  Notas

- Los embeds tienen límites: título 256 chars, descripción 4096 chars
- Ve la guía`Guia del embed.md para mas ejemplos de uso del comando
